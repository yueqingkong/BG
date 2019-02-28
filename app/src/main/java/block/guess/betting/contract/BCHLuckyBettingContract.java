package block.guess.betting.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface BCHLuckyBettingContract {

    interface BView extends BaseView<Presenter> {
        void updateLuckyTips();

        void payClick();

        void paySuccess();

        void payFail();
    }

    interface Presenter extends BasePresenter {
        void payRequest(long id, int times);
    }
}
