package block.guess.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import block.guess.R;

/**
 * 四分之一圆
 */
public class HalfCircleView extends View {

    private Paint paint;

    private int direct = 0;//0:左 1:右

    public HalfCircleView(Context context) {
        super(context);
        initParams();
    }

    public HalfCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.HalfCircle);
        direct = typedArray.getInt(R.styleable.HalfCircle_half_direct, 0);
        typedArray.recycle();

        initParams();
    }

    private void initParams() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.color_white));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawQuarter(canvas);
    }

    private void drawQuarter(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        int pointX = 0;
        int pointY = 0;
        switch (direct) {
            case 0:
                pointX = 0;
                pointY = height / 2;
                break;
            case 1:
                pointX = width;
                pointY = height / 2;
                break;
        }

        int radius = Math.max(width/2, height/2);
        canvas.drawCircle(pointX, pointY, radius, paint);
    }
}
