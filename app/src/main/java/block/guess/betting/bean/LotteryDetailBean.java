package block.guess.betting.bean;

import java.io.Serializable;
import java.util.List;

public class LotteryDetailBean implements Serializable {


    /**
     * id : 83
     * contract_id : 51
     * category : 2
     * period : 2
     * random_number : 058
     * random : {"method":"generateSignedIntegers","hashedApiKey":"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==","n":3,"min":0,"max":9,"replacement":true,"base":10,"data":[0,5,8],"completionTime":"2018-06-19 12:16:25Z","serialNumber":1190}
     * signature : ne/pR3K67bOpcgEbQQaQvsvvD+uEAjPnfkG4Kum1+7m0EQkrGX41yh/qyqOU1sARVAy8F69zLMgJZjWtQ3278B0Rii7r3tbsoUDDpGk8a2q6q3KagZCUgQHnUP2B8+LVAzfyntTZI18FhSxKWYLh4LTMDX9jSI8ai6OUVZ9reBw2Izgq5+UnxC28rQexfurqLf8fBA/WFJwaiesIS3TtvcogbyQ0gnkzHEwYpAyzvIdgVqV4nInvrl69DQaeaWXvC/iOh16gcJu+3Vl4zaq2N06a76YO6XF50ncETsb8+uMERaMNNsKdSJ6zOR+/2yiOgS+o9VnLjJvyOh9x0Q21h/evLNM/UxuA0detQhT6EcBAZOwW0ZQgUtKqalhVC05hsIQgSvWAhUvFgG9yQ64hglDf8gK0+ojM/ric23RRCuEIc2gLXI5s6VqRH68D/H61jn3UMfjaAYhn3SgdaN3730WjUYZAs6/jk3uOLtX/J+2hzSdPgxyI2JfpSZpE9gG/j29Ph1D7VqjvS4KZeP0PlDw4xeCyBYpJ7tHHGq8fhPBGlFcSttDSfKHYCvtXhI8jR6WvCpXsxPoEKipu7OXcNqAm44djh0+v66eNbOdb5Y5qdyNI6l3G4MhFINH2UpMbxOg1lDXGQ4KgWMBlk7ClOvhsr2VXrCMbk9TkUUj7cLs=
     * open_time : 1529411027
     * height : 535359
     * open_height : 535360
     * open_block_hash : 0000000000000000003960d62d74370d692995ea7351d0364db9e2abd06a0ffa
     * status : 4
     * address : 1Ec8MQkWakX9HRdcMzgMXSHVXvPrh9vV3p
     * winner_list : [{"id":1,"user_id":2,"contract_id":51,"reward":90000000,"status":2,"address":"1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h","send_to_friend":1,"buy_tx_hash":"73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082","tx_hash":"c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9","username":"hhhhg","avatar":"","times":0,"period":2,"category":2}]
     * lotteries_numbers : [{"id":77,"contract_id":51,"award_number":"193","open_time":1529411027,"height":535360,"category":1}]
     * end : 1529063083
     */

    private int id;
    private int contract_id;
    private int category;
    private int period;
    private String random_number;
    private String random;
    private String signature;
    private int open_time;
    private int height;
    private int open_height;
    private String open_block_hash;
    private int status;
    private String address;
    private int end;
    private List<WinnerListBean> winner_list;
    private List<LotteriesNumbersBean> lotteries_numbers;
    private List<PurchaseHistoryBean> purchase_history;

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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<WinnerListBean> getWinner_list() {
        return winner_list;
    }

    public void setWinner_list(List<WinnerListBean> winner_list) {
        this.winner_list = winner_list;
    }

    public List<LotteriesNumbersBean> getLotteries_numbers() {
        return lotteries_numbers;
    }

    public void setLotteries_numbers(List<LotteriesNumbersBean> lotteries_numbers) {
        this.lotteries_numbers = lotteries_numbers;
    }

    public List<PurchaseHistoryBean> getPurchase_history() {
        return purchase_history;
    }

    public void setPurchase_history(List<PurchaseHistoryBean> purchase_history) {
        this.purchase_history = purchase_history;
    }



    public static class WinnerListBean {
        /**
         * id : 1
         * user_id : 2
         * contract_id : 51
         * reward : 90000000
         * status : 2
         * address : 1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h
         * send_to_friend : 1
         * buy_tx_hash : 73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082
         * tx_hash : c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9
         * username : hhhhg
         * avatar :
         * times : 0
         * period : 2
         * category : 2
         */

        private int id;
        private int user_id;
        private int contract_id;
        private int reward;
        private int status;
        private String address;
        private int send_to_friend;
        private String buy_tx_hash;
        private String tx_hash;
        private String username;
        private String avatar;
        private int times;
        private int period;
        private int category;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public int getReward() {
            return reward;
        }

        public void setReward(int reward) {
            this.reward = reward;
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

        public int getSend_to_friend() {
            return send_to_friend;
        }

        public void setSend_to_friend(int send_to_friend) {
            this.send_to_friend = send_to_friend;
        }

        public String getBuy_tx_hash() {
            return buy_tx_hash;
        }

        public void setBuy_tx_hash(String buy_tx_hash) {
            this.buy_tx_hash = buy_tx_hash;
        }

        public String getTx_hash() {
            return tx_hash;
        }

        public void setTx_hash(String tx_hash) {
            this.tx_hash = tx_hash;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public int getCategory() {
            return category;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }

    public static class LotteriesNumbersBean {
        /**
         * id : 77
         * contract_id : 51
         * award_number : 193
         * open_time : 1529411027
         * height : 535360
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

    public static class PurchaseHistoryBean {
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
         * period : 0
         * prize : 90000000
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
        private int prize;

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

        public int getPrize() {
            return prize;
        }

        public void setPrize(int prize) {
            this.prize = prize;
        }
    }
}
