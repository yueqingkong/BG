package block.guess.wallet;

import android.graphics.Paint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.main.bean.HistoryBean;
import block.guess.utils.MathUtil;
import block.guess.utils.SystemUtil;
import block.guess.utils.TimeUtil;
import block.guess.wallet.bean.TransactionCategoryEnum;
import block.guess.wallet.contract.TransactionDetailContract;
import block.guess.wallet.presenter.TransactionDetailPresenter;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.webview.util.BlockChainUrlUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/wallet/transactiondetail")
public class TransactionDetailActivity extends BaseActivity implements TransactionDetailContract.BView, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.txt_bch_amount)
    TextView txtBchAmount;
    @BindView(R.id.view_dash)
    View viewDash;

    @Autowired
    HistoryBean historyBean;

    private static String TAG = "_TransactionDetailActivity";
    private TransactionDetailActivity activity;
    private TransactionDetailContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transation_detail);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new TransactionDetailPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setTitleTxt(getString(R.string.transaction_detile));
        toolbarBase.setToolbarCallback(this);

        long diff = historyBean.getBalance_diff();
        String showAmount = (diff > 0 ? "+" : "") + MathUtil.format(diff);
        txtBchAmount.setText(String.format("%sBCH", showAmount));
    }

    @Override
    public void category() {
        View view = findViewById(R.id.include_category);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(getString(R.string.category));
        rightTxt.setText(TransactionCategoryEnum.string(activity, historyBean.getOp_category().getCategory()));
    }

    @Override
    public void status() {
        View view = findViewById(R.id.include_status);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(getString(R.string.status));
        String status = historyBean.getConfirmations() == 0 ?
                getString(R.string.wait) :
                getString(R.string.confirm);
        rightTxt.setText(status);
    }

    @Override
    public void dateTime() {
        View view = findViewById(R.id.include_datetime);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(getString(R.string.datetime));
        String showTime = TimeUtil.timestampFormat(historyBean.getTime() * 1000, TimeUtil.FORMAT_TIME);
        rightTxt.setText(showTime);
    }

    @Override
    public void txid() {
        View view = findViewById(R.id.include_txid);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(getString(R.string.txid));
        rightTxt.setText(historyBean.getTxid());
        rightTxt.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        rightTxt.getPaint().setAntiAlias(true);//抗锯齿
        rightTxt.setTextColor(getResources().getColor(R.color.color_132fcb));
        rightTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txid = historyBean.getTxid();
                String language = SystemUtil.language(activity);

                String url = BlockChainUrlUtil.txUrl(txid, language);
                ARouter.getInstance().build("/widget/webview")
                        .withString("url", url)
                        .navigation(activity);
            }
        });
    }

    @Override
    public void presenter(TransactionDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {

    }
}
