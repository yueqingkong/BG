package block.guess.my.contract;

import block.guess.base.BACallBack;
import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface ChangePasswordContract {

    interface BView extends BaseView<Presenter> {
        void updatePassword();
        void changePasswordSuccess();
    }

    interface Presenter extends BasePresenter {
        void changePassword(String oldpwd, String newpwd, BACallBack<Boolean> callBack);
    }
}
