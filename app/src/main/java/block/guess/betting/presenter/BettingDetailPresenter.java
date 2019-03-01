package block.guess.betting.presenter;

import block.guess.betting.contract.BettingDetailContract;

public class BettingDetailPresenter implements BettingDetailContract.Presenter {

    private BettingDetailContract.BView baseView;

    public BettingDetailPresenter(BettingDetailContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        baseView.contractDetailRequest();
    }
}
