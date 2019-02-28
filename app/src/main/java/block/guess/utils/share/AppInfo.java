package block.guess.utils.share;

import com.google.gson.Gson;

import block.guess.login.bean.UserInfoBean;
import block.guess.main.bean.BalanceBean;
import block.guess.utils.share.bean.BaseInfo;

public class AppInfo {

    /** 第一次启动App */
    private static String FIRST_LOGIN = "FIRST_LOGIN";
    /** 登陆成功后，保存用户信息 */
    private static String INFO_USER = "INFO_USER";
    /** 保存用户钱包 */
    private static String INFO_BALANCE = "INFO_BALANCE";
    /** 最后一次获奖id */
    private static String INFO_CONTRACTID = "AWARD_CONTRACTID";

    private static AppInfo appInfo;
    private BaseInfo baseInfo;

    public AppInfo() {
        baseInfo = new BaseInfo("AppInfo");
    }

    public synchronized static AppInfo getAppInfo() {
        if (appInfo == null) {
            appInfo = new AppInfo();
        }
        return appInfo;
    }

    public void setFirstLogin(boolean b) {
        baseInfo.putValue(FIRST_LOGIN, b);
    }

    public boolean getFirstLogin() {
        boolean firstLogin = true;
        if (baseInfo.isContains(FIRST_LOGIN)) {
            firstLogin = baseInfo.getBoolean(FIRST_LOGIN);
        }
        return firstLogin;
    }

    public void setInfoUser(UserInfoBean infoBean) {
        baseInfo.putValue(INFO_USER, new Gson().toJson(infoBean));
    }

    public UserInfoBean getInfoUser() {
        UserInfoBean infoBean = null;
        if (baseInfo.isContains(INFO_USER)) {
            infoBean = new Gson().fromJson(baseInfo.getStringValue(INFO_USER), UserInfoBean.class);
        }
        return infoBean;
    }

    public boolean userExist() {
        return baseInfo.isContains(INFO_USER);
    }

    public void removeUser() {
        baseInfo.remove(INFO_USER);
    }

    public void setContractid(int id) {
        baseInfo.putValue(INFO_CONTRACTID, id);
    }

    public int getContractid() {
        return baseInfo.getIntValue(INFO_CONTRACTID, 0);
    }

    public boolean balanceExist(){
       return  baseInfo.isContains(INFO_BALANCE);
    }

    public void removeBalance(){
        baseInfo.remove(INFO_BALANCE);
    }

    public void saveBalance(BalanceBean bean) {
        baseInfo.putValue(INFO_BALANCE, new Gson().toJson(bean));
    }

    public BalanceBean getBalance() {
        BalanceBean balanceBean = null;
        if (baseInfo.isContains(INFO_BALANCE)) {
            String info = baseInfo.getStringValue(INFO_BALANCE);
            balanceBean = new Gson().fromJson(info, BalanceBean.class);
        }
        return balanceBean;
    }
}
