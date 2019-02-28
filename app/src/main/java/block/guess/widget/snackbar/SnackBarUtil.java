package block.guess.widget.snackbar;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import block.guess.R;
import block.guess.utils.SystemUtil;

public class SnackBarUtil {

    public static void success(Activity activity, String string) {
        show(activity, R.color.color_45ceb4, R.mipmap.ic_status_done, activity.getString(R.string.success), string);
    }

    public static void error(Activity activity, String string) {
        show(activity, R.color.color_ff0363, R.mipmap.ic_status_error, activity.getString(R.string.error), string);
    }

    public static void show(Activity activity, int backres, int resid, String status, String content) {
        View view = SystemUtil.getRootView(activity);

        Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_SHORT);
        View snackbarview = snackbar.getView();
        Context context = snackbarview.getContext();
        Snackbar.SnackbarLayout snacklayout = (Snackbar.SnackbarLayout) snackbarview;
        View layoutView = LayoutInflater.from(snackbarview.getContext()).inflate(R.layout.snackbar_status, null);//加载布局文件新建View

        ImageView statusImg = layoutView.findViewById(R.id.img_status);
        TextView statusTxt = layoutView.findViewById(R.id.txt_status);
        TextView contentTxt = layoutView.findViewById(R.id.txt_content);

        snackbarview.setBackgroundColor(context.getResources().getColor(backres));
        statusImg.setBackgroundResource(resid);
        statusTxt.setText(status);
        contentTxt.setText(content);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);//设置新建布局参数
        params.gravity = Gravity.CENTER_VERTICAL;
        snacklayout.removeAllViews();
        snacklayout.addView(layoutView, 0);
        snackbar.show();
    }
}
