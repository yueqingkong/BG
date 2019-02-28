package block.guess.my.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.wallet.bean.StatusEnum;

public interface BettingRecordDetailContract {

    interface BView extends BaseView<Presenter> {

        void contractDetail();

        void winAmount(StatusEnum status);

        void number();

        void times(CategoryEnum category);

        void bet(CategoryEnum category);

        void betContent(CategoryEnum category);

        void amount(CategoryEnum category);

        void dateTime();

        void txid();

        void winningNumber();
    }

    interface Presenter extends BasePresenter {
    }
}
