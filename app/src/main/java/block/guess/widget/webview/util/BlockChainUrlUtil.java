package block.guess.widget.webview.util;

import android.app.Activity;
import android.text.TextUtils;
import block.guess.R;
import block.guess.utils.okhttp.Callback.BaseCallBack;
import block.guess.utils.okhttp.OKHttpUtil;
import block.guess.widget.webview.bean.GameRuleBean;
import block.guess.widget.webview.request.GameRuleReuest;
import com.alibaba.android.arouter.launcher.ARouter;

import java.util.List;

public class BlockChainUrlUtil {

    private static String BaseUrl = "http://bch.blockguess.fun/";
    private static String GameUrl = "https://www.blockguess.fun/api/v1/description?category=";
    private static String BCHBtccom = "https://bch.btc.com/";

    private static String avaliableUrl(String string, String language) {
        return BaseUrl + string + "?locale=" + language;
    }

    public static String blockUrl(String string, String language) {
        return avaliableUrl("block/" + string, language);
    }

    public static String txUrl(String string, String language) {
        return avaliableUrl("tx/" + string, language);
    }

    public static String addressUrl(String string, String language) {
        return avaliableUrl("address/" + string, language);
    }

    public static String ruleTitle(Activity activity, String category) {
        String show = "";
        if (category.equals("1")) {
            show = activity.getString(R.string.bch_3d);
        } else if (category.equals("2")) {
            show = activity.getString(R.string.bch_lucky);
        } else if (category.equals("3")) {
            show = activity.getString(R.string.bch_lotto);
        }
        return show;
    }

    public static void gameRule(Activity activity, String category, String language) {
        GameRuleReuest request = new GameRuleReuest(category);
        OKHttpUtil.client().request(request, new BaseCallBack<List<GameRuleBean>>(activity) {
            @Override
            public void success(List<GameRuleBean> gameRuleBeans) {
                String content = "";
                for (GameRuleBean ruleBean : gameRuleBeans) {
                    if (language.equals(ruleBean.getLocale())) {
                        content = ruleBean.getContent();
                    }
                }

                if (!TextUtils.isEmpty(content)) {
                    ARouter.getInstance().build("/widget/richtxt")
                            .withString("title", ruleTitle(activity, category))
                            .withString("rich", content)
                            .navigation(activity);
                }
            }

            @Override
            public void serverError(int code, String err) {
            }

            @Override
            public void netError() {
            }
        });
    }

    /**
     * btc.com 查询地址
     *
     * @param address
     * @return
     */
    public static String btccomAddress(String address) {
        return BCHBtccom + address;
    }
}
