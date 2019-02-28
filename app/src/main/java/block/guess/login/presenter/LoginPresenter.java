package block.guess.login.presenter;

import android.app.Activity;

import block.guess.R;
import block.guess.login.bean.LoginBean;
import block.guess.login.bean.UserInfoBean;
import block.guess.login.contract.LoginContract;
import block.guess.login.request.LoginRequest;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.utils.share.AppInfo;
import block.guess.widget.dialog.common.CaptChaDialog;
import block.guess.widget.snackbar.SnackBarUtil;

public class LoginPresenter implements LoginContract.Presenter {

    private static final String TAG = "_LoginPresenter";
    private LoginContract.BView baseView;
    private LoginPresenter presenter;
    private Activity activity;

    private String email;
    private String password;

    public LoginPresenter(LoginContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        presenter = this;
        activity = (Activity) baseView;
        baseView.presenter(presenter);
        baseView.init();
    }

    @Override
    public void signIn(final String email, final String password) {
        this.email = email;
        this.password = password;

        LoginBean loginBean = new LoginBean(email, password);
        LoginRequest request = new LoginRequest(loginBean);
        OKHttpUtil.client().request(request, new BaseCallBack<UserInfoBean>(activity) {

            @Override
            public void success(UserInfoBean infoBean) {
                SnackBarUtil.success(activity,activity.getString(R.string.login_success));
                AppInfo.getAppInfo().setInfoUser(infoBean);

                baseView.loginSuccess();
            }

            @Override
            public void serverError(int code, String err) {
                againSignIn();
            }

            @Override
            public void netError() {

            }
        });
    }

    @Override
    public void againSignIn() {
        CaptChaDialog dialog = new CaptChaDialog(new CaptChaDialog.CaptCallback() {

            @Override
            public void inputFinish(String id, String captcha) {
                LoginBean loginBean = new LoginBean(email, password, id, captcha);
                LoginRequest request = new LoginRequest(loginBean);
                OKHttpUtil.client().request(request, new BaseCallBack<UserInfoBean>(activity) {

                    @Override
                    public void success(UserInfoBean infoBean) {
                        SnackBarUtil.success(activity,activity.getString(R.string.login_success));
                        AppInfo.getAppInfo().setInfoUser(infoBean);

                        baseView.loginSuccess();
                    }

                    @Override
                    public void serverError(int code, String err) {
                    }

                    @Override
                    public void netError() {

                    }
                });
            }
        });
        dialog.showDialog(activity);
    }
}
