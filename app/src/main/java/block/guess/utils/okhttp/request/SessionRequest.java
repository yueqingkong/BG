package block.guess.utils.okhttp.request;

import block.guess.login.bean.UserInfoBean;
import block.guess.utils.log.LogUtil;
import block.guess.utils.share.AppInfo;

public abstract class SessionRequest extends BaseRequest {

    private static String TAG = "_SessionRequest";

    public SessionRequest(Object obj) {
        super(obj);

        UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
        if (infoBean != null) {
            String token = infoBean.getToken();
            LogUtil.d(TAG, "token: " + token);
            getStringMap().put("authorization", token);
        }
        getStringMap().put("platform", "app");
    }

    @Override
    public String requstUri() {
        return null;
    }
}
