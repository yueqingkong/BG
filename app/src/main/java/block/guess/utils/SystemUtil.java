package block.guess.utils;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.util.Locale;

import block.guess.R;

public class SystemUtil {

    public static int screenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    public static int screenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    public static void copy(Context context, String string) {
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(string);
    }

    public static void share(Activity activity, String title, String content) {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, content);
        activity.startActivity(Intent.createChooser(textIntent, title));
    }

    /**
     * 获取系统语言
     *
     * @param activity
     * @return
     */
    public static String language(Activity activity) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            locale = activity.getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = activity.getResources().getConfiguration().locale;
        }

        String language = locale.getLanguage() + "-" + locale.getCountry();
        return language;
    }

    /**
     * 震动
     *
     * @param activity
     */
    public static void vibrator(Activity activity) {
        Vibrator vibrator = (Vibrator) activity.getSystemService(activity.VIBRATOR_SERVICE);
        vibrator.vibrate(250);
    }

    /**
     * 获取界面的根布局
     *
     * @param activity
     * @return
     */
    public static View getRootView(Activity activity) {
        return ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
    }

    /**
     * 利用反射获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        int result = 0;

        //获取状态栏高度的资源id
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
