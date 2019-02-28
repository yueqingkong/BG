package block.guess.wallet.bean;

import java.util.HashMap;
import java.util.Map;

public enum CategoryEnum {

    D3(1),
    LUCKY(2),
    LOTTO(3),
    FREE(4);

    int category;

    CategoryEnum(int category) {
        this.category = category;
    }

    private static Map<Integer, CategoryEnum> enumMap = new HashMap<>();

    static {
        for (CategoryEnum e : CategoryEnum.values()) {
            enumMap.put(e.category, e);
        }
    }

    public static CategoryEnum parse(int category) {
        CategoryEnum en = enumMap.get(category);
        return en;
    }

    public int getCategory() {
        return category;
    }
}
