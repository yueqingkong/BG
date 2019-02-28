package block.guess.main.presenter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import block.guess.login.bean.UserInfoBean;
import block.guess.main.contract.MyContract;
import block.guess.main.bean.UserBean;
import block.guess.main.request.UploadAvatarRequest;
import block.guess.main.request.UserInfoRequest;
import block.guess.utils.BitmapUtil;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.utils.share.AppInfo;

public class MyPresenter implements MyContract.Presenter {

    private static String TAG = "_MyPresenter";
    private MyContract.BView baseView;

    public MyPresenter(MyContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        baseView.initPlan();
        baseView.initRecord();
        baseView.initAbout();
    }

    @Override
    public void updateName(Activity activity,final String name) {
        UserBean userBean = new UserBean(name);
        UserInfoRequest request = new UserInfoRequest(userBean);
        OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {
            @Override
            public void success(String string) {
                LogUtil.d(TAG, string);

                UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
                infoBean.setUsername(name);
                AppInfo.getAppInfo().setInfoUser(infoBean);

                baseView.updateName(name);
            }

            @Override
            public void serverError(int code, String err) {

            }

            @Override
            public void netError() {

            }
        });
    }

    @Override
    public void uploadAvatar(Activity activity, Uri uri) {
        try {
            Bitmap bitmap = realFilePath(activity, uri);
            File file = BitmapUtil.saveImage("", bitmap, 0);
            UploadAvatarRequest request = new UploadAvatarRequest(file.getAbsolutePath());
            OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {
                @Override
                public void success(String string) {
                    LogUtil.d(TAG, string);
                    UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
                    infoBean.setAvatar(string);
                    AppInfo.getAppInfo().setInfoUser(infoBean);

                    baseView.loadAvatar(string);
                }

                @Override
                public void serverError(int code, String err) {

                }

                @Override
                public void netError() {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bitmap realFilePath(Activity activity, Uri uri) throws Exception {
        InputStream input = activity.getContentResolver().openInputStream(uri);
        BitmapFactory.Options onlyBoundsOptions = new BitmapFactory.Options();
        onlyBoundsOptions.inJustDecodeBounds = true;
        onlyBoundsOptions.inDither = true;//optional
        onlyBoundsOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        BitmapFactory.decodeStream(input, null, onlyBoundsOptions);
        input.close();
        int originalWidth = onlyBoundsOptions.outWidth;
        int originalHeight = onlyBoundsOptions.outHeight;
        if ((originalWidth == -1) || (originalHeight == -1))
            return null;
        //图片分辨率以480x800为标准
        float hh = 800f;//这里设置高度为800f
        float ww = 480f;//这里设置宽度为480f 缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
        int be = 1;//be=1表示不缩放
        if (originalWidth > originalHeight && originalWidth > ww) {//如果宽度大的话根据宽度固定大小缩放
            be = (int) (originalWidth / ww);
        } else if (originalWidth < originalHeight && originalHeight > hh) {//如果高度高的话根据宽度固定大小缩放
            be = (int) (originalHeight / hh);
        }
        if (be <= 0)
            be = 1;        //比例压缩
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = be;//设置缩放比例
        bitmapOptions.inDither = true;//optional
        bitmapOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;//optional
        input = activity.getContentResolver().openInputStream(uri);
        Bitmap bitmap = BitmapFactory.decodeStream(input, null, bitmapOptions);
        input.close();
        return compressImage(bitmap);//再进行质量压缩
    }

    /**
     * 质量压缩方法
     *
     * @param image
     * @return
     */
    public static Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) { //循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset();//重置baos即清空baos           //第一个参数 ：图片格式 ，第二个参数： 图片质量，100为最高，0为最差  ，第三个参数：保存压缩后的数据的流
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;//每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());//把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);//把ByteArrayInputStream数据生成图片
        return bitmap;
    }
}
