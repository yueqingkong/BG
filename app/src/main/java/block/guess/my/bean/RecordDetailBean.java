package block.guess.my.bean;

import block.guess.login.bean.UserInfoBean;
import block.guess.utils.share.AppInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecordDetailBean implements Serializable {

    /**
     * id : 168
     * identifier : a98a6795c3236618f8003b35db0e1a491a4cb097
     * user_id : 2
     * contract_id : 663
     * times : 1
     * unit : 0
     * total_amount : 0
     * prize : 0
     * tx_hash : 6576546ab0aff7e8a90e59a07a0542a4e1b5efd09e59f2db0cd158c92245831f
     * status : 1
     * category : 4
     * created_at : 1536574127
     * send_to_friend : 0
     * send_to_friend_tx_hash :
     * send_to_friend_address :
     * contract : {"id":663,"period":8,"coin":2,"prev_period_coin":0,"unit":0,"status":3,"address":"1Hmqo32XuDUHN4PyzBPVkCXmG2o7barWu","tx_hash":"","create_tx_hash":"6c15aa3d00b7b4ad934d56509a905e5c8dab3144ea3d1096e49d1270c9a74923","to_server_tx_hash":"caa74d1110e854f61c1a6787340c01fb77db1d31882962e8f271404fd9a2d918","category":4,"total_amount":5,"total_users":5,"total_order":5,"result":"","start":1536509100,"end":1536581100,"height":547251,"award_number":"830","times":0,"remaining":0,"winners":null,"total_reward":0,"max_prize":0,"lottery":null,"free_shot":0,"free_shot_used":0,"free_shot_count":0,"free_shot_max":0,"is_win":false}
     * lottery : {"Id":658,"contract_id":663,"random_number":"583","random":"{\"method\":\"generateSignedIntegers\",\"hashedApiKey\":\"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==\",\"n\":3,\"min\":0,\"max\":9,\"replacement\":true,\"base\":10,\"data\":[5,8,3],\"completionTime\":\"2018-09-10 12:05:01Z\",\"serialNumber\":1770}","signature":"r7h3+bTFgPGv+kg3/5dwxpEP33vavsx4TD8I+cRYLWId64SDKIzCBuOxxxwPvUl/ZXb0+/XldB15VpfpIjyYsIN0uCUgEQpb7/Ub2Zv42bqrphtS6BPSCLAopxfLrcjZYVhmnJODPPgtsjLTwi+/GQCTe733UpKMe4zU0dEjiC5cna1HnRBgZ+Dl23J6Gw1e/m7ECnFGPweE5kKLvAY35Yg4qw6G3haJOp+1zHY5GKqyS357XFngLPo6Ifm1KqWSH7Ext27ULAbgTIBsmXkcjqzqJm0vs5yswd4Rvkg1AYB/ZCPKuAOGvW9Okj3RzptE27gZhqr3B0wTf8QR+BC2syw36Bhz5Nz8St8F35bRZWp/K3DrMpgIyh4SByI63B8W4D0DG/sLqui8R7yvBt55/aYXToXS9E4wLjL+W06rDrZnag1w643jt4SkgyUErf1bqiYrHGe1cGWUY7sg/ywMJR79aXUZIcVv9KaGe0JO6lenNySOLkeG2kHPiQRnSnIlp3N1HDvF95U2PlIpLC68IQe0IOn5UZyzWzSNSK22tdQmue2oNKZ+b67g4Nc8t3C9BVJNJEMlZt5/PsBHAarWfpz6PTyvhyOY47yB4hrN7V5kqtP+TSOnS7O66GOpkCGCmC8xNw/Twkt/HVg4HO07VwIU47uhW0B9foAK0NNwiqY=","open_time":1536581661,"height":547251,"block_hash":"","open_height":547252,"open_block_hash":"0000000000000000010f72e74681c1d221bf1cbe6e1d6b67ef0d1be60fb55e67","status":4,"lotteries_numbers":[{"Id":652,"contract_id":663,"award_number":"830","open_time":1536581661,"height":547252,"category":1}]}
     * award_numbers : null
     * red_numbers : null
     * blue_numbers : null
     * purchase_numbers : [{"Id":2133,"contract_id":663,"user_id":2,"purchase_identifier":"a98a6795c3236618f8003b35db0e1a491a4cb097","order_no":1,"award_number":"628","category":1}]
     * free_shot_numbers : null
     */

    private int id;
    private String identifier;
    private int user_id;
    private int contract_id;
    private int times;
    private int unit;
    private int total_amount;
    private int prize;
    private String tx_hash;
    private int status;
    private int category;
    private long created_at;
    private int send_to_friend;
    private String send_to_friend_tx_hash;
    private String send_to_friend_address;
    private ContractBean contract;
    private LotteryBean lottery;
    private Object award_numbers;
    private Object red_numbers;
    private Object blue_numbers;
    private Object free_shot_numbers;
    private ArrayList<PurchaseNumbersBean> purchase_numbers;

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
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

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
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

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public int getSend_to_friend() {
        return send_to_friend;
    }

    public void setSend_to_friend(int send_to_friend) {
        this.send_to_friend = send_to_friend;
    }

    public String getSend_to_friend_tx_hash() {
        return send_to_friend_tx_hash;
    }

    public void setSend_to_friend_tx_hash(String send_to_friend_tx_hash) {
        this.send_to_friend_tx_hash = send_to_friend_tx_hash;
    }

    public String getSend_to_friend_address() {
        return send_to_friend_address;
    }

    public void setSend_to_friend_address(String send_to_friend_address) {
        this.send_to_friend_address = send_to_friend_address;
    }

    public ContractBean getContract() {
        return contract;
    }

    public void setContract(ContractBean contract) {
        this.contract = contract;
    }

    public LotteryBean getLottery() {
        return lottery;
    }

    public void setLottery(LotteryBean lottery) {
        this.lottery = lottery;
    }

    public Object getAward_numbers() {
        return award_numbers;
    }

    public void setAward_numbers(Object award_numbers) {
        this.award_numbers = award_numbers;
    }

    public Object getRed_numbers() {
        return red_numbers;
    }

    public void setRed_numbers(Object red_numbers) {
        this.red_numbers = red_numbers;
    }

    public Object getBlue_numbers() {
        return blue_numbers;
    }

    public void setBlue_numbers(Object blue_numbers) {
        this.blue_numbers = blue_numbers;
    }

    public Object getFree_shot_numbers() {
        return free_shot_numbers;
    }

    public void setFree_shot_numbers(Object free_shot_numbers) {
        this.free_shot_numbers = free_shot_numbers;
    }

    public List<PurchaseNumbersBean> getPurchase_numbers() {
        return purchase_numbers;
    }

    public int ownPurchase() {
        int count = 0;
        UserInfoBean infoBean = AppInfo.getAppInfo().getInfoUser();
        if (infoBean != null && purchase_numbers != null) {
            for (PurchaseNumbersBean numbersBean : purchase_numbers) {
                if (numbersBean.user_id == infoBean.getId()) {
                    count++;
                }
            }
        }
        return count;
    }

    public void setPurchase_numbers(ArrayList<PurchaseNumbersBean> purchase_numbers) {
        this.purchase_numbers = purchase_numbers;
    }

    public static class ContractBean implements Serializable {
        /**
         * id : 663
         * period : 8
         * coin : 2
         * prev_period_coin : 0
         * unit : 0
         * status : 3
         * address : 1Hmqo32XuDUHN4PyzBPVkCXmG2o7barWu
         * tx_hash :
         * create_tx_hash : 6c15aa3d00b7b4ad934d56509a905e5c8dab3144ea3d1096e49d1270c9a74923
         * to_server_tx_hash : caa74d1110e854f61c1a6787340c01fb77db1d31882962e8f271404fd9a2d918
         * category : 4
         * total_amount : 5
         * total_users : 5
         * total_order : 5
         * result :
         * start : 1536509100
         * end : 1536581100
         * height : 547251
         * award_number : 830
         * times : 0
         * remaining : 0
         * winners : null
         * total_reward : 0
         * max_prize : 0
         * lottery : null
         * free_shot : 0
         * free_shot_used : 0
         * free_shot_count : 0
         * free_shot_max : 0
         * is_win : false
         */

        private int id;
        private int period;
        private int coin;
        private int prev_period_coin;
        private int unit;
        private int status;
        private String address;
        private String tx_hash;
        private String create_tx_hash;
        private String to_server_tx_hash;
        private int category;
        private int total_amount;
        private int total_users;
        private int total_order;
        private String result;
        private int start;
        private int end;
        private int height;
        private String award_number;
        private int times;
        private int remaining;
        private Object winners;
        private int total_reward;
        private int max_prize;
        private Object lottery;
        private int free_shot;
        private int free_shot_used;
        private int free_shot_count;
        private int free_shot_max;
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

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
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

        public int getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(int total_amount) {
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

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
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

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
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

        public int getFree_shot_max() {
            return free_shot_max;
        }

        public void setFree_shot_max(int free_shot_max) {
            this.free_shot_max = free_shot_max;
        }

        public boolean isIs_win() {
            return is_win;
        }

        public void setIs_win(boolean is_win) {
            this.is_win = is_win;
        }
    }

    public static class LotteryBean implements Serializable {
        /**
         * Id : 658
         * contract_id : 663
         * random_number : 583
         * random : {"method":"generateSignedIntegers","hashedApiKey":"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==","n":3,"min":0,"max":9,"replacement":true,"base":10,"data":[5,8,3],"completionTime":"2018-09-10 12:05:01Z","serialNumber":1770}
         * signature : r7h3+bTFgPGv+kg3/5dwxpEP33vavsx4TD8I+cRYLWId64SDKIzCBuOxxxwPvUl/ZXb0+/XldB15VpfpIjyYsIN0uCUgEQpb7/Ub2Zv42bqrphtS6BPSCLAopxfLrcjZYVhmnJODPPgtsjLTwi+/GQCTe733UpKMe4zU0dEjiC5cna1HnRBgZ+Dl23J6Gw1e/m7ECnFGPweE5kKLvAY35Yg4qw6G3haJOp+1zHY5GKqyS357XFngLPo6Ifm1KqWSH7Ext27ULAbgTIBsmXkcjqzqJm0vs5yswd4Rvkg1AYB/ZCPKuAOGvW9Okj3RzptE27gZhqr3B0wTf8QR+BC2syw36Bhz5Nz8St8F35bRZWp/K3DrMpgIyh4SByI63B8W4D0DG/sLqui8R7yvBt55/aYXToXS9E4wLjL+W06rDrZnag1w643jt4SkgyUErf1bqiYrHGe1cGWUY7sg/ywMJR79aXUZIcVv9KaGe0JO6lenNySOLkeG2kHPiQRnSnIlp3N1HDvF95U2PlIpLC68IQe0IOn5UZyzWzSNSK22tdQmue2oNKZ+b67g4Nc8t3C9BVJNJEMlZt5/PsBHAarWfpz6PTyvhyOY47yB4hrN7V5kqtP+TSOnS7O66GOpkCGCmC8xNw/Twkt/HVg4HO07VwIU47uhW0B9foAK0NNwiqY=
         * open_time : 1536581661
         * height : 547251
         * block_hash :
         * open_height : 547252
         * open_block_hash : 0000000000000000010f72e74681c1d221bf1cbe6e1d6b67ef0d1be60fb55e67
         * status : 4
         * lotteries_numbers : [{"Id":652,"contract_id":663,"award_number":"830","open_time":1536581661,"height":547252,"category":1}]
         */

        private int Id;
        private int contract_id;
        private String random_number;
        private String random;
        private String signature;
        private int open_time;
        private int height;
        private String block_hash;
        private int open_height;
        private String open_block_hash;
        private int status;
        private List<LotteriesNumbersBean> lotteries_numbers;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public int getContract_id() {
            return contract_id;
        }

        public void setContract_id(int contract_id) {
            this.contract_id = contract_id;
        }

        public String getRandom_number() {
            return random_number;
        }

        public void setRandom_number(String random_number) {
            this.random_number = random_number;
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

        public String getBlock_hash() {
            return block_hash;
        }

        public void setBlock_hash(String block_hash) {
            this.block_hash = block_hash;
        }

        public int getOpen_height() {
            return open_height;
        }

        public void setOpen_height(int open_height) {
            this.open_height = open_height;
        }

        public String getOpen_block_hash() {
            return open_block_hash;
        }

        public void setOpen_block_hash(String open_block_hash) {
            this.open_block_hash = open_block_hash;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<LotteriesNumbersBean> getLotteries_numbers() {
            return lotteries_numbers;
        }

        public void setLotteries_numbers(List<LotteriesNumbersBean> lotteries_numbers) {
            this.lotteries_numbers = lotteries_numbers;
        }

        public static class LotteriesNumbersBean implements Serializable {
            /**
             * Id : 652
             * contract_id : 663
             * award_number : 830
             * open_time : 1536581661
             * height : 547252
             * category : 1
             */

            private int Id;
            private int contract_id;
            private String award_number;
            private int open_time;
            private int height;
            private int category;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
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

    public static class PurchaseNumbersBean implements Serializable {
        /**
         * Id : 2133
         * contract_id : 663
         * user_id : 2
         * purchase_identifier : a98a6795c3236618f8003b35db0e1a491a4cb097
         * order_no : 1
         * award_number : 628
         * category : 1
         */

        private int Id;
        private int contract_id;
        private int user_id;
        private String purchase_identifier;
        private int order_no;
        private String award_number;
        private int category;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
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
