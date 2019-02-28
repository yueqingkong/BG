package block.guess.login.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface CreateAccountContract {

    interface BView extends BaseView<Presenter> {

        void captChaDialog();

        void signUpClick();

        void accountCreateSuccess();
    }

    interface Presenter extends BasePresenter {

        void requestToken(String id, String code, String email);

        void creatAccount(String invitecode, String username, String email, String password, String token);
    }
}
