package block.guess.wallet.presenter;

import block.guess.wallet.contract.BCHReceiveContract;

public class BCHReceivePresenter implements BCHReceiveContract.Presenter {

    private BCHReceiveContract.BView baseView;

    public BCHReceivePresenter(BCHReceiveContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        this.baseView.init();
    }
}
