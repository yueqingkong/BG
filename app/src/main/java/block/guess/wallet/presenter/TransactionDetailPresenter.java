package block.guess.wallet.presenter;

import block.guess.wallet.contract.TransactionDetailContract;

public class TransactionDetailPresenter implements TransactionDetailContract.Presenter {

    private TransactionDetailContract.BView baseView;

    public TransactionDetailPresenter(TransactionDetailContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        this.baseView.init();
        this.baseView.category();
        this.baseView.status();
        this.baseView.dateTime();
        this.baseView.txid();
    }
}
