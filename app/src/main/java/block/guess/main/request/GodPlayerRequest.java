package block.guess.main.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class GodPlayerRequest extends BaseRequest {

    public GodPlayerRequest() {
        super("");
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_RANKINGS_WINNERS;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
