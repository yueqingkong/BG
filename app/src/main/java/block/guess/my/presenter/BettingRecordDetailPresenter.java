package block.guess.my.presenter;

import block.guess.my.contract.BettingRecordDetailContract;

public class BettingRecordDetailPresenter implements BettingRecordDetailContract.Presenter{

    private BettingRecordDetailContract.BView baseView;

    public BettingRecordDetailPresenter(BettingRecordDetailContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        baseView.contractDetail();
    }
}
