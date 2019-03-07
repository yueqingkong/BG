package block.guess.betting.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseFragment;
import block.guess.betting.adapter.WinningPlayerAdapter;
import block.guess.betting.bean.ContractDetailBean;
import block.guess.betting.bean.LotteryDetailBean;
import block.guess.betting.contract.WinningPlayerContract;
import block.guess.betting.presenter.WinningPlayerPresenter;
import block.guess.utils.DensityUtils;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

public class WinningPlayerFragment extends BaseFragment implements WinningPlayerContract.BView {

    @BindView(R.id.recycler_winning_player)
    RecyclerView recyclerWinningPlayer;
    @BindView(R.id.img_empty_box)
    ImageView imgEmptyBox;
    @BindView(R.id.txt_no_winning_record)
    TextView txtNoWinningRecord;

    private static WinningPlayerFragment fragment;

    public static WinningPlayerFragment fragment() {
        if (fragment == null) {
            fragment = new WinningPlayerFragment();
        }
        return fragment;
    }

    private View baseView;
    private Activity activity;
    private WinningPlayerContract.Presenter presenter;
    private WinningPlayerAdapter playerAdapter;

    private List<LotteryDetailBean.WinnerListBean> winingPlayerList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        baseView = inflater.inflate(R.layout.fragment_part_winningpalyer, container, false);
        ButterKnife.bind(this, baseView);

        new WinningPlayerPresenter(this).start();
        return baseView;
    }

    @Override
    public void init() {
        activity = getActivity();
        if (winingPlayerList == null || winingPlayerList.size() == 0) {
            imgEmptyBox.setVisibility(View.VISIBLE);
            txtNoWinningRecord.setVisibility(View.VISIBLE);
        } else {
            imgEmptyBox.setVisibility(View.GONE);
            txtNoWinningRecord.setVisibility(View.GONE);

            LinearLayoutManager manager = new LinearLayoutManager(activity);
            recyclerWinningPlayer.setLayoutManager(manager);

            int dp1 = DensityUtils.dip2px(1);
            BaseItemDecoration itemDecoration = new BaseItemDecoration(0, dp1, 0, 0);
            recyclerWinningPlayer.addItemDecoration(itemDecoration);
            playerAdapter = new WinningPlayerAdapter(winingPlayerList);
            recyclerWinningPlayer.setAdapter(playerAdapter);
        }
    }

    @Override
    public void presenter(WinningPlayerContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void setWiningPlayerList(List<LotteryDetailBean.WinnerListBean> list) {
        this.winingPlayerList = list;
    }
}
