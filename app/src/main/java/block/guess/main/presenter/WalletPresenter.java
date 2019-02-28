package block.guess.main.presenter;

import java.util.List;

import block.guess.main.bean.BalanceBean;
import block.guess.main.bean.HistoryBean;
import block.guess.main.contract.WalletContract;
import block.guess.main.request.BalanceRequest;
import block.guess.main.request.HistoryRequest;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;

public class WalletPresenter implements WalletContract.Presenter {

    private static String TAG = "_WalletPresenter";
    private WalletContract.BView baseView;
    private boolean isRequst = false;

    public WalletPresenter(WalletContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }

    @Override
    public void historyRequest(int index) {
        if (isRequst) {
            return;
        }

        isRequst = true;
        baseView.historyStartRequst();

        HistoryRequest request = new HistoryRequest(index);
        OKHttpUtil.client().request(request, new BaseCallBack<List<HistoryBean>>(baseView.activity()) {

            @Override
            public void success(List<HistoryBean> beans) {
                isRequst = false;
                if (beans != null) {
                    LogUtil.d(TAG, "" + beans.size());
                    baseView.historyList(beans);
                }
            }

            @Override
            public void serverError(int code, String err) {
                isRequst = false;
                baseView.historyFail();
            }

            @Override
            public void netError() {
                isRequst = false;
                baseView.historyFail();
            }
        });
    }
}
