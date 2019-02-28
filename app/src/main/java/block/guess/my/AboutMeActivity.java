package block.guess.my;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.my.adapter.AboutMeAdapter;
import block.guess.my.bean.AboutMeBean;
import block.guess.my.contract.AboutMeContract;
import block.guess.my.presenter.AboutMePresenter;
import block.guess.utils.DensityUtils;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/my/aboutme")
public class AboutMeActivity extends BaseActivity implements AboutMeContract.BView, AboutMeAdapter.AboutMeCallBack, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_icon)
    ImageView imgIcon;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.recycler_list)
    RecyclerView recyclerList;

    private static String TAG = "_AboutMeActivity";
    private AboutMeActivity activity;
    private AboutMeContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new AboutMePresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setTitleTxt(getString(R.string.about_us));
        toolbarBase.setToolbarCallback(this);

        List<AboutMeBean> aboutMeBeanList = new ArrayList<>();
        aboutMeBeanList.add(new AboutMeBean(1, R.mipmap.ic_twitter_my, activity.getString(R.string.twitter), "https://twitter.com/block_guess"));
        aboutMeBeanList.add(new AboutMeBean(2, R.mipmap.ic_telegram_my, activity.getString(R.string.telegram), "https://t.me/blockguess"));
        aboutMeBeanList.add(new AboutMeBean(3, R.mipmap.ic_email_my, activity.getString(R.string.customer_support), "https://medium.com/@blockguessfun"));
        aboutMeBeanList.add(new AboutMeBean(4, R.mipmap.ic_discord_my, activity.getString(R.string.discord), "https://discordapp.com/invite/7yvV2Xu"));
        aboutMeBeanList.add(new AboutMeBean(5, R.mipmap.ic_github_my, activity.getString(R.string.github), "https://github.com/blockguess"));
        aboutMeBeanList.add(new AboutMeBean(6, R.mipmap.ic_supportus_my, activity.getString(R.string.support_us), "https://blockguessfun.zendesk.com/hc/en-us"));

        int dp24 = DensityUtils.dip2px(24);
        BaseItemDecoration decoration = new BaseItemDecoration(dp24, 0, dp24, 0, R.color.color_f3f4fa, 1,false);
        recyclerList.addItemDecoration(decoration);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerList.setLayoutManager(layoutManager);
        AboutMeAdapter aboutMeAdapter = new AboutMeAdapter(aboutMeBeanList);
        recyclerList.setAdapter(aboutMeAdapter);
        aboutMeAdapter.setAboutMeCallBack(this);
    }

    @Override
    public void presenter(AboutMeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void itemClick(AboutMeBean bean) {
        ARouter.getInstance().build("/widget/webview")
                .withString("url", bean.getUrl())
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
