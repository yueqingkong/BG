package block.guess.my;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.my.adapter.WinningRecordAdapter;
import block.guess.my.bean.WinningRecordBean;
import block.guess.my.contract.WinningRecordContract;
import block.guess.my.presenter.WinningRecordPresenter;
import block.guess.my.request.WinningRecordRequest;
import block.guess.utils.DensityUtils;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/my/winningrecord")
public class WinningRecordActivity extends BaseActivity implements WinningRecordContract.BView, WinningRecordAdapter.WinningRecordCallback, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.recycler_winning_record)
    RecyclerView recyclerWinningRecord;
    @BindView(R.id.constraintlayout_empty)
    ConstraintLayout constraintlayoutEmpty;

    private static String TAG = "_WinningRecordActivity";

    private WinningRecordActivity activity;
    private WinningRecordContract.Presenter presenter;
    private WinningRecordAdapter recordAdapter;

    private boolean isRequset = false;
    private int index = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_record);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new WinningRecordPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setTitleTxt(getString(R.string.winning_record));
        toolbarBase.setToolbarCallback(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerWinningRecord.setLayoutManager(layoutManager);

        int dp12 = DensityUtils.dip2px(12);
        BaseItemDecoration itemDecoration = new BaseItemDecoration(dp12, dp12, dp12);
        recyclerWinningRecord.addItemDecoration(itemDecoration);
        recordAdapter = new WinningRecordAdapter();
        recyclerWinningRecord.setAdapter(recordAdapter);
        recordAdapter.setRecordCallback(this);
        recyclerWinningRecord.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange()) {
                    winningRecordRequest();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void winningRecordRequest() {
        if (isRequset) {
            return;
        }

        isRequset = true;
        recordAdapter.setLoadingStatus();
        WinningRecordRequest request = new WinningRecordRequest(index);
        OKHttpUtil.client().request(request, new BaseCallBack<List<WinningRecordBean>>(activity) {

            @Override
            public void success(List<WinningRecordBean> beans) {
                LogUtil.d(TAG, "" + beans.size());

                isRequset = false;
                if (index == 1 && beans.size() == 0) {
                    constraintlayoutEmpty.setVisibility(View.VISIBLE);
                } else {
                    constraintlayoutEmpty.setVisibility(View.GONE);
                }

                if (beans.size() > 0) {
                    if (index == 1) {
                        recordAdapter.updateRecords(beans);
                    } else {
                        recordAdapter.appendRecords(beans);
                    }

                    index++;
                } else {
                    recordAdapter.setEndStatus();
                }
            }

            @Override
            public void serverError(int code, String err) {
                isRequset = false;
            }

            @Override
            public void netError() {
                isRequset = false;
            }
        });
    }

    @Override
    public void presenter(WinningRecordContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void leftClick() {
        activity.finish();
    }

    @Override
    public void rightClick() {

    }

    @Override
    public void itemClick(WinningRecordBean bean) {
        ARouter.getInstance().build("/betting/bchdetail")
                .withLong("contractId", bean.getContract_id())
                .withInt("status",bean.getStatus())
                .navigation(activity);
    }
}
