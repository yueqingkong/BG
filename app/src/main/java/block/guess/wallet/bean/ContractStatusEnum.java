package block.guess.wallet.bean;

import java.util.HashMap;
import java.util.Map;

import block.guess.utils.MathUtil;

public enum ContractStatusEnum {
    START(1),
    END(2),
    COMPLETE(3);

    int status;

    ContractStatusEnum(int i) {
        this.status = i;
    }

    private static Map<Integer, ContractStatusEnum> statusEnumMap = new HashMap<>();

    static {
        for (ContractStatusEnum e : ContractStatusEnum.values()) {
            statusEnumMap.put(e.status, e);
        }
    }

    public static ContractStatusEnum value(int status) {
        ContractStatusEnum statusEnum = ContractStatusEnum.START;
        if (statusEnumMap.containsKey(status)) {
            statusEnum = statusEnumMap.get(status);
        }
        return statusEnum;
    }
}
