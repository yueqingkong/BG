package block.guess.betting.bean;

import java.io.Serializable;

import block.guess.utils.MathUtil;

/**
 * 投注号码
 */
public class Betting3DBean implements Serializable {

    private int firstNumber = -1;
    private int secondNumber = -1;
    private int thirdNumber = -1;

    public Betting3DBean() {
    }

    public Betting3DBean(int firstNumber, int secondNumber, int thirdNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.thirdNumber = thirdNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }

    public int getThirdNumber() {
        return thirdNumber;
    }

    public void setThirdNumber(int thirdNumber) {
        this.thirdNumber = thirdNumber;
    }

    /**
     * 生成三位随机数
     */
    public void randomNumber() {
        this.firstNumber = MathUtil.randomInMax(8) + 1;
        this.secondNumber = MathUtil.randomInMax(8) + 1;
        this.thirdNumber = MathUtil.randomInMax(8) + 1;
    }

    public boolean isAvailable() {
        return this.firstNumber >= 0
                && this.secondNumber >= 0
                && this.thirdNumber >= 0;
    }

    @Override
    public String toString() {
        return String.valueOf(firstNumber)
                + String.valueOf(secondNumber)
                + String.valueOf(thirdNumber);
    }

    public void clear() {
        firstNumber = -1;
        secondNumber = -1;
        thirdNumber = -1;
    }
}
