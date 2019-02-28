package block.guess.wallet.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface BCHSendContract {

    interface BView extends BaseView<Presenter> {

        void qrcodeScan();

        void withdrawSuccess();

        void minerFeePopupwindow();
    }

    interface Presenter extends BasePresenter {
        void withdrawalRequest(String address, long amount);

        void withdrawalConfirm(String address, long amount, String code, long fee);
    }
}
