package block.guess.betting.contract;

import java.util.List;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.betting.bean.Betting3DBean;
import block.guess.main.bean.HomeBean;

public interface BCH3DBettingContract {

    interface BView extends BaseView<Presenter> {

        void singleClick();

        void fourClick();

        void handsClick();

        void timesNotes();

        void updateBeans(List<Betting3DBean> beans);

        void payCheck();

        void clearAll();

        void subtract();

        void plus();

        void paySuccess(long contractid,String identifier);

        void payFail();
    }

    interface Presenter extends BasePresenter {
        void payClick(HomeBean homeBean, int times, List<Betting3DBean> beans);
    }
}
