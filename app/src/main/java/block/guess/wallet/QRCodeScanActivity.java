package block.guess.wallet;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.R;
import block.guess.wallet.contract.AddressScanContract;
import block.guess.wallet.presenter.AddressScanPresenter;
import block.guess.widget.album.AlbumUtil;
import block.guess.widget.zxing.BaseScanActivity;
import block.guess.widget.zxing.camera.CameraManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/wallet/qrcodescan")
public class QRCodeScanActivity extends BaseScanActivity implements AddressScanContract.BView {

    @BindView(R.id.capture_preview)
    SurfaceView capturePreview;
    @BindView(R.id.capture_scan_line)
    ImageView captureScanLine;
    @BindView(R.id.constraintlayout_back)
    ConstraintLayout constraintlayoutBack;
    @BindView(R.id.constraintlayout_light)
    ConstraintLayout constraintlayoutLight;
    @BindView(R.id.constraintlayout_album)
    ConstraintLayout constraintlayoutAlbum;
    @BindView(R.id.img_qrcode)
    ImageView imgQrcode;
    @BindView(R.id.constraintlayout_qrcode)
    ConstraintLayout constraintlayoutQrcode;
    @BindView(R.id.img_flash)
    ImageView imgFlash;

    private static String TAG = "_QRCodeScanActivity";
    private QRCodeScanActivity activity;
    private AddressScanContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_address_scan);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new AddressScanPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false,getResources().getColor(R.color.color_white));

        setViewFind(capturePreview);
        setLineAnimation(captureScanLine);
    }

    @OnClick({R.id.constraintlayout_back, R.id.constraintlayout_light, R.id.constraintlayout_album})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.constraintlayout_back:
                scanCall("");
                break;
            case R.id.constraintlayout_light:
                flashSwitch();
                break;
            case R.id.constraintlayout_album:
                albumOpen();
                break;
        }
    }

    @Override
    public void flashSwitch() {
        boolean selected = imgFlash.isSelected();
        selected = !selected;

        imgFlash.setSelected(selected);
        CameraManager.get().flashLight(selected);
    }

    @Override
    public void albumOpen() {
        AlbumUtil.openAlbum(activity);
    }

    @Override
    public void scanCall(String value) {
        Intent intentTemp = new Intent();
        intentTemp.putExtra("qrcode", value);
        setResult(RESULT_OK, intentTemp);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 120) {
            Uri uri = data.getData();
            if (uri != null) {
                String result = AlbumUtil.getRealPathFromUri(activity, data.getData());
                getAblamString(result);
            }
        }
    }

    @Override
    public void presenter(AddressScanContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
