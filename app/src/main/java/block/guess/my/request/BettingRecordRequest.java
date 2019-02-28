package block.guess.my.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class BettingRecordRequest extends BaseRequest {

    private int pagrIndex;

    public BettingRecordRequest(int index) {
        super("");
        this.pagrIndex = index;
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_USER_PURCHASE + "?pageIdx=" + pagrIndex;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
