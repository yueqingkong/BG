package block.guess.betting;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.betting.contract.GiftSuccessContract;
import block.guess.betting.presenter.GiftSuccessPresenter;
import block.guess.widget.toolbar.BaseToolBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/betting/gifsuccess")
public class GiftSuccessActivity extends BaseActivity implements GiftSuccessContract.BView {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_bg_gift)
    ImageView imgBgGift;
    @BindView(R.id.txt_back_home)
    TextView txtBackHome;

    @Autowired
    long contractid;
    @Autowired
    String identify;

    private static String TAG = "_GiftSuccessActivity";
    private GiftSuccessActivity activity;
    private GiftSuccessContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift_success);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new GiftSuccessPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false,getResources().getColor(R.color.color_white));

        toolbarBase.setLeft(R.mipmap.btn_close_big);
        toolbarBase.setTitleTxt(getString(R.string.gift_result));
    }

    @OnClick({R.id.txt_back_home})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.txt_back_home:
                backHome();
                break;
        }
    }

    @Override
    public void backHome() {
        ARouter.getInstance().build("/main/main")
                .navigation(activity);
    }

    @Override
    public void presenter(GiftSuccessContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
