package block.guess.betting.presenter;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

import block.guess.betting.bean.BCH3dBuyBean;
import block.guess.betting.bean.Betting3DBean;
import block.guess.betting.bean.LottoBean;
import block.guess.betting.bean.PayResultBean;
import block.guess.betting.contract.LottoBettingContract;
import block.guess.betting.request.BCH3DBuyRequest;
import block.guess.main.bean.HomeBean;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import com.google.gson.Gson;

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
    public void payClick(final HomeBean homeBean, int times, List<LottoBean> beans, BaseCallBack<Boolean> callBack) {
        BCH3dBuyBean buyBean = new BCH3dBuyBean();
        buyBean.setContract_id(homeBean.getContract().getId());
        buyBean.setTimes(times);
        buyBean.setCategory(3);

        String[][] redNumbers = new String[beans.size()][6];
        String[][] blueNumbers = new String[beans.size()][1];

        for (int i = 0; i < beans.size(); i++) {
            LottoBean lottoBean = beans.get(i);
            for (int j = 0; j < lottoBean.numberLists().size(); j++) {
                redNumbers[i][j] = String.valueOf(lottoBean.numberLists().get(j));
            }
            blueNumbers[i][0] = String.valueOf(lottoBean.purpleNumber());
        }
        buyBean.setRed_numbers(redNumbers);
        buyBean.setBlue_numbers(blueNumbers);

        BCH3DBuyRequest request = new BCH3DBuyRequest(buyBean);
        OKHttpUtil.client().request(request, new BaseCallBack<PayResultBean>(activity) {
            @Override
            public void success(PayResultBean resultBean) {
                long contractId = resultBean.getContract_id();
                String identifier = resultBean.getIdentifier();

                baseView.paySuccess(contractId, identifier);

                callBack.success(true);
            }

            @Override
            public void serverError(int code, String err) {
                baseView.payFail();
                callBack.serverError(code, err);
            }

            @Override
            public void netError() {
                baseView.payFail();
                callBack.netError();
            }
        });
    }
}
