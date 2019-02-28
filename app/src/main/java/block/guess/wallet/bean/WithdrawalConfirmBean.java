package block.guess.wallet.bean;

public class WithdrawalConfirmBean {

    private String to;
    private long satoshis;
    private String code;
    private long fee;

    public WithdrawalConfirmBean(String to, long satoshis, String code, long fee) {
        this.to = to;
        this.satoshis = satoshis;
        this.code = code;
        this.fee = fee;
    }
}
