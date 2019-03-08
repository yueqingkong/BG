package block.guess.my;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.my.bean.RecordDetailBean;
import block.guess.my.contract.BettingRecordDetailContract;
import block.guess.my.presenter.BettingRecordDetailPresenter;
import block.guess.utils.DensityUtils;
import block.guess.utils.StringsUtil;
import block.guess.utils.SystemUtil;
import block.guess.utils.TimeUtil;
import block.guess.utils.imageload.GlideUtil;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.wallet.bean.StatusEnum;
import block.guess.widget.popupwindow.PopupwindowUtil;
import block.guess.widget.popupwindow.bean.PopupCallback;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.webview.util.BlockChainUrlUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/my/bettingrecorddetail")
public class BettingRecordDetailActivity extends BaseActivity implements BettingRecordDetailContract.BView, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.view_bettingdetail_top)
    View viewBettingdetailTop;
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
    RecordDetailBean recordDetailBean;

    private BettingRecordDetailActivity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bettingrecord_detail);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new BettingRecordDetailPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setTitleTxt(getString(R.string.betting_detail));
        toolbarBase.setToolbarCallback(this);
    }

    @Override
    public void contractDetail() {
        CategoryEnum category = CategoryEnum.parse(recordDetailBean.getCategory());
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

        StatusEnum status = StatusEnum.parse(recordDetailBean.getStatus());
        switch (status) {
            case WAIT:
                txtBettingNote.setText(activity.getString(R.string.to_be_award));
                GlideUtil.load(imgBettingResult, R.mipmap.img_tobeawarded);
                toolbarBase.setRightTxt(R.mipmap.btn_more_big);
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
        winningNumber();
    }

    @Override
    public void winAmount(StatusEnum status) {
        View view = findViewById(R.id.constraintlayout_detail_result);
        TextView amountTxt = view.findViewById(R.id.txt_wining_amount);

        if (status == StatusEnum.WIN) {
            view.setVisibility(View.VISIBLE);
            String showAnount = StringsUtil.decimal((long) recordDetailBean.getContract().getMax_prize());
            amountTxt.setText("+" + showAnount + "BCH");
        }
    }

    @Override
    public void number() {
        View view = findViewById(R.id.include_number);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.no_));
        rightTxt.setText("NO." + recordDetailBean.getContract_id());
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
        rightTxt.setText("" + recordDetailBean.getTimes());
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
            stringBuffer.append(recordDetailBean.getPurchase_numbers().size());
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
        int numbers = recordDetailBean.getPurchase_numbers().size();
        for (int i = 0; i < numbers; i++) {
            RecordDetailBean.PurchaseNumbersBean bean = recordDetailBean.getPurchase_numbers().get(i);
            stringBuffer.append(bean.getAward_number());
            if (!(numbers - 1 == i || numbers == 1)) {
                stringBuffer.append(",");
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
        String amountTxt = StringsUtil.decimal(recordDetailBean.getTotal_amount()) + "BCH";
        rightTxt.setText(amountTxt);
    }

    @Override
    public void dateTime() {
        View view = findViewById(R.id.include_datetime);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.datetime));
        rightTxt.setText(TimeUtil.timestampFormat(recordDetailBean.getCreated_at() * 1000, TimeUtil.FORMAT_TIME));
    }

    @Override
    public void txid() {
        View view = findViewById(R.id.include_txid);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.txid));

        rightTxt.setTextColor(activity.getResources().getColor(R.color.color_132fcb));
        String ellipsis = StringsUtil.ellipsisStartEnd(recordDetailBean.getTx_hash());
        rightTxt.setText(ellipsis);
        rightTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hash = recordDetailBean.getTx_hash();
                String language = SystemUtil.language(activity);

                String url = BlockChainUrlUtil.txUrl(hash, language);
                ARouter.getInstance().build("/widget/webview")
                        .withString("url", url)
                        .navigation(activity);
            }
        });
    }

    @Override
    public void winningNumber() {
        View view = findViewById(R.id.include_wining_number);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.wining_number));
        StatusEnum statusEnum = StatusEnum.parse(recordDetailBean.getStatus());
        if (statusEnum == StatusEnum.WIN) {
            viewBottom.setVisibility(View.VISIBLE);
            view.setVisibility(View.VISIBLE);
            rightTxt.setText(String.valueOf(recordDetailBean.getContract().getAward_number()));
        } else {
            viewBottom.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
        }
    }

    @Override
    public void presenter(BettingRecordDetailContract.Presenter presenter) {

    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {
        int leftMargin = DensityUtils.dip2px(-80);
        int topMargin = DensityUtils.dip2px(14);

        PopupwindowUtil.show(activity, R.layout.part_popupwindow_gift, toolbarBase.findViewById(R.id.txt_right), leftMargin, topMargin, new PopupCallback() {
            @Override
            public void createView(final PopupWindow dialog, View view) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        long contractid = recordDetailBean.getContract_id();
                        String identify = recordDetailBean.getIdentifier();
                        String txHash = recordDetailBean.getTx_hash();

                        ARouter.getInstance().build("/betting/bchgift")
                                .withLong("contractid", contractid)
                                .withString("identifier", identify)
                                .withString("txhash", txHash)
                                .navigation();

                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
