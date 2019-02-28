package block.guess.main.presenter;

import block.guess.main.contract.LotteryLotteryContract;

public class LotteryLotteryPresenter implements LotteryLotteryContract.Presenter {

    private LotteryLotteryContract.BView baseView;

    public LotteryLotteryPresenter(LotteryLotteryContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        baseView.d3Click();
    }
}
