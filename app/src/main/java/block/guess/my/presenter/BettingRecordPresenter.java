package block.guess.my.presenter;

import block.guess.my.contract.BettingRecordContract;

public class BettingRecordPresenter implements BettingRecordContract.Presenter{

    private BettingRecordContract.BView baseView;
    public BettingRecordPresenter(BettingRecordContract.BView view){
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        baseView.recordDetails();
    }
}
