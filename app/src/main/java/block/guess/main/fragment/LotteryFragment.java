package block.guess.main.fragment;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import block.guess.R;
import block.guess.base.BaseFragment;
import block.guess.main.adapter.LotteryPagerAdapter;
import block.guess.main.contract.LotteryContract;
import block.guess.main.presenter.LotteryPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LotteryFragment extends BaseFragment implements LotteryContract.BView, ViewPager.OnPageChangeListener {

    @BindView(R.id.txt_lottery)
    TextView txtLottery;
    @BindView(R.id.txt_ranking)
    TextView txtRanking;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private static LotteryFragment fragment;

    public static LotteryFragment lottery() {
        if (fragment == null) {
            fragment = new LotteryFragment();
        }
        return fragment;
    }

    private Activity activity;
    private View baseView;

    private LotteryContract.Presenter presenter;
    private LotteryPagerAdapter lotteryPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        baseView = inflater.inflate(R.layout.fragment_tab_lottery, container, false);
        ButterKnife.bind(this, baseView);
        new LotteryPresenter(this).start();
        return baseView;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            viewpager.setCurrentItem(0);
        }
    }

    @Override
    public void init() {
        activity = getActivity();

        List<BaseFragment> baseFragments = new ArrayList<>();
        baseFragments.add(LotteryLotteryFragment.fragment());
        baseFragments.add(LotteryRankingFragment.fragment());

        lotteryPagerAdapter = new LotteryPagerAdapter(getChildFragmentManager(), baseFragments);
        viewpager.setAdapter(lotteryPagerAdapter);
        viewpager.addOnPageChangeListener(this);
        viewpager.setCurrentItem(0);
    }

    @OnClick({R.id.txt_lottery, R.id.txt_ranking})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_lottery:
                viewpager.setCurrentItem(0);
                break;
            case R.id.txt_ranking:
                viewpager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void lotteryClick() {
        txtLottery.setTextColor(getResources().getColor(R.color.color_00115d));
        txtLottery.setSelected(true);
        txtRanking.setTextColor(getResources().getColor(R.color.color_8a94be));
        txtRanking.setSelected(false);
    }

    @Override
    public void rankingClick() {
        txtLottery.setTextColor(getResources().getColor(R.color.color_8a94be));
        txtLottery.setSelected(false);
        txtRanking.setTextColor(getResources().getColor(R.color.color_00115d));
        txtRanking.setSelected(true);
    }

    @Override
    public void presenter(LotteryContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                lotteryClick();
                break;
            case 1:
                rankingClick();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
