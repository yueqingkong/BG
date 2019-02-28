package block.guess.utils.okhttp.request;

import com.google.gson.Gson;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import block.guess.login.bean.UserInfoBean;
import block.guess.utils.ApiUtil;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.share.AppInfo;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public abstract class BaseRequest<T> {

    private static final String TAG = "_BaseRequest";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private Object object;
    private Map<String, String> stringMap;

    public BaseRequest(Object obj) {
        this.object = obj;
        stringMap = new HashMap<>();

        // TODO: 2018/9/24 部分不需要传 
        UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
        if (infoBean != null) {
            String token = infoBean.getToken();
            LogUtil.d(TAG, "token: " + token);
            getStringMap().put("authorization", token);
        }
        getStringMap().put("platform", "app");
    }

    public abstract String requstUri();

    public abstract HttpMethodEnum httpMethod();

    public Object requestBody() {
        return object;
    }

    public void putHeaders(String key, String value) {
        stringMap.put(key, value);
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public Request request() {
        Request.Builder requestBuilder = null;
        if (httpMethod() == HttpMethodEnum.GET) {
            String url = ApiUtil.SERVER + requstUri();
            LogUtil.d(TAG, "url: " + url);

            requestBuilder = new Request.Builder()
                    .url(url);

            Map<String, String> stringMap = getStringMap();
            Iterator<Map.Entry<String, String>> entries = stringMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                String key = entry.getKey();
                String value = entry.getValue();
                requestBuilder.addHeader(key, value);
            }
        } else if (httpMethod() == HttpMethodEnum.POST) {
            String url = ApiUtil.SERVER + requstUri();

            String json = new Gson().toJson(requestBody());
            RequestBody body = RequestBody.create(JSON, json);
            requestBuilder = new Request.Builder()
                    .url(url)
                    .post(body);

            Map<String, String> stringMap = getStringMap();
            Iterator<Map.Entry<String, String>> entries = stringMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                String key = entry.getKey();
                String value = entry.getValue();
                requestBuilder.addHeader(key, value);
            }
        } else if (httpMethod() == HttpMethodEnum.PUT) {
            String url = ApiUtil.SERVER + requstUri();

            String json = new Gson().toJson(requestBody());
            RequestBody body = RequestBody.create(JSON, json);
            requestBuilder = new Request.Builder()
                    .url(url)
                    .put(body);

            Map<String, String> stringMap = getStringMap();
            Iterator<Map.Entry<String, String>> entries = stringMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                String key = entry.getKey();
                String value = entry.getValue();
                requestBuilder.addHeader(key, value);
            }
        } else if (httpMethod() == HttpMethodEnum.FILE) {
            String url = ApiUtil.SERVER + requstUri();

            File file = new File(getStringMap().get("file"));
            String fileName = file.getName();

            RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), file);
            RequestBody body = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("file", fileName, fileBody)
                    .build();
            requestBuilder = new Request.Builder()
                    .url(url)
                    .post(body);

            Map<String, String> stringMap = getStringMap();
            Iterator<Map.Entry<String, String>> entries = stringMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                String key = entry.getKey();
                String value = entry.getValue();
                requestBuilder.addHeader(key, value);
            }
        }
        return requestBuilder.build();
    }
}
