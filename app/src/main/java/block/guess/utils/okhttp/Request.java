package block.guess.utils.okhttp;

import android.app.Activity;

import block.guess.main.bean.BalanceBean;
import block.guess.main.bean.MainEvent;
import block.guess.main.request.BalanceRequest;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.share.AppInfo;

public class Request {

    private static Request request;

    public synchronized static Request request() {
        if (request == null) {
            request = new Request();
        }
        return request;
    }

    /**
     * 账户余额
     *
     * @param activity
     */
    public void balanceRequest(Activity activity) {
        BalanceRequest request = new BalanceRequest("");
        OKHttpUtil.client().request(request, new BaseCallBack<BalanceBean>(activity) {

            @Override
            public void success(BalanceBean bean) {
                AppInfo.getAppInfo().saveBalance(bean);
                MainEvent.send(MainEvent.HomeType.BALANCE);
            }

            @Override
            public void serverError(int code, String err) {
            }

            @Override
            public void netError() {
            }
        });
    }
}
