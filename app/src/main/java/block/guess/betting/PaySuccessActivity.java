package block.guess.betting;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.betting.contract.PaySuccessContract;
import block.guess.betting.presenter.PaySuccessPresenter;
import block.guess.wallet.bean.CategoryEnum;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/betting/bchpaysuccess")
public class PaySuccessActivity extends BaseActivity implements PaySuccessContract.BView, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_pay_success)
    ImageView imgPaySuccess;
    @BindView(R.id.txt_pay_success)
    TextView txtPaySuccess;
    @BindView(R.id.txt_pay_result)
    TextView txtPayResult;
    @BindView(R.id.txt_pay_transfer)
    TextView txtPayTransfer;

    @Autowired
    long contractId;
    @Autowired
    String identifier;
    @Autowired
    int category;

    private static String TAG = "_BCHPaySuccessActivity";
    private PaySuccessActivity activity;
    private PaySuccessContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bchlucky_paysuccess);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new PaySuccessPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_close_big);
        toolbarBase.setTitleTxt(getString(R.string.pay_result));
        toolbarBase.setToolbarCallback(this);

        txtStatus(true);
        if (CategoryEnum.parse(category) == CategoryEnum.FREE) {
            txtPayTransfer.setVisibility(View.GONE);
        }
    }

    private void txtStatus(boolean b) {
        txtPayResult.setEnabled(b);
        txtPayTransfer.setEnabled(b);
    }

    @OnClick({R.id.txt_pay_result, R.id.txt_pay_transfer})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.txt_pay_result:
                orderDetail();
                break;
            case R.id.txt_pay_transfer:
                giftFriend();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            leftClick();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void orderDetail() {
        ARouter.getInstance().build("/betting/bchdetail")
                .withLong("contractId", contractId)
                .withString("identifier", identifier)
                .navigation(activity);
    }

    private void giftFriend() {
        ARouter.getInstance().build("/betting/bchgift")
                .withLong("contractid", contractId)
                .withString("identifier", identifier)
                .navigation(activity);
    }

    @Override
    public void presenter(PaySuccessContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void leftClick() {
        ARouter.getInstance().build("/main/main")
                .navigation(activity);
    }

    @Override
    public void rightClick() {

    }
}
