package block.guess.wallet.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface BCHReceiveContract {

    interface BView extends BaseView<Presenter> {

        void copyAddress();

        void saveQRCode();
    }

    interface Presenter extends BasePresenter {

    }
}
