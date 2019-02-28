package block.guess.betting;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.Nullable;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.betting.bean.GiftSendBean;
import block.guess.betting.contract.BCHGiftContract;
import block.guess.betting.presenter.BCHGiftPresenter;
import block.guess.betting.request.GiftFriendRequest;
import block.guess.betting.request.TxhashPublishRequest;
import block.guess.betting.bean.TxhashBean;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/betting/bchgift")
public class BCHGiftActivity extends BaseActivity implements BCHGiftContract.BView, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.edit_account)
    EditText editAccount;
    @BindView(R.id.img_scan)
    ImageView imgScan;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.txt_gift)
    TextView txtGift;

    @Autowired
    long contractid;
    @Autowired
    String identifier;
    @Autowired
    String txhash;

    private static String TAG = "_BCHGiftActivity";
    private BCHGiftActivity activity;
    private BCHGiftContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bch_gift);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new BCHGiftPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false,getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setTitleTxt(getString(R.string.gift_friend));
        toolbarBase.setToolbarCallback(this);
    }

    @OnClick({R.id.img_scan, R.id.txt_gift})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.img_scan:
                scanQRCode();
                break;
            case R.id.txt_gift:
                giftRequest();
                break;
        }
    }

    @Override
    public void scanQRCode() {
        ARouter.getInstance().build("/wallet/qrcodescan")
                .navigation(activity, 120);
    }

    @Override
    public void giftRequest() {
        String address = editAccount.getText().toString();
        String email = editEmail.getText().toString();
        GiftSendBean giftSendBean = new GiftSendBean(identifier, address, email);
        GiftFriendRequest request = new GiftFriendRequest(giftSendBean);
        OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {

            @Override
            public void success(String o) {
                LogUtil.d(TAG, o);

                ARouter.getInstance().build("/betting/gifsuccess")
                        .withLong("contractid", contractid)
                        .withString("identify", identifier)
                        .navigation(activity);
            }

            @Override
            public void serverError(int code, String err) {
                if (code == 2600 || code == 2400) {
                    publishTxhash();
                }
            }

            @Override
            public void netError() {

            }
        });
    }

    @Override
    public void publishTxhash() {
        TxhashBean txhashBean = new TxhashBean(txhash);
        TxhashPublishRequest publishRequest = new TxhashPublishRequest(txhashBean);
        OKHttpUtil.client().request(publishRequest, new BaseCallBack<String>(activity) {

            @Override
            public void success(String s) {
                LogUtil.d(TAG, s);
            }

            @Override
            public void serverError(int code, String err) {

            }

            @Override
            public void netError() {

            }
        });
    }

    @Override
    public void presenter(BCHGiftContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 120) {
            if (data == null) {
                activity.finish();
            } else {
                String value = data.getStringExtra("qrcode");
                editAccount.setText(value);
            }
        }
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {

    }
}
