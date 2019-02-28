package block.guess.base;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

import block.guess.utils.SystemUtil;
public class BaseActivity extends AppCompatActivity {

    /**
     * 沉浸式状态栏
     *
     * @param color
     */
    public void statusBar(boolean white, int color) {
        //设置 paddingTop
        ViewGroup rootView = (ViewGroup) getWindow().getDecorView().findViewById(android.R.id.content);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //5.0 以上直接设置状态栏颜色
            getWindow().setStatusBarColor(color);

            // 状态栏字体颜色
            getWindow().getDecorView().setSystemUiVisibility(white ? View.SYSTEM_UI_FLAG_VISIBLE : View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            //根布局添加占位状态栏
            ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
            View statusBarView = new View(this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, SystemUtil.getStatusBarHeight(this));
            statusBarView.setBackgroundColor(color);
            decorView.addView(statusBarView, lp);
        }
    }
}
