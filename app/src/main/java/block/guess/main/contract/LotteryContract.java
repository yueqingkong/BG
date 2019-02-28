package block.guess.main.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface LotteryContract {
    interface BView extends BaseView<Presenter> {

        void lotteryClick();

        void rankingClick();
    }

    interface Presenter extends BasePresenter {

    }
}
