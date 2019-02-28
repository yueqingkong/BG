package block.guess.my.presenter;

import android.app.Activity;

import block.guess.my.bean.PasswordBean;
import block.guess.my.contract.ChangePasswordContract;
import block.guess.my.request.ChangePasswordRequest;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;

public class ChangePasswordPresenter implements ChangePasswordContract.Presenter {

    private Activity activity;
    private ChangePasswordContract.BView baseView;

    public ChangePasswordPresenter(ChangePasswordContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        activity = (Activity) baseView;
        this.baseView.init();
    }

    @Override
    public void changePassword(String oldpwd, String newpwd) {
        PasswordBean passwordBean = new PasswordBean(oldpwd, newpwd);
        ChangePasswordRequest request = new ChangePasswordRequest(passwordBean);
        OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {

            @Override
            public void success(String o) {
                baseView.changePasswordSuccess();
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
