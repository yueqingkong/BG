package block.guess.main.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseFragment;
import block.guess.main.adapter.LotteryRankingAdapter;
import block.guess.main.bean.RankingBean;
import block.guess.main.contract.LotteryRankingContract;
import block.guess.main.presenter.LotteryRankingPresenter;
import block.guess.utils.DensityUtils;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LotteryRankingFragment extends BaseFragment implements LotteryRankingContract.BView {

    @BindView(R.id.txt_god_player)
    TextView txtGodPlayer;
    @BindView(R.id.txt_super_player)
    TextView txtSuperPlayer;
    @BindView(R.id.txt_best_partner)
    TextView txtBestPartner;
    @BindView(R.id.recycler_ranking)
    RecyclerView recyclerRanking;
    @BindView(R.id.constraintlayout_empty)
    ConstraintLayout constraintlayoutEmpty;

    private static LotteryRankingFragment fragment;

    public static LotteryRankingFragment fragment() {
        if (fragment == null) {
            fragment = new LotteryRankingFragment();
        }
        return fragment;
    }

    private static String TAG = "_LotteryRankingFragment";
    private Activity activity;
    private View baseView;

    private LotteryRankingAdapter rankingAdapter;
    private LotteryRankingContract.Presenter presenter;

    private int category = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        baseView = inflater.inflate(R.layout.fragment_lottery_ranking, container, false);
        ButterKnife.bind(this, baseView);
        new LotteryRankingPresenter(this).start();
        return baseView;
    }

    @Override
    public void init() {
        activity = getActivity();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerRanking.setLayoutManager(layoutManager);

        int dp16 = DensityUtils.dip2px(16);
        BaseItemDecoration itemDecoration = new BaseItemDecoration(dp16, 0, dp16, 1);
        recyclerRanking.addItemDecoration(itemDecoration);
        rankingAdapter = new LotteryRankingAdapter();
        recyclerRanking.setAdapter(rankingAdapter);
    }

    @OnClick({R.id.txt_god_player, R.id.txt_super_player, R.id.txt_best_partner})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_god_player:
                godPlayderClick();
                break;
            case R.id.txt_super_player:
                superPlayerClick();
                break;
            case R.id.txt_best_partner:
                bestPartnerClick();
                break;
        }
    }

    @Override
    public void godPlayderClick() {
        txtGodPlayer.setSelected(true);
        txtGodPlayer.setTextColor(getResources().getColor(R.color.color_white));
        txtSuperPlayer.setSelected(false);
        txtSuperPlayer.setTextColor(getResources().getColor(R.color.color_645aff));
        txtBestPartner.setSelected(false);
        txtBestPartner.setTextColor(getResources().getColor(R.color.color_645aff));

        category = 0;
        presenter.rankingRequest(category);
    }

    @Override
    public void superPlayerClick() {
        txtGodPlayer.setSelected(false);
        txtGodPlayer.setTextColor(getResources().getColor(R.color.color_645aff));
        txtSuperPlayer.setSelected(true);
        txtSuperPlayer.setTextColor(getResources().getColor(R.color.color_white));
        txtBestPartner.setSelected(false);
        txtBestPartner.setTextColor(getResources().getColor(R.color.color_645aff));

        category = 1;
        presenter.rankingRequest(category);
    }

    @Override
    public void bestPartnerClick() {
        txtGodPlayer.setSelected(false);
        txtGodPlayer.setTextColor(getResources().getColor(R.color.color_645aff));
        txtSuperPlayer.setSelected(false);
        txtSuperPlayer.setTextColor(getResources().getColor(R.color.color_645aff));
        txtBestPartner.setSelected(true);
        txtBestPartner.setTextColor(getResources().getColor(R.color.color_white));

        category = 2;
        presenter.rankingRequest(category);
    }

    @Override
    public void rankingSuccess(List<RankingBean> beans) {
        if (beans.size() == 0) {
            constraintlayoutEmpty.setVisibility(View.VISIBLE);
        } else {
            constraintlayoutEmpty.setVisibility(View.GONE);
            rankingAdapter.setRankingBeanList(beans);
        }
    }

    @Nullable
    @Override
    public Activity activity() {
        return activity;
    }

    @Override
    public void presenter(LotteryRankingContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
