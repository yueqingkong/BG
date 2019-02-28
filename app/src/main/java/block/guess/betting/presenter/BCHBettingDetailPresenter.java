package block.guess.betting.presenter;

import block.guess.betting.contract.BCHBettingDetailContract;

public class BCHBettingDetailPresenter implements BCHBettingDetailContract.Presenter {

    private BCHBettingDetailContract.BView baseView;

    public BCHBettingDetailPresenter(BCHBettingDetailContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        baseView.contractDetailRequest();
    }
}
