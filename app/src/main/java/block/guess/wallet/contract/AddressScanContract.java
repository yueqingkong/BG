package block.guess.wallet.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface AddressScanContract {

    interface BView extends BaseView<Presenter> {
        void flashSwitch();

        void albumOpen();
    }

    interface Presenter extends BasePresenter {

    }
}
