package block.guess.betting.contract;

import java.util.List;

import block.guess.base.BACallBack;
import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.betting.bean.LottoBean;
import block.guess.main.bean.HomeBean;
import block.guess.utils.okhttp.Callback.BaseCallBack;

public interface LottoBettingContract {

    interface BView extends BaseView<Presenter> {

        void singleClick();

        void fourClick();

        void handsClick();

        void timesNotes();

        void updateBeans(List<LottoBean> beans);

        void payCheck();

        void clearAll();

        void subtract();

        void plus();

        void paySuccess(long contractid,String identifier);
    }

    interface Presenter extends BasePresenter {
        void payClick(HomeBean homeBean, int times, List<LottoBean> beans, BACallBack<Boolean> callBack);
    }
}
