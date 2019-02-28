package block.guess.my.bean;

public class PartnerFinanceBean {

    /**
     * total_coin : 0
     * total_paid_coin : 0
     * total_unpaid_coin : 0
     */

    private long total_coin;
    private long total_paid_coin;
    private long total_unpaid_coin;

    public long getTotal_coin() {
        return total_coin;
    }

    public void setTotal_coin(long total_coin) {
        this.total_coin = total_coin;
    }

    public long getTotal_paid_coin() {
        return total_paid_coin;
    }

    public void setTotal_paid_coin(long total_paid_coin) {
        this.total_paid_coin = total_paid_coin;
    }

    public long getTotal_unpaid_coin() {
        return total_unpaid_coin;
    }

    public void setTotal_unpaid_coin(long total_unpaid_coin) {
        this.total_unpaid_coin = total_unpaid_coin;
    }
}
