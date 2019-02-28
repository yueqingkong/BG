package block.guess.my.request;

import android.app.Activity;

import java.util.List;

import block.guess.my.bean.PartnerDynamicBean;
import block.guess.my.bean.PartnerFinanceBean;
import block.guess.my.bean.PartnerInviteeBean;
import block.guess.my.contract.PartnerPlanContact;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;

public class PartnerPlanPresenter implements PartnerPlanContact.Presenter {

    private static String TAG = "_PartnerPlanPresenter";

    private Activity activity;
    private PartnerPlanContact.BView baseView;

    public PartnerPlanPresenter(PartnerPlanContact.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }


    @Override
    public void start() {
        activity = (Activity) baseView;
        baseView.init();
    }


    @Override
    public void financeRequest() {
        PartnerFinanceRequest request = new PartnerFinanceRequest("");
        OKHttpUtil.client().request(request, new BaseCallBack<PartnerFinanceBean>(activity) {
            @Override
            public void success(PartnerFinanceBean bean) {
                LogUtil.d(TAG, "financeRequest:" + String.valueOf(bean.getTotal_coin()));
                baseView.financeInfo(bean);
            }

            @Override
            public void serverError(int code, String err) {

            }

            @Override
            public void netError() {

            }
        });
    }

    @Override
    public void inviteeRequest() {
        PartnerInviteeRequest request = new PartnerInviteeRequest("");
        OKHttpUtil.client().request(request, new BaseCallBack<List<PartnerInviteeBean>>(activity) {
            @Override
            public void success(List<PartnerInviteeBean> beans) {
                LogUtil.d(TAG, "inviteeRequest:" + String.valueOf(beans.size()));
                baseView.inviteeInfo(beans);
            }

            @Override
            public void serverError(int code, String err) {

            }

            @Override
            public void netError() {

            }
        });
    }

    @Override
    public void rewardRequest() {
        PartnerRewardRequest request = new PartnerRewardRequest("");
        OKHttpUtil.client().request(request, new BaseCallBack<List<PartnerDynamicBean>>(activity) {
            @Override
            public void success(List<PartnerDynamicBean> beans) {
                LogUtil.d(TAG, "rewardRequest:" + String.valueOf(beans.size()));
                baseView.rewardInfo(beans);
            }

            @Override
            public void serverError(int code, String err) {

            }

            @Override
            public void netError() {

            }
        });
    }
}
