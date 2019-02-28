package block.guess.betting.presenter;

import block.guess.betting.contract.WinningPlayerContract;

public class WinningPlayerPresenter implements WinningPlayerContract.Presenter {

    private WinningPlayerContract.BView baseView;

    public WinningPlayerPresenter(WinningPlayerContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        this.baseView.init();
    }
}
