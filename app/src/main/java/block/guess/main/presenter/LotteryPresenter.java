package block.guess.main.presenter;

import block.guess.main.contract.LotteryContract;

public class LotteryPresenter implements LotteryContract.Presenter {

    private LotteryContract.BView baseView;

    public LotteryPresenter(LotteryContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        baseView.lotteryClick();
    }
}
