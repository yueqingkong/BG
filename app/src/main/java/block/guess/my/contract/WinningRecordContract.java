package block.guess.my.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface WinningRecordContract {

    interface BView extends BaseView<Presenter> {

        void winningRecordRequest();
    }

    interface Presenter extends BasePresenter {

    }
}
