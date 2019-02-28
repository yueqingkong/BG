package block.guess.main.contract;

import android.app.Activity;

import java.util.List;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.main.bean.RankingBean;

public interface LotteryRankingContract {

    interface BView extends BaseView<Presenter> {

        void godPlayderClick();

        void superPlayerClick();

        void bestPartnerClick();

        void rankingSuccess(List<RankingBean> beans);

        Activity activity();
    }

    interface Presenter extends BasePresenter {
        void rankingRequest(int category);
    }
}
