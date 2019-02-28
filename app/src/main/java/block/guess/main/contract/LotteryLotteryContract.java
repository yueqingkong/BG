package block.guess.main.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface LotteryLotteryContract {

    interface BView extends BaseView<Presenter> {

        void lotteryRequest();

        void d3Click();

        void luckyClick();

        void lottoClick();
    }

    interface Presenter extends BasePresenter {

    }
}
