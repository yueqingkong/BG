package block.guess.login;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.login.contract.LaunchContract;
import block.guess.login.presenter.LaunchPresenter;
import block.guess.utils.PermissionUtil;

@Route(path = "/login/launch")
public class LaunchActivity extends BaseActivity implements LaunchContract.BView {

    private LaunchActivity activity;
    /**
     * 需要用户申请的动态权限
     */
    private String[] Permissions = new String[]{
            PermissionUtil.PERMISSION_STORAGE,
            PermissionUtil.PERMISSION_STORAGE_WRITE,
            PermissionUtil.PERMISSION_CAMERA,
    };

    private LaunchContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launch);
        ARouter.getInstance().inject(this);

        new LaunchPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
    }

    @Override
    public void permission() {
        PermissionUtil.getInstance().requestPermission(activity, Permissions, permissionCallBack);
    }

    @Override
    public void firstLaunch() {
        ARouter.getInstance().build("/login/guide").navigation(activity, new NavCallback() {
            @Override
            public void onArrival(Postcard postcard) {
                activity.finish();
            }
        });
    }

    @Override
    public void homeStart() {
        ARouter.getInstance().build("/main/main").navigation(activity, new NavCallback() {
            @Override
            public void onArrival(Postcard postcard) {
                activity.finish();
            }
        });
    }

    @Override
    public void presenter(LaunchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtil.getInstance().onRequestPermissionsResult(activity, requestCode, permissions, grantResults, permissionCallBack);
    }

    protected PermissionUtil.ResultCallBack permissionCallBack = new PermissionUtil.ResultCallBack() {
        @Override
        public void granted(String[] permissions) {
            if (permissions != null || permissions.length == Permissions.length) {
                presenter.allow();
            }
        }

        @Override
        public void deny(String[] permissions) {
            if (permissions != null || permissions.length > 0) {
                //activity.finish();
            }
        }
    };
}
