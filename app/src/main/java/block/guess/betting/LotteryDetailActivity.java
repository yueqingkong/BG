package block.guess.betting;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import block.guess.betting.bean.LotteryDetailBean;
import block.guess.betting.bean.RandomBean;
import block.guess.utils.share.AppInfo;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.net.URLEncoder;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.base.BaseFragment;
import block.guess.betting.contract.LotteryDetailContract;
import block.guess.betting.fragment.MyBettingFragment;
import block.guess.betting.fragment.WinningPlayerFragment;
import block.guess.betting.presenter.LotteryDetailPresenter;
import block.guess.betting.request.LotteryDetailRequest;
import block.guess.utils.SystemUtil;
import block.guess.utils.TimeUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.webview.util.BlockChainUrlUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.gson.Gson;

@Route(path = "/betting/bchlotterydetail")
public class LotteryDetailActivity extends BaseActivity implements LotteryDetailContract.BView, ToolbarCallback {

    private static final String TAG = "_BCHLotteryDetailActivity";

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.txt_number)
    TextView txtNumber;
    @BindView(R.id.txt_datetime)
    TextView txtDatetime;
    @BindView(R.id.txt_ball_first)
    TextView txtBallFirst;
    @BindView(R.id.txt_ball_second)
    TextView txtBallSecond;
    @BindView(R.id.txt_ball_third)
    TextView txtBallThird;
    @BindView(R.id.constraintlayout_detail)
    ConstraintLayout constraintlayoutDetail;
    @BindView(R.id.view_diver_top)
    View viewDiverTop;
    @BindView(R.id.view_diver_bottom)
    View viewDiverBottom;
    @BindView(R.id.txt_winning_player)
    TextView txtWinningPlayer;
    @BindView(R.id.txt_my_betting)
    TextView txtMyBetting;
    @BindView(R.id.framelayout_lottery)
    FrameLayout framelayoutLottery;

    @Autowired
    long contractId;

    private LotteryDetailActivity activity;
    private LotteryDetailContract.Presenter presenter;
    private BaseFragment currentFragment;
    private WinningPlayerFragment playerFragment;
    private MyBettingFragment bettingFragment;

    private LotteryDetailBean lotteryDetailBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bchlottery_detail);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new LotteryDetailPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setToolbarCallback(this);

        txtWinningPlayer.setText(getString(R.string.winning_player));
        txtMyBetting.setText(getString(R.string.my_betting));

        txtWinningPlayer.setSelected(true);
        txtWinningPlayer.setTextColor(getResources().getColor(R.color.color_white));
        txtMyBetting.setSelected(false);
        txtMyBetting.setTextColor(getResources().getColor(R.color.color_645aff));
    }

    @Override
    public void lotteryDetailRequest() {
        LotteryDetailRequest request = new LotteryDetailRequest("", contractId);
        OKHttpUtil.client().request(request, new BaseCallBack<LotteryDetailBean>(activity) {

            @Override
            public void success(LotteryDetailBean bean) {
                lotteryDetailBean = bean;
                lotteryDetail(bean);
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
    public void lotteryDetail(LotteryDetailBean bean) {
        CategoryEnum category = CategoryEnum.parse(bean.getCategory());
        switch (category) {
            case D3:
            case FREE:
                toolbarBase.setTitleTxt(getString(R.string.bch3d_lottery));
                break;
            case LUCKY:
                toolbarBase.setTitleTxt(getString(R.string.bchlucky_lottery));
                break;
        }

        int id = bean.getId();
        txtNumber.setText(activity.getString(R.string.contract_no_, id));

        String showTime = TimeUtil.timestampFormat((long) bean.getOpen_time() * 1000, TimeUtil.FORMAT_MONTH_DAY_TIME);
        txtDatetime.setText(showTime);

        if (bean.getLotteries_numbers() == null || bean.getLotteries_numbers().size() == 0) {
            txtBallFirst.setText("?");
            txtBallSecond.setText("?");
            txtBallThird.setText("?");
        } else {
            String awardNumber = bean.getLotteries_numbers().get(0).getAward_number();
            txtBallFirst.setText(String.valueOf(awardNumber.charAt(0)));
            txtBallSecond.setText(String.valueOf(awardNumber.charAt(1)));
            txtBallThird.setText(String.valueOf(awardNumber.charAt(2)));
        }

        random(bean);
        endingHeight(bean);
        lotteryHeight(bean);
        endingBetting(bean);
        contractAddress(bean);

        winningPlayerClick();
    }

    @Override
    public void random(LotteryDetailBean bean) {
        View view = findViewById(R.id.include_random);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(getString(R.string.random_org_number, bean.getRandom_number()));

        rightTxt.setTextColor(getResources().getColor(R.color.color_132fcb));
        rightTxt.setText(getString(R.string.verify));
        rightTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String random = bean.getRandom_number();
                    String signnature = bean.getSignature();
                    String data = "format=json&random=" +
                            URLEncoder.encode(new String(random.getBytes("UTF-8")))
                            + "&signature=" + URLEncoder.encode(new String(signnature.getBytes("UTF-8")));

                    ARouter.getInstance().build("/widget/webview")
                            .withString("url", "https://api.random.org/verify")
                            .withString("data", data)
                            .navigation(activity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void endingHeight(LotteryDetailBean bean) {
        View view = findViewById(R.id.include_height_ending);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(getString(R.string.ending_height));

        int endingHeight = bean.getOpen_height();
        rightTxt.setTextColor(getResources().getColor(R.color.color_132fcb));
        rightTxt.setText(String.valueOf(endingHeight));
        rightTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height = bean.getOpen_height();
                String language = SystemUtil.language(activity);

                String url = BlockChainUrlUtil.blockUrl(String.valueOf(height), language);
                ARouter.getInstance().build("/widget/webview")
                        .withString("url", url)
                        .navigation(activity);
            }
        });
    }

    @Override
    public void lotteryHeight(LotteryDetailBean bean) {
        View view = findViewById(R.id.include_height_lottery);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(getString(R.string.block_height));

        int blockHeight = bean.getHeight();
        rightTxt.setTextColor(getResources().getColor(R.color.color_132fcb));
        rightTxt.setText(String.valueOf(blockHeight));
        rightTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int height = bean.getHeight();
                String language = SystemUtil.language(activity);

                String url = BlockChainUrlUtil.blockUrl(String.valueOf(height), language);
                ARouter.getInstance().build("/widget/webview")
                        .withString("url", url)
                        .navigation(activity);
            }
        });
    }

    @Override
    public void endingBetting(LotteryDetailBean bean) {
        View view = findViewById(R.id.include_end_time);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(getString(R.string.end_time_betting));

        RandomBean randomBean = new Gson().fromJson(bean.getRandom(), RandomBean.class);
        String dateTime = randomBean.getCompletionTime();
        rightTxt.setText(dateTime);
    }

    @Override
    public void contractAddress(LotteryDetailBean bean) {
        View view = findViewById(R.id.include_address);
        TextView leftTxt = view.findViewById(R.id.txt_left);
        TextView rightTxt = view.findViewById(R.id.txt_right);

        leftTxt.setText(getString(R.string.contract_address));

        String addrrss = bean.getAddress();
        rightTxt.setTextColor(getResources().getColor(R.color.color_132fcb));
        rightTxt.setText(addrrss);
        rightTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = bean.getAddress();
                String language = SystemUtil.language(activity);

                String url = BlockChainUrlUtil.addressUrl(address, language);
                ARouter.getInstance().build("/widget/webview")
                        .withString("url", url)
                        .navigation(activity);
            }
        });
    }

    @OnClick({R.id.txt_winning_player, R.id.txt_my_betting})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.txt_winning_player:
                winningPlayerClick();
                break;
            case R.id.txt_my_betting:
                myBettingClick();
                break;
        }
    }

    @Override
    public void presenter(LotteryDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {

    }

    @Override
    public void winningPlayerClick() {
        txtWinningPlayer.setSelected(true);
        txtWinningPlayer.setTextColor(getResources().getColor(R.color.color_white));
        txtMyBetting.setSelected(false);
        txtMyBetting.setTextColor(getResources().getColor(R.color.color_645aff));

        if (playerFragment == null) {
            playerFragment = WinningPlayerFragment.fragment();
            if (lotteryDetailBean != null && lotteryDetailBean.getWinner_list() != null) {
                playerFragment.setWiningPlayerList(lotteryDetailBean.getWinner_list());
            }
        }
        switchFragment(playerFragment);
    }

    @Override
    public void myBettingClick() {
        txtWinningPlayer.setSelected(false);
        txtWinningPlayer.setTextColor(getResources().getColor(R.color.color_645aff));
        txtMyBetting.setSelected(true);
        txtMyBetting.setTextColor(getResources().getColor(R.color.color_white));

        if (bettingFragment == null) {
            bettingFragment = MyBettingFragment.fragment();
            if (AppInfo.getAppInfo().userExist() && lotteryDetailBean != null && lotteryDetailBean.getPurchase_history() != null) {
                bettingFragment.setPurchaseHistoryBeanList(lotteryDetailBean.getPurchase_history());
            }
        }
        switchFragment(bettingFragment);
    }

    @Override
    public void switchFragment(BaseFragment baseFragment) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (this.currentFragment != null) {
                transaction = transaction.hide(this.currentFragment);
            }

            if (baseFragment.isAdded()) {
                transaction.show(baseFragment).commitAllowingStateLoss();
            } else {
                transaction.replace(R.id.framelayout_lottery, baseFragment, "LotteryFragment").commitAllowingStateLoss();
            }
            this.currentFragment = baseFragment;
        }
    }
}
