package block.guess.main.presenter;

import block.guess.main.contract.MainContract;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.BView baseView;

    public MainPresenter(MainContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }
}
