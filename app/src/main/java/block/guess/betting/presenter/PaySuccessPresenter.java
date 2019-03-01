package block.guess.betting.presenter;

import android.app.Activity;
import block.guess.betting.bean.ContractDetailBean;
import block.guess.betting.contract.PaySuccessContract;
import block.guess.betting.request.BCHContractDetailRequest;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;

public class PaySuccessPresenter implements PaySuccessContract.Presenter {

    private static String TAG = "_PaySuccessPresenter";
    private PaySuccessContract.BView baseView;
    private Activity activity;

    public PaySuccessPresenter(PaySuccessContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        activity = (Activity) baseView;
    }

    @Override
    public void contractDetailRequest(long contractId, BaseCallBack<ContractDetailBean> callBack) {
        BCHContractDetailRequest request = new BCHContractDetailRequest("", contractId);
        OKHttpUtil.client().request(request, new BaseCallBack<ContractDetailBean>(activity) {

            @Override
            public void success(ContractDetailBean bean) {
                callBack.success(bean);
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
