package block.guess.betting.presenter;

import android.app.Activity;

import block.guess.betting.bean.BCH3dBuyBean;
import block.guess.betting.contract.BCHLuckyBettingContract;
import block.guess.betting.request.BCH3DBuyRequest;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;

public class BCHLuckyBettingPresenter implements BCHLuckyBettingContract.Presenter {

    private static String TAG = "_BCHLuckyBettingPresenter";

    private Activity activity;
    private BCHLuckyBettingContract.BView baseView;

    public BCHLuckyBettingPresenter(BCHLuckyBettingContract.BView view) {
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
        OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {
            @Override
            public void success(String o) {
                LogUtil.d(TAG, o);
                baseView.paySuccess();
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
