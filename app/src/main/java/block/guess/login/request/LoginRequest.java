package block.guess.login.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class LoginRequest extends BaseRequest<String> {

    public LoginRequest(Object obj) {
        super(obj);
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_LOGIN;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.POST;
    }
}
