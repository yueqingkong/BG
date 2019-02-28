package block.guess.wallet;

import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.login.bean.UserInfoBean;
import block.guess.utils.BitmapUtil;
import block.guess.utils.SystemUtil;
import block.guess.utils.share.AppInfo;
import block.guess.wallet.contract.BCHReceiveContract;
import block.guess.wallet.presenter.BCHReceivePresenter;
import block.guess.widget.snackbar.SnackBarUtil;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import block.guess.widget.zxing.utils.CreateScan;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/wallet/bchreceive")
public class BCHReceiveActivity extends BaseActivity implements BCHReceiveContract.BView, ToolbarCallback {

    private static String TAG = "_BCHReceiveActivity";

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_qrcode)
    ImageView imgQrcode;
    @BindView(R.id.constraintlayout_qrcode)
    ConstraintLayout constraintlayoutQrcode;
    @BindView(R.id.txt_bch_address)
    TextView txtBchAddress;
    @BindView(R.id.txt_copy_address)
    TextView txtCopyAddress;
    @BindView(R.id.txt_save_qrcode)
    TextView txtSaveQrcode;

    private BCHReceiveActivity activity;
    private BCHReceiveContract.Presenter presenter;
    private MediaScannerConnection scanner;

    private String bchAddress;
    private Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bch_receive);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new BCHReceivePresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false,getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setTitleTxt(getString(R.string.receive_bch));
        toolbarBase.setToolbarCallback(this);

        UserInfoBean userInfoBean = AppInfo.getAppInfo().getInfoUser();
        bchAddress = userInfoBean.getAddress();

        CreateScan createScan = new CreateScan();
        bitmap = createScan.generateQRCode(bchAddress);
        imgQrcode.setImageBitmap(bitmap);

        txtBchAddress.setText(bchAddress);
    }

    @OnClick({R.id.txt_copy_address, R.id.txt_save_qrcode})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.txt_copy_address:
                copyAddress();
                break;
            case R.id.txt_save_qrcode:
                saveQRCode();
                break;
        }
    }

    @Override
    public void copyAddress() {
        SnackBarUtil.success(activity, getResources().getString(R.string.address_been_copied));
        SystemUtil.copy(activity, bchAddress);
    }

    @Override
    public void saveQRCode() {
        SnackBarUtil.success(activity, getResources().getString(R.string.photo_save_int_album));
        BitmapUtil.saveBmp2Gallery(bitmap, bchAddress);
    }

    @Override
    public void presenter(BCHReceiveContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {

    }
}
