package block.guess.wallet.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class WithdrawalRequest extends BaseRequest {

    public WithdrawalRequest(Object obj) {
        super(obj);
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_USERS_WITHDRAWAL;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.POST;
    }
}
