package block.guess.login.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface GuideContract {

    interface BView extends BaseView<Presenter> {

        void firstPosition();

        void secondPosition();

        void thirdPosition();
    }

    interface Presenter extends BasePresenter {

    }
}
