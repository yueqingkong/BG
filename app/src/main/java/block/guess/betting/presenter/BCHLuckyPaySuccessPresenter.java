package block.guess.betting.presenter;

import block.guess.betting.contract.BCHLuckyPaySuccessContract;

public class BCHLuckyPaySuccessPresenter implements BCHLuckyPaySuccessContract.Presenter {

    private BCHLuckyPaySuccessContract.BView baseView;

    public BCHLuckyPaySuccessPresenter(BCHLuckyPaySuccessContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }
}
