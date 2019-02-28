package block.guess.betting.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import block.guess.utils.MathUtil;

public class LottoBean implements Serializable {

    private ArrayList<Integer> numberLists = new ArrayList<>();
    private Integer purpleNumber;

    public boolean containsNumber(Integer num) {
        return numberLists.contains(num);
    }

    public void selectNumber(Integer num) {
        boolean contains = numberLists.contains(num);
        if (contains) {
            numberLists.remove(num);
        } else {
            if (numberLists.size() <= 5) {
                numberLists.add(num);
            }
        }
    }

    public boolean purpleContain(Integer num) {
        return num.equals(purpleNumber);
    }

    public void selectPurple(Integer num) {
        this.purpleNumber = num;
    }

    /**
     * 生成随机数
     */
    public void randomNumber() {
        Map<Integer, Integer> numberMap = new HashMap<>();
        while (true) {
            int random = MathUtil.randomInMax(33) + 1;
            if (numberMap.containsKey(random)) {
                continue;
            } else {
                numberMap.put(random, random);
                if (numberMap.size() == 6) {
                    break;
                }
            }
        }
        numberLists.clear();
        numberLists.addAll(numberMap.keySet());

        purpleNumber = MathUtil.randomInMax(16) + 1;
    }

    public boolean isAvailable() {
        boolean available = numberLists.size() == 6 && purpleNumber > 0;
        if (available) {
            for (Integer integer : numberLists) {
                available = integer > 0;
                if (!available) {
                    break;
                }
            }
        }
        return available;
    }

    public ArrayList<Integer> numberLists() {
        return numberLists;
    }

    public Integer purpleNumber() {
        return purpleNumber;
    }

    public void clear() {
        numberLists.clear();
        purpleNumber = 0;
    }
}
