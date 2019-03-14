package block.guess.login;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.widget.snackbar.SnackBarUtil;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.BuildConfig;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.login.contract.LoginContract;
import block.guess.login.presenter.LoginPresenter;
import block.guess.main.bean.MainEvent;
import block.guess.utils.okhttp.Request;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/login/login")
public class LoginActivity extends BaseActivity implements LoginContract.BView {

    @BindView(R.id.edit_account)
    EditText editAccount;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.txt_forget_password)
    TextView txtForgetPassword;
    @BindView(R.id.txt_sign_in)
    TextView txtSignIn;
    @BindView(R.id.txt_no_account)
    TextView txtNoAccount;
    @BindView(R.id.txt_sign_up)
    TextView txtSignUp;
    @BindView(R.id.img_close)
    ImageView imgClose;

    @Autowired
    public String userEmail;
    @Autowired
    public String userPassword;

    private LoginActivity activity;
    private LoginContract.Presenter presenter;

    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 120:
                    activity.finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new LoginPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        if (BuildConfig.DEFAULT_HINT) {
            editAccount.setText("762396990@qq.com");
            editPassword.setText("@QWer1234");
            //editAccount.setText("yinchangxin1989@gmail.com");
            //editPassword.setText("#bitmain!@#$");
//            editAccount.setText("mhl564312135@gmail.com");
//            editPassword.setText("mohuilin28");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!TextUtils.isEmpty(userEmail)) {
            editAccount.setText(userEmail);
            editPassword.setText(userPassword);
        }
    }

    @OnClick({R.id.img_close, R.id.txt_sign_in, R.id.txt_forget_password, R.id.txt_sign_up})
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.img_close:
                activity.finish();
                break;
            case R.id.txt_sign_in:
                signIn();
                break;
            case R.id.txt_forget_password:
                forgetPassword();
                break;
            case R.id.txt_sign_up:
                signUp();
                break;
        }
    }

    @Override
    public void signIn() {
        txtSignIn.setEnabled(false);
        txtSignIn.setAlpha(0.5f);

        String email = editAccount.getText().toString();
        String password = editPassword.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            SnackBarUtil.error(activity, getString(R.string.account_password_empty));
            return;
        }
        presenter.signIn(email, password, new BaseCallBack<Boolean>(activity) {
            @Override
            public void success(Boolean aBoolean) {
                txtSignIn.setEnabled(true);
                txtSignIn.setAlpha(1f);

                loginSuccess();
            }

            @Override
            public void serverError(int code, String err) {
                txtSignIn.setEnabled(true);
                txtSignIn.setAlpha(1f);

                presenter.againSignIn();
            }

            @Override
            public void netError() {
                txtSignIn.setEnabled(true);
                txtSignIn.setAlpha(1f);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void forgetPassword() {
        ARouter.getInstance().build("/login/forgetpassword").navigation();
    }

    @Override
    public void signUp() {
        ARouter.getInstance().build("/login/createaccount").navigation();
    }

    @Override
    public void loginSuccess() {
        MainEvent.send(MainEvent.HomeType.LOGIN_SUCCESS);

        Request.request().balanceRequest(activity);
        handler.sendEmptyMessageDelayed(120, 1000);
    }

    @Override
    public void presenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
