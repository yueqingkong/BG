package block.guess.utils.okhttp;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.TimeUnit;

import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.request.BaseRequest;
import okhttp3.Call;
import okhttp3.OkHttpClient;

public class OKHttpUtil {

    private static String TAg = "_OKHttpUtil";
    private static OKHttpUtil httpUtil;
    private static OkHttpClient httpClient;

    private Handler handler;

    public synchronized static OKHttpUtil client() {
        if (httpUtil == null) {
            httpUtil = new OKHttpUtil();
        }
        return httpUtil;
    }

    public OKHttpUtil() {
        handler = new Handler(Looper.myLooper());
        httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    public void request(BaseRequest baseRequest, BaseCallBack baseCallBack) {
        LogUtil.d(TAg, "Uri: " + baseRequest.requstUri());
        baseCallBack.setHandler(handler);

        Call call = httpClient.newCall(baseRequest.request());
        call.enqueue(baseCallBack);
    }
}
