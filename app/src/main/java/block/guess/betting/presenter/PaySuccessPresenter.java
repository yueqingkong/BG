package block.guess.betting.presenter;

import android.app.Activity;
import block.guess.betting.contract.PaySuccessContract;

public class PaySuccessPresenter implements PaySuccessContract.Presenter {

    private static String TAG = "_PaySuccessPresenter";
    private PaySuccessContract.BView baseView;
    private Activity activity;

    public PaySuccessPresenter(PaySuccessContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        activity = (Activity) baseView;
    }
}
