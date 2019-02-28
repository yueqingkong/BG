package block.guess.login.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface ForgetPasswordContract {

    interface BView extends BaseView<Presenter> {

        void main();
    }

    interface Presenter extends BasePresenter {

        void emailToken(String email);

        void registerAccount(String email, String token, String password);
    }
}
