package block.guess.betting.bean;

import java.io.Serializable;
import java.util.List;

public class BettingDetailBean implements Serializable {

    /**
     * id : 322
     * identifier : faba17e92e2f5b47e4a2bba8c969258b2425a8da
     * user_id : 21
     * contract_id : 1178
     * times : 1
     * unit : 50000
     * total_amount : 50000
     * tx_hash : 1a1c0f89e3dfeb35aca668702cbc9f109e842188260609b30a51adc95bae5ffd
     * status : 1
     * category : 1
     * created_at : 1551933128
     * purchase_numbers : [{"id":2524,"contract_id":1178,"user_id":21,"purchase_identifier":"faba17e92e2f5b47e4a2bba8c969258b2425a8da","identifier":"cc2ed09eb212f419f2b8ba0edf0be584321855c8","order_no":1,"award_number":"262","category":1,"status":1}]
     * period : 1126
     */

    private int id;
    private String identifier;
    private int user_id;
    private int contract_id;
    private int times;
    private int unit;
    private long total_amount;
    private String tx_hash;
    private int status;
    private int category;
    private int created_at;
    private int period;
    private List<PurchaseNumbersBean> purchase_numbers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public long getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(long total_amount) {
        this.total_amount = total_amount;
    }

    public String getTx_hash() {
        return tx_hash;
    }

    public void setTx_hash(String tx_hash) {
        this.tx_hash = tx_hash;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public List<PurchaseNumbersBean> getPurchase_numbers() {
        return purchase_numbers;
    }

    public void setPurchase_numbers(List<PurchaseNumbersBean> purchase_numbers) {
        this.purchase_numbers = purchase_numbers;
    }

    public static class PurchaseNumbersBean {
        /**
         * id : 2524
         * contract_id : 1178
         * user_id : 21
         * purchase_identifier : faba17e92e2f5b47e4a2bba8c969258b2425a8da
         * identifier : cc2ed09eb212f419f2b8ba0edf0be584321855c8
         * order_no : 1
         * award_number : 262
         * category : 1
         * status : 1
         */

        private int id;
        private int contract_id;
        private int user_id;
        private String purchase_identifier;
        private String identifier;
        private int order_no;
        private String award_number;
        private int category;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getContract_id() {
            return contract_id;
        }

        public void setContract_id(int contract_id) {
            this.contract_id = contract_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getPurchase_identifier() {
            return purchase_identifier;
        }

        public void setPurchase_identifier(String purchase_identifier) {
            this.purchase_identifier = purchase_identifier;
        }

        public String getIdentifier() {
            return identifier;
        }

        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        public int getOrder_no() {
            return order_no;
        }

        public void setOrder_no(int order_no) {
            this.order_no = order_no;
        }

        public String getAward_number() {
            return award_number;
        }

        public void setAward_number(String award_number) {
            this.award_number = award_number;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
