package block.guess.betting.contract;

import block.guess.base.BACallBack;
import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface LuckyBettingContract {

    interface BView extends BaseView<Presenter> {
        void updateLuckyTips();

        void payClick();

        void paySuccess(long contractid,String identifier);

        void payFail();
    }

    interface Presenter extends BasePresenter {
        void payRequest(long id, int times, BACallBack<Boolean> callBack);
    }
}
