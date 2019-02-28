package block.guess.main.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class UserInfoRequest extends BaseRequest {

    public UserInfoRequest(Object object) {
        super(object);
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_USERS_INFO;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.PUT;
    }
}
