package block.guess.betting.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface GiftSuccessContract {

    interface BView extends BaseView<Presenter> {

        void backHome();
    }

    interface Presenter extends BasePresenter {

    }
}
