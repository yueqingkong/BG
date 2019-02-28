package block.guess.login;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.login.adapter.GuideAdapter;
import block.guess.login.contract.GuideContract;
import block.guess.login.presenter.GuidePresenter;
import block.guess.utils.log.LogUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/login/guide")
public class GuideActivity extends BaseActivity implements GuideContract.BView {

    @BindView(R.id.recycler_guide)
    RecyclerView recyclerGuide;
    @BindView(R.id.view_left)
    View viewLeft;
    @BindView(R.id.view_centre)
    View viewCentre;
    @BindView(R.id.view_right)
    View viewRight;

    private static String TAG = "_GuideActivity";
    private GuideActivity activity;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new GuidePresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();

        //todo 2019
        manager = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        recyclerGuide.setLayoutManager(manager);
        GuideAdapter guideAdapter = new GuideAdapter(activity);
        recyclerGuide.setAdapter(guideAdapter);
        recyclerGuide.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private boolean intent = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int review_position = manager.findFirstVisibleItemPosition();
                    LogUtil.d(TAG, "position: " + review_position);

                    switch (review_position) {
                        case 0:
                            firstPosition();
                            break;
                        case 1:
                            secondPosition();
                            break;
                        case 2:
                            thirdPosition();
                            break;
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int review_position = manager.findFirstVisibleItemPosition();
                LogUtil.d(TAG, "position: " + review_position + "; dx: " + dx);

                if (!intent && review_position == 2 && dx > 10) {
                    intent = true;
                    ARouter.getInstance().build("/main/main").navigation(activity, new NavCallback() {
                        @Override
                        public void onArrival(Postcard postcard) {
                            activity.finish();
                        }
                    });
                }
            }
        });

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerGuide);
    }


    @Override
    public void firstPosition() {
        viewLeft.setBackgroundResource(R.drawable.shape_oval_white);
        viewCentre.setBackgroundResource(R.drawable.shape_oval_white_40);
        viewRight.setBackgroundResource(R.drawable.shape_oval_white_40);
    }

    @Override
    public void secondPosition() {
        viewLeft.setBackgroundResource(R.drawable.shape_oval_d2d8f1);
        viewCentre.setBackgroundResource(R.drawable.shape_oval_645aff);
        viewRight.setBackgroundResource(R.drawable.shape_oval_d2d8f1);
    }

    @Override
    public void thirdPosition() {
        viewLeft.setBackgroundResource(R.drawable.shape_oval_white_40);
        viewCentre.setBackgroundResource(R.drawable.shape_oval_white_40);
        viewRight.setBackgroundResource(R.drawable.shape_oval_white);
    }

    @Override
    public void presenter(GuideContract.Presenter presenter) {

    }
}
