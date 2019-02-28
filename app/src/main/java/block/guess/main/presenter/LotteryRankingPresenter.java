package block.guess.main.presenter;

import java.util.List;

import block.guess.main.bean.RankingBean;
import block.guess.main.contract.LotteryRankingContract;
import block.guess.main.request.BestPartnerRequest;
import block.guess.main.request.GodPlayerRequest;
import block.guess.main.request.SuperPlayerRequest;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.utils.okhttp.request.BaseRequest;

public class LotteryRankingPresenter implements LotteryRankingContract.Presenter {

    private LotteryRankingContract.BView baseView;

    public LotteryRankingPresenter(LotteryRankingContract.BView view) {
        this.baseView = view;
        this.baseView.presenter(this);
    }

    @Override
    public void start() {
        baseView.init();
        baseView.godPlayderClick();
    }

    @Override
    public void rankingRequest(int category) {
        BaseRequest baseRequest = null;
        switch (category) {
            case 0:
                baseRequest = new GodPlayerRequest();
                break;
            case 1:
                baseRequest = new SuperPlayerRequest();
                break;
            case 2:
                baseRequest = new BestPartnerRequest();
                break;
        }

        OKHttpUtil.client().request(baseRequest, new BaseCallBack<List<RankingBean>>(baseView.activity()) {

            @Override
            public void success(List<RankingBean> rankingBeans) {
                baseView.rankingSuccess(rankingBeans);
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
