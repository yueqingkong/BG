package block.guess.betting.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface BCH3dSelectionContract {

    interface BView extends BaseView<Presenter> {

        void bettingSelected();

        void bottomSelectedClick();

        void registerSensor();

        void unregisterSensor();
    }

    interface Presenter extends BasePresenter {

    }
}
