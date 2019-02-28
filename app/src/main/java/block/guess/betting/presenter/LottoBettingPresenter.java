package block.guess.betting.presenter;

import android.app.Activity;

import java.util.List;

import block.guess.betting.bean.LottoBean;
import block.guess.betting.contract.LottoBettingContract;
import block.guess.main.bean.HomeBean;

public class LottoBettingPresenter implements LottoBettingContract.Presenter {

    private LottoBettingContract.BView baseView;
    private Activity activity;

    public LottoBettingPresenter(LottoBettingContract.BView bView) {
        baseView = bView;
        baseView.presenter(this);
    }

    @Override
    public void start() {
        activity = (Activity) baseView;
        baseView.init();
    }

    @Override
    public void payClick(HomeBean homeBean, int times, List<LottoBean> beans) {

    }
}
