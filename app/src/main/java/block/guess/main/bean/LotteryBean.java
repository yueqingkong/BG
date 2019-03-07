package block.guess.main.bean;

import java.io.Serializable;
import java.util.List;

public class LotteryBean implements Serializable {


    /**
     * id : 55
     * contract_id : 2
     * period : 1
     * open_time : 1529060598
     * address : 15CuxZQ4v51xyc86BDp5B4qb35kgpXDrdR
     * lotteries_numbers : [{"id":49,"contract_id":2,"award_number":"040","open_time":1529060598,"height":534776,"category":1}]
     */

    private int id;
    private int contract_id;
    private int period;
    private int open_time;
    private String address;
    private List<LotteriesNumbersBean> lotteries_numbers;

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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getOpen_time() {
        return open_time;
    }

    public void setOpen_time(int open_time) {
        this.open_time = open_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<LotteriesNumbersBean> getLotteries_numbers() {
        return lotteries_numbers;
    }

    public void setLotteries_numbers(List<LotteriesNumbersBean> lotteries_numbers) {
        this.lotteries_numbers = lotteries_numbers;
    }

    public static class LotteriesNumbersBean {
        /**
         * id : 49
         * contract_id : 2
         * award_number : 040
         * open_time : 1529060598
         * height : 534776
         * category : 1
         */

        private int id;
        private int contract_id;
        private String award_number;
        private int open_time;
        private int height;
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

        public String getAward_number() {
            return award_number;
        }

        public void setAward_number(String award_number) {
            this.award_number = award_number;
        }

        public int getOpen_time() {
            return open_time;
        }

        public void setOpen_time(int open_time) {
            this.open_time = open_time;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }
}
