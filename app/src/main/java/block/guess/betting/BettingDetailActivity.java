package block.guess.betting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.betting.bean.ContractDetailBean;
import block.guess.betting.contract.BettingDetailContract;
import block.guess.betting.presenter.BettingDetailPresenter;
import block.guess.betting.request.BCHContractDetailRequest;
import block.guess.login.bean.UserInfoBean;
import block.guess.utils.StringsUtil;
import block.guess.utils.SystemUtil;
import block.guess.utils.TimeUtil;
import block.guess.utils.imageload.GlideUtil;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.utils.share.AppInfo;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.wallet.bean.StatusEnum;
import block.guess.widget.popupwindow.PopupwindowUtil;
import block.guess.widget.popupwindow.bean.PopupCallback;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.webview.util.BlockChainUrlUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.List;

@Route(path = "/betting/bchdetail")
public class BettingDetailActivity extends BaseActivity implements BettingDetailContract.BView, ToolbarCallback {

    private static final String TAG = "_BCHBettingDetailActivity";

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_betting_category)
    ImageView imgBettingCategory;
    @BindView(R.id.txt_betting_category)
    TextView txtBettingCategory;
    @BindView(R.id.txt_betting_note)
    TextView txtBettingNote;
    @BindView(R.id.img_betting_result)
    ImageView imgBettingResult;
    @BindView(R.id.txt_wining_amount)
    TextView txtWiningAmount;
    @BindView(R.id.constraintlayout_detail_result)
    CoordinatorLayout constraintlayoutDetailResult;
    @BindView(R.id.view_bottom)
    View viewBottom;

    @Autowired
    long contractId;
    @Autowired
    String identifier;

    private BettingDetailActivity activity;
    private BettingDetailContract.Presenter presenter;

    private ContractDetailBean contractDetailBean = null;

    private CategoryEnum category;
    private StatusEnum status;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bchbetting_detail);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new BettingDetailPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setTitleTxt(getString(R.string.betting_detail));
        toolbarBase.setRight(R.mipmap.btn_more_big);
        toolbarBase.setToolbarCallback(this);
    }

    @Override
    public void contractDetailRequest() {
        BCHContractDetailRequest request = new BCHContractDetailRequest("", contractId);
        OKHttpUtil.client().request(request, new BaseCallBack<ContractDetailBean>(activity) {

            @Override
            public void success(ContractDetailBean bean) {
                LogUtil.d(TAG, "" + bean.getContract().getId());

                contractDetailBean = bean;
                contractDetail();
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
    public void contractDetail() {
        category = CategoryEnum.parse(contractDetailBean.getContract().getCategory());
        switch (category) {
            case D3:
                GlideUtil.load(imgBettingCategory, R.mipmap.img_bch_3_d_small);
                txtBettingCategory.setText(activity.getString(R.string.buy_bch3d));
                break;
            case LUCKY:
                GlideUtil.load(imgBettingCategory, R.mipmap.img_luckybch_small);
                txtBettingCategory.setText(activity.getString(R.string.buy_bchlucky));
                break;
            case FREE:
                GlideUtil.load(imgBettingCategory, R.mipmap.img_bch_3_d_small);
                txtBettingCategory.setText(activity.getString(R.string.free_bch_3d));
                break;
            case LOTTO:
                GlideUtil.load(imgBettingCategory, R.mipmap.ic_bchlotto_home);
                txtBettingCategory.setText(activity.getString(R.string.buy_lotto));
                break;
        }

        status = StatusEnum.WAIT;
        if (contractDetailBean.getWinner_list() != null && contractDetailBean.getWinner_list().size() > 0) {
            boolean winner = false;

            UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
            for (ContractDetailBean.WinnerListBean bean : contractDetailBean.getWinner_list()) {
                if (bean.getUser_id() == infoBean.getId()) {
                    winner = true;
                    break;
                }
            }

            if (winner) {
                status = StatusEnum.WIN;
            } else {
                status = StatusEnum.NOT_WIN;
            }
        } else if (contractDetailBean.getPurchase_history() != null && contractDetailBean.getPurchase_history().size() > 0) {
            status = StatusEnum.parse(contractDetailBean.getPurchase_history().get(0).getStatus());
        }

        switch (status) {
            case WAIT:
                txtBettingNote.setText(activity.getString(R.string.to_be_award));
                GlideUtil.load(imgBettingResult, R.mipmap.img_tobeawarded);
                break;
            case WIN:
                txtBettingNote.setText(activity.getString(R.string.the_wining));
                GlideUtil.load(imgBettingResult, R.mipmap.img_win);
                break;
            case NOT_WIN:
                txtBettingNote.setText(activity.getString(R.string.not_award));
                GlideUtil.load(imgBettingResult, R.mipmap.img_lose);
                break;
            case OPEN:
                txtBettingNote.setText(activity.getString(R.string.open_prize));
                GlideUtil.load(imgBettingResult, R.mipmap.img_tobeawarded);
                break;
        }

        if (category != CategoryEnum.D3 && status == StatusEnum.WAIT) {
            toolbarBase.setRightTxt(R.mipmap.btn_more_big);
        }

        winAmount(status);
        number();
        times(category);
        bet(category);
        betContent(category);
        amount(category);
        dateTime();
        txid();
        winningNumber(status);
    }

    @Override
    public void winAmount(StatusEnum status) {
        View view = findViewById(R.id.constraintlayout_detail_result);
        TextView amountTxt = view.findViewById(R.id.txt_wining_amount);

        if (status == StatusEnum.WIN) {
            view.setVisibility(View.VISIBLE);

            int times = contractDetailBean.getContract().getTimes() == 0 ? 1 : contractDetailBean.getContract().getTimes();
            String showAnount = StringsUtil.decimal((long) contractDetailBean.getContract().getUnit() * times);
            amountTxt.setText("+" + showAnount + "BCH");
        }
    }

    @Override
    public void number() {
        View view = findViewById(R.id.include_number);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.no_));
        rightTxt.setText("NO." + contractDetailBean.getContract().getId());
    }

    @Override
    public void times(CategoryEnum category) {
        View view = findViewById(R.id.include_times);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        if (category == CategoryEnum.LUCKY
                || category == CategoryEnum.FREE
                || category == CategoryEnum.LOTTO) {
            view.setVisibility(View.GONE);
        }
        leftTxt.setText(activity.getString(R.string.times));
        rightTxt.setText("" + contractDetailBean.getContract().getTimes());
    }

    @Override
    public void bet(CategoryEnum category) {
        View view = findViewById(R.id.include_bet);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.bet));

        StringBuffer stringBuffer = new StringBuffer();
        if (category == CategoryEnum.FREE) {
            stringBuffer.append("1");
        } else {
            stringBuffer.append(contractDetailBean.getPurchase_history().size());
        }
        rightTxt.setText("" + stringBuffer.toString());
    }

    @Override
    public void betContent(CategoryEnum category) {
        View view = findViewById(R.id.include_beting_content);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.bet_content));

        StringBuffer stringBuffer = new StringBuffer();
        if (category == CategoryEnum.D3) {
            stringBuffer.append(contractDetailBean.getContract().getId());
        } else {
            int numbers = contractDetailBean.getPurchase_history() == null
                    ? 0
                    : contractDetailBean.getPurchase_history().size();
            for (int i = 0; i < numbers; i++) {
                ContractDetailBean.PurchaseHistoryBean bean = contractDetailBean.getPurchase_history().get(i);
                List<ContractDetailBean.PurchaseHistoryBean.PurchaseNumbersBean> numbersBeanList = bean.getPurchase_numbers();
                if (numbersBeanList.size() > 0) {
                    for (ContractDetailBean.PurchaseHistoryBean.PurchaseNumbersBean numbersBean : numbersBeanList) {
                        stringBuffer.append(numbersBean.getAward_number());
                    }

                    if (!(numbers - 1 == i || numbers == 1)) {
                        stringBuffer.append(",");
                    }
                }
            }
        }

        rightTxt.setText(stringBuffer.toString());
    }

    @Override
    public void amount(CategoryEnum category) {
        View view = findViewById(R.id.include_amount);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.amount));
        String amountTxt = StringsUtil.decimal(contractDetailBean.getContract().getTotal_amount()) + "BCH";
        rightTxt.setText(amountTxt);
    }

    @Override
    public void dateTime() {
        View view = findViewById(R.id.include_datetime);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.datetime));
        rightTxt.setText(TimeUtil.timestampFormat(((long) contractDetailBean.getContract().getStart()) * 1000, TimeUtil.FORMAT_TIME));
    }

    @Override
    public void txid() {
        View view = findViewById(R.id.include_txid);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.txid));

        rightTxt.setTextColor(activity.getResources().getColor(R.color.color_132fcb));
        String ellipsis = StringsUtil.ellipsisStartEnd(contractDetailBean.getContract().getCreate_tx_hash());
        rightTxt.setText(ellipsis);
        rightTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hash = contractDetailBean.getContract().getCreate_tx_hash();
                String language = SystemUtil.language(activity);

                String url = BlockChainUrlUtil.txUrl(hash, language);
                ARouter.getInstance().build("/widget/webview")
                        .withString("url", url)
                        .navigation(activity);
            }
        });
    }

    @Override
    public void winningNumber(StatusEnum status) {
        View view = findViewById(R.id.include_wining_number);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.wining_number));
        if (status == StatusEnum.WIN) {
            view.setVisibility(View.VISIBLE);
            viewBottom.setVisibility(View.VISIBLE);
            rightTxt.setText(String.valueOf(contractDetailBean.getContract().getAward_number()));
        } else {
            viewBottom.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
        }
    }

    @Override
    public void presenter(BettingDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {
        // 已经开奖，不能赠送
        if (TextUtils.isEmpty(identifier)) {
            return;
        }

        PopupwindowUtil.show(activity, R.layout.part_popupwindow_gift, toolbarBase.findViewById(R.id.txt_right), 0, 0, new PopupCallback() {
            @Override
            public void createView(final PopupWindow dialog, View view) {
                view.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        ARouter.getInstance().build("/betting/bchgift")
                                .withLong("contractid", contractId)
                                .withString("identifier", identifier)
                                .navigation();

                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
