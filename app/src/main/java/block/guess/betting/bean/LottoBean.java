package block.guess.betting.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import block.guess.utils.MathUtil;

public class LottoBean implements Serializable {

    private ArrayList<String> numberLists = new ArrayList<>();
    private String purpleNumber;

    public boolean containsNumber(String num) {
        return numberLists.contains(num);
    }

    public void selectNumber(String num) {
        boolean contains = numberLists.contains(num);
        if (contains) {
            numberLists.remove(num);
        } else {
            if (numberLists.size() <= 5) {
                numberLists.add(num);
            }
        }
    }

    public boolean purpleContain(String num) {
        return num.equals(purpleNumber);
    }

    public void selectPurple(String num) {
        this.purpleNumber = num;
    }

    /**
     * 生成随机数
     */
    public void randomNumber() {
        Map<Integer, String> numberMap = new HashMap<>();
        while (true) {
            int random = MathUtil.randomInMax(33) + 1;
            if (numberMap.containsKey(random)) {
                continue;
            } else {
                String randomStr = "";
                if (random < 10) {
                    randomStr = "0" + random;
                } else {
                    randomStr = String.valueOf(random);
                }
                numberMap.put(random, randomStr);
                if (numberMap.size() == 6) {
                    break;
                }
            }
        }
        numberLists.clear();
        numberLists.addAll(numberMap.values());

        // 蓝球
        Integer purpleRandom = MathUtil.randomInMax(16) + 1;
        String purpleStr = "";
        if (purpleRandom < 10) {
            purpleStr = "0" + purpleRandom;
        } else {
            purpleStr = String.valueOf(purpleRandom);
        }
        purpleNumber = purpleStr;
    }

    public boolean isAvailable() {
        boolean available = numberLists.size() == 6 && !TextUtils.isEmpty(purpleNumber);
        if (available) {
            for (String integer : numberLists) {
                available = !TextUtils.isEmpty(integer);
                if (!available) {
                    break;
                }
            }
        }
        return available;
    }

    public ArrayList<String> numberLists() {
        return numberLists;
    }

    public String purpleNumber() {
        return purpleNumber;
    }

    public void clear() {
        numberLists.clear();
        purpleNumber = "";
    }
}
