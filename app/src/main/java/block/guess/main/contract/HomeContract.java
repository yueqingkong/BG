package block.guess.main.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.betting.bean.BCH3dBuyBean;

public interface HomeContract {

    interface BView extends BaseView<Presenter> {

        void balance();

        void bannerListRequest();

        void homeRequest();

        void free3dDialogPopup();

        void awardAnim(long contractid);
    }

    interface Presenter extends BasePresenter {

        void free3DDetail(int contractid);

        void freen3DReceive(int contractid, BCH3dBuyBean.RandomItem item);

        void awardRequest(int category);
    }
}
