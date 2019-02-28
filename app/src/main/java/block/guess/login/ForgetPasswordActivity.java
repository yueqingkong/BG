package block.guess.login;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.BuildConfig;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.login.contract.ForgetPasswordContract;
import block.guess.login.presenter.ForgetPasswordPresenter;
import block.guess.widget.VerifyTextView;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/login/forgetpassword")
public class ForgetPasswordActivity extends BaseActivity implements ForgetPasswordContract.BView, ToolbarCallback {

    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_verify_code)
    EditText editVerifyCode;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.txt_reset_now)
    TextView txtResetNow;
    @BindView(R.id.txt_verify_code)
    VerifyTextView txtVerifyCode;
    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.txt_forget_password)
    TextView txtForgetPassword;

    private ForgetPasswordActivity activity;
    private ForgetPasswordContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new ForgetPasswordPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setToolbarCallback(this);

        txtVerifyCode.finishCount();
        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String string = editable.toString();
                boolean enable = !TextUtils.isEmpty(string);
                txtVerifyCode.setEnabled(enable);
            }
        });

        if (BuildConfig.DEFAULT_HINT) {
            editEmail.setText("pujin@protonmail.com");
            editPassword.setText("qwer1234");
        }
    }


    @OnClick({R.id.txt_verify_code, R.id.txt_reset_now})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_verify_code:
                emailToken();
                break;
            case R.id.txt_reset_now:
                register();
                break;
        }
    }

    private void emailToken() {
        String email = editEmail.getText().toString();
        presenter.emailToken(email);
    }

    private void register() {
        String email = editEmail.getText().toString();
        String token = editVerifyCode.getText().toString();
        String password = editPassword.getText().toString();
        presenter.registerAccount(email, token, password);
    }

    @Override
    public void main() {
        ARouter.getInstance().build("/main/main").navigation(activity, new NavCallback() {
            @Override
            public void onArrival(Postcard postcard) {
                activity.finish();
            }
        });
    }

    @Override
    public void presenter(ForgetPasswordContract.Presenter presenter) {
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
