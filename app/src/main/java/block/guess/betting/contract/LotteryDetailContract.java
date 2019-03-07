package block.guess.betting.contract;

import block.guess.base.BaseFragment;
import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.betting.bean.LotteryDetailBean;

public interface LotteryDetailContract {

    interface BView extends BaseView<Presenter> {

        void lotteryDetailRequest();

        void lotteryDetail(LotteryDetailBean bean);

        void random(LotteryDetailBean bean);

        void endingHeight(LotteryDetailBean bean);

        void lotteryHeight(LotteryDetailBean bean);

        void endingBetting(LotteryDetailBean bean);

        void contractAddress(LotteryDetailBean bean);

        void winningPlayerClick();

        void myBettingClick();

        void switchFragment(BaseFragment baseFragment);
    }

    interface Presenter extends BasePresenter {

    }
}
