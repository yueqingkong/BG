package block.guess.login.contract;


import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface LaunchContract {

    interface BView extends BaseView<Presenter> {

        void permission();

        void firstLaunch();

        void homeStart();
    }

    interface Presenter extends BasePresenter {
        void allow();
    }
}
