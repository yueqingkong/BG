package block.guess.widget.webview.request;

import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class GameRuleReuest extends BaseRequest {

    private String category;

    public GameRuleReuest(String i) {
        super("");
        this.category = i;
    }

    @Override
    public String requstUri() {
        return "/api/v1/description?category=" + category;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.GET;
    }
}
