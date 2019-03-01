package block.guess.betting.contract;

import block.guess.base.contract.BasePresenter;
import block.guess.base.contract.BaseView;
import block.guess.betting.bean.ContractDetailBean;
import block.guess.utils.okhttp.Callback.BaseCallBack;

public interface PaySuccessContract {

    interface BView extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter {

        void contractDetailRequest(long contractId, BaseCallBack<ContractDetailBean> callBack);
    }
}
