package block.guess.wallet.presenter;

import android.app.Activity;

import block.guess.wallet.contract.AddressScanContract;

public class AddressScanPresenter implements AddressScanContract.Presenter {

    private Activity activity;
    private AddressScanContract.BView baseView;

    public AddressScanPresenter(AddressScanContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        activity = (Activity) baseView;
        baseView.init();
    }
}
