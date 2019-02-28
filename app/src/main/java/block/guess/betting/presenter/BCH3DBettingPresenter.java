package block.guess.betting.presenter;

import android.app.Activity;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import block.guess.betting.bean.BCH3dBuyBean;
import block.guess.betting.bean.Betting3DBean;
import block.guess.betting.contract.BCH3DBettingContract;
import block.guess.betting.request.BCH3DBuyRequest;
import block.guess.main.bean.HomeBean;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;

public class BCH3DBettingPresenter implements BCH3DBettingContract.Presenter {

    private static final String TAG = "_BCH3DBettingPresenter";
    private BCH3DBettingContract.BView baseView;
    private Activity activity;

    public BCH3DBettingPresenter(BCH3DBettingContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        this.activity = (Activity) baseView;
        this.baseView.init();
    }

    @Override
    public void payClick(final HomeBean bean, int times, List<Betting3DBean> beans) {
        BCH3dBuyBean buyBean = new BCH3dBuyBean();
        buyBean.setContract_id(bean.getContract().getId());
        buyBean.setTimes(times);

        List<String> strings = new ArrayList<>();
        for (Betting3DBean b : beans) {
            strings.add(b.toString());
        }
        buyBean.setAward_numbers(strings);

        BCH3DBuyRequest request = new BCH3DBuyRequest(buyBean);
        OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {
            @Override
            public void success(String o) {
                LogUtil.d(TAG, o);

                long contractId = bean.getContract().getId();
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
