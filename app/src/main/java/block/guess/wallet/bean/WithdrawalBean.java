package block.guess.wallet.bean;

public class WithdrawalBean {

    private String to;
    private long satoshis;

    public WithdrawalBean(String to, long satoshis) {
        this.to = to;
        this.satoshis = satoshis;
    }
}
