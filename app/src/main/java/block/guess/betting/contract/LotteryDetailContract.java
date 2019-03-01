package block.guess.betting.contract;

import block.guess.base.BaseFragment;
import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface LotteryDetailContract {

    interface BView extends BaseView<Presenter> {

        void lotteryDetailRequest();

        void lotteryDetail();

        void random();

        void endingHeight();

        void lotteryHeight();

        void endingBetting();

        void contractAddress();

        void winningPlayerClick();

        void myBettingClick();

        void switchFragment(BaseFragment baseFragment);
    }

    interface Presenter extends BasePresenter {

    }
}
