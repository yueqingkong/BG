package block.guess.widget.horizontalball;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import block.guess.utils.DensityUtils;

import java.util.List;

public class HorizontalNumberBallView extends LinearLayout {

    private List<NumberBallBean> numberBallBeanList;

    public HorizontalNumberBallView(Context context) {
        super(context);
    }

    public HorizontalNumberBallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalNumberBallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HorizontalNumberBallView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setData(List<NumberBallBean> beans) {
        this.numberBallBeanList = beans;

        removeAllViews();

        int DP34 = DensityUtils.dip2px(34);
        for (NumberBallBean ballBean : beans) {
            TextView textView = new TextView(getContext());

            LinearLayout.LayoutParams layoutParams = new LayoutParams(DP34, DP34);
            int spaceLeft = DensityUtils.dip2px(ballBean.getLeft());
            layoutParams.leftMargin = spaceLeft;
            textView.setLayoutParams(layoutParams);
            textView.setBackgroundResource(ballBean.getBgResId());
            textView.setText(ballBean.getNumber());
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(getResources().getColor(ballBean.getTxtColorId()));

            addView(textView);
        }
    }
}
