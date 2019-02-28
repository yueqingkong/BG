package block.guess.betting.presenter;

import block.guess.betting.contract.MyBettingContract;

public class MyBettingPresenter implements MyBettingContract.Presenter {

    private MyBettingContract.BView baseView;

    public MyBettingPresenter(MyBettingContract.BView view) {
        this.baseView = view;
    }

    @Override
    public void start() {

    }
}
