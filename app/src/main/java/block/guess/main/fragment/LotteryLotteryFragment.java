package block.guess.main.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseFragment;
import block.guess.main.adapter.LotteryLotteryAdapter;
import block.guess.main.bean.LotteryPageBean;
import block.guess.main.contract.LotteryLotteryContract;
import block.guess.main.presenter.LotteryLotteryPresenter;
import block.guess.main.request.LotteryPageRequest;
import block.guess.utils.DensityUtils;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

public class LotteryLotteryFragment extends BaseFragment implements LotteryLotteryContract.BView, LotteryLotteryAdapter.LotteryCallback {

    @BindView(R.id.txt_bch_3d)
    TextView txtBch3d;
    @BindView(R.id.txt_bch_lucky)
    TextView txtBchLucky;
    @BindView(R.id.recycler_lottery)
    RecyclerView recyclerLottery;
    @BindView(R.id.txt_lotto)
    TextView txtLotto;
    @BindView(R.id.img_empty)
    ImageView imgEmpty;

    private static LotteryLotteryFragment fragment;

    public static LotteryLotteryFragment fragment() {
        if (fragment == null) {
            fragment = new LotteryLotteryFragment();
        }
        return fragment;
    }

    private static String TAG = "_LotteryLotteryFragment";
    private Activity activity;
    private View baseView;

    private int category;
    private int index = 1;

    private boolean isRequest = false;
    private LotteryLotteryAdapter lotteryLotteryAdapter;
    private LotteryLotteryContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        baseView = inflater.inflate(R.layout.fragment_lottery_lottery, container, false);
        ButterKnife.bind(this, baseView);
        new LotteryLotteryPresenter(this).start();
        return baseView;
    }

    @Override
    public void init() {
        activity = getActivity();

        recyclerLottery.setLayoutManager(new LinearLayoutManager(getContext()));
        lotteryLotteryAdapter = new LotteryLotteryAdapter(this);
        recyclerLottery.setAdapter(lotteryLotteryAdapter);

        int dp12 = DensityUtils.dip2px(12);
        BaseItemDecoration itemDecoration = new BaseItemDecoration(dp12, dp12, dp12, 0);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerLottery.setLayoutManager(layoutManager);
        recyclerLottery.addItemDecoration(itemDecoration);
        recyclerLottery.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange()) {
                    lotteryRequest();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void lotteryRequest() {
        if (isRequest) {
            return;
        }

        isRequest = true;
        lotteryLotteryAdapter.setLoadingStatus();
        LotteryPageRequest pageRequest = new LotteryPageRequest(category, index);
        OKHttpUtil.client().request(pageRequest, new BaseCallBack<List<LotteryPageBean>>(activity) {

            @Override
            public void success(List<LotteryPageBean> lotteryPageBeans) {
                LogUtil.d(TAG, "Size: " + lotteryPageBeans.size());

                isRequest = false;
                if (lotteryPageBeans.size() > 0) {
                    imgEmpty.setVisibility(View.GONE);
                    if (index == 1) {
                        lotteryLotteryAdapter.setLotteries(lotteryPageBeans);
                    } else {
                        lotteryLotteryAdapter.appendLotteries(lotteryPageBeans);
                    }

                    index++;
                } else {
                    imgEmpty.setVisibility(lotteryLotteryAdapter.getItemCount() == 1 ? View.VISIBLE : View.GONE);
                    lotteryLotteryAdapter.setEndStatus();
                }
            }

            @Override
            public void serverError(int code, String err) {
                isRequest = false;
                lotteryLotteryAdapter.setEndStatus();
            }

            @Override
            public void netError() {
                isRequest = false;
                lotteryLotteryAdapter.setEndStatus();
            }
        });
    }

    @OnClick({R.id.txt_bch_3d, R.id.txt_bch_lucky, R.id.txt_lotto})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_bch_3d:
                d3Click();
                break;
            case R.id.txt_bch_lucky:
                luckyClick();
                break;
            case R.id.txt_lotto:
                lottoClick();
                break;
        }
    }


    @Override
    public void d3Click() {
        txtBch3d.setTextColor(getResources().getColor(R.color.color_white));
        txtBch3d.setSelected(true);
        txtBchLucky.setTextColor(getResources().getColor(R.color.color_645aff));
        txtBchLucky.setSelected(false);
        txtLotto.setTextColor(getResources().getColor(R.color.color_645aff));
        txtLotto.setSelected(false);

        category = 1;
        index = 1;

        lotteryLotteryAdapter.clearBeans();
        lotteryRequest();
    }

    @Override
    public void luckyClick() {
        txtBch3d.setTextColor(getResources().getColor(R.color.color_645aff));
        txtBch3d.setSelected(false);
        txtBchLucky.setTextColor(getResources().getColor(R.color.color_white));
        txtBchLucky.setSelected(true);
        txtLotto.setTextColor(getResources().getColor(R.color.color_645aff));
        txtLotto.setSelected(false);

        category = 2;
        index = 1;

        lotteryLotteryAdapter.clearBeans();
        lotteryRequest();
    }

    @Override
    public void lottoClick() {
        txtBch3d.setTextColor(getResources().getColor(R.color.color_645aff));
        txtBch3d.setSelected(false);
        txtBchLucky.setTextColor(getResources().getColor(R.color.color_645aff));
        txtBchLucky.setSelected(false);
        txtLotto.setTextColor(getResources().getColor(R.color.color_white));
        txtLotto.setSelected(true);

        category = 3;
        index = 1;

        lotteryLotteryAdapter.clearBeans();
        lotteryRequest();
    }

    @Override
    public void presenter(LotteryLotteryContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void itemClick(LotteryPageBean bean) {
        int contractid = bean.getId();
        ARouter.getInstance().build("/betting/bchlotterydetail")
                .withLong("contractId", contractid)
                .navigation(activity);
    }
}
