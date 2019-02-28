package block.guess.main.bean;

import java.io.Serializable;
import java.util.List;

public class HomeBean implements Serializable {

    /**
     * contract : {"id":652,"period":644,"coin":2,"prev_period_coin":0,"unit":50000,"status":1,"address":"19CEjtZJ3J2nSUucxhFF9HbWae1QwUZdec","tx_hash":"","create_tx_hash":"73b68c5c759a0f299179f40432f4532741f3dea2a3a21508c0fd1bcde6924b3e","to_server_tx_hash":"","category":1,"total_amount":0,"total_users":0,"total_order":0,"result":"","start":1535796501,"end":1535803701,"height":0,"award_number":"","times":200,"remaining":0,"winners":null,"total_reward":0,"max_prize":0,"lottery":null,"free_shot":0,"free_shot_used":0,"free_shot_count":0,"is_win":false}
     * purchase_history : []
     * winner_list : null
     * lottery : null
     */

    private ContractBean contract;
    private Object winner_list;
    private Object lottery;
    private List<?> purchase_history;

    public ContractBean getContract() {
        return contract;
    }

    public void setContract(ContractBean contract) {
        this.contract = contract;
    }

    public Object getWinner_list() {
        return winner_list;
    }

    public void setWinner_list(Object winner_list) {
        this.winner_list = winner_list;
    }

    public Object getLottery() {
        return lottery;
    }

    public void setLottery(Object lottery) {
        this.lottery = lottery;
    }

    public List<?> getPurchase_history() {
        return purchase_history;
    }

    public void setPurchase_history(List<?> purchase_history) {
        this.purchase_history = purchase_history;
    }

    public class ContractBean implements Serializable, Cloneable {
        /**
         * id : 652
         * period : 644
         * coin : 2
         * prev_period_coin : 0
         * unit : 50000
         * status : 1
         * address : 19CEjtZJ3J2nSUucxhFF9HbWae1QwUZdec
         * tx_hash :
         * create_tx_hash : 73b68c5c759a0f299179f40432f4532741f3dea2a3a21508c0fd1bcde6924b3e
         * to_server_tx_hash :
         * category : 1
         * total_amount : 0
         * total_users : 0
         * total_order : 0
         * result :
         * start : 1535796501
         * end : 1535803701
         * height : 0
         * award_number :
         * times : 200
         * remaining : 0
         * winners : null
         * total_reward : 0
         * max_prize : 0
         * lottery : null
         * free_shot : 0
         * free_shot_used : 0
         * free_shot_count : 0
         * is_win : false
         */

        private int id;
        private int period;
        private int coin;
        private int prev_period_coin;
        private long unit;
        private int status;
        private String address;
        private String tx_hash;
        private String create_tx_hash;
        private String to_server_tx_hash;
        private int category;
        private double total_amount;
        private int total_users;
        private int total_order;
        private String result;
        private long start;
        private long end;
        private int height;
        private String award_number;
        private long times;
        private int remaining;
        private Object winners;
        private int total_reward;
        private int max_prize;
        private Object lottery;
        private int free_shot;
        private int free_shot_used;
        private int free_shot_count;
        private boolean is_win;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getPrev_period_coin() {
            return prev_period_coin;
        }

        public void setPrev_period_coin(int prev_period_coin) {
            this.prev_period_coin = prev_period_coin;
        }

        public long getUnit() {
            return unit;
        }

        public void setUnit(long unit) {
            this.unit = unit;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTx_hash() {
            return tx_hash;
        }

        public void setTx_hash(String tx_hash) {
            this.tx_hash = tx_hash;
        }

        public String getCreate_tx_hash() {
            return create_tx_hash;
        }

        public void setCreate_tx_hash(String create_tx_hash) {
            this.create_tx_hash = create_tx_hash;
        }

        public String getTo_server_tx_hash() {
            return to_server_tx_hash;
        }

        public void setTo_server_tx_hash(String to_server_tx_hash) {
            this.to_server_tx_hash = to_server_tx_hash;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }

        public double getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(double total_amount) {
            this.total_amount = total_amount;
        }

        public int getTotal_users() {
            return total_users;
        }

        public void setTotal_users(int total_users) {
            this.total_users = total_users;
        }

        public int getTotal_order() {
            return total_order;
        }

        public void setTotal_order(int total_order) {
            this.total_order = total_order;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public long getStart() {
            return start;
        }

        public void setStart(long start) {
            this.start = start;
        }

        public long getEnd() {
            return end;
        }

        public void setEnd(long end) {
            this.end = end;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getAward_number() {
            return award_number;
        }

        public void setAward_number(String award_number) {
            this.award_number = award_number;
        }

        public long getTimes() {
            return times;
        }

        public void setTimes(long times) {
            this.times = times;
        }

        public int getRemaining() {
            return remaining;
        }

        public void setRemaining(int remaining) {
            this.remaining = remaining;
        }

        public Object getWinners() {
            return winners;
        }

        public void setWinners(Object winners) {
            this.winners = winners;
        }

        public int getTotal_reward() {
            return total_reward;
        }

        public void setTotal_reward(int total_reward) {
            this.total_reward = total_reward;
        }

        public int getMax_prize() {
            return max_prize;
        }

        public void setMax_prize(int max_prize) {
            this.max_prize = max_prize;
        }

        public Object getLottery() {
            return lottery;
        }

        public void setLottery(Object lottery) {
            this.lottery = lottery;
        }

        public int getFree_shot() {
            return free_shot;
        }

        public void setFree_shot(int free_shot) {
            this.free_shot = free_shot;
        }

        public int getFree_shot_used() {
            return free_shot_used;
        }

        public void setFree_shot_used(int free_shot_used) {
            this.free_shot_used = free_shot_used;
        }

        public int getFree_shot_count() {
            return free_shot_count;
        }

        public void setFree_shot_count(int free_shot_count) {
            this.free_shot_count = free_shot_count;
        }

        public boolean isIs_win() {
            return is_win;
        }

        public void setIs_win(boolean is_win) {
            this.is_win = is_win;
        }

        @Override
        public ContractBean clone() {
            ContractBean contractBean = null;
            try {
                contractBean = (ContractBean) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return contractBean;
        }
    }
}
