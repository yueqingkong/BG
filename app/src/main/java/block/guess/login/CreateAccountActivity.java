package block.guess.login;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.BuildConfig;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.login.contract.CreateAccountContract;
import block.guess.login.presenter.CreateAccountPresenter;
import block.guess.utils.KeyboardUtil;
import block.guess.widget.VerifyTextView;
import block.guess.widget.dialog.common.CaptChaDialog;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/login/createaccount")
public class CreateAccountActivity extends BaseActivity implements CreateAccountContract.BView, ToolbarCallback,CaptChaDialog.CaptCallback {

    @BindView(R.id.edit_invitation_code)
    EditText editInvitationCode;
    @BindView(R.id.edit_username)
    EditText editUsername;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.edit_verify_code)
    EditText editVerifyCode;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.txt_sign_up)
    TextView txtSignUp;
    @BindView(R.id.txt_verify_code)
    VerifyTextView txtVerifyCode;
    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.txt_create_account)
    TextView txtCreateAccount;

    private CreateAccountActivity activity;
    private CreateAccountContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new CreateAccountPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setToolbarCallback(this);

        txtVerifyCode.finishCount();

        KeyboardUtil.openKeybord(editInvitationCode);

        if (BuildConfig.DEFAULT_HINT) {
            editUsername.setText("pujin");
            editEmail.setText("pujin@protonmail.com");
            editPassword.setText("qwer1234");
        }
    }

    @OnClick({R.id.txt_sign_up, R.id.txt_verify_code})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_verify_code:
                captChaDialog();
                break;
            case R.id.txt_sign_up:
                signUpClick();
                break;
        }
    }

    @Override
    public void captChaDialog() {
        CaptChaDialog dialog = new CaptChaDialog(this);
        dialog.showDialog(activity);
    }

    @Override
    public void signUpClick() {
        String inviteCode = editInvitationCode.getText().toString();
        if (TextUtils.isEmpty(inviteCode)) {
            inviteCode = "blockguess";
        }
        String username = editUsername.getText().toString();
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        String token = editVerifyCode.getText().toString();

        presenter.creatAccount(inviteCode, username, email, password, token);
    }

    @Override
    public void presenter(CreateAccountContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void inputFinish(String id, String captcha) {
        String email = editEmail.getText().toString();
        presenter.requestToken(id, captcha, email);
    }

    @Override
    public void dialogDissmiss() {

    }

    @Override
    public void accountCreateSuccess() {
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();
        ARouter.getInstance().build("/login/login")
                .withString("userEmail", email)
                .withString("userPassword", password)
                .navigation(activity);
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {

    }
}
