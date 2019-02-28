package block.guess.main.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class BestPartnerRequest extends BaseRequest {

    public BestPartnerRequest() {
        super("");
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_RANKINGS_PARTNERS;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
