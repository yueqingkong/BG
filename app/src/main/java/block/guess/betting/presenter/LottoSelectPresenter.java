package block.guess.betting.presenter;

import android.app.Activity;

import block.guess.betting.contract.LottoSelectContract;

public class LottoSelectPresenter implements LottoSelectContract.Presenter {

    private Activity activity;
    private LottoSelectContract.BView baseView;

    public LottoSelectPresenter(LottoSelectContract.BView bView) {
        baseView = bView;
        baseView.presenter(this);
    }

    @Override
    public void start() {
        activity = (Activity) baseView;
        baseView.init();
        baseView.registerSensor();
    }
}
