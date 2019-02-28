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
import block.guess.my.adapter.BettingRecordAdapter;
import block.guess.my.bean.RecordDetailBean;
import block.guess.my.contract.BettingRecordContract;
import block.guess.my.presenter.BettingRecordPresenter;
import block.guess.my.request.BettingRecordRequest;
import block.guess.utils.DensityUtils;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.widget.recyclerview.decoration.BaseItemDecoration;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/my/bettingrecord")
public class BettingRecordActivity extends BaseActivity implements BettingRecordContract.BView, BettingRecordAdapter.BettingRecordCallback, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.recycler_betting_record)
    RecyclerView recyclerBettingRecord;
    @BindView(R.id.constraintlayout_empty)
    ConstraintLayout constraintlayoutEmpty;

    private BettingRecordActivity activity;
    private BettingRecordAdapter recordAdapter;
    private BettingRecordContract.Presenter presenter;

    private boolean isRequest = false;
    private int index = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bettingrecord);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new BettingRecordPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false, getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_return_gray);
        toolbarBase.setTitleTxt(getString(R.string.betting_record));
        toolbarBase.setToolbarCallback(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerBettingRecord.setLayoutManager(layoutManager);

        int dp12 = DensityUtils.dip2px(12);
        BaseItemDecoration itemDecoration = new BaseItemDecoration(dp12, dp12, dp12);
        recyclerBettingRecord.addItemDecoration(itemDecoration);
        recordAdapter = new BettingRecordAdapter();
        recyclerBettingRecord.setAdapter(recordAdapter);
        recordAdapter.setRecordCallback(this);
        recyclerBettingRecord.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange()) {
                    recordDetails();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void recordDetails() {
        if (isRequest) {
            return;
        }

        isRequest = true;
        recordAdapter.setLoadingStatus();
        BettingRecordRequest recordRequest = new BettingRecordRequest(index);
        OKHttpUtil.client().request(recordRequest, new BaseCallBack<List<RecordDetailBean>>(activity) {

            @Override
            public void success(List<RecordDetailBean> beans) {
                isRequest = false;

                if (index == 1 && beans.size() == 0) {
                    constraintlayoutEmpty.setVisibility(View.VISIBLE);
                } else {
                    constraintlayoutEmpty.setVisibility(View.GONE);
                }

                if (beans.size() > 0) {
                    if (index == 1) {
                        recordAdapter.updateRecords(beans);
                    } else {
                        recordAdapter.insertRecords(beans);
                    }

                    index++;
                } else {
                    recordAdapter.setEndStatus();
                }
            }

            @Override
            public void serverError(int code, String err) {
                isRequest = false;
                recordAdapter.setEndStatus();
            }

            @Override
            public void netError() {
                isRequest = false;
                recordAdapter.setEndStatus();
            }
        });
    }

    @Override
    public void presenter(BettingRecordContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void itemClick(RecordDetailBean detailBean) {
        ARouter.getInstance().build("/my/bettingrecorddetail")
                .withSerializable("recordDetailBean", detailBean)
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
