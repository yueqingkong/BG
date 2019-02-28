package block.guess.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import block.guess.R;
import block.guess.utils.DensityUtils;
import block.guess.utils.TimeUtil;
import block.guess.utils.log.LogUtil;

public class ClockCountView extends View {

    private static String TAG = "_ClockCountView";
    private static final int MAX_VALUE = 30;

    private Paint paint;

    private int progress;
    private long endTime;

    private CountDownTimer downTimer;

    public ClockCountView(Context context) {
        super(context);
    }

    public ClockCountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockCountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void init(long end) {
        this.endTime = end;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);

        if (TimeUtil.timestamp() > endTime * 1000) {
            progress = 30;
            invalidate();
        } else {
            launchTimer();
        }
    }

    public void launchTimer() {
        if (downTimer == null) {
            long millinsFuture = (endTime * 1000) - TimeUtil.timestamp();
            downTimer = new CountDownTimer(millinsFuture, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    Message message = new Message();
                    message.what = 120;
                    message.obj = millisUntilFinished / 1000 % 30;
                    handler.sendMessage(message);
                }

                @Override
                public void onFinish() {
                    downTimer = null;
                }
            }.start();
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 120:
                    int millins = (int) (long) msg.obj;
                    LogUtil.d(TAG, millins + "");

                    progress = MAX_VALUE - millins;
                    invalidate();
                    break;
            }
        }
    };

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (downTimer != null) {
            downTimer.cancel();
            downTimer = null;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCirlce(canvas);
        drawSector(canvas);
    }


    private void drawCirlce(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();

        int cornerX = width / 2;
        int cornerY = height / 2;

        paint.setColor(getResources().getColor(R.color.color_8b95bb));
        canvas.drawCircle(cornerX, cornerY, cornerX, paint);

        paint.setColor(getResources().getColor(R.color.color_f3f4fa));
        canvas.drawCircle(cornerX, cornerY, cornerX - 3, paint);
    }

    private void drawSector(Canvas canvas) {
        paint.setColor(getResources().getColor(R.color.color_8b95bb));

        int dp4 = DensityUtils.dip2px(4);
        int cornerX = getWidth() / 2;
        RectF mRecF = new RectF(cornerX - dp4, cornerX - dp4, cornerX + dp4, cornerX + dp4);

        int sweep = progress * 360 / MAX_VALUE;
        canvas.drawArc(mRecF, -90, sweep, true, paint);
    }
}
