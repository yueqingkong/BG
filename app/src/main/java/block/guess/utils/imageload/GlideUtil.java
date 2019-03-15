package block.guess.utils.imageload;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import block.guess.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

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

    public static void avatar(final ImageView view, String string) {
        RequestOptions options = new RequestOptions().
                fallback(R.mipmap.avatar_default).
                error(R.mipmap.avatar_default).
                placeholder(R.mipmap.avatar_default);

        Context context = view.getContext();
        Glide.with(context).load(string).apply(options).into(view);
    }
}
