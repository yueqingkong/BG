package block.guess.widget.bar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import block.guess.R;

public class ProgressBarView extends View {

    private Paint backPaint;
    private Paint progressPaint;

    private int currentValue;
    private int totalValue;
    private ProgressCallBack progressCallBack;

    public ProgressBarView(Context context) {
        super(context);
        initParams();
    }

    public ProgressBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initParams();
    }

    public ProgressBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initParams();
    }

    public void initParams() {
        backPaint = new Paint();
        backPaint.setStyle(Paint.Style.FILL);
        backPaint.setColor(getContext().getResources().getColor(R.color.color_f3f4fa));
        backPaint.setAntiAlias(true);
        backPaint.setStrokeCap(Paint.Cap.ROUND);

        progressPaint = new Paint();
        progressPaint.setStyle(Paint.Style.FILL);
        progressPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.saveLayerAlpha(0, 0, getWidth(), getHeight(), 255, Canvas.ALL_SAVE_FLAG);

        backgroundDraw(canvas);
        progressDraw(canvas);
    }

    private void backgroundDraw(Canvas canvas) {
        int with = getWidth();
        int height = getHeight();

        int startX = height / 2;
        int startY = height / 2;
        int endX = with - startX;
        int endY = startY;

        backPaint.setStrokeWidth(height);
        canvas.drawLine(startX, startY, endX, endY, backPaint);
    }

    private void progressDraw(Canvas canvas) {
        int with = getWidth();
        int height = getHeight();

        int startX = height / 2;
        int startY = height / 2;
        int endY = startY;

        int progress = (currentValue * with) / totalValue;
        progressPaint.setStrokeWidth(height);

        LinearGradient linearGradient = new LinearGradient(0, startX, progress, endY, getContext().getResources().getColor(R.color.color_5a7cff), getContext().getResources().getColor(R.color.color_7be9db), Shader.TileMode.CLAMP);
        progressPaint.setShader(linearGradient);

        progressPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        if (progress <= startX) {
            progressPaint.setStrokeCap(Paint.Cap.BUTT);
            canvas.drawLine(0, startY, progress, endY, progressPaint);
        } else {
            progressPaint.setStrokeCap(Paint.Cap.ROUND);

            progress = progress - startX;
            canvas.drawLine(0, startY, progress, endY, progressPaint);
        }
    }

    /**
     * 设置当前进度
     *
     * @param current
     * @param total
     */
    public void progress(int current, final int total) {
        this.currentValue = 0;
        this.totalValue = total;

        ValueAnimator animator = ValueAnimator.ofInt(0, current);
        animator.setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int current = (int) animation.getAnimatedValue();

                currentValue = current;
                progressCallBack.drawProgress(current, total);

                postInvalidate();
            }
        });
        animator.start();
    }

    public void setProgressCallBack(ProgressCallBack progressCallBack) {
        this.progressCallBack = progressCallBack;
    }

    public interface ProgressCallBack {
        void drawProgress(int progress, int total);
    }
}
