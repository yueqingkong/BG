package block.guess.login.presenter;

import block.guess.login.contract.LaunchContract;
import block.guess.utils.share.AppInfo;

public class LaunchPresenter implements LaunchContract.Presenter {

    private LaunchContract.BView baseView;

    public LaunchPresenter(LaunchContract.BView bView) {
        this.baseView = bView;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        baseView.permission();
    }

    @Override
    public void allow() {
        if (AppInfo.getAppInfo().getFirstLogin()) {
            baseView.firstLaunch();
            AppInfo.getAppInfo().setFirstLogin(false);
        } else  {
            baseView.homeStart();
        }
    }
}
