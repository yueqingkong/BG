package block.guess.login.contract;


import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.utils.okhttp.Callback.BaseCallBack;

public interface LoginContract {

    interface BView extends BaseView<Presenter> {

        void signIn();

        void forgetPassword();

        void signUp();

        void loginSuccess();
    }

    interface Presenter extends BasePresenter {

        void signIn(String email, String password, BaseCallBack<Boolean> callBack);

        void againSignIn();
    }
}
