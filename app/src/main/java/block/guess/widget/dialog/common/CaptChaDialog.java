package block.guess.widget.dialog.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import block.guess.R;
import block.guess.login.request.CaptchaRequest;
import block.guess.utils.ApiUtil;
import block.guess.utils.imageload.GlideUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.widget.dialog.DialogUtil;
import block.guess.widget.dialog.bean.DialogCallback;

/**
 * 显示验证码弹框
 */
public class CaptChaDialog implements DialogCallback {

    private Context context;

    private Dialog codeDialog;
    private ImageView captchaImg;
    private EditText captFirstEdit;
    private EditText captSecondEdit;
    private EditText captThirdEdit;
    private EditText captFourthEdit;
    private EditText captFifthEdit;
    private EditText captSixthEdit;
    private TextView refreshTxt;

    private String captchaId;
    private int selectPosition;
    private CaptCallback captCallback;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 120:
                    String url = (String) msg.obj;
                    GlideUtil.load(captchaImg, url);
                    break;
            }
        }
    };

    public CaptChaDialog(CaptCallback callback) {
        this.captCallback = callback;
    }

    public void showDialog(Context context) {
        this.context = context;
        DialogUtil.show(context, R.layout.dialog_captcha, this);
    }

    @Override
    public void createView(Dialog dialog, View view) {
        codeDialog = dialog;
        captchaImg = view.findViewById(R.id.img_captcha);
        captFirstEdit = view.findViewById(R.id.edit_captcha_first);
        captSecondEdit = view.findViewById(R.id.edit_captcha_second);
        captThirdEdit = view.findViewById(R.id.edit_captcha_third);
        captFourthEdit = view.findViewById(R.id.edit_captcha_fourth);
        captFifthEdit = view.findViewById(R.id.edit_captcha_fifth);
        captSixthEdit = view.findViewById(R.id.edit_captcha_sixth);
        refreshTxt = view.findViewById(R.id.txt_refresh_code);

        captFirstEdit.requestFocus();
        captFirstEdit.setSelected(true);

        captFirstEdit.addTextChangedListener(new CaptTextWatcher(captFirstEdit, captSecondEdit));
        captSecondEdit.addTextChangedListener(new CaptTextWatcher(captSecondEdit, captThirdEdit));
        captThirdEdit.addTextChangedListener(new CaptTextWatcher(captThirdEdit, captFourthEdit));
        captFourthEdit.addTextChangedListener(new CaptTextWatcher(captFourthEdit, captFifthEdit));
        captFifthEdit.addTextChangedListener(new CaptTextWatcher(captFifthEdit, captSixthEdit));
        captSixthEdit.addTextChangedListener(new CaptTextWatcher(captSixthEdit, captFirstEdit));

        refreshTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestCaptCha();
            }
        });
        refreshTxt.performClick();
    }

    private void requestCaptCha() {
        CaptchaRequest request = new CaptchaRequest("");
        OKHttpUtil.client().request(request, new BaseCallBack<String>((Activity) context) {

            @Override
            public void success(String s) {
                captchaId = s;

                String address = ApiUtil.SERVER + context.getResources().getString(R.string.captcha_png, captchaId);
                Message message = new Message();
                message.what = 120;
                message.obj = address;
                handler.sendMessage(message);
            }

            @Override
            public void serverError(int code, String err) {

            }

            @Override
            public void netError() {

            }
        });
    }

    private class CaptTextWatcher implements TextWatcher {

        private EditText currentEdit;
        private EditText nextEdit;

        public CaptTextWatcher(EditText cur, EditText next) {
            this.currentEdit = cur;
            this.nextEdit = next;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (editable.toString().isEmpty()) {
                selectPosition--;
                currentEdit.setSelected(false);
            } else {
                currentEdit.setSelected(true);
                selectPosition++;
                nextEdit.requestFocus();
            }

            // 输入完成
            if (selectPosition == 6 && codeDialog.isShowing()) {
                codeDialog.dismiss();

                String code = captChaCode();
                captCallback.inputFinish(captchaId, code);
            }
        }
    }

    private String captChaCode() {
        return captFirstEdit.getText().toString()
                + captSecondEdit.getText().toString()
                + captThirdEdit.getText().toString()
                + captFourthEdit.getText().toString()
                + captFifthEdit.getText().toString()
                + captSixthEdit.getText().toString();
    }

    public interface CaptCallback {
        void inputFinish(String id, String captcha);
    }
}
