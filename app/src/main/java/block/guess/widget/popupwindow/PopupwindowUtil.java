package block.guess.widget.popupwindow;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

import android.view.WindowManager;
import android.widget.PopupWindow;
import block.guess.utils.DensityUtils;
import block.guess.widget.popupwindow.bean.PopupCallback;
import block.guess.widget.popupwindow.common.BasePopupwindow;

public class PopupwindowUtil {

    public static void show(final Activity activity, int resid, final View bottomView, int xOff, final int yOff, PopupCallback callback) {
        final BasePopupwindow basePopupwindow = new BasePopupwindow(activity, resid);
        View baseView = basePopupwindow.getBaseView();
        basePopupwindow.showAsDropDown(bottomView, xOff, yOff);
        basePopupwindow.setBackgroundDrawable(new BitmapDrawable());
        backgroundAlpha(activity, 0.8f);

        basePopupwindow.getContentView().post(new Runnable() {
            @Override
            public void run() {
                int width = basePopupwindow.getContentView().getWidth();
                int height = basePopupwindow.getContentView().getHeight();
                int offsetX = -(width + bottomView.getLeft() - DensityUtils.screenWidth()) - DensityUtils.dip2px(10);
                basePopupwindow.update(bottomView, offsetX, yOff, width, height);
            }
        });
        basePopupwindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(activity, 1f);
            }
        });

        callback.createView(basePopupwindow, baseView);
    }

    /**
     * 设置背景透明度
     *
     * @param activity
     * @param alpha    0.0-1.0
     */
    private static void backgroundAlpha(Activity activity, float alpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = alpha;
        activity.getWindow().setAttributes(lp);
    }
}
