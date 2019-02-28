package block.guess.betting.bean;

public class RandomOrgBean {
    private String format;
    private String random;
    private String signature;

    public RandomOrgBean(String random, String signature) {
        this.format = "json";
        this.random = random;
        this.signature = signature;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
