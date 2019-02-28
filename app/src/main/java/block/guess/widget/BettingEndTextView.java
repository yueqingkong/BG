package block.guess.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import block.guess.R;
import block.guess.utils.TimeUtil;

public class BettingEndTextView extends AppCompatTextView {

    private int resourceId;
    private long startTime;
    private long endTime;

    private CountDownTimer downTimer;

    public BettingEndTextView(Context context) {
        super(context);
    }

    public BettingEndTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BettingEndTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(int resid,long start, long end) {
        this.resourceId = resid;
        this.startTime = start;
        this.endTime = end;

        if (TimeUtil.timestamp() > endTime * 1000) {
            setText(getResources().getString(R.string.waiting_prize));
        } else {
            launchTimer();
        }
    }

    public void launchTimer() {
        if (downTimer == null) {
            long millinsFuture = ((long) endTime * 1000) - TimeUtil.timestamp();
            downTimer = new CountDownTimer(millinsFuture, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    Message message = new Message();
                    message.what = 120;
                    message.obj = millisUntilFinished / 1000;
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
                    long millins = (long) msg.obj;
                    String formatTime = TimeUtil.timestampSecondFormat((int) millins);
                    setText(getContext().getString(resourceId, formatTime));
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
}
