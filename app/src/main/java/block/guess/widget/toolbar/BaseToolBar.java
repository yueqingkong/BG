package block.guess.widget.toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import block.guess.R;

public class BaseToolBar extends RelativeLayout {

    private View view;
    private TextView leftTxt;
    private TextView titleTxt;
    private TextView rightTxt;

    private ToolbarCallback toolbarCallback;

    public BaseToolBar(Context context) {
        super(context);
        init();
    }

    public BaseToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BaseToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Context context = getContext();
        view = LayoutInflater.from(context).inflate(R.layout.view_base_toolbar, this);

        leftTxt = view.findViewById(R.id.txt_left);
        titleTxt = view.findViewById(R.id.txt_centre);
        rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (toolbarCallback != null) {
                    toolbarCallback.leftClick();
                }
            }
        });
        rightTxt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbarCallback.rightClick();
            }
        });
    }

    public void setLeftTxt(String string) {
        leftTxt.setText(string);
    }

    public void setLeftTxt(int resid) {
        leftTxt.setBackgroundResource(resid);
    }

    public void setTitleTxt(String string) {
        titleTxt.setText(string);
    }

    public void setRightTxt(String string) {
        titleTxt.setText(string);
    }

    public void setRightTxt(int resid) {
        rightTxt.setBackgroundResource(resid);
    }

    public void setToolbarCallback(ToolbarCallback callback) {
        this.toolbarCallback = callback;
    }
}
