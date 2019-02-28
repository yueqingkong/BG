package block.guess.main.presenter;

import android.app.Activity;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.ArrayList;
import java.util.List;

import block.guess.base.BaseFragment;
import block.guess.betting.bean.BCH3dBuyBean;
import block.guess.betting.request.BCH3DBuyRequest;
import block.guess.login.bean.UserInfoBean;
import block.guess.main.contract.HomeContract;
import block.guess.main.request.Free3DRequest;
import block.guess.my.bean.WinningRecordBean;
import block.guess.my.request.WinningRecordRequest;
import block.guess.utils.log.LogUtil;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.utils.share.AppInfo;

public class HomePresenter implements HomeContract.Presenter {

    private static String TAG = "_HomePresenter";
    private HomeContract.BView baseView;
    private Activity activity;

    public HomePresenter(HomeContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        activity = ((BaseFragment) baseView).getActivity();
        baseView.init();

        baseView.balance();
        baseView.bannerListRequest();
        baseView.homeRequest();

        awardRequest(1);
    }

    @Override
    public void free3DDetail(final int contractid) {
        Free3DRequest request = new Free3DRequest("");
        OKHttpUtil.client().request(request, new BaseCallBack<BCH3dBuyBean.RandomItem>(activity) {

            @Override
            public void success(BCH3dBuyBean.RandomItem item) {
                freen3DReceive(contractid, item);
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
    public void freen3DReceive(final int contractid, BCH3dBuyBean.RandomItem item) {
        BCH3dBuyBean buyBean = new BCH3dBuyBean();
        buyBean.setContract_id(contractid);
        buyBean.setTimes(1);

        List<BCH3dBuyBean.RandomItem> randomItems = new ArrayList<>();
        randomItems.add(item);
        buyBean.setFree_shot_numbers(randomItems);

        BCH3DBuyRequest request = new BCH3DBuyRequest(buyBean);
        OKHttpUtil.client().request(request, new BaseCallBack<String>(activity) {
            @Override
            public void success(String o) {
                LogUtil.d(TAG, o);

                ARouter.getInstance().build("/betting/bchpaysuccess")
                        .withLong("contractId", (long) contractid)
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
    public void awardRequest(int category) {
        UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
        if (infoBean == null) {
            return;
        }

        WinningRecordRequest request = new WinningRecordRequest(1);
        OKHttpUtil.client().request(request, new BaseCallBack<List<WinningRecordBean>>(activity) {

            @Override
            public void success(List<WinningRecordBean> beans) {
                LogUtil.d(TAG, "" + beans.size());
                if (beans.size() > 0) {
                    int contractid = beans.get(0).getContract_id();
                    if (contractid != AppInfo.getAppInfo().getContractid()) {
                        AppInfo.getAppInfo().setContractid(contractid);
                        baseView.awardAnim(contractid);
                    }
                }
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
