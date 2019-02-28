package block.guess.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import block.guess.R;
import block.guess.utils.DensityUtils;

public class HorizontalDotVIew extends LinearLayout {

    public HorizontalDotVIew(Context context) {
        super(context);
    }

    public HorizontalDotVIew(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HorizontalDotVIew(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void update(int index, int count) {
        removeAllViews();

        for (int i = 0; i < count; i++) {
            View view = normalView();
            view.setBackgroundResource(index == i ? R.drawable.shape_oval_white : R.drawable.shape_oval_white_40);
            addView(view);
        }
    }

    private View normalView() {
        int margin = DensityUtils.dip2px(5);
        int width = DensityUtils.dip2px(6);
        LayoutParams layoutParams = new LayoutParams(width, width);
        layoutParams.setMargins(margin, 0, margin, 0);
        View view = new View(getContext());
        view.setLayoutParams(layoutParams);
        return view;
    }
}
