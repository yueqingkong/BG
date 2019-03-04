package block.guess.wallet.presenter;

import android.app.Activity;

import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.wallet.bean.WithdrawalBean;
import block.guess.wallet.bean.WithdrawalConfirmBean;
import block.guess.wallet.contract.BCHSendContract;
import block.guess.wallet.request.WithdrawalConfirmRequst;
import block.guess.wallet.request.WithdrawalRequest;

public class BCHSendPresenter implements BCHSendContract.Presenter {

    private static String TAG = "_BCHSendPresenter";
    private Activity activity;
    private BCHSendContract.BView baseView;

    public BCHSendPresenter(BCHSendContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        this.activity = (Activity) baseView;
        this.baseView.init();
    }

    @Override
    public void withdrawalRequest(String address, long amount, BaseCallBack<Boolean> callBack) {
        WithdrawalBean bean = new WithdrawalBean(address, amount);
        WithdrawalRequest request = new WithdrawalRequest(bean);
        OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {
            @Override
            public void success(String o) {
                callBack.success(true);
            }

            @Override
            public void serverError(int code, String err) {
                callBack.serverError(code, err);
            }

            @Override
            public void netError() {
                callBack.netError();
            }
        });
    }

    @Override
    public void withdrawalConfirm(String address, long amount, String code, long fee, BaseCallBack<Boolean> callBack) {
        WithdrawalConfirmBean bean = new WithdrawalConfirmBean(address, amount, code, fee);
        WithdrawalConfirmRequst requst = new WithdrawalConfirmRequst(bean);
        OKHttpUtil.client().request(requst, new BaseCallBack<String>(activity) {
            @Override
            public void success(String o) {
                callBack.success(true);
            }

            @Override
            public void serverError(int code, String err) {
                callBack.serverError(code, err);
            }

            @Override
            public void netError() {
                callBack.netError();
            }
        });
    }
}
