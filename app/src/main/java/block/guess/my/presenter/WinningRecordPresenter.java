package block.guess.my.presenter;

import block.guess.my.contract.WinningRecordContract;

public class WinningRecordPresenter implements WinningRecordContract.Presenter {

    private WinningRecordContract.BView baseView;

    public WinningRecordPresenter(WinningRecordContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        this.baseView.init();
        this.baseView.winningRecordRequest();
    }
}
