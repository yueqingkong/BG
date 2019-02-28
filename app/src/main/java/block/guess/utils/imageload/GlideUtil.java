package block.guess.utils.imageload;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

public class GlideUtil {

    public static void load(ImageView view, String string) {
        Context context = view.getContext();
        Glide.with(context).load(string).into(view);
    }

    public static void load(ImageView view, File file) {
        Context context = view.getContext();
        Glide.with(context).load(file).into(view);
    }

    public static void load(ImageView view, Uri uri) {
        Context context = view.getContext();
        Glide.with(context).load(uri).into(view);
    }

    public static void load(ImageView view, int resid) {
        Glide.with(view).load(resid).into(view);
    }
}
