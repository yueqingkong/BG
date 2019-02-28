package block.guess.betting.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.wallet.bean.StatusEnum;

public interface BCHBettingDetailContract {

    interface BView extends BaseView<Presenter> {

        void contractDetailRequest();

        void contractDetail();

        void winAmount(StatusEnum status);

        void number();

        void times(CategoryEnum category);

        void bet(CategoryEnum category);

        void betContent(CategoryEnum category);

        void amount(CategoryEnum category);

        void dateTime();

        void txid();

        void winningNumber(StatusEnum status);
    }

    interface Presenter extends BasePresenter {
    }
}
