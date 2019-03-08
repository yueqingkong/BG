package block.guess.betting.bean;

import java.util.List;

public class RandomBean {
    /**
     * method : generateSignedIntegers
     * hashedApiKey : czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==
     * n : 3
     * min : 0
     * max : 9
     * replacement : true
     * base : 10
     * data : [0,5,8]
     * completionTime : 2018-06-19 12:16:25Z
     * serialNumber : 1190
     */

    private String method;
    private String hashedApiKey;
    private int n;
    private int min;
    private int max;
    private boolean replacement;
    private int base;
    private String completionTime;
    private int serialNumber;
    private List<Integer> data;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHashedApiKey() {
        return hashedApiKey;
    }

    public void setHashedApiKey(String hashedApiKey) {
        this.hashedApiKey = hashedApiKey;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public boolean isReplacement() {
        return replacement;
    }

    public void setReplacement(boolean replacement) {
        this.replacement = replacement;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public String getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
