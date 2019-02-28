package block.guess.my.presenter;

import block.guess.my.contract.AboutMeContract;

public class AboutMePresenter implements AboutMeContract.Presenter {

    private AboutMeContract.BView baseView;

    public AboutMePresenter(AboutMeContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }
}
