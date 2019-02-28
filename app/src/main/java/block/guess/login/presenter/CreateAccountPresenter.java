package block.guess.login.presenter;

import android.app.Activity;

import block.guess.login.bean.CaptchaEmailBean;
import block.guess.login.bean.RegisterBean;
import block.guess.login.contract.CreateAccountContract;
import block.guess.login.request.EmailRequest;
import block.guess.login.request.RegisterRequest;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;

public class CreateAccountPresenter implements CreateAccountContract.Presenter {

    private static final String TAG = "_CreateAccountPresenter";
    private Activity activity;
    private CreateAccountContract.BView baseView;

    public CreateAccountPresenter(CreateAccountContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }


    @Override
    public void start() {
        activity = (Activity) baseView;
        baseView.init();
        baseView.presenter(this);
    }


    @Override
    public void requestToken(String id, String code, String email) {
        CaptchaEmailBean emailBean = new CaptchaEmailBean(id, code, email);
        EmailRequest emailRequest = new EmailRequest(emailBean);
        OKHttpUtil.client().request(emailRequest, new BaseCallBack<String>(activity) {

            @Override
            public void success(String s) {
                LogUtil.d(TAG, s);
                baseView.accountCreateSuccess();
            }

            @Override
            public void serverError(int code, String err) {

            }

            @Override
            public void netError() {

            }
        });
    }

    @Override
    public void creatAccount(String invitecode, String username, String email, String password, String token) {
        RegisterBean registerBean = new RegisterBean(invitecode, username, email, password, token);
        RegisterRequest registerRequest = new RegisterRequest(registerBean);
        OKHttpUtil.client().request(registerRequest, new BaseCallBack<String>(activity) {
            @Override
            public void success(String o) {

            }

            @Override
            public void serverError(int code, String err) {

            }

            @Override
            public void netError() {

            }
        });
    }
}
