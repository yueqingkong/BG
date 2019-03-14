package block.guess.main;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.base.BaseFragment;
import block.guess.main.bean.MainPagerCallback;
import block.guess.main.contract.MainContract;
import block.guess.main.fragment.HomeFragment;
import block.guess.main.fragment.LotteryFragment;
import block.guess.main.fragment.MyFragment;
import block.guess.main.fragment.WalletFragment;
import block.guess.main.presenter.MainPresenter;
import block.guess.utils.share.AppInfo;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/main/main")
public class MainActivity extends BaseActivity implements MainContract.BView, MainPagerCallback {

    private MainActivity activity;

    private HomeFragment homeFragment;
    private LotteryFragment lotteryFragment;
    private WalletFragment walletFragment;
    private MyFragment myFragment;
    private BaseFragment currentFragment;

    private int lastPosition;
    private View homeTab;
    private View lotteryTab;
    private View walletTab;
    private View myTab;

    private MainContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        activity = this;
        ARouter.getInstance().inject(this);
        new MainPresenter(this).start();
    }

    @Override
    public void init() {
        getSupportActionBar().hide();

        homeTab = findViewById(R.id.include_main);
        lotteryTab = findViewById(R.id.include_lottery);
        walletTab = findViewById(R.id.include_wallet);
        myTab = findViewById(R.id.include_my);

        ((TextView) homeTab.findViewById(R.id.txt_tab_title)).setText(getResources().getText(R.string.game));
        ((TextView) lotteryTab.findViewById(R.id.txt_tab_title)).setText(getResources().getText(R.string.lottery));
        ((TextView) walletTab.findViewById(R.id.txt_tab_title)).setText(getResources().getText(R.string.wallet));
        ((TextView) myTab.findViewById(R.id.txt_tab_title)).setText(getResources().getText(R.string.my));
        homeTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_home_purple);
        ((TextView) homeTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_645aff));
        lotteryTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_lottery_gray);
        ((TextView) lotteryTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_8a94be));
        walletTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_balance_gray);
        ((TextView) walletTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_8a94be));
        myTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_my_gray);
        ((TextView) myTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_8a94be));

        onPageSelected(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (homeFragment != null) {
            homeFragment.homeRequest();
        }

        if (walletFragment != null) {
            walletFragment.historyRequest();
        }
    }

    @OnClick({R.id.include_main, R.id.include_lottery, R.id.include_wallet, R.id.include_my})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.include_main:
                onPageSelected(0);
                break;
            case R.id.include_lottery:
                onPageSelected(1);
                break;
            case R.id.include_wallet:
                if (checkUserStatus()) {
                    onPageSelected(2);
                }
                break;
            case R.id.include_my:
                if (checkUserStatus()) {
                    onPageSelected(3);
                }
                break;
        }
    }

    @Override
    public boolean checkUserStatus() {
        boolean userstatus = AppInfo.getAppInfo().userExist();
        if (!userstatus) {
            ARouter.getInstance().build("/login/login").navigation(activity);
        }
        return userstatus;
    }

    @Override
    public void onPageSelected(int position) {
        // 重置上一页的tab状态
        switch (lastPosition) {
            case 0:
                homeTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_home_gray);
                ((TextView) homeTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_8a94be));
                break;
            case 1:
                lotteryTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_lottery_gray);
                ((TextView) lotteryTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_8a94be));
                break;
            case 2:
                walletTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_balance_gray);
                ((TextView) walletTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_8a94be));
                break;
            case 3:
                myTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_my_gray);
                ((TextView) myTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_8a94be));
                break;
        }

        // 显示当前页状态
        switch (position) {
            case 0:
                statusBar(false, getResources().getColor(R.color.color_white));
                homeTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_home_purple);
                ((TextView) homeTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_645aff));
                break;
            case 1:
                statusBar(false, getResources().getColor(R.color.color_white));
                lotteryTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_lottery_purple);
                ((TextView) lotteryTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_645aff));
                break;
            case 2:
                statusBar(false, getResources().getColor(R.color.color_f3f4fa));
                walletTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_balance_purple);
                ((TextView) walletTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_645aff));
                break;
            case 3:
                statusBar(false, getResources().getColor(R.color.color_f3f4fa));
                myTab.findViewById(R.id.image_tab_title).setBackgroundResource(R.mipmap.tab_my_purple);
                ((TextView) myTab.findViewById(R.id.txt_tab_title)).setTextColor(getResources().getColor(R.color.color_645aff));
                break;
        }

        BaseFragment baseFragment = null;
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = HomeFragment.home();
                }
                baseFragment = homeFragment;
                break;
            case 1:
                if (lotteryFragment == null) {
                    lotteryFragment = LotteryFragment.lottery();
                }
                baseFragment = lotteryFragment;
                break;
            case 2:
                if (walletFragment == null) {
                    walletFragment = WalletFragment.wallet();
                }

                walletFragment.historyRequest();
                baseFragment = walletFragment;
                break;
            case 3:
                if (myFragment == null) {
                    myFragment = MyFragment.my();
                }
                baseFragment = myFragment;
                break;
        }

        switchFragment(baseFragment);
        lastPosition = position;
    }

    @Override
    public void switchFragment(BaseFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null && !fragmentManager.isDestroyed()) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            if (this.currentFragment != null) {
                transaction = transaction.hide(this.currentFragment);
            }

            if (fragment.isAdded()) {
                transaction.show(fragment).commitAllowingStateLoss();
            } else {
                transaction.add(R.id.framelayout_main, fragment, "LotteryFragment")
                        .addToBackStack("LotteryFragment")
                        .commitAllowingStateLoss();
            }
            this.currentFragment = fragment;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void presenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
