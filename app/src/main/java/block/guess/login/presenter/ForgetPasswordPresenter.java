package block.guess.login.presenter;

import android.app.Activity;

import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.login.bean.ForgetBean;
import block.guess.login.bean.ResetForgetBean;
import block.guess.login.contract.ForgetPasswordContract;
import block.guess.login.request.ForgetRequest;
import block.guess.login.request.RestForgetRequest;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.widget.dialog.common.CaptChaDialog;
import block.guess.utils.log.LogUtil;

public class ForgetPasswordPresenter implements ForgetPasswordContract.Presenter {

    private static String TAG = "_ForgetPasswordPresenter";
    private ForgetPasswordContract.BView baseView;

    private Activity activity;

    public ForgetPasswordPresenter(ForgetPasswordContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        activity = (Activity) baseView;
        baseView.init();
    }

    @Override
    public void emailToken(final String email) {
        CaptChaDialog dialog = new CaptChaDialog(new CaptChaDialog.CaptCallback() {

            @Override
            public void inputFinish(String id, String captcha) {
                ForgetBean forgetBean = new ForgetBean(email, id, captcha);
                ForgetRequest request = new ForgetRequest(forgetBean);
                OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {

                    @Override
                    public void success(String s) {
                        LogUtil.d(TAG, s);
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

    @Override
    public void registerAccount(final String email, String token, final String password) {
        ResetForgetBean forgetBean = new ResetForgetBean(email, token, password);
        RestForgetRequest forgetRequest = new RestForgetRequest(forgetBean);
        OKHttpUtil.client().request(forgetRequest, new BaseCallBack<String>(activity) {
            @Override
            public void success(String o) {
                ARouter.getInstance().build("/login/login")
                        .withString("userEmail", email)
                        .withString("userPassword", password)
                        .navigation(activity);
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
