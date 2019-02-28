package block.guess.widget.nesting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

import block.guess.widget.nesting.bean.ScrollCallBack;

public class RecyclerScrollView extends ScrollView {

    private int slop;
    private int touch;

    private ScrollCallBack scrollCallBack;

    public RecyclerScrollView(Context context) {
        super(context);
        init();
    }

    public RecyclerScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RecyclerScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Context context = getContext();

        // 获取相应context的touch slop值（即在用户滑动之前，能够滑动的以像素为单位的距离）
        slop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /**
     * 是否intercept当前的触摸事件
     *
     * @param ev 触摸事件
     * @return true：调用onMotionEvent()方法，并完成滑动操作
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //  保存当前touch的纵坐标值
                touch = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                //  滑动距离大于slop值时，返回true
                if (Math.abs((int) ev.getRawY() - touch) > slop) return true;
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (getScrollY() == 0) {
            if (scrollCallBack != null) {
                scrollCallBack.scrollTop();
            }
        } else if (getScrollY() + getHeight() - getPaddingTop() - getPaddingBottom() == getChildAt(0).getHeight()) {
            if (scrollCallBack != null) {
                scrollCallBack.scrollBottom();
            }
        }
    }

    public void setScrollCallBack(ScrollCallBack back) {
        this.scrollCallBack = back;
    }
}
