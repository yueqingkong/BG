package block.guess.main.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import block.guess.R;
import block.guess.base.BaseFragment;
import block.guess.main.MainActivity;
import block.guess.main.adapter.BannerAdapter;
import block.guess.main.adapter.HomeAdapter;
import block.guess.main.bean.BalanceBean;
import block.guess.main.bean.BannerBean;
import block.guess.main.bean.HomeBean;
import block.guess.main.bean.MainEvent;
import block.guess.main.contract.HomeContract;
import block.guess.main.presenter.HomePresenter;
import block.guess.main.request.BannerRequest;
import block.guess.main.request.HomeRequest;
import block.guess.utils.DensityUtils;
import block.guess.utils.StringsUtil;
import block.guess.utils.TimeUtil;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.utils.share.AppInfo;
import block.guess.widget.HorizontalDotVIew;
import block.guess.widget.dialog.DialogUtil;
import block.guess.widget.dialog.bean.DialogCallback;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import block.guess.widget.ribbon.RibbonView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment implements HomeContract.BView, HomeAdapter.HomeItemClickCallBack, BannerAdapter.BannerCallback {

    private static final String TAG = "_HomeFragment";

    @BindView(R.id.txt_bch_amount)
    TextView txtBchAmount;
    @BindView(R.id.txt_my_bch)
    TextView txtMyBch;
    @BindView(R.id.img_scan)
    ImageView imgScan;
    @BindView(R.id.img_receive)
    ImageView imgReceive;
    @BindView(R.id.img_notify)
    ImageView imgNotify;
    @BindView(R.id.constraintlayout_account)
    ConstraintLayout constraintlayoutAccount;
    @BindView(R.id.recycler_banner)
    RecyclerView recyclerBanner;
    @BindView(R.id.txt_top_game)
    TextView txtTopGame;
    @BindView(R.id.recycler_home)
    RecyclerView recyclerHome;
    @BindView(R.id.view_horizontal_dot)
    HorizontalDotVIew viewHorizontalDot;
    @BindView(R.id.txt_sign_in)
    TextView txtSignIn;

    private static HomeFragment fragment;

    public static HomeFragment home() {
        if (fragment == null) {
            fragment = new HomeFragment();
        }
        return fragment;
    }

    private Activity activity;
    private View baseView;

    private HomeBean free3DBean;

    private LinearLayoutManager horizonManager;
    private BannerAdapter bannerAdapter;

    private HomeAdapter homeAdapter;
    private HomeContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        baseView = inflater.inflate(R.layout.fragment_tab_home, container, false);
        ButterKnife.bind(this, baseView);

        EventBus.getDefault().register(this);
        new HomePresenter(this).start();
        return baseView;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            bannerAdapter.cancelTimer();
        } else {
            bannerAdapter.lauchTimer();

            balance();
            homeRequest();
        }
    }

    @Override
    public void init() {
        activity = getActivity();

        horizonManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerBanner.setLayoutManager(horizonManager);
        BaseItemDecoration horizonDecoration = new BaseItemDecoration(0, 0, 0, 0);
        recyclerBanner.addItemDecoration(horizonDecoration);
        bannerAdapter = new BannerAdapter();
        recyclerBanner.setAdapter(bannerAdapter);
        bannerAdapter.setBannerCallback(this);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerBanner);
        recyclerBanner.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int currentPosition = horizonManager.findFirstVisibleItemPosition();
                    viewHorizontalDot.update(currentPosition, bannerAdapter.getItemCount());
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerHome.setLayoutManager(layoutManager);
        BaseItemDecoration itemDecoration = new BaseItemDecoration(0, 0, 0);
        recyclerHome.addItemDecoration(itemDecoration);
        homeAdapter = new HomeAdapter();
        recyclerHome.setAdapter(homeAdapter);
        homeAdapter.setClickCallBack(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEvent(MainEvent event) {
        switch (event.event()) {
            case LOGIN_SUCCESS:
                presenter.awardRequest(1);
                break;
            case BALANCE:
                balance();
                break;
        }
    }

    @Override
    public void balance() {
        if (AppInfo.getAppInfo().balanceExist()) {
            BalanceBean balanceBean = AppInfo.getAppInfo().getBalance();

            String showBalance = "";
            if (balanceBean.getBalance() == 0) {
                showBalance = "0.00000000";
            } else {
                showBalance = StringsUtil.decimal(balanceBean.getBalance());
            }

            txtMyBch.setText(getString(R.string.my_balance_bch));

            boolean select = txtMyBch.isSelected();
            if (select) {
                txtBchAmount.setText("****");
                Drawable drawable = getResources().getDrawable(R.mipmap.ic_closeeye_home);
                drawable.setBounds(0, 0, DensityUtils.dip2px(15), DensityUtils.dip2px(10));
                txtMyBch.setCompoundDrawables(null, null, drawable, null);
            } else {
                txtBchAmount.setText(showBalance);
                Drawable drawable = getResources().getDrawable(R.mipmap.ic_openeye_home);
                drawable.setBounds(0, 0, DensityUtils.dip2px(15), DensityUtils.dip2px(10));
                txtMyBch.setCompoundDrawables(null, null, drawable, null);
            }

            txtSignIn.setVisibility(View.GONE);
            imgScan.setVisibility(View.VISIBLE);
            imgReceive.setVisibility(View.VISIBLE);
            imgNotify.setVisibility(View.VISIBLE);
        } else {
            String showBalance = "0.00000000";
            txtBchAmount.setText(showBalance);

            txtMyBch.setCompoundDrawables(null, null, null, null);
            txtMyBch.setText(getString(R.string.sign_in_more_service));

            txtSignIn.setVisibility(View.VISIBLE);
            imgScan.setVisibility(View.GONE);
            imgReceive.setVisibility(View.GONE);
            imgNotify.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.txt_my_bch)
    void onBchClick() {
        if (AppInfo.getAppInfo().balanceExist()) {
            boolean select = txtMyBch.isSelected();
            txtMyBch.setSelected(!select);

            balance();
        }
    }

    @OnClick(R.id.img_scan)
    void scanClick() {
        BalanceBean balanceBean = AppInfo.getAppInfo().getBalance();
        ARouter.getInstance().build("/wallet/bchsend")
                .withBoolean("scan", true)
                .withLong("accountBalance", balanceBean.getBalance())
                .navigation(activity);
    }

    @OnClick(R.id.img_receive)
    void receiveClick() {
        ARouter.getInstance().build("/wallet/bchreceive")
                .navigation(activity);
    }

    @OnClick(R.id.img_notify)
    void notifyClick() {
        Toast.makeText(activity, getString(R.string.no_new_messsage), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.txt_sign_in)
    void signInClick() {
        ARouter.getInstance().build("/login/login").navigation(activity);
    }

    @Override
    public void bannerListRequest() {
        BannerRequest request = new BannerRequest("");
        OKHttpUtil.client().request(request, new BaseCallBack<List<BannerBean>>(activity) {

            @Override
            public void success(List<BannerBean> beanList) {
                // TODO: 2018/11/18
                BannerBean bannerBean = new BannerBean();
                bannerBean.setCategory(4);
                beanList.add(bannerBean);

                bannerAdapter.updateBeans(beanList);
                viewHorizontalDot.update(0, beanList.size());
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
    public void homeRequest() {
        HomeRequest request = new HomeRequest("");
        OKHttpUtil.client().request(request, new BaseCallBack<List<HomeBean>>(activity) {

            @Override
            public void success(List<HomeBean> homeBeanList) {
                LogUtil.d(TAG, homeBeanList.size() + "");

                HomeBean freeBean = null;
                List<HomeBean> beanList = new ArrayList<>();
                for (HomeBean homeBean : homeBeanList) {
                    if (homeBean.getContract().getCategory() == 4) {
                        freeBean = homeBean;
                    } else {
                        beanList.add(homeBean);
                    }
                }

                free3DBean = freeBean;
                if (!beanList.isEmpty()) {
                    homeAdapter.setHomeBeans(beanList);
                }
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
    public void free3dDialogPopup() {
        DialogUtil.show(activity, R.layout.dialog_free3d, new DialogCallback() {

            private ImageView closeImg;
            private TextView hourFirstTxt;
            private TextView hourSecondTxt;
            private TextView minuteFirstTxt;
            private TextView minuteSecondTxt;
            private TextView secondFirstTxt;
            private TextView secondSecondTxt;
            private TextView receiveTxt;

            @Override
            public void createView(final Dialog dialog, View view) {
                closeImg = view.findViewById(R.id.img_close);
                hourFirstTxt = view.findViewById(R.id.txt_hour_);
                hourSecondTxt = view.findViewById(R.id.txt_hour);
                minuteFirstTxt = view.findViewById(R.id.txt_minute_);
                minuteSecondTxt = view.findViewById(R.id.txt_minute);
                secondFirstTxt = view.findViewById(R.id.txt_second_);
                secondSecondTxt = view.findViewById(R.id.txt_second);
                receiveTxt = view.findViewById(R.id.txt_receive);

                long remainSecond = free3DBean.getContract().getEnd() * 1000 - TimeUtil.timestamp();
                launchTimer(remainSecond);

                closeImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                receiveTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int contractid = free3DBean.getContract().getId();
                        presenter.free3DDetail(contractid);

                        dialog.dismiss();
                    }
                });

                boolean enable = free3DBean.getContract().getFree_shot() > free3DBean.getContract().getFree_shot_used();
                enableFree(remainSecond > 0 && enable);

                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (downTimer != null) {
                            downTimer.cancel();
                            downTimer = null;
                        }
                    }
                });
            }

            private CountDownTimer downTimer;

            public void launchTimer(long remainsecond) {
                if (downTimer == null) {
                    downTimer = new CountDownTimer(remainsecond, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            long second = millisUntilFinished / 1000;
                            countTimer(second);
                        }

                        @Override
                        public void onFinish() {
                            downTimer = null;

                            enableFree(false);
                            finishCount();
                        }
                    }.start();
                }
            }

            private void countTimer(long second) {
                String string = TimeUtil.timestampSecondFullFormat((int) second);

                hourFirstTxt.setText(String.valueOf(string.charAt(0)));
                hourSecondTxt.setText(String.valueOf(string.charAt(1)));
                minuteFirstTxt.setText(String.valueOf(string.charAt(3)));
                minuteSecondTxt.setText(String.valueOf(string.charAt(4)));
                secondFirstTxt.setText(String.valueOf(string.charAt(6)));
                secondSecondTxt.setText(String.valueOf(string.charAt(7)));
            }

            private void finishCount() {
                hourFirstTxt.setText("0");
                hourSecondTxt.setText("0");
                minuteFirstTxt.setText("0");
                minuteSecondTxt.setText("0");
                secondFirstTxt.setText("0");
                secondSecondTxt.setText("0");
            }

            private void enableFree(boolean enable) {
                receiveTxt.setEnabled(enable);

                if (enable) {
                    receiveTxt.setBackgroundResource(R.drawable.shape_rectangle_gradual_ffe635_fec818_r18);
                } else {
                    receiveTxt.setBackgroundResource(R.drawable.shape_rectangle_fec818_50_r18);
                }
            }
        });
    }

    @Override
    public void free3DReceive(long contractid, String identifier,int category) {
        ARouter.getInstance().build("/betting/bchpaysuccess")
                .withLong("contractId", contractid)
                .withString("identifier", identifier)
                .withInt("category",category)
                .navigation(activity);
    }

    @Override
    public void presenter(HomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void itemBannerClick(BannerBean bean) {
        switch (bean.getCategory()) {
            case 2:
                if (((MainActivity) activity).checkUserStatus()) {
                    ARouter.getInstance().build("/my/partnerplan")
                            .navigation(activity);
                }
                break;
            case 4:
                free3dDialogPopup();
                break;
        }
    }

    @Override
    public void bannerScroll() {
        int currentPosition = horizonManager.findFirstVisibleItemPosition();
        currentPosition = (currentPosition + 1) % 2;
        recyclerBanner.smoothScrollToPosition(currentPosition);
        viewHorizontalDot.update(currentPosition, bannerAdapter.getItemCount());
    }

    @Override
    public void itemClick(HomeBean homeBean) {
        int category = homeBean.getContract().getCategory();
        String buildPath = null;
        switch (category) {
            case 1:
                buildPath = "/betting/bch3dselection";
                break;
            case 2:
                buildPath = "/betting/bchluckybetting";
                break;
            case 3:
                buildPath = "/betting/lottoselect";
                break;
        }
        ARouter.getInstance().build(buildPath)
                .withSerializable("homeBean", homeBean)
                .navigation(activity);
    }

    @Override
    public void awardAnim(final long contractid) {
        int screenWidth = DensityUtils.screenWidth();
        int screenHeight = DensityUtils.screenHeight();
        DialogUtil.show(activity, R.layout.dialog_award, screenWidth, screenHeight, new DialogCallback() {

            @Override
            public void createView(final Dialog dialog, View view) {
                RibbonView ribbonView = view.findViewById(R.id.ribbon);
                ribbonView.addAllBeans(75);

                TextView seeTxt = view.findViewById(R.id.txt_see);
                seeTxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dialog != null && dialog.isShowing()) {
                            dialog.dismiss();
                        }

                        ARouter.getInstance().build("/betting/bchdetail")
                                .withLong("contractId", contractid)
                                .withInt("status", 2)
                                .navigation(activity);
                    }
                });
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
