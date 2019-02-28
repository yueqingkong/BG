package block.guess.betting.presenter;

import block.guess.betting.contract.BCH3dSelectionContract;

public class BCH3DSelectionPresenter implements BCH3dSelectionContract.Presenter {

    private BCH3dSelectionContract.BView baseView;

    public BCH3DSelectionPresenter(BCH3dSelectionContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }
}
