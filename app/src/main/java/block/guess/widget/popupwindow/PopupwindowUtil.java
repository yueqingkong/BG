package block.guess.widget.popupwindow;

import android.app.Activity;
import android.view.View;

import block.guess.utils.DensityUtils;
import block.guess.widget.popupwindow.bean.PopupCallback;
import block.guess.widget.popupwindow.common.BasePopupwindow;

public class PopupwindowUtil {

    public static void show(Activity activity, int resid, final View bottomView, int xOff, final int yOff, PopupCallback callback) {
        final BasePopupwindow basePopupwindow = new BasePopupwindow(activity, resid);
        View baseView = basePopupwindow.getBaseView();
        basePopupwindow.showAsDropDown(bottomView, xOff, yOff);
        basePopupwindow.getContentView().post(new Runnable() {
            @Override
            public void run() {
                int width = basePopupwindow.getContentView().getWidth();
                int height = basePopupwindow.getContentView().getHeight();
                int offsetX = -(width + bottomView.getLeft() - DensityUtils.screenWidth()) - DensityUtils.dip2px(10);
                basePopupwindow.update(bottomView, offsetX, yOff, width, height);
            }
        });

        callback.createView(basePopupwindow, baseView);
    }
}
