package block.guess.betting.presenter;

import android.app.Activity;

import block.guess.betting.contract.BCHLotteryDetailContract;

public class BCHLotteryDetailPresenter implements BCHLotteryDetailContract.Presenter {

    private Activity activity;
    private BCHLotteryDetailContract.BView baseView;

    public BCHLotteryDetailPresenter(BCHLotteryDetailContract.BView view) {
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
