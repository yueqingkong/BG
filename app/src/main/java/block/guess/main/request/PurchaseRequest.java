package block.guess.main.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class PurchaseRequest extends BaseRequest {

    public PurchaseRequest(Object obj) {
        super(obj);
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_USER_PURCHASE;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return null;
    }
}
