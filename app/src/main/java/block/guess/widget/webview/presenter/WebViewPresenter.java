package block.guess.widget.webview.presenter;

import block.guess.widget.webview.contract.WebvViewContract;

public class WebViewPresenter implements WebvViewContract.Presenter {

    private WebvViewContract.BView baseView;

    public WebViewPresenter(WebvViewContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
    }
}
