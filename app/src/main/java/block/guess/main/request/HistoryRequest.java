package block.guess.main.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class HistoryRequest extends BaseRequest {

    private int pageIndex;

    public HistoryRequest(int index) {
        super("");
        this.pageIndex = index;
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_USER_TX + "?pageIdx=" + pageIndex;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
