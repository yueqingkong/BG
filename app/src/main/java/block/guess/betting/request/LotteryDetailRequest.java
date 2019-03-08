package block.guess.betting.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class LotteryDetailRequest extends BaseRequest {

    private long contractid;

    public LotteryDetailRequest(long id) {
        super(id);
        this.contractid = id;
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_LOTTERIES + "/" + contractid;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
