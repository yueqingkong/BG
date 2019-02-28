package block.guess.betting;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.Nullable;
import block.guess.R;
import block.guess.base.BaseActivity;
import block.guess.betting.bean.ContractDetailBean;
import block.guess.betting.contract.BCHLuckyPaySuccessContract;
import block.guess.betting.presenter.BCHLuckyPaySuccessPresenter;
import block.guess.betting.request.BCHContractDetailRequest;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.widget.toolbar.BaseToolBar;
import block.guess.widget.toolbar.ToolbarCallback;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/betting/bchpaysuccess")
public class BCHPaySuccessActivity extends BaseActivity implements BCHLuckyPaySuccessContract.BView, ToolbarCallback {

    @BindView(R.id.toolbar_base)
    BaseToolBar toolbarBase;
    @BindView(R.id.img_pay_success)
    ImageView imgPaySuccess;
    @BindView(R.id.txt_pay_success)
    TextView txtPaySuccess;
    @BindView(R.id.txt_pay_result)
    TextView txtPayResult;
    @BindView(R.id.txt_pay_transfer)
    TextView txtPayTransfer;

    @Autowired
    long contractId;

    private static String TAG = "_BCHPaySuccessActivity";
    private BCHPaySuccessActivity activity;
    private BCHLuckyPaySuccessContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bchlucky_paysuccess);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);

        new BCHLuckyPaySuccessPresenter(this).start();
    }

    @Override
    public void init() {
        activity = this;
        getSupportActionBar().hide();
        statusBar(false,getResources().getColor(R.color.color_white));

        toolbarBase.setLeftTxt(R.mipmap.btn_close_big);
        toolbarBase.setTitleTxt(getString(R.string.pay_result));
        toolbarBase.setToolbarCallback(this);
    }

    @OnClick({R.id.txt_pay_result, R.id.txt_pay_transfer})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.txt_pay_result:
                orderDetail();
                break;
            case R.id.txt_pay_transfer:
                giftFriend();
                break;
        }
    }

    private void orderDetail() {
        BCHContractDetailRequest request = new BCHContractDetailRequest("", contractId);
        OKHttpUtil.client().request(request, new BaseCallBack<ContractDetailBean>(activity) {

            @Override
            public void success(ContractDetailBean bean) {
                LogUtil.d(TAG, "" + bean.getContract().getId());

                String identifier = bean.getPurchase_history().get(0).getIdentifier();
                ARouter.getInstance().build("/betting/bchdetail")
                        .withLong("contractId", contractId)
                        .withString("identifier", identifier)
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

    private void giftFriend() {
        LogUtil.d(TAG, "" + contractId);
        BCHContractDetailRequest request = new BCHContractDetailRequest("", contractId);
        OKHttpUtil.client().request(request, new BaseCallBack<ContractDetailBean>(activity) {

            @Override
            public void success(ContractDetailBean bean) {
                LogUtil.d(TAG, "" + bean.getContract().getId());

                String identifier = bean.getPurchase_history().get(0).getIdentifier();
                ARouter.getInstance().build("/betting/bchgift")
                        .withLong("contractid", contractId)
                        .withString("identifier", identifier)
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

    @Override
    public void presenter(BCHLuckyPaySuccessContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void leftClick() {
        ARouter.getInstance().build("/main/main")
                .navigation(activity);
    }

    @Override
    public void rightClick() {

    }
}
