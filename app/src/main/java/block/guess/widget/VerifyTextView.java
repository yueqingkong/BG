package block.guess.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import block.guess.R;

public class VerifyTextView extends AppCompatTextView implements View.OnTouchListener {

    private CountDownTimer downTimer;

    public VerifyTextView(Context context) {
        super(context);
        init();
    }

    public VerifyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerifyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setTextColor(getResources().getColor(R.color.color_white));
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_UP:
                launchTimer();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void launchTimer() {
        if (downTimer == null) {
            downTimer = new CountDownTimer(60000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long second = millisUntilFinished / 1000;
                    countTimer(second);
                }

                @Override
                public void onFinish() {
                    downTimer = null;
                    finishCount();
                }
            }.start();
        }
    }

    public void countTimer(long second) {
        setBackgroundResource(R.drawable.shape_rectangle_d2d8f1_r6);
        setText(second + "S");
    }

    public void finishCount() {
        setBackgroundResource(R.drawable.shape_rectangle_45ceb4_r6);
        setText(getResources().getString(R.string.verify_code));
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (downTimer != null) {
            downTimer.cancel();
            downTimer = null;
        }
    }
}
