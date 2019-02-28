package block.guess.login.presenter;

import block.guess.login.contract.GuideContract;

public class GuidePresenter implements GuideContract.Presenter {

    private GuideContract.BView baseView;

    public GuidePresenter(GuideContract.BView bView) {
        this.baseView = bView;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }
}
