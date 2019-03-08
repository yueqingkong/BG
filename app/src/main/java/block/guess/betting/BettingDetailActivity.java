package block.guess.betting;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.betting.bean.BettingDetailBean;
import block.guess.betting.contract.BettingDetailContract;
import block.guess.betting.presenter.BettingDetailPresenter;
import block.guess.betting.request.BettingDetailRequest;
import block.guess.utils.StringsUtil;
import block.guess.utils.SystemUtil;
import block.guess.utils.TimeUtil;
import block.guess.utils.imageload.GlideUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.wallet.bean.StatusEnum;
import block.guess.widget.popupwindow.PopupwindowUtil;
import block.guess.widget.popupwindow.bean.PopupCallback;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.webview.util.BlockChainUrlUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

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
    int status;
    @Autowired
    String identifier;

    private BettingDetailActivity activity;
    private BettingDetailContract.Presenter presenter;

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
        BettingDetailRequest request = new BettingDetailRequest(contractId,status);
        OKHttpUtil.client().request(request, new BaseCallBack<List<BettingDetailBean>>(activity) {

            @Override
            public void success(List<BettingDetailBean> bean) {
                contractDetail(bean.get(0));
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
    public void contractDetail(BettingDetailBean bettingDetailBean) {
        CategoryEnum category = CategoryEnum.parse(bettingDetailBean.getCategory());
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

        StatusEnum status = StatusEnum.parse(bettingDetailBean.getStatus());
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

        winAmount(bettingDetailBean);
        number(bettingDetailBean);
        times(bettingDetailBean);
        bet(bettingDetailBean);
        betContent(bettingDetailBean);
        amount(bettingDetailBean);
        dateTime(bettingDetailBean);
        txid(bettingDetailBean);
        winningNumber(bettingDetailBean);
    }

    @Override
    public void winAmount(BettingDetailBean bettingDetailBean) {
        View view = findViewById(R.id.constraintlayout_detail_result);
        TextView amountTxt = view.findViewById(R.id.txt_wining_amount);

        if (StatusEnum.parse(bettingDetailBean.getStatus()) == StatusEnum.WIN) {
            view.setVisibility(View.VISIBLE);

            long unit = bettingDetailBean.getUnit();
            int times = bettingDetailBean.getTimes() == 0 ? 1 : bettingDetailBean.getTimes();

            String showAnount = StringsUtil.decimal(unit * times);
            amountTxt.setText("+" + showAnount + "BCH");
        }
    }

    @Override
    public void number(BettingDetailBean bettingDetailBean) {
        View view = findViewById(R.id.include_number);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.no_));
        rightTxt.setText("NO." + bettingDetailBean.getPeriod());
    }

    @Override
    public void times(BettingDetailBean bettingDetailBean) {
        View view = findViewById(R.id.include_times);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        CategoryEnum category = CategoryEnum.parse(bettingDetailBean.getCategory());
        if (category == CategoryEnum.LUCKY
                || category == CategoryEnum.FREE
                || category == CategoryEnum.LOTTO) {
            view.setVisibility(View.GONE);
        }
        leftTxt.setText(activity.getString(R.string.times));
        rightTxt.setText("" + bettingDetailBean.getTimes());
    }

    @Override
    public void bet(BettingDetailBean bettingDetailBean) {
        View view = findViewById(R.id.include_bet);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.bet));

        StringBuffer stringBuffer = new StringBuffer();

        CategoryEnum category = CategoryEnum.parse(bettingDetailBean.getCategory());
        if (category == CategoryEnum.FREE) {
            stringBuffer.append("1");
        } else {
            stringBuffer.append(bettingDetailBean.getPurchase_numbers().size());
        }
        rightTxt.setText("" + stringBuffer.toString());
    }

    @Override
    public void betContent(BettingDetailBean bettingDetailBean) {
        View view = findViewById(R.id.include_beting_content);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.bet_content));

        StringBuffer stringBuffer = new StringBuffer();

        int numbers = bettingDetailBean.getPurchase_numbers().size();
        int index = 0;
        for (BettingDetailBean.PurchaseNumbersBean numbersBean : bettingDetailBean.getPurchase_numbers()) {
            stringBuffer.append(numbersBean.getAward_number());
            if (!(numbers - 1 == index)) {
                stringBuffer.append(",");
            }
            index++;
        }

        rightTxt.setText(stringBuffer.toString());
    }

    @Override
    public void amount(BettingDetailBean bettingDetailBean) {
        View view = findViewById(R.id.include_amount);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.amount));
        String amountTxt = StringsUtil.decimal(bettingDetailBean.getTotal_amount()) + "BCH";
        rightTxt.setText(amountTxt);
    }

    @Override
    public void dateTime(BettingDetailBean bettingDetailBean) {
        View view = findViewById(R.id.include_datetime);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.datetime));
        rightTxt.setText(TimeUtil.timestampFormat(bettingDetailBean.getCreated_at() * 1000, TimeUtil.FORMAT_TIME));
    }

    @Override
    public void txid(BettingDetailBean bettingDetailBean) {
        View view = findViewById(R.id.include_txid);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.txid));

        rightTxt.setTextColor(activity.getResources().getColor(R.color.color_132fcb));
        String ellipsis = StringsUtil.ellipsisStartEnd(bettingDetailBean.getTx_hash());
        rightTxt.setText(ellipsis);
        rightTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hash = bettingDetailBean.getTx_hash();
                String language = SystemUtil.language(activity);

                String url = BlockChainUrlUtil.txUrl(hash, language);
                ARouter.getInstance().build("/widget/webview")
                        .withString("url", url)
                        .navigation(activity);
            }
        });
    }

    @Override
    public void winningNumber(BettingDetailBean bettingDetailBean) {
        View view = findViewById(R.id.include_wining_number);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(activity.getString(R.string.wining_number));

        StatusEnum status = StatusEnum.parse(bettingDetailBean.getStatus());
        if (status == StatusEnum.WIN) {
            view.setVisibility(View.VISIBLE);
            viewBottom.setVisibility(View.VISIBLE);
            //rightTxt.setText(String.valueOf(bettingDetailBean));
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
