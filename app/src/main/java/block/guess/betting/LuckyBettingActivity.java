package block.guess.betting;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.betting.contract.LuckyBettingContract;
import block.guess.betting.presenter.BCHLuckyBettingPresenter;
import block.guess.main.bean.HomeBean;
import block.guess.utils.DensityUtils;
import block.guess.utils.StringsUtil;
import block.guess.utils.SystemUtil;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.widget.bar.ProgressBarView;
import block.guess.widget.popupwindow.PopupwindowUtil;
import block.guess.widget.popupwindow.bean.PopupCallback;
import block.guess.widget.snackbar.SnackBarUtil;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.webview.util.BlockChainUrlUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/betting/bchluckybetting")
public class LuckyBettingActivity extends BaseActivity implements LuckyBettingContract.BView, ProgressBarView.ProgressCallBack, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_lucky)
    ImageView imgLucky;
    @BindView(R.id.txt_lucky)
    TextView txtLucky;
    @BindView(R.id.txt_remain_total)
    TextView txtRemainTotal;
    @BindView(R.id.view_progressbar)
    ProgressBarView viewProgressbar;
    @BindView(R.id.txt_selled)
    TextView txtSelled;
    @BindView(R.id.txt_remain)
    TextView txtRemain;
    @BindView(R.id.view_amount_contral)
    View viewAmountContral;
    @BindView(R.id.txt_subtract)
    TextView txtSubtract;
    @BindView(R.id.txt_plus)
    TextView txtPlus;
    @BindView(R.id.edit_amount)
    EditText editAmount;
    @BindView(R.id.view_bottom)
    View viewBottom;
    @BindView(R.id.checkbox_game_rule)
    CheckBox checkboxGameRule;
    @BindView(R.id.txt_agree_rule)
    TextView txtAgreeRule;
    @BindView(R.id.txt_game_rule)
    TextView txtGameRule;
    @BindView(R.id.txt_betting_count)
    TextView txtBettingCount;
    @BindView(R.id.txt_lucky_max_tips)
    TextView txtLuckyMaxTips;
    @BindView(R.id.txt_lucky_max)
    TextView txtLuckyMax;
    @BindView(R.id.txt_pay)
    TextView txtPay;
    @BindView(R.id.constraintlayout_bottom)
    ConstraintLayout constraintlayoutBottom;

    @Autowired
    HomeBean homeBean;

    private LuckyBettingActivity activity;
    private LuckyBettingContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bchlucky_betting);
        ARouter.getInstance().inject(this);
        ButterKnife.bind(this);

        new BCHLuckyBettingPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setRightTxt(R.mipmap.btn_more_big);
        toolbarBase.setToolbarCallback(this);

        txtLucky.setText(getString(R.string.betting_bchlucky_stage, homeBean.getContract().getId()));

        int total = (int) homeBean.getContract().getTimes();
        int remain = homeBean.getContract().getRemaining();

        txtRemainTotal.setText(getString(R.string.remain_full, remain, total));
        txtSelled.setText(getString(R.string.selled_amount, 0));
        txtRemain.setText(getString(R.string.remained_amount, total));

        int order = total - remain;
        viewProgressbar.setProgressCallBack(this);
        viewProgressbar.progress(order, total);

        editAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                updateLuckyTips();
            }
        });
    }

    @OnClick({R.id.txt_subtract, R.id.txt_plus, R.id.txt_pay, R.id.txt_game_rule})
    void OnClic(View view) {
        switch (view.getId()) {
            case R.id.txt_subtract:
                String string = editAmount.getText().toString();
                if (TextUtils.isEmpty(string) || Integer.parseInt(string) == 1) {
                    SnackBarUtil.error(activity, getString(R.string.betting_at_least_one));
                } else {
                    int subInt = Integer.parseInt(string) - 1;
                    editAmount.setText(String.valueOf(subInt));
                }
                break;
            case R.id.txt_plus:
                String plusString = editAmount.getText().toString();
                int plusInt = 0;
                if (TextUtils.isEmpty(plusString)) {
                    plusInt = 1;
                } else {
                    plusInt = Integer.parseInt(plusString) + 1;
                }
                editAmount.setText(String.valueOf(plusInt));
                break;
            case R.id.txt_pay:
                payClick();
                break;
            case R.id.txt_game_rule:
                gameRule();
                break;
        }
    }

    private void gameRule() {
        String category = CategoryEnum.LUCKY.getCategory() + "";
        String language = SystemUtil.language(activity);
        String ruleUrl = BlockChainUrlUtil.gameRule(category, language);

        ARouter.getInstance().build("/widget/webview")
                .withString("url", ruleUrl)
                .navigation(activity);
    }

    @Override
    public void updateLuckyTips() {
        String string = editAmount.getText().toString();
        int stakes = 0;
        if (TextUtils.isEmpty(string) || Integer.parseInt(string) == 0) {
            stakes = 1;
            editAmount.setText("1");
        } else {
            stakes = Integer.parseInt(string);
        }

        long payAmount = 100000 * stakes;
        txtBettingCount.setText(getString(R.string.decimal_bch, StringsUtil.decimal(payAmount)));
        txtLuckyMax.setText(getString(R.string.decimal_bch, StringsUtil.decimal(payAmount * 1000)));
    }

    @Override
    public void payClick() {
        String string = editAmount.getText().toString();
        if (TextUtils.isEmpty(string) || Integer.parseInt(string) == 0) {
            SnackBarUtil.error(activity, getString(R.string.betting_at_least_one));
        } else if (!checkboxGameRule.isChecked()) {
            SnackBarUtil.error(activity, getString(R.string.please_agree_rule));
        } else {
            txtPay.setEnabled(false);

            long id = homeBean.getContract().getId();
            int stakes = Integer.parseInt(string);
            presenter.payRequest(id, stakes);
        }
    }

    @Override
    public void paySuccess(long contractid,String identifier) {
        ARouter.getInstance().build("/betting/bchpaysuccess")
                .withLong("contractId", contractid)
                .withString("identifier", identifier)
                .navigation(activity);
    }

    @Override
    public void payFail() {
        txtPay.setEnabled(true);
    }

    @Override
    public void presenter(LuckyBettingContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {
        int leftMargin = DensityUtils.dip2px(-80);
        int topMargin = DensityUtils.dip2px(14);

        PopupwindowUtil.show(activity, R.layout.part_popupwindow_gamerule, toolbarBase.findViewById(R.id.txt_right), leftMargin, topMargin, new PopupCallback() {
            @Override
            public void createView(final PopupWindow dialog, View view) {
                view.findViewById(R.id.txt_gamerule).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String category = CategoryEnum.LUCKY.getCategory() + "";
                        String language = SystemUtil.language(activity);
                        String ruleUrl = BlockChainUrlUtil.gameRule(category, language);

                        ARouter.getInstance().build("/widget/webview")
                                .withString("url", ruleUrl)
                                .navigation(activity);

                        dialog.dismiss();
                    }
                });

                view.findViewById(R.id.txt_contractaddress).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String address = homeBean.getContract().getAddress();
                        String url = BlockChainUrlUtil.btccomAddress(address);
                        ARouter.getInstance().build("/widget/webview")
                                .withString("url", url)
                                .navigation(activity);

                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public void drawProgress(int progress, int total) {
        int remain = total - progress;
        txtSelled.setText(getString(R.string.selled_amount, progress));
        txtRemain.setText(getString(R.string.remained_amount, remain));
    }
}
