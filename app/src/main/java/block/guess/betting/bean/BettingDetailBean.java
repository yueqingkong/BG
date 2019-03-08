package block.guess.betting.bean;

import java.io.Serializable;
import java.util.List;

public class BettingDetailBean implements Serializable {

    /**
     * id : 104
     * identifier : b0624c00eaba7090a717774fe0f5f8da6104d2fb
     * user_id : 2
     * contract_id : 51
     * times : 10
     * unit : 100000
     * total_amount : 1000000
     * tx_hash : 6deed536d5e715b575d853e47cfff71bbbc1c5b29eb177398b0687813557c03d
     * status : 3
     * category : 2
     * created_at : 1529410584
     * send_to_friend : 1
     * purchase_numbers : [{"id":1910,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":1,"award_number":"785","category":1},{"id":1911,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":2,"award_number":"940","category":1},{"id":1912,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":3,"award_number":"601","category":1},{"id":1913,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":4,"award_number":"718","category":1},{"id":1914,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":5,"award_number":"268","category":1},{"id":1915,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":6,"award_number":"554","category":1},{"id":1916,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":7,"award_number":"388","category":1},{"id":1917,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":8,"award_number":"910","category":1},{"id":1918,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":9,"award_number":"865","category":1},{"id":1919,"contract_id":51,"user_id":2,"purchase_identifier":"b0624c00eaba7090a717774fe0f5f8da6104d2fb","order_no":10,"award_number":"408","category":1}]
     * period : 2
     */

    private int id;
    private String identifier;
    private int user_id;
    private int contract_id;
    private int times;
    private int unit;
    private int total_amount;
    private String tx_hash;
    private int status;
    private int category;
    private int created_at;
    private int send_to_friend;
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

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
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

    public int getSend_to_friend() {
        return send_to_friend;
    }

    public void setSend_to_friend(int send_to_friend) {
        this.send_to_friend = send_to_friend;
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
         * id : 1910
         * contract_id : 51
         * user_id : 2
         * purchase_identifier : b0624c00eaba7090a717774fe0f5f8da6104d2fb
         * order_no : 1
         * award_number : 785
         * category : 1
         */

        private int id;
        private int contract_id;
        private int user_id;
        private String purchase_identifier;
        private int order_no;
        private String award_number;
        private int category;

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
    }
}
