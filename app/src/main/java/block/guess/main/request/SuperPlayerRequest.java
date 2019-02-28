package block.guess.main.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class SuperPlayerRequest extends BaseRequest {

    public SuperPlayerRequest() {
        super("");
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_RANKINGS_BUYERS;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
