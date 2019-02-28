package block.guess.widget.zxing.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.google.zxing.Result;

import block.guess.widget.zxing.BaseScanActivity;
import block.guess.widget.zxing.camera.CameraManager;
import block.guess.widget.zxing.decode.DecodeHandler;
import block.guess.widget.zxing.decode.DecodeThread;

/**
 * This class handles all the messaging which comprises the state machine for capture.
 */
public final class CaptureActivityHandler extends Handler {
    public static final int AUTO_FOCUS = 0;
    public static final int DECODE_SUCCEEDED = 1;
    public static final int DECODE_FAILED = 2;

    private static final String TAG = CaptureActivityHandler.class.getName();

    private final BaseScanActivity mActivity;
    private final DecodeThread mDecodeThread;
    private State mState;

    public CaptureActivityHandler(BaseScanActivity activity) {
        this.mActivity = activity;
        mDecodeThread = new DecodeThread(activity);
        mDecodeThread.start();
        mState = State.SUCCESS;
        // Start ourselves capturing previews and decoding.
        restartPreviewAndDecode();
    }

    @Override
    public void handleMessage(Message message) {
        switch (message.what) {
            case AUTO_FOCUS:
                // Log.d(TAG, "Got auto-focus message");
                // When one auto focus pass finishes, start another. This is the closest thing to
                // continuous AF. It does seem to hunt a bit, but I'm not sure what else to do.
                if (mState == State.PREVIEW) {
                    CameraManager.get().requestAutoFocus(this, AUTO_FOCUS);
                }
                break;
            case DECODE_SUCCEEDED:
                mState = State.SUCCESS;
                Bundle bundle = message.getData();
                mActivity.handleDecode((Result) message.obj, bundle);
                break;
            case DECODE_FAILED:
                // We're decoding as fast as possible, so when one decode fails, start another.
                mState = State.PREVIEW;
                CameraManager.get().requestPreviewFrame(mDecodeThread.getHandler(), DecodeHandler.DECODE);
                break;
        }
    }

    public void quitSynchronously() {
        mState = State.DONE;
        CameraManager.get().stopPreview();
        Message quit = Message.obtain(mDecodeThread.getHandler(), DecodeHandler.QUIT);
        quit.sendToTarget();
        try {
            mDecodeThread.join();
        } catch (InterruptedException e) {
            // continue
        }

        // Be absolutely sure we don't send any queued up messages
        removeMessages(DECODE_SUCCEEDED);
        removeMessages(DECODE_FAILED);
    }

    public void restartPreviewAndDecode() {
        if (mState != State.PREVIEW) {
            CameraManager.get().startPreview();
            mState = State.PREVIEW;
            CameraManager.get().requestPreviewFrame(mDecodeThread.getHandler(), DecodeHandler.DECODE);
            CameraManager.get().requestAutoFocus(this, AUTO_FOCUS);
        }
    }

    private enum State {
        PREVIEW, SUCCESS, DONE
    }
}