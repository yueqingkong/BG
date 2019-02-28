package block.guess.my;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.login.bean.UserInfoBean;
import block.guess.my.adapter.PartnerPlanAdapter;
import block.guess.my.bean.PartnerDynamicBean;
import block.guess.my.bean.PartnerFinanceBean;
import block.guess.my.bean.PartnerInviteeBean;
import block.guess.my.contract.PartnerPlanContact;
import block.guess.my.request.PartnerPlanPresenter;
import block.guess.utils.StringsUtil;
import block.guess.utils.SystemUtil;
import block.guess.utils.share.AppInfo;
import block.guess.widget.dialog.DialogUtil;
import block.guess.widget.dialog.bean.DialogCallback;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/my/partnerplan")
public class PartnerPlanActivity extends BaseActivity implements PartnerPlanContact.BView, DialogCallback {

    private static String TAG = "_PartnerPlanActivity";

    @BindView(R.id.view_bg)
    View viewBg;
    @BindView(R.id.txt_bch_amount)
    TextView txtBchAmount;
    @BindView(R.id.constraintlayout_bg_inviteuser)
    ConstraintLayout constraintlayoutBgInviteuser;
    @BindView(R.id.txt_exclusive_code)
    TextView txtExclusiveCode;
    @BindView(R.id.txt_code)
    TextView txtCode;
    @BindView(R.id.txt_invite)
    TextView txtInvite;
    @BindView(R.id.txt_rules)
    TextView txtRules;
    @BindView(R.id.txt_partner_list)
    TextView txtPartnerList;
    @BindView(R.id.txt_partner_dynamic)
    TextView txtPartnerDynamic;
    @BindView(R.id.txt_left)
    TextView txtLeft;
    @BindView(R.id.txt_right)
    TextView txtRight;
    @BindView(R.id.recycler_list)
    RecyclerView recyclerList;
    @BindView(R.id.img_close)
    ImageView imgClose;
    @BindView(R.id.img_empty)
    ImageView imgEmpty;
    @BindView(R.id.constraintlayout_empty)
    ConstraintLayout constraintlayoutEmpty;
    @BindView(R.id.constraintlayout_bottom)
    ConstraintLayout constraintlayoutBottom;

    private PartnerPlanActivity activity;
    private PartnerPlanAdapter planAdapter;
    private PartnerPlanContact.Presenter presenter;

    private String inviteeCode;
    private PartnerFinanceBean financeBean;
    private List<PartnerInviteeBean> inviteeBeanList;
    private List<PartnerDynamicBean> dynamicBeanList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partnet_plan);
        ButterKnife.bind(this);
        new PartnerPlanPresenter(this).start();
        ARouter.getInstance().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (TextUtils.isEmpty(txtCode.getText().toString())) {
            UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
            if (infoBean != null) {
                inviteeCode = infoBean.getInvite_code();
                txtCode.setText(inviteeCode);

                presenter.financeRequest();
                presenter.inviteeRequest();
                presenter.rewardRequest();
            }
        }
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(true, getResources().getColor(R.color.color_645aff));

        UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
        inviteeCode = infoBean.getInvite_code();
        txtCode.setText(inviteeCode);

        txtLeft.setText(getString(R.string.date));
        txtRight.setText(getString(R.string.username));
        partnerInviteeClick();

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerList.setLayoutManager(layoutManager);
        planAdapter = new PartnerPlanAdapter();
        recyclerList.setAdapter(planAdapter);
    }

    @OnClick({R.id.img_close, R.id.txt_rules, R.id.txt_invite, R.id.txt_partner_list, R.id.txt_partner_dynamic})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.img_close:
                activity.finish();
                break;
            case R.id.txt_rules:
                rulesDialog();
                break;
            case R.id.txt_invite:
                String title = getString(R.string.share);
                String content = getString(R.string.share_content, inviteeCode, inviteeCode);
                SystemUtil.share(activity, title, content);
                break;
            case R.id.txt_partner_list:
                partnerInviteeClick();
                break;
            case R.id.txt_partner_dynamic:
                partnerDynamicClick();
                break;
        }
    }

    @Override
    public void financeInfo(PartnerFinanceBean bean) {
        financeBean = bean;

        long total = financeBean.getTotal_coin();
        String rewardTotal = "+" + StringsUtil.decimal(total) + "BCH";
        txtBchAmount.setText(rewardTotal);
    }

    @Override
    public void inviteeInfo(List<PartnerInviteeBean> beans) {
        inviteeBeanList = beans;
        partnerInviteeClick();
    }

    @Override
    public void rewardInfo(List<PartnerDynamicBean> beans) {
        dynamicBeanList = beans;
    }

    @Override
    public void partnerInviteeClick() {
        txtLeft.setText(getString(R.string.date));
        txtRight.setText(getString(R.string.username));

        txtPartnerList.setSelected(true);
        txtPartnerList.setTextColor(getResources().getColor(R.color.color_white));
        txtPartnerDynamic.setSelected(false);
        txtPartnerDynamic.setTextColor(getResources().getColor(R.color.color_645aff));

        if (inviteeBeanList != null && inviteeBeanList.size() > 0) {
            constraintlayoutEmpty.setVisibility(View.GONE);
            constraintlayoutBottom.setVisibility(View.VISIBLE);
            planAdapter.setDatas(inviteeBeanList);
        } else {
            constraintlayoutEmpty.setVisibility(View.VISIBLE);
            constraintlayoutBottom.setVisibility(View.GONE);
        }
    }

    @Override
    public void partnerDynamicClick() {
        txtLeft.setText(getString(R.string.username));
        txtRight.setText(getString(R.string.dividend));

        txtPartnerList.setSelected(false);
        txtPartnerList.setTextColor(getResources().getColor(R.color.color_645aff));
        txtPartnerDynamic.setSelected(true);
        txtPartnerDynamic.setTextColor(getResources().getColor(R.color.color_white));

        if (dynamicBeanList != null && dynamicBeanList.size() > 0) {
            constraintlayoutEmpty.setVisibility(View.GONE);
            constraintlayoutBottom.setVisibility(View.VISIBLE);
            planAdapter.setDatas(dynamicBeanList);
        } else {
            constraintlayoutEmpty.setVisibility(View.VISIBLE);
            constraintlayoutBottom.setVisibility(View.GONE);
        }
    }

    @Override
    public void rulesDialog() {
        DialogUtil.show(activity, R.layout.dialog_partner_plan, this);
    }

    @Override
    public void presenter(PartnerPlanContact.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void createView(final Dialog dialog, View view) {
        ImageView closeImg = view.findViewById(R.id.img_close);
        closeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        });
    }
}
