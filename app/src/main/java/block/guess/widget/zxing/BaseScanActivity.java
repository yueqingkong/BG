package block.guess.widget.zxing;

import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.google.zxing.Result;

import java.io.IOException;

import block.guess.base.BaseActivity;
import block.guess.utils.SystemUtil;
import block.guess.widget.snackbar.SnackBarUtil;
import block.guess.widget.zxing.camera.CameraManager;
import block.guess.widget.zxing.decode.DecodeImageCallback;
import block.guess.widget.zxing.decode.DecodeImageThread;
import block.guess.widget.zxing.utils.BeepManager;
import block.guess.widget.zxing.utils.CaptureActivityHandler;
import block.guess.widget.zxing.utils.InactivityTimer;

public abstract class BaseScanActivity extends BaseActivity {

    private CaptureActivityHandler handler;
    private InactivityTimer inactivityTimer;
    private BeepManager beepManager;
    public boolean isHasSurface = false;

    /**
     * SurfaceView
     */
    private SurfaceView scanPreview = null;
    public final int PARSE_BARCODE_SUC = 601;
    private BaseScanActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        activity = this;

        inactivityTimer = new InactivityTimer(activity);
        beepManager = new BeepManager(activity);
        CameraManager.init();
    }

    public void setViewFind(SurfaceView scanPreview) {
        this.scanPreview = scanPreview;
    }

    public void setLineAnimation(View view) {
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 1f);
        animation.setDuration(2000);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(Animation.RESTART);
        view.startAnimation(animation);
    }

    public abstract void scanCall(String value);

    public Handler getHandler() {
        return handler;
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler = null;
        if (isHasSurface) {
            initCamera(scanPreview.getHolder());
        } else {
            scanPreview.getHolder().addCallback(callback);
        }
        inactivityTimer.onResume();
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (CameraManager.get().isOpen()) {
            Toast.makeText(activity, "open camera error", Toast.LENGTH_LONG).show();
            return;
        }
        try {
            CameraManager.get().openDriver(surfaceHolder, SystemUtil.screenWidth(activity), SystemUtil.screenHeight(activity));
            if (handler == null) {
                handler = new CaptureActivityHandler(this);
            }
        } catch (IOException ioe) {
            Toast.makeText(activity, "open camera error", Toast.LENGTH_LONG).show();
        } catch (RuntimeException e) {
            Toast.makeText(activity, "open camera error", Toast.LENGTH_LONG).show();
        }
    }

    private SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            if (!isHasSurface) {
                isHasSurface = true;
                initCamera(holder);
            }
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            isHasSurface = false;
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        }
    };

    public void handleDecode(Result rawResult, Bundle bundle) {
        inactivityTimer.onActivity();
        beepManager.playBeepSoundAndVibrate();
        scanCall(rawResult.getText());
    }

    public void getAblamString(final String path) {
        new Thread(new DecodeImageThread(path, new DecodeImageCallback() {
            @Override
            public void decodeSucceed(Result result) {
                scanCall(result.getText());
            }

            @Override
            public void decodeFail(int type, String reason) {
                SnackBarUtil.error(activity, "Scan failed!");
            }
        })).start();
    }

    @Override
    protected void onPause() {
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        inactivityTimer.onPause();
        beepManager.close();
        CameraManager.get().closeDriver();
        if (!isHasSurface) {
            scanPreview.getHolder().removeCallback(callback);
        }
        super.onPause();
    }
}
