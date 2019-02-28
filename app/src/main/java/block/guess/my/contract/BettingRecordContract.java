package block.guess.my.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface BettingRecordContract {

    interface BView extends BaseView<Presenter> {

        void recordDetails();

    }

    interface Presenter extends BasePresenter {

    }
}
