package block.guess.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AlertDialog;
import block.guess.R;
import block.guess.utils.DensityUtils;
import block.guess.widget.dialog.bean.DialogCallback;

public class DialogUtil {

    public static void show(Context context, int resid, DialogCallback callback) {
        int dp16 = DensityUtils.dip2px(16);
        int width = DensityUtils.screenWidth() - dp16 * 2;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;

        show(context, resid, width, height, callback);
    }

    /**
     * @param context
     * @param resid
     * @param width
     * @param height
     * @param callback
     */
    public static void show(Context context, int resid, int width, int height, DialogCallback callback) {
        Dialog dialog = new Dialog(context, R.style.Dialog);
        View view = LayoutInflater.from(context).inflate(resid, null);
        dialog.setContentView(view);

        Window mWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.width = width;
        lp.height = height;
        mWindow.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();

        callback.createView(dialog, view);
    }

    public static void alert(Context context, String title, String message, String left, String right, final AlertCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNegativeButton(left, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.cancelClick();
                dialogInterface.cancel();
            }
        });
        builder.setPositiveButton(right, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.confirmClick();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public interface AlertCallback {
        void cancelClick();

        void confirmClick();
    }
}
