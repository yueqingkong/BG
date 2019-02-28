package block.guess.widget;

import android.content.Context;
import androidx.annotation.Nullable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;
import block.guess.main.bean.HomeBean;

public class PendulumImageView extends AppCompatImageView {

    private HomeBean homeBean;

    public PendulumImageView(Context context) {
        super(context);
    }

    public PendulumImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PendulumImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HomeBean getHomeBean() {
        return homeBean;
    }

    public void setHomeBean(HomeBean homeBean) {
        this.homeBean = homeBean;
    }
}
