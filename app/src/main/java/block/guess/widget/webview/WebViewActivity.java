package block.guess.widget.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.Nullable;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.webview.contract.WebvViewContract;
import block.guess.widget.webview.presenter.WebViewPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/widget/webview")
public class WebViewActivity extends BaseActivity implements WebvViewContract.BView, ToolbarCallback {


    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.myProgressBar)
    ProgressBar myProgressBar;

    @Autowired
    String url;
    @Autowired
    String data;

    private WebViewActivity activity;
    private WebvViewContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ARouter.getInstance().inject(this);
        ButterKnife.bind(this);

        new WebViewPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false,getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setToolbarCallback(this);

        myProgressBar.setVisibility(View.VISIBLE);
        if (TextUtils.isEmpty(data)) {
            webview.loadUrl(url);
        } else {
            try {
                webview.postUrl(url, data.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        webview.canGoBack();
        webview.setDownloadListener(new MyWebViewDownLoadListener());
        webview.setWebChromeClient(MyWebChromeClient);
        webview.setWebViewClient(myWebViewClient);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        webSettings.setJavaScriptEnabled(true);//是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        webSettings.setSupportZoom(true);//是否可以缩放，默认true
        webSettings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        webSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        webSettings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        webSettings.setAppCacheEnabled(true);//是否使用缓存
        webSettings.setDomStorageEnabled(true);//DOM Storage

        if (Build.VERSION.SDK_INT >= 11) {
            webSettings.setPluginState(WebSettings.PluginState.ON);
            webSettings.setDisplayZoomControls(false);
        }
    }

    @Override
    public void leftClick() {
        onBackPressed();
    }

    @Override
    public void rightClick() {

    }

    private class MyWebViewDownLoadListener implements DownloadListener {

        @Override
        public void onDownloadStart(String url, String userAgent, String contentDisposition,
                                    String mimetype, long contentLength) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    private WebViewClient myWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.loadUrl("javascript:window.local_obj.showTitle(document.getElementsByTagName('title')[0].text);");
            view.loadUrl("javascript:window.local_obj.showContent(document.getElementsByTagName('meta')['description'].content);");
            view.loadUrl("javascript:window.local_obj.showImg(document.getElementsByTagName('img')[0].src);");
        }
    };

    private WebChromeClient MyWebChromeClient = new WebChromeClient() {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                myProgressBar.setProgress(newProgress);
                myProgressBar.setVisibility(View.GONE);
            } else {
                myProgressBar.setProgress(newProgress);
                myProgressBar.postInvalidate();
            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            onWebTitle(view, title);
        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }
    };

    protected void onWebTitle(WebView view, String string) {
        toolbarBase.setTitleTxt(string);
    }

    public boolean onKeyDown(int keyCode, KeyEvent keyEvent) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webview.canGoBack()) {
                webview.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, keyEvent);
    }

    @Override
    public void presenter(WebvViewContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
