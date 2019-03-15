package block.guess.betting.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface GiveFriendContract {

    interface BView extends BaseView<Presenter> {

        void scanQRCode();

        void giftRequest();

        void publishTxhash();
    }

    interface Presenter extends BasePresenter {

    }
}
