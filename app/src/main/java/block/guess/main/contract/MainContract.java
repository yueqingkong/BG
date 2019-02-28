package block.guess.main.contract;

import block.guess.base.BaseFragment;
import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface MainContract {

    interface BView extends BaseView<Presenter> {

        void onPageSelected(int position);

        boolean checkUserStatus();

        void switchFragment(BaseFragment fragment);
    }

    interface Presenter extends BasePresenter {

    }
}
