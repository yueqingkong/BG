package block.guess.betting.presenter;

import android.app.Activity;

import block.guess.betting.contract.LotteryDetailContract;

public class LotteryDetailPresenter implements LotteryDetailContract.Presenter {

    private Activity activity;
    private LotteryDetailContract.BView baseView;

    public LotteryDetailPresenter(LotteryDetailContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        this.activity = (Activity) baseView;
        this.baseView.init();
        this.baseView.lotteryDetailRequest();
    }
}
