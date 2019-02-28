package block.guess.main.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class BalanceRequest extends BaseRequest {

    public BalanceRequest(Object obj) {
        super(obj);
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_USER_BALANCE;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
