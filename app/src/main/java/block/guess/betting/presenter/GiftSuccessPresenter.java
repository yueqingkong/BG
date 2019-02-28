package block.guess.betting.presenter;

import block.guess.betting.contract.GiftSuccessContract;

public class GiftSuccessPresenter implements GiftSuccessContract.Presenter {

    private GiftSuccessContract.BView baseView;

    public GiftSuccessPresenter(GiftSuccessContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }
}
