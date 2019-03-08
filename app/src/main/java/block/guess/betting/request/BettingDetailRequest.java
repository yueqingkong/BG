package block.guess.betting.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class BettingDetailRequest extends BaseRequest {

    private long contactid;
    private int status;

    public BettingDetailRequest(Long s, int status) {
        super(s);
        this.contactid = s;
        this.status = status;
    }

    @Override
    public String requstUri() {
        String uri = "";
        if (status == 0) {
            uri = ApiUtil.V1_PURCHASE + "?contract_id=" + contactid;
        } else {
            uri = ApiUtil.V1_PURCHASE + "?contract_id=" + contactid + "&status=" + status;
        }
        return uri;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
