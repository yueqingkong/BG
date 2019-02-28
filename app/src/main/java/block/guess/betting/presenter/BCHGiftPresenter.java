package block.guess.betting.presenter;

import block.guess.betting.contract.BCHGiftContract;

public class BCHGiftPresenter implements BCHGiftContract.Presenter{

    private BCHGiftContract.BView baseView;
    public BCHGiftPresenter(BCHGiftContract.BView view){
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }
}
