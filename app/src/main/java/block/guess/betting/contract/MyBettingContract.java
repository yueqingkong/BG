package block.guess.betting.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface MyBettingContract {

    interface BView extends BaseView<WinningPlayerContract.Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
