package block.guess.my;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.BuildConfig;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.my.contract.ChangePasswordContract;
import block.guess.my.presenter.ChangePasswordPresenter;
import block.guess.widget.snackbar.SnackBarUtil;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/my/changepassword")
public class ChangePasswordActivity extends BaseActivity implements ChangePasswordContract.BView, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.edit_password_old)
    EditText editPasswordOld;
    @BindView(R.id.edit_password_new)
    EditText editPasswordNew;
    @BindView(R.id.txt_change_now)
    TextView txtChangeNow;

    private static String TAG = "_ChangePasswordActivity";
    private ChangePasswordActivity activity;
    private ChangePasswordContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_passord);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new ChangePasswordPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false,getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setToolbarCallback(this);

        if (BuildConfig.DEFAULT_HINT) {
            editPasswordOld.setText("@QWer1234");
            editPasswordNew.setText("@QWer1234");
        }
    }

    @OnClick({R.id.txt_change_now})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.txt_change_now:
                updatePassword();
                break;
        }
    }

    @Override
    public void changePasswordSuccess() {
        SnackBarUtil.success(activity, activity.getString(R.string.password_change_success));
        activity.finish();
    }

    @Override
    public void updatePassword() {
        String oldpass = editPasswordOld.getText().toString();
        String newpass = editPasswordNew.getText().toString();

        presenter.changePassword(oldpass, newpass);
    }

    @Override
    public void presenter(ChangePasswordContract.Presenter presenter) {
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
