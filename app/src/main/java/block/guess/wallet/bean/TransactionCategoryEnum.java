package block.guess.wallet.bean;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import block.guess.R;

public enum TransactionCategoryEnum {
    SEND(1),
    CONTRACT(2),
    AWARD(3),
    RECEIVE(6),
    PARTNER(7),
    D3(8),
    LUCKY(9),
    LOTTO(10),
    FREE(11),
    GIFADDRESS(12);//赠送彩票

    private int category;

    TransactionCategoryEnum(int i) {
        this.category = i;
    }

    private static Map<Integer, TransactionCategoryEnum> categoryEnumMap = new HashMap<>();

    static {
        for (TransactionCategoryEnum e : values()) {
            categoryEnumMap.put(e.category, e);
        }
    }

    public static String string(Context context, int i) {
        TransactionCategoryEnum e = categoryEnumMap.get(i);

        String string = "";
        if (e == LUCKY) {
            string = context.getResources().getString(R.string.buy_bchlucky);
        } else if (e == D3) {
            string = context.getResources().getString(R.string.buy_bch3d);
        } else if (e == SEND) {
            string = context.getResources().getString(R.string.send);
        } else if (e == RECEIVE) {
            string = context.getResources().getString(R.string.recharge);
        } else if (e == AWARD) {
            string = context.getResources().getString(R.string.award);
        } else if (e == PARTNER) {
            string = context.getResources().getString(R.string.partner_plan);
        } else if (e == FREE) {
            string = context.getResources().getString(R.string.buy_bchfree);
        } else if (e == GIFADDRESS) {
            string = context.getResources().getString(R.string.reward);
        } else if (e == LOTTO) {
            string = context.getResources().getString(R.string.buy_lotto);
        } else if (e == CONTRACT) {
            string = context.getResources().getString(R.string.contract);
        } else {
            string = context.getResources().getString(R.string.unknown);
        }
        return string;
    }

    public static int resourceId(Context context, int i) {
        TransactionCategoryEnum e = categoryEnumMap.get(i);

        int resourceid = 0;
        if (e == LUCKY) {
            resourceid = R.mipmap.ic_bchlucky;
        } else if (e == D3) {
            resourceid = R.mipmap.ic_bch3d;
        } else if (e == SEND) {
            resourceid = R.mipmap.ic_send;
        } else if (e == RECEIVE) {
            resourceid = R.mipmap.ic_receive;
        } else if (e == AWARD) {
            resourceid = R.mipmap.ic_award;
        } else if (e == PARTNER) {
            resourceid = R.mipmap.ic_parntercolor;
        } else if (e == FREE) {
            resourceid = R.mipmap.ic_bch3d;
        } else if (e == GIFADDRESS) {
            resourceid = R.mipmap.ic_giftcolor;
        } else if (e == LOTTO) {
            resourceid = R.mipmap.ic_bchlotto;
        } else {
            resourceid = R.mipmap.ic_send;
        }
        return resourceid;
    }
}
