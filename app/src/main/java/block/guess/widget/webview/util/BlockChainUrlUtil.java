package block.guess.widget.webview.util;

public class BlockChainUrlUtil {

    private static String BaseUrl = "http://bch.blockguess.fun/";
    private static String GameUrl = "https://blockguess.fun/description?category=";
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

    public static String gameRule(String category, String language) {
        return GameUrl + category + "&locale=" + language;
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
