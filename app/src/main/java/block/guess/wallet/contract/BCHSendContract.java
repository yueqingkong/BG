package block.guess.wallet.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.utils.okhttp.Callback.BaseCallBack;

public interface BCHSendContract {

    interface BView extends BaseView<Presenter> {

        void qrcodeScan();

        void minerFeePopupwindow();
    }

    interface Presenter extends BasePresenter {

        void withdrawalRequest(String address, long amount, BaseCallBack<Boolean> callBack);

        void withdrawalConfirm(String address, long amount, String code, long fee,BaseCallBack<Boolean> callBack);
    }
}
