package block.guess.main.request;

import java.util.List;

import block.guess.main.bean.LotteryBean;
import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class LotteryPageRequest extends BaseRequest<List<LotteryBean>> {

    private int category;
    private int pageIndex;

    public LotteryPageRequest(int category, int index) {
        super("");
        this.category = category;
        this.pageIndex = index;
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_LATTERIES + "?category=" + category + "&pageIdx=" + pageIndex;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
