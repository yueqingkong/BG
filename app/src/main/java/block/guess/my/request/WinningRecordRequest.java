package block.guess.my.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class WinningRecordRequest extends BaseRequest {

    private int pageIndex;

    public WinningRecordRequest(int index) {
        super(index);
        this.pageIndex = index;
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_USERS_WINNING_RECORD + "?pageIdx=" + pageIndex;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
