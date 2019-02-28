package block.guess.betting.presenter;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import block.guess.betting.bean.BCH3dBuyBean;
import block.guess.betting.bean.Betting3DBean;
import block.guess.betting.bean.LottoBean;
import block.guess.betting.contract.LottoBettingContract;
import block.guess.betting.request.BCH3DBuyRequest;
import block.guess.main.bean.HomeBean;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;

public class LottoBettingPresenter implements LottoBettingContract.Presenter {

    private static String TAG = "_LottoBettingPresenter";
    private LottoBettingContract.BView baseView;
    private Activity activity;

    public LottoBettingPresenter(LottoBettingContract.BView bView) {
        baseView = bView;
        baseView.presenter(this);
    }

    @Override
    public void start() {
        activity = (Activity) baseView;
        baseView.init();
    }

    @Override
    public void payClick(final HomeBean homeBean, int times, List<LottoBean> beans) {
        BCH3dBuyBean buyBean = new BCH3dBuyBean();
        buyBean.setContract_id(homeBean.getContract().getId());
        buyBean.setTimes(times);

        List<String> strings = new ArrayList<>();
        for (LottoBean b : beans) {
            strings.add(b.toString());
        }
        buyBean.setAward_numbers(strings);

        BCH3DBuyRequest request = new BCH3DBuyRequest(buyBean);
        OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {
            @Override
            public void success(String o) {
                LogUtil.d(TAG, o);

                long contractId = homeBean.getContract().getId();
                baseView.paySuccess(contractId);
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
