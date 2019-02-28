package block.guess.wallet.bean;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import block.guess.R;

public enum StatusEnum {
    WAIT(1),
    WIN(2),
    NOT_WIN(3),
    OPEN(4);

    int status;

    StatusEnum(int status) {
        this.status = status;
    }

    private static Map<Integer, StatusEnum> enumMap = new HashMap<>();

    static {
        for (StatusEnum e : StatusEnum.values()) {
            enumMap.put(e.status, e);
        }
    }

    public static StatusEnum parse(int status) {
        return enumMap.get(status);
    }

    public static String string(Context context, int status) {
        StatusEnum statusEnum = StatusEnum.parse(status);

        String string = "";
        switch (statusEnum) {
            case WAIT:
                string = context.getString(R.string.to_be_award);
                break;
            case WIN:
                string = context.getString(R.string.the_wining);
                break;
            case NOT_WIN:
                string = context.getString(R.string.not_award);
                break;
            case OPEN:
                string = context.getString(R.string.open_prize);
                break;
        }
        return string;
    }
}
