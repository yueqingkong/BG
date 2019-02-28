package block.guess.betting.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;

public interface LottoSelectContract {

    interface BView extends BaseView<Presenter> {

        void shaking();

        void bottomStatus();

        void bottomClick();

        void toBetting();

        void registerSensor();

        void unregisterSensor();
    }

    interface Presenter extends BasePresenter {

    }
}
