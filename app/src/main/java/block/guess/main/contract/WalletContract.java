package block.guess.main.contract;

import android.app.Activity;

import java.util.List;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.main.bean.BalanceBean;
import block.guess.main.bean.HistoryBean;

public interface WalletContract {

    interface BView extends BaseView<Presenter> {

        void balance();

        void historyList(List<HistoryBean> beans);

        void historyStartRequst();

        void historyFail();

        void sendDetail();

        void receiveDetail();

        Activity activity();
    }

    interface Presenter extends BasePresenter {

        void historyRequest(int index);
    }
}
