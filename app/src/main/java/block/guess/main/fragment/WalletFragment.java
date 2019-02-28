package block.guess.main.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseFragment;
import block.guess.main.adapter.WalletAdapter;
import block.guess.main.bean.BalanceBean;
import block.guess.main.bean.HistoryBean;
import block.guess.main.bean.MainEvent;
import block.guess.main.contract.WalletContract;
import block.guess.main.presenter.WalletPresenter;
import block.guess.utils.DensityUtils;
import block.guess.utils.StringsUtil;
import block.guess.utils.okhttp.Request;
import block.guess.utils.share.AppInfo;
import block.guess.widget.nesting.RecyclerScrollView;
import block.guess.widget.nesting.bean.ScrollCallBack;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WalletFragment extends BaseFragment implements WalletContract.BView, ScrollCallBack {

    private static String TAG = "_WalletFragment";

    @BindView(R.id.txt_my_wallet)
    TextView txtMyWallet;
    @BindView(R.id.img_bch)
    ImageView imgBch;
    @BindView(R.id.txt_wallet_bch)
    TextView txtWalletBch;
    @BindView(R.id.txt_wallet_rmb)
    TextView txtWalletRmb;
    @BindView(R.id.constraintlayout_wallet)
    ConstraintLayout constraintlayoutWallet;
    @BindView(R.id.img_send)
    ImageView imgSend;
    @BindView(R.id.constraintlayout_send)
    ConstraintLayout constraintlayoutSend;
    @BindView(R.id.img_receive)
    ImageView imgReceive;
    @BindView(R.id.constraintlayout_receive)
    ConstraintLayout constraintlayoutReceive;
    @BindView(R.id.txt_transaction_history)
    TextView txtTransactionHistory;
    @BindView(R.id.recycler_transaction_history)
    RecyclerView recyclerTransactionHistory;
    @BindView(R.id.img_empty_wallet)
    ImageView imgEmptyWallet;
    @BindView(R.id.txt_no_transaction_record)
    TextView txtNoTransactionRecord;
    @BindView(R.id.scrollview)
    RecyclerScrollView scrollview;

    private static WalletFragment walletFragment;

    public static WalletFragment wallet() {
        if (walletFragment == null) {
            walletFragment = new WalletFragment();
        }
        return walletFragment;
    }

    private Activity activity;
    private View baseView;

    private WalletAdapter walletAdapter;
    private WalletContract.Presenter presenter;

    private int index = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        baseView = inflater.inflate(R.layout.fragment_tab_wallet, container, false);
        ButterKnife.bind(this, baseView);
        return baseView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        EventBus.getDefault().register(this);
        new WalletPresenter(this).start();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            index = 0;
            Request.request().balanceRequest(activity);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEvent(MainEvent event) {
        switch (event.event()) {
            case BALANCE:
                balance();
                break;
        }
    }

    @Override
    public void init() {
        activity = getActivity();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerTransactionHistory.setLayoutManager(layoutManager);

        int dp24 = DensityUtils.dip2px(24);
        BaseItemDecoration itemDecoration = new BaseItemDecoration(dp24, 0, dp24, 1);
        recyclerTransactionHistory.addItemDecoration(itemDecoration);
        recyclerTransactionHistory.setHasFixedSize(true);
        recyclerTransactionHistory.setNestedScrollingEnabled(false);
        walletAdapter = new WalletAdapter();
        recyclerTransactionHistory.setAdapter(walletAdapter);
        walletAdapter.setTransactionCallback(new WalletAdapter.TransactionCallback() {
            @Override
            public void historyClick(HistoryBean historyBean) {
                ARouter.getInstance().build("/wallet/transactiondetail")
                        .withSerializable("historyBean", historyBean)
                        .navigation(activity);
            }
        });

        scrollview.setScrollCallBack(this);
        presenter.historyRequest(index);
    }

    @Override
    public void balance() {
        BalanceBean balanceBean = AppInfo.getAppInfo().getBalance();

        String showBalance = "";
        if (balanceBean.getBalance() == 0) {
            showBalance = "0.00000000";
        } else {
            showBalance = StringsUtil.decimal(balanceBean.getBalance());
        }
        txtWalletBch.setText(showBalance);
        txtWalletRmb.setText("≈ " + balanceBean.getPrice() + " USD");
    }

    @Override
    public void historyStartRequst() {
        walletAdapter.setLoadingStatus();
    }

    @Override
    public void historyList(List<HistoryBean> beans) {
        if (beans.size() > 0) {
            if (index == 1) {
                walletAdapter.setHistoryBeans(beans);
            } else {
                walletAdapter.appendHistoryBeans(beans);
            }
            index++;
        } else {
            walletAdapter.setEndStatus();
        }

        if (walletAdapter.getItemCount() == 0) {
            imgEmptyWallet.setVisibility(View.VISIBLE);
            txtNoTransactionRecord.setVisibility(View.VISIBLE);
        } else {
            imgEmptyWallet.setVisibility(View.GONE);
            txtNoTransactionRecord.setVisibility(View.GONE);
        }
    }

    @Override
    public void historyFail() {
        walletAdapter.setEndStatus();
    }

    @OnClick({R.id.constraintlayout_send, R.id.constraintlayout_receive})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.constraintlayout_send:
                sendDetail();
                break;
            case R.id.constraintlayout_receive:
                receiveDetail();
                break;
        }
    }

    @Override
    public void sendDetail() {
        BalanceBean balanceBean = AppInfo.getAppInfo().getBalance();
        long showBalance = 0L;
        if (balanceBean != null) {
            showBalance = balanceBean.getBalance();
        }

        ARouter.getInstance().build("/wallet/bchsend")
                .withLong("accountBalance", showBalance)
                .navigation(activity);
    }

    @Override
    public void receiveDetail() {
        ARouter.getInstance().build("/wallet/bchreceive")
                .navigation(activity);
    }

    @Override
    public Activity activity() {
        return activity;
    }

    @Override
    public void presenter(WalletContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void scrollTop() {

    }

    @Override
    public void scrollBottom() {
        presenter.historyRequest(index);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
