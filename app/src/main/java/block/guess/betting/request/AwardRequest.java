package block.guess.betting.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class AwardRequest extends BaseRequest {

    int category;

    public AwardRequest(int i) {
        super("");
        this.category = i;
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_LOTTERIES + "?category=" + category;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
