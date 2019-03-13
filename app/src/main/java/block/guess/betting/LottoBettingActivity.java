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
import android.widget.RelativeLayout;
import android.widget.TextView;

import block.guess.base.BACallBack;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.betting.adapter.LottoBettingAdapter;
import block.guess.betting.bean.LottoBean;
import block.guess.betting.contract.LottoBettingContract;
import block.guess.betting.presenter.LottoBettingPresenter;
import block.guess.main.bean.HomeBean;
import block.guess.utils.DensityUtils;
import block.guess.utils.StringsUtil;
import block.guess.utils.SystemUtil;
import block.guess.utils.imageload.GlideUtil;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.widget.BettingEndTextView;
import block.guess.widget.ClockCountView;
import block.guess.widget.popupwindow.PopupwindowUtil;
import block.guess.widget.popupwindow.bean.PopupCallback;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import block.guess.widget.snackbar.SnackBarUtil;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.webview.util.BlockChainUrlUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/betting/lottobetting")
public class LottoBettingActivity extends BaseActivity implements LottoBettingContract.BView, ToolbarCallback, LottoBettingAdapter.LottoBettingCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_category)
    ImageView imgCategory;
    @BindView(R.id.txt_stage_number)
    TextView txtStageNumber;
    @BindView(R.id.view_clock)
    ClockCountView viewClock;
    @BindView(R.id.txt_date_end)
    BettingEndTextView txtDateEnd;
    @BindView(R.id.txt_bch3d_select_single)
    TextView txtBch3dSelectSingle;
    @BindView(R.id.txt_bch3d_select_four)
    TextView txtBch3dSelectFour;
    @BindView(R.id.txt_bch3d_select_hands)
    TextView txtBch3dSelectHands;
    @BindView(R.id.view_top)
    View viewTop;
    @BindView(R.id.recycler_betting)
    RecyclerView recyclerBetting;
    @BindView(R.id.checkbox_game_rule)
    CheckBox checkboxGameRule;
    @BindView(R.id.txt_agree_rule)
    TextView txtAgreeRule;
    @BindView(R.id.txt_game_rule)
    TextView txtGameRule;
    @BindView(R.id.txt_clear_all)
    TextView txtClearAll;
    @BindView(R.id.constraintlayout_print_card)
    RelativeLayout constraintlayoutPrintCard;
    @BindView(R.id.view_bottom)
    View viewBottom;
    @BindView(R.id.txt_betting_count)
    TextView txtBettingCount;
    @BindView(R.id.txt_betting_bch)
    TextView txtBettingBch;
    @BindView(R.id.txt_win_bch)
    TextView txtWinBch;
    @BindView(R.id.txt_bch_amount)
    TextView txtBchAmount;
    @BindView(R.id.txt_buy)
    TextView txtBuy;
    @BindView(R.id.view_calculate_plus_subtract)
    View viewCalculatePlusSubtract;
    @BindView(R.id.view_subtract)
    View viewSubtract;
    @BindView(R.id.edit_amount)
    EditText editAmount;
    @BindView(R.id.view_plus)
    View viewPlus;
    @BindView(R.id.txt_pay)
    TextView txtPay;
    @BindView(R.id.constraintlayout_bottom)
    ConstraintLayout constraintlayoutBottom;

    @Autowired
    HomeBean homeBean;
    @Autowired
    ArrayList<LottoBean> bettingBeans;

    private LottoBettingContract.Presenter presenter;

    private LottoBettingActivity activity;
    private LottoBettingAdapter lottoBettingAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotto_betting);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new LottoBettingPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setRightTxt(R.mipmap.btn_more_big);
        toolbarBase.setToolbarCallback(this);

        GlideUtil.load(imgCategory, R.mipmap.ic_bchlotto_home);

        viewClock.init(homeBean.getContract().getEnd());
        txtStageNumber.setText(getString(R.string.betting_lotto_stage, homeBean.getContract().getId()));
        txtDateEnd.init(R.string.betting_bch3d_end, homeBean.getContract().getStart(), homeBean.getContract().getEnd());

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        BaseItemDecoration itemDecoration = new BaseItemDecoration(0, 0, 0, 0, R.color.color_d3d8ef, 1, true);
        recyclerBetting.setLayoutManager(layoutManager);
        recyclerBetting.addItemDecoration(itemDecoration);
        lottoBettingAdapter = new LottoBettingAdapter(bettingBeans);
        recyclerBetting.setAdapter(lottoBettingAdapter);
        lottoBettingAdapter.setLottoBettingCallback(this);

        timesNotes();
        editAmount.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                timesNotes();
            }
        });
    }

    @Override
    public void presenter(LottoBettingContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @OnClick({R.id.txt_bch3d_select_single, R.id.txt_bch3d_select_four
            , R.id.txt_bch3d_select_hands, R.id.txt_pay
            , R.id.txt_clear_all, R.id.view_subtract
            , R.id.view_plus
            , R.id.txt_game_rule})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.txt_bch3d_select_single:
                singleClick();
                break;
            case R.id.txt_bch3d_select_four:
                fourClick();
                break;
            case R.id.txt_bch3d_select_hands:
                handsClick();
                break;
            case R.id.txt_pay:
                payCheck();
                break;
            case R.id.txt_clear_all:
                clearAll();
                break;
            case R.id.view_subtract:
                subtract();
                break;
            case R.id.view_plus:
                plus();
                break;
            case R.id.txt_game_rule:
                gameRule();
                break;
        }
    }

    private void gameRule() {
        String category = CategoryEnum.LOTTO.getCategory() + "";
        String language = SystemUtil.language(activity);
        BlockChainUrlUtil.gameRule(activity, category, language);
    }

    @Override
    public void singleClick() {
        if (bettingBeans.size() < 5) {
            LottoBean lottoBean = new LottoBean();
            lottoBean.randomNumber();
            bettingBeans.add(lottoBean);

            updateBeans(bettingBeans);
        } else {
            SnackBarUtil.error(activity, activity.getString(R.string.betting_count_, 5));
        }
    }

    @Override
    public void fourClick() {
        if (bettingBeans.size() < 5) {
            int remain = 5 - bettingBeans.size();
            if (remain > 4) {
                remain = 4;
            }

            for (int i = 0; i < remain; i++) {
                LottoBean lottoBean = new LottoBean();
                lottoBean.randomNumber();
                bettingBeans.add(lottoBean);
            }

            updateBeans(bettingBeans);
        } else {
            SnackBarUtil.error(activity, activity.getString(R.string.betting_count_, 5));
        }
    }

    @Override
    public void handsClick() {
        if (bettingBeans.size() < 5) {
            ARouter.getInstance().build("/betting/lottoselect")
                    .withSerializable("homeBean", homeBean)
                    .withSerializable("bettingBeans", bettingBeans)
                    .navigation(activity);
        } else {
            SnackBarUtil.error(activity, activity.getString(R.string.betting_count_, 5));
        }
    }

    @Override
    public void timesNotes() {
        int select = bettingBeans.size();
        String string = editAmount.getText().toString();
        int times = 0;
        if (TextUtils.isEmpty(string) || Integer.parseInt(string) == 0) {
            times = 1;
            editAmount.setText("1");
        } else {
            times = Integer.parseInt(string);
        }

        txtBettingCount.setText(getString(R.string.total_select_times, select, times));

        double single = ((double) homeBean.getContract().getUnit()) / (100000000d);
        double payTotal = select * times * single;
        txtBettingBch.setText(getString(R.string.pay_bch, StringsUtil.decimal((long) (payTotal * StringsUtil.Unit))));

        double winTotal = single * homeBean.getContract().getTimes();//固定倍数 25000
        if (select == 0) {
            winTotal = 0;
        }
        txtBchAmount.setText(getString(R.string.pay_bch, StringsUtil.decimal((long) (winTotal * StringsUtil.Unit))));
    }

    @Override
    public void payCheck() {
        if (TextUtils.isEmpty(editAmount.getText().toString())) {
        } else if (!checkboxGameRule.isChecked()) {
            SnackBarUtil.error(activity, getString(R.string.please_agree_rule));
        } else {
            txtPay.setAlpha(0.5f);
            txtPay.setEnabled(false);

            int times = Integer.parseInt(editAmount.getText().toString());
            presenter.payClick(homeBean, times, bettingBeans, new BACallBack<Boolean>(){
                @Override
                public void success(Boolean aBoolean) {
                    txtPay.setEnabled(true);
                    txtPay.setAlpha(1f);
                }

                @Override
                public void error(int code, String err) {
                    txtPay.setEnabled(true);
                    txtPay.setAlpha(1f);
                }

                @Override
                public void error() {
                    txtPay.setEnabled(true);
                    txtPay.setAlpha(1f);
                }
            });
        }
    }

    @Override
    public void clearAll() {
        bettingBeans.clear();
        updateBeans(bettingBeans);
    }

    @Override
    public void subtract() {
        String string = editAmount.getText().toString();
        if (TextUtils.isEmpty(string) || Integer.parseInt(string) == 1) {
            SnackBarUtil.error(activity, getString(R.string.times_at_least_, 1));
        } else {
            Integer integer = Integer.parseInt(editAmount.getText().toString());
            integer--;
            editAmount.setText(String.valueOf(integer));

            timesNotes();
        }
    }

    @Override
    public void plus() {
        Integer integer = Integer.parseInt(editAmount.getText().toString());
        if (integer == 10) {
            SnackBarUtil.error(activity, getString(R.string.times_at_most_, integer));
        } else {
            integer++;
            editAmount.setText(String.valueOf(integer));

            timesNotes();
        }
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
                        String category = CategoryEnum.LOTTO.getCategory() + "";
                        String language = SystemUtil.language(activity);
                        BlockChainUrlUtil.gameRule(activity, category, language);

                        dialog.dismiss();
                    }
                });

                view.findViewById(R.id.txt_contractaddress).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String address = homeBean.getContract().getAddress();
                        String url = BlockChainUrlUtil.addressUrl(address, SystemUtil.language(activity));
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
    public void delete(LottoBean bean) {
        bettingBeans.remove(bean);
        updateBeans(bettingBeans);
    }

    @Override
    public void detail(LottoBean bean) {
        bettingBeans.remove(bean);

        ARouter.getInstance().build("/betting/lottoselect")
                .withSerializable("homeBean", homeBean)
                .withSerializable("currentBean", bean)
                .withSerializable("bettingBeans", bettingBeans)
                .navigation(activity);
    }

    @Override
    public void updateBeans(List<LottoBean> beans) {
        lottoBettingAdapter.update(beans);
        timesNotes();
    }

    @Override
    public void paySuccess(long contractid, String identifier) {
        ARouter.getInstance().build("/betting/bchpaysuccess")
                .withLong("contractId", contractid)
                .withString("identifier", identifier)
                .withInt("category",homeBean.getContract().getCategory())
                .navigation(activity);
    }

    public void setPresenter(LottoBettingContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
