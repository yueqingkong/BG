package block.guess.wallet.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface TransactionDetailContract {

    interface BView extends BaseView<Presenter> {

        void category();

        void status();

        void dateTime();

        void txid();
    }

    interface Presenter extends BasePresenter {
    }
}
