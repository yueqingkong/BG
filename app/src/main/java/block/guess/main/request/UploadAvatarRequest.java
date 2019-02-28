package block.guess.main.request;

import block.guess.utils.ApiUtil;
import block.guess.utils.okhttp.bean.HttpMethodEnum;
import block.guess.utils.okhttp.request.BaseRequest;

public class UploadAvatarRequest extends BaseRequest {

    public UploadAvatarRequest(String filepath) {
        super(filepath);
        getStringMap().put("file", filepath);
    }

    @Override
    public String requstUri() {
        return ApiUtil.V1_USERS_AVATAR;
    }

    @Override
    public HttpMethodEnum httpMethod() {
        return HttpMethodEnum.FILE;
    }
}
