package block.guess.my.contract;

import java.util.List;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.my.bean.PartnerDynamicBean;
import block.guess.my.bean.PartnerFinanceBean;
import block.guess.my.bean.PartnerInviteeBean;

public interface PartnerPlanContact {

    interface BView extends BaseView<Presenter> {

        void financeInfo(PartnerFinanceBean bean);

        void inviteeInfo(List<PartnerInviteeBean> beans);

        void rewardInfo(List<PartnerDynamicBean> beans);

        void partnerInviteeClick();

        void partnerDynamicClick();

        void rulesDialog();
    }

    interface Presenter extends BasePresenter {

        void financeRequest();

        void inviteeRequest();

        void rewardRequest();
    }
}
