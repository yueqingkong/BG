package block.guess.betting.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class BettingDetailRequest extends BaseRequest {

    private String identifier;

    public BettingDetailRequest(String s) {
        super(s);
        this.identifier = s;
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_PURCHASE + identifier;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
