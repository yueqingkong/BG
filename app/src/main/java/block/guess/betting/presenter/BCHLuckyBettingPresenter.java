package block.guess.betting.presenter;

import android.app.Activity;

import block.guess.betting.bean.BCH3dBuyBean;
import block.guess.betting.bean.PayResultBean;
import block.guess.betting.contract.LuckyBettingContract;
import block.guess.betting.request.BCH3DBuyRequest;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;

public class BCHLuckyBettingPresenter implements LuckyBettingContract.Presenter {

    private static String TAG = "_BCHLuckyBettingPresenter";

    private Activity activity;
    private LuckyBettingContract.BView baseView;

    public BCHLuckyBettingPresenter(LuckyBettingContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        activity = (Activity) baseView;
        baseView.init();
        baseView.updateLuckyTips();
    }

    @Override
    public void payRequest(long id, int times) {
        BCH3dBuyBean buyBean = new BCH3dBuyBean();
        buyBean.setContract_id(id);
        buyBean.setTimes(times);

        BCH3DBuyRequest request = new BCH3DBuyRequest(buyBean);
        OKHttpUtil.client().request(request, new BaseCallBack<PayResultBean>(activity) {
            @Override
            public void success(PayResultBean resultBean) {
                long contractId = resultBean.getContract_id();
                String identifier = resultBean.getIdentifier();

                baseView.paySuccess(contractId,identifier);
            }

            @Override
            public void serverError(int code, String err) {
                baseView.payFail();
            }

            @Override
            public void netError() {
                baseView.payFail();
            }
        });
    }
}
