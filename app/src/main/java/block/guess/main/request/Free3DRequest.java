package block.guess.main.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class Free3DRequest extends BaseRequest {

    public Free3DRequest(Object obj) {
        super(obj);
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_USERS_PRANDOM;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.POST;
    }
}
