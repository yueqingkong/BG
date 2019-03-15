package block.guess.betting.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.betting.bean.BettingDetailBean;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.wallet.bean.StatusEnum;

public interface BettingDetailContract {

    interface BView extends BaseView<Presenter> {

        void contractDetailRequest();

        void contractDetail(BettingDetailBean bettingDetailBean);

        void winAmount(BettingDetailBean bettingDetailBean);

        void number(BettingDetailBean bettingDetailBean);

        void times(BettingDetailBean bettingDetailBean);

        void bet(BettingDetailBean bettingDetailBean);

        void betContent(BettingDetailBean bettingDetailBean);

        void amount(BettingDetailBean bettingDetailBean);

        void dateTime(BettingDetailBean bettingDetailBean);

        void txid(BettingDetailBean bettingDetailBean);

        void winningNumber(BettingDetailBean bettingDetailBean);
    }

    interface Presenter extends BasePresenter {
    }
}
