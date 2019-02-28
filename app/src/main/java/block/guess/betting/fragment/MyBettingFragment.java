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
import block.guess.betting.adapter.MyBettingAdapter;
import block.guess.betting.bean.ContractDetailBean;
import block.guess.betting.contract.MyBettingContract;
import block.guess.betting.contract.WinningPlayerContract;
import block.guess.betting.presenter.MyBettingPresenter;
import block.guess.utils.DensityUtils;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MyBettingFragment extends BaseFragment implements MyBettingContract.BView {

    @BindView(R.id.recycler_mybetting)
    RecyclerView recyclerMybetting;
    @BindView(R.id.img_empty_box)
    ImageView imgEmptyBox;
    @BindView(R.id.txt_no_winning_record)
    TextView txtNoWinningRecord;

    private static MyBettingFragment fragment;

    public static MyBettingFragment fragment() {
        if (fragment == null) {
            fragment = new MyBettingFragment();
        }
        return fragment;
    }

    private View baseView;
    private Activity activity;
    private MyBettingAdapter myBettingAdapter;

    private WinningPlayerContract.Presenter presenter;
    private List<ContractDetailBean.PurchaseHistoryBean> purchaseHistoryBeanList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        baseView = inflater.inflate(R.layout.fragment_part_mybetting, container, false);
        ButterKnife.bind(this, baseView);

        new MyBettingPresenter(this).start();
        return baseView;
    }

    @Override
    public void init() {
        activity = getActivity();

        if (purchaseHistoryBeanList == null || purchaseHistoryBeanList.size() == 0) {
            imgEmptyBox.setVisibility(View.VISIBLE);
            txtNoWinningRecord.setVisibility(View.VISIBLE);
        } else {
            imgEmptyBox.setVisibility(View.GONE);
            txtNoWinningRecord.setVisibility(View.GONE);

            LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
            recyclerMybetting.setLayoutManager(layoutManager);
            int dp1 = DensityUtils.dip2px(1);
            BaseItemDecoration itemDecoration = new BaseItemDecoration(0, dp1, 0, 0);
            recyclerMybetting.addItemDecoration(itemDecoration);
            myBettingAdapter = new MyBettingAdapter(purchaseHistoryBeanList);
        }
    }

    @Override
    public void presenter(WinningPlayerContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void setPurchaseHistoryBeanList(List<ContractDetailBean.PurchaseHistoryBean> list) {
        this.purchaseHistoryBeanList = list;
    }
}
