package block.guess.betting.bean;

import java.util.List;

public class ContractDetailBean {

    /**
     * contract : {"id":51,"period":2,"coin":2,"prev_period_coin":0,"unit":100000,"status":3,"address":"1Ec8MQkWakX9HRdcMzgMXSHVXvPrh9vV3p","tx_hash":"c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9","create_tx_hash":"c7f3bcf4b7d26039c34e2bec2764efc0149e52e666e7f1b1d2b80906baf84b14","to_server_tx_hash":"","category":2,"total_amount":28272,"total_users":1,"total_order":46,"result":"","start":1529059483,"end":1529063083,"height":535359,"award_number":"193","times":1000,"remaining":0,"winners":[{"Id":1,"user_id":2,"contract_id":51,"reward":90000000,"status":2,"address":"1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h","send_to_friend":1,"send_to_friend_address":"","purchase_id":0,"buy_tx_hash":"73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082","amount":0,"tx_hash":"c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9","username":"","avatar":"","contract":null,"purchase_numbers":[{"Id":1,"contract_id":1,"user_id":2,"purchase_identifier":"35f9c6564074e39b4ed89d13447b8e4e63373743","order_no":1,"award_number":"508","category":1}],"purchase_history":null}],"total_reward":90000000,"max_prize":0,"lottery":{"Id":83,"contract_id":51,"random_number":"058","random":"{\"method\":\"generateSignedIntegers\",\"hashedApiKey\":\"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==\",\"n\":3,\"min\":0,\"max\":9,\"replacement\":true,\"base\":10,\"data\":[0,5,8],\"completionTime\":\"2018-06-19 12:16:25Z\",\"serialNumber\":1190}","signature":"ne/pR3K67bOpcgEbQQaQvsvvD+uEAjPnfkG4Kum1+7m0EQkrGX41yh/qyqOU1sARVAy8F69zLMgJZjWtQ3278B0Rii7r3tbsoUDDpGk8a2q6q3KagZCUgQHnUP2B8+LVAzfyntTZI18FhSxKWYLh4LTMDX9jSI8ai6OUVZ9reBw2Izgq5+UnxC28rQexfurqLf8fBA/WFJwaiesIS3TtvcogbyQ0gnkzHEwYpAyzvIdgVqV4nInvrl69DQaeaWXvC/iOh16gcJu+3Vl4zaq2N06a76YO6XF50ncETsb8+uMERaMNNsKdSJ6zOR+/2yiOgS+o9VnLjJvyOh9x0Q21h/evLNM/UxuA0detQhT6EcBAZOwW0ZQgUtKqalhVC05hsIQgSvWAhUvFgG9yQ64hglDf8gK0+ojM/ric23RRCuEIc2gLXI5s6VqRH68D/H61jn3UMfjaAYhn3SgdaN3730WjUYZAs6/jk3uOLtX/J+2hzSdPgxyI2JfpSZpE9gG/j29Ph1D7VqjvS4KZeP0PlDw4xeCyBYpJ7tHHGq8fhPBGlFcSttDSfKHYCvtXhI8jR6WvCpXsxPoEKipu7OXcNqAm44djh0+v66eNbOdb5Y5qdyNI6l3G4MhFINH2UpMbxOg1lDXGQ4KgWMBlk7ClOvhsr2VXrCMbk9TkUUj7cLs=","open_time":1529411027,"height":535359,"block_hash":"","open_height":535360,"open_block_hash":"0000000000000000003960d62d74370d692995ea7351d0364db9e2abd06a0ffa","status":4,"lotteries_numbers":[{"Id":77,"contract_id":51,"award_number":"193","open_time":1529411027,"height":535360,"category":1}]},"free_shot":0,"free_shot_used":0,"free_shot_count":0,"free_shot_max":0,"is_win":false}
     * purchase_history : []
     * winner_list : [{"Id":1,"user_id":2,"contract_id":51,"reward":90000000,"status":2,"address":"1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h","send_to_friend":1,"send_to_friend_address":"","purchase_id":0,"buy_tx_hash":"73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082","amount":0,"tx_hash":"c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9","username":"bl***ss","avatar":"","contract":{"id":51,"period":2,"coin":2,"prev_period_coin":0,"unit":100000,"status":3,"address":"1Ec8MQkWakX9HRdcMzgMXSHVXvPrh9vV3p","tx_hash":"c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9","create_tx_hash":"c7f3bcf4b7d26039c34e2bec2764efc0149e52e666e7f1b1d2b80906baf84b14","to_server_tx_hash":"","category":2,"total_amount":28272,"total_users":1,"total_order":46,"result":"","start":1529059483,"end":1529063083,"height":535359,"award_number":"193","times":1000,"remaining":0,"winners":null,"total_reward":0,"max_prize":0,"lottery":null,"free_shot":0,"free_shot_used":0,"free_shot_count":0,"free_shot_max":0,"is_win":false},"purchase_numbers":[{"Id":1,"contract_id":1,"user_id":2,"purchase_identifier":"35f9c6564074e39b4ed89d13447b8e4e63373743","order_no":1,"award_number":"508","category":1}],"purchase_history":{"Id":1,"identifier":"35f9c6564074e39b4ed89d13447b8e4e63373743","user_id":2,"contract_id":1,"times":1,"unit":50000,"total_amount":50000,"prize":0,"tx_hash":"dabb33b9c7c3bd7d824613a66725842752da5a0ad0279efad7f4905cb7f3ddf0","status":3,"category":1,"created_at":1528873707,"send_to_friend":1,"send_to_friend_tx_hash":"","send_to_friend_address":"","contract":null,"lottery":null,"award_numbers":null,"red_numbers":null,"blue_numbers":null,"purchase_numbers":null,"free_shot_numbers":null}}]
     * lottery : {"Id":83,"contract_id":51,"random_number":"058","random":"{\"method\":\"generateSignedIntegers\",\"hashedApiKey\":\"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==\",\"n\":3,\"min\":0,\"max\":9,\"replacement\":true,\"base\":10,\"data\":[0,5,8],\"completionTime\":\"2018-06-19 12:16:25Z\",\"serialNumber\":1190}","signature":"ne/pR3K67bOpcgEbQQaQvsvvD+uEAjPnfkG4Kum1+7m0EQkrGX41yh/qyqOU1sARVAy8F69zLMgJZjWtQ3278B0Rii7r3tbsoUDDpGk8a2q6q3KagZCUgQHnUP2B8+LVAzfyntTZI18FhSxKWYLh4LTMDX9jSI8ai6OUVZ9reBw2Izgq5+UnxC28rQexfurqLf8fBA/WFJwaiesIS3TtvcogbyQ0gnkzHEwYpAyzvIdgVqV4nInvrl69DQaeaWXvC/iOh16gcJu+3Vl4zaq2N06a76YO6XF50ncETsb8+uMERaMNNsKdSJ6zOR+/2yiOgS+o9VnLjJvyOh9x0Q21h/evLNM/UxuA0detQhT6EcBAZOwW0ZQgUtKqalhVC05hsIQgSvWAhUvFgG9yQ64hglDf8gK0+ojM/ric23RRCuEIc2gLXI5s6VqRH68D/H61jn3UMfjaAYhn3SgdaN3730WjUYZAs6/jk3uOLtX/J+2hzSdPgxyI2JfpSZpE9gG/j29Ph1D7VqjvS4KZeP0PlDw4xeCyBYpJ7tHHGq8fhPBGlFcSttDSfKHYCvtXhI8jR6WvCpXsxPoEKipu7OXcNqAm44djh0+v66eNbOdb5Y5qdyNI6l3G4MhFINH2UpMbxOg1lDXGQ4KgWMBlk7ClOvhsr2VXrCMbk9TkUUj7cLs=","open_time":1529411027,"height":535359,"block_hash":"","open_height":535360,"open_block_hash":"0000000000000000003960d62d74370d692995ea7351d0364db9e2abd06a0ffa","status":4,"lotteries_numbers":[{"Id":77,"contract_id":51,"award_number":"193","open_time":1529411027,"height":535360,"category":1}]}
     */

    private ContractBean contract;
    private LotteryBeanX lottery;
    private List<PurchaseHistoryBean> purchase_history;
    private List<WinnerListBean> winner_list;

    public ContractBean getContract() {
        return contract;
    }

    public void setContract(ContractBean contract) {
        this.contract = contract;
    }

    public LotteryBeanX getLottery() {
        return lottery;
    }

    public void setLottery(LotteryBeanX lottery) {
        this.lottery = lottery;
    }

    public List<PurchaseHistoryBean> getPurchase_history() {
        return purchase_history;
    }

    public void setPurchase_history(List<PurchaseHistoryBean> purchase_history) {
        this.purchase_history = purchase_history;
    }

    public List<WinnerListBean> getWinner_list() {
        return winner_list;
    }

    public void setWinner_list(List<WinnerListBean> winner_list) {
        this.winner_list = winner_list;
    }

    public static class ContractBean {
        /**
         * id : 51
         * period : 2
         * coin : 2
         * prev_period_coin : 0
         * unit : 100000
         * status : 3
         * address : 1Ec8MQkWakX9HRdcMzgMXSHVXvPrh9vV3p
         * tx_hash : c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9
         * create_tx_hash : c7f3bcf4b7d26039c34e2bec2764efc0149e52e666e7f1b1d2b80906baf84b14
         * to_server_tx_hash :
         * category : 2
         * total_amount : 28272
         * total_users : 1
         * total_order : 46
         * result :
         * start : 1529059483
         * end : 1529063083
         * height : 535359
         * award_number : 193
         * times : 1000
         * remaining : 0
         * winners : [{"Id":1,"user_id":2,"contract_id":51,"reward":90000000,"status":2,"address":"1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h","send_to_friend":1,"send_to_friend_address":"","purchase_id":0,"buy_tx_hash":"73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082","amount":0,"tx_hash":"c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9","username":"","avatar":"","contract":null,"purchase_numbers":[{"Id":1,"contract_id":1,"user_id":2,"purchase_identifier":"35f9c6564074e39b4ed89d13447b8e4e63373743","order_no":1,"award_number":"508","category":1}],"purchase_history":null}]
         * total_reward : 90000000
         * max_prize : 0
         * lottery : {"Id":83,"contract_id":51,"random_number":"058","random":"{\"method\":\"generateSignedIntegers\",\"hashedApiKey\":\"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==\",\"n\":3,\"min\":0,\"max\":9,\"replacement\":true,\"base\":10,\"data\":[0,5,8],\"completionTime\":\"2018-06-19 12:16:25Z\",\"serialNumber\":1190}","signature":"ne/pR3K67bOpcgEbQQaQvsvvD+uEAjPnfkG4Kum1+7m0EQkrGX41yh/qyqOU1sARVAy8F69zLMgJZjWtQ3278B0Rii7r3tbsoUDDpGk8a2q6q3KagZCUgQHnUP2B8+LVAzfyntTZI18FhSxKWYLh4LTMDX9jSI8ai6OUVZ9reBw2Izgq5+UnxC28rQexfurqLf8fBA/WFJwaiesIS3TtvcogbyQ0gnkzHEwYpAyzvIdgVqV4nInvrl69DQaeaWXvC/iOh16gcJu+3Vl4zaq2N06a76YO6XF50ncETsb8+uMERaMNNsKdSJ6zOR+/2yiOgS+o9VnLjJvyOh9x0Q21h/evLNM/UxuA0detQhT6EcBAZOwW0ZQgUtKqalhVC05hsIQgSvWAhUvFgG9yQ64hglDf8gK0+ojM/ric23RRCuEIc2gLXI5s6VqRH68D/H61jn3UMfjaAYhn3SgdaN3730WjUYZAs6/jk3uOLtX/J+2hzSdPgxyI2JfpSZpE9gG/j29Ph1D7VqjvS4KZeP0PlDw4xeCyBYpJ7tHHGq8fhPBGlFcSttDSfKHYCvtXhI8jR6WvCpXsxPoEKipu7OXcNqAm44djh0+v66eNbOdb5Y5qdyNI6l3G4MhFINH2UpMbxOg1lDXGQ4KgWMBlk7ClOvhsr2VXrCMbk9TkUUj7cLs=","open_time":1529411027,"height":535359,"block_hash":"","open_height":535360,"open_block_hash":"0000000000000000003960d62d74370d692995ea7351d0364db9e2abd06a0ffa","status":4,"lotteries_numbers":[{"Id":77,"contract_id":51,"award_number":"193","open_time":1529411027,"height":535360,"category":1}]}
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
        private int total_reward;
        private int max_prize;
        private LotteryBean lottery;
        private int free_shot;
        private int free_shot_used;
        private int free_shot_count;
        private int free_shot_max;
        private boolean is_win;
        private List<WinnersBean> winners;

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

        public LotteryBean getLottery() {
            return lottery;
        }

        public void setLottery(LotteryBean lottery) {
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

        public List<WinnersBean> getWinners() {
            return winners;
        }

        public void setWinners(List<WinnersBean> winners) {
            this.winners = winners;
        }

        public static class LotteryBean {
            /**
             * Id : 83
             * contract_id : 51
             * random_number : 058
             * random : {"method":"generateSignedIntegers","hashedApiKey":"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==","n":3,"min":0,"max":9,"replacement":true,"base":10,"data":[0,5,8],"completionTime":"2018-06-19 12:16:25Z","serialNumber":1190}
             * signature : ne/pR3K67bOpcgEbQQaQvsvvD+uEAjPnfkG4Kum1+7m0EQkrGX41yh/qyqOU1sARVAy8F69zLMgJZjWtQ3278B0Rii7r3tbsoUDDpGk8a2q6q3KagZCUgQHnUP2B8+LVAzfyntTZI18FhSxKWYLh4LTMDX9jSI8ai6OUVZ9reBw2Izgq5+UnxC28rQexfurqLf8fBA/WFJwaiesIS3TtvcogbyQ0gnkzHEwYpAyzvIdgVqV4nInvrl69DQaeaWXvC/iOh16gcJu+3Vl4zaq2N06a76YO6XF50ncETsb8+uMERaMNNsKdSJ6zOR+/2yiOgS+o9VnLjJvyOh9x0Q21h/evLNM/UxuA0detQhT6EcBAZOwW0ZQgUtKqalhVC05hsIQgSvWAhUvFgG9yQ64hglDf8gK0+ojM/ric23RRCuEIc2gLXI5s6VqRH68D/H61jn3UMfjaAYhn3SgdaN3730WjUYZAs6/jk3uOLtX/J+2hzSdPgxyI2JfpSZpE9gG/j29Ph1D7VqjvS4KZeP0PlDw4xeCyBYpJ7tHHGq8fhPBGlFcSttDSfKHYCvtXhI8jR6WvCpXsxPoEKipu7OXcNqAm44djh0+v66eNbOdb5Y5qdyNI6l3G4MhFINH2UpMbxOg1lDXGQ4KgWMBlk7ClOvhsr2VXrCMbk9TkUUj7cLs=
             * open_time : 1529411027
             * height : 535359
             * block_hash :
             * open_height : 535360
             * open_block_hash : 0000000000000000003960d62d74370d692995ea7351d0364db9e2abd06a0ffa
             * status : 4
             * lotteries_numbers : [{"Id":77,"contract_id":51,"award_number":"193","open_time":1529411027,"height":535360,"category":1}]
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

            public static class LotteriesNumbersBean {
                /**
                 * Id : 77
                 * contract_id : 51
                 * award_number : 193
                 * open_time : 1529411027
                 * height : 535360
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

        public static class WinnersBean {
            /**
             * Id : 1
             * user_id : 2
             * contract_id : 51
             * reward : 90000000
             * status : 2
             * address : 1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h
             * send_to_friend : 1
             * send_to_friend_address :
             * purchase_id : 0
             * buy_tx_hash : 73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082
             * amount : 0
             * tx_hash : c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9
             * username :
             * avatar :
             * contract : null
             * purchase_numbers : [{"Id":1,"contract_id":1,"user_id":2,"purchase_identifier":"35f9c6564074e39b4ed89d13447b8e4e63373743","order_no":1,"award_number":"508","category":1}]
             * purchase_history : null
             */

            private int Id;
            private int user_id;
            private int contract_id;
            private int reward;
            private int status;
            private String address;
            private int send_to_friend;
            private String send_to_friend_address;
            private int purchase_id;
            private String buy_tx_hash;
            private int amount;
            private String tx_hash;
            private String username;
            private String avatar;
            private Object contract;
            private Object purchase_history;
            private List<PurchaseNumbersBean> purchase_numbers;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
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

            public String getSend_to_friend_address() {
                return send_to_friend_address;
            }

            public void setSend_to_friend_address(String send_to_friend_address) {
                this.send_to_friend_address = send_to_friend_address;
            }

            public int getPurchase_id() {
                return purchase_id;
            }

            public void setPurchase_id(int purchase_id) {
                this.purchase_id = purchase_id;
            }

            public String getBuy_tx_hash() {
                return buy_tx_hash;
            }

            public void setBuy_tx_hash(String buy_tx_hash) {
                this.buy_tx_hash = buy_tx_hash;
            }

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
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

            public Object getContract() {
                return contract;
            }

            public void setContract(Object contract) {
                this.contract = contract;
            }

            public Object getPurchase_history() {
                return purchase_history;
            }

            public void setPurchase_history(Object purchase_history) {
                this.purchase_history = purchase_history;
            }

            public List<PurchaseNumbersBean> getPurchase_numbers() {
                return purchase_numbers;
            }

            public void setPurchase_numbers(List<PurchaseNumbersBean> purchase_numbers) {
                this.purchase_numbers = purchase_numbers;
            }

            public static class PurchaseNumbersBean {
                /**
                 * Id : 1
                 * contract_id : 1
                 * user_id : 2
                 * purchase_identifier : 35f9c6564074e39b4ed89d13447b8e4e63373743
                 * order_no : 1
                 * award_number : 508
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
    }

    public static class LotteryBeanX {
        /**
         * Id : 83
         * contract_id : 51
         * random_number : 058
         * random : {"method":"generateSignedIntegers","hashedApiKey":"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==","n":3,"min":0,"max":9,"replacement":true,"base":10,"data":[0,5,8],"completionTime":"2018-06-19 12:16:25Z","serialNumber":1190}
         * signature : ne/pR3K67bOpcgEbQQaQvsvvD+uEAjPnfkG4Kum1+7m0EQkrGX41yh/qyqOU1sARVAy8F69zLMgJZjWtQ3278B0Rii7r3tbsoUDDpGk8a2q6q3KagZCUgQHnUP2B8+LVAzfyntTZI18FhSxKWYLh4LTMDX9jSI8ai6OUVZ9reBw2Izgq5+UnxC28rQexfurqLf8fBA/WFJwaiesIS3TtvcogbyQ0gnkzHEwYpAyzvIdgVqV4nInvrl69DQaeaWXvC/iOh16gcJu+3Vl4zaq2N06a76YO6XF50ncETsb8+uMERaMNNsKdSJ6zOR+/2yiOgS+o9VnLjJvyOh9x0Q21h/evLNM/UxuA0detQhT6EcBAZOwW0ZQgUtKqalhVC05hsIQgSvWAhUvFgG9yQ64hglDf8gK0+ojM/ric23RRCuEIc2gLXI5s6VqRH68D/H61jn3UMfjaAYhn3SgdaN3730WjUYZAs6/jk3uOLtX/J+2hzSdPgxyI2JfpSZpE9gG/j29Ph1D7VqjvS4KZeP0PlDw4xeCyBYpJ7tHHGq8fhPBGlFcSttDSfKHYCvtXhI8jR6WvCpXsxPoEKipu7OXcNqAm44djh0+v66eNbOdb5Y5qdyNI6l3G4MhFINH2UpMbxOg1lDXGQ4KgWMBlk7ClOvhsr2VXrCMbk9TkUUj7cLs=
         * open_time : 1529411027
         * height : 535359
         * block_hash :
         * open_height : 535360
         * open_block_hash : 0000000000000000003960d62d74370d692995ea7351d0364db9e2abd06a0ffa
         * status : 4
         * lotteries_numbers : [{"Id":77,"contract_id":51,"award_number":"193","open_time":1529411027,"height":535360,"category":1}]
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
        private List<LotteriesNumbersBeanX> lotteries_numbers;

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

        public List<LotteriesNumbersBeanX> getLotteries_numbers() {
            return lotteries_numbers;
        }

        public void setLotteries_numbers(List<LotteriesNumbersBeanX> lotteries_numbers) {
            this.lotteries_numbers = lotteries_numbers;
        }

        public static class LotteriesNumbersBeanX {
            /**
             * Id : 77
             * contract_id : 51
             * award_number : 193
             * open_time : 1529411027
             * height : 535360
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

    public static class WinnerListBean {
        /**
         * Id : 1
         * user_id : 2
         * contract_id : 51
         * reward : 90000000
         * status : 2
         * address : 1EdhBic1pCNsCYk97BA8B9sE1zn7Qscu9h
         * send_to_friend : 1
         * send_to_friend_address :
         * purchase_id : 0
         * buy_tx_hash : 73a7ea4bb4aa7eb10e857d52526fa80f4c017170aa4e5d87cb491c842a8f9082
         * amount : 0
         * tx_hash : c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9
         * username : bl***ss
         * avatar :
         * contract : {"id":51,"period":2,"coin":2,"prev_period_coin":0,"unit":100000,"status":3,"address":"1Ec8MQkWakX9HRdcMzgMXSHVXvPrh9vV3p","tx_hash":"c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9","create_tx_hash":"c7f3bcf4b7d26039c34e2bec2764efc0149e52e666e7f1b1d2b80906baf84b14","to_server_tx_hash":"","category":2,"total_amount":28272,"total_users":1,"total_order":46,"result":"","start":1529059483,"end":1529063083,"height":535359,"award_number":"193","times":1000,"remaining":0,"winners":null,"total_reward":0,"max_prize":0,"lottery":null,"free_shot":0,"free_shot_used":0,"free_shot_count":0,"free_shot_max":0,"is_win":false}
         * purchase_numbers : [{"Id":1,"contract_id":1,"user_id":2,"purchase_identifier":"35f9c6564074e39b4ed89d13447b8e4e63373743","order_no":1,"award_number":"508","category":1}]
         * purchase_history : {"Id":1,"identifier":"35f9c6564074e39b4ed89d13447b8e4e63373743","user_id":2,"contract_id":1,"times":1,"unit":50000,"total_amount":50000,"prize":0,"tx_hash":"dabb33b9c7c3bd7d824613a66725842752da5a0ad0279efad7f4905cb7f3ddf0","status":3,"category":1,"created_at":1528873707,"send_to_friend":1,"send_to_friend_tx_hash":"","send_to_friend_address":"","contract":null,"lottery":null,"award_numbers":null,"red_numbers":null,"blue_numbers":null,"purchase_numbers":null,"free_shot_numbers":null}
         */

        private int Id;
        private int user_id;
        private int contract_id;
        private int reward;
        private int status;
        private String address;
        private int send_to_friend;
        private String send_to_friend_address;
        private int purchase_id;
        private String buy_tx_hash;
        private int amount;
        private String tx_hash;
        private String username;
        private String avatar;
        private ContractBeanX contract;
        private PurchaseHistoryBean purchase_history;
        private List<PurchaseNumbersBeanX> purchase_numbers;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
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

        public String getSend_to_friend_address() {
            return send_to_friend_address;
        }

        public void setSend_to_friend_address(String send_to_friend_address) {
            this.send_to_friend_address = send_to_friend_address;
        }

        public int getPurchase_id() {
            return purchase_id;
        }

        public void setPurchase_id(int purchase_id) {
            this.purchase_id = purchase_id;
        }

        public String getBuy_tx_hash() {
            return buy_tx_hash;
        }

        public void setBuy_tx_hash(String buy_tx_hash) {
            this.buy_tx_hash = buy_tx_hash;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
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

        public ContractBeanX getContract() {
            return contract;
        }

        public void setContract(ContractBeanX contract) {
            this.contract = contract;
        }

        public PurchaseHistoryBean getPurchase_history() {
            return purchase_history;
        }

        public void setPurchase_history(PurchaseHistoryBean purchase_history) {
            this.purchase_history = purchase_history;
        }

        public List<PurchaseNumbersBeanX> getPurchase_numbers() {
            return purchase_numbers;
        }

        public void setPurchase_numbers(List<PurchaseNumbersBeanX> purchase_numbers) {
            this.purchase_numbers = purchase_numbers;
        }

        public static class ContractBeanX {
            /**
             * id : 51
             * period : 2
             * coin : 2
             * prev_period_coin : 0
             * unit : 100000
             * status : 3
             * address : 1Ec8MQkWakX9HRdcMzgMXSHVXvPrh9vV3p
             * tx_hash : c589ebc033377ed12f73c50c177aa4a643e6e717ffd7ddf661239dd7760d7ea9
             * create_tx_hash : c7f3bcf4b7d26039c34e2bec2764efc0149e52e666e7f1b1d2b80906baf84b14
             * to_server_tx_hash :
             * category : 2
             * total_amount : 28272
             * total_users : 1
             * total_order : 46
             * result :
             * start : 1529059483
             * end : 1529063083
             * height : 535359
             * award_number : 193
             * times : 1000
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

        public static class PurchaseHistoryBean {
            /**
             * Id : 1
             * identifier : 35f9c6564074e39b4ed89d13447b8e4e63373743
             * user_id : 2
             * contract_id : 1
             * times : 1
             * unit : 50000
             * total_amount : 50000
             * prize : 0
             * tx_hash : dabb33b9c7c3bd7d824613a66725842752da5a0ad0279efad7f4905cb7f3ddf0
             * status : 3
             * category : 1
             * created_at : 1528873707
             * send_to_friend : 1
             * send_to_friend_tx_hash :
             * send_to_friend_address :
             * contract : null
             * lottery : null
             * award_numbers : null
             * red_numbers : null
             * blue_numbers : null
             * purchase_numbers : null
             * free_shot_numbers : null
             */

            private int Id;
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
            private int created_at;
            private int send_to_friend;
            private String send_to_friend_tx_hash;
            private String send_to_friend_address;
            private Object contract;
            private Object lottery;
            private Object award_numbers;
            private Object red_numbers;
            private Object blue_numbers;
            private Object purchase_numbers;
            private Object free_shot_numbers;

            public int getId() {
                return Id;
            }

            public void setId(int Id) {
                this.Id = Id;
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

            public Object getContract() {
                return contract;
            }

            public void setContract(Object contract) {
                this.contract = contract;
            }

            public Object getLottery() {
                return lottery;
            }

            public void setLottery(Object lottery) {
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

            public Object getPurchase_numbers() {
                return purchase_numbers;
            }

            public void setPurchase_numbers(Object purchase_numbers) {
                this.purchase_numbers = purchase_numbers;
            }

            public Object getFree_shot_numbers() {
                return free_shot_numbers;
            }

            public void setFree_shot_numbers(Object free_shot_numbers) {
                this.free_shot_numbers = free_shot_numbers;
            }
        }

        public static class PurchaseNumbersBeanX {
            /**
             * Id : 1
             * contract_id : 1
             * user_id : 2
             * purchase_identifier : 35f9c6564074e39b4ed89d13447b8e4e63373743
             * order_no : 1
             * award_number : 508
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

    public static class PurchaseHistoryBean {
        /**
         * Id : 181
         * identifier : c4abe601c268896104faf1eca2ce96c0a53bbaab
         * user_id : 2
         * contract_id : 678
         * times : 1
         * unit : 50000
         * total_amount : 50000
         * prize : 0
         * tx_hash : 233532a7e825b2acea69fd91d9dd90d7c04c10ff852be7fe59226a2643a0c7b8
         * status : 1
         * category : 1
         * created_at : 1536737946
         * send_to_friend : 0
         * send_to_friend_tx_hash :
         * send_to_friend_address :
         * contract : {"id":678,"period":666,"coin":2,"prev_period_coin":0,"unit":50000,"status":1,"address":"12orsAk6XjKXPBpDxhKLjYRFfWNvTQ1LBM","tx_hash":"","create_tx_hash":"d9ec7eeebc54200c16cf18474eb62cb120a215077897455ed7dae1745361b6d5","to_server_tx_hash":"","category":1,"total_amount":0,"total_users":0,"total_order":0,"result":"","start":1536734467,"end":1536741667,"height":0,"award_number":"","times":200,"remaining":0,"winners":null,"total_reward":0,"max_prize":0,"lottery":null,"free_shot":0,"free_shot_used":0,"free_shot_count":0,"free_shot_max":0,"is_win":false}
         * lottery : {"Id":0,"contract_id":678,"random_number":"","random":"","signature":"","open_time":0,"height":0,"block_hash":"","open_height":0,"open_block_hash":"","status":0,"lotteries_numbers":[]}
         * award_numbers : null
         * red_numbers : null
         * blue_numbers : null
         * purchase_numbers : [{"Id":2156,"contract_id":678,"user_id":2,"purchase_identifier":"c4abe601c268896104faf1eca2ce96c0a53bbaab","order_no":1,"award_number":"966","category":1}]
         * free_shot_numbers : null
         */

        private int Id;
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
        private int created_at;
        private int send_to_friend;
        private String send_to_friend_tx_hash;
        private String send_to_friend_address;
        private ContractBeanX contract;
        private LotteryBean lottery;
        private Object award_numbers;
        private Object red_numbers;
        private Object blue_numbers;
        private Object free_shot_numbers;
        private List<PurchaseNumbersBean> purchase_numbers;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
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

        public ContractBeanX getContract() {
            return contract;
        }

        public void setContract(ContractBeanX contract) {
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

        public void setPurchase_numbers(List<PurchaseNumbersBean> purchase_numbers) {
            this.purchase_numbers = purchase_numbers;
        }

        public static class ContractBeanX {
            /**
             * id : 678
             * period : 666
             * coin : 2
             * prev_period_coin : 0
             * unit : 50000
             * status : 1
             * address : 12orsAk6XjKXPBpDxhKLjYRFfWNvTQ1LBM
             * tx_hash :
             * create_tx_hash : d9ec7eeebc54200c16cf18474eb62cb120a215077897455ed7dae1745361b6d5
             * to_server_tx_hash :
             * category : 1
             * total_amount : 0
             * total_users : 0
             * total_order : 0
             * result :
             * start : 1536734467
             * end : 1536741667
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

        public static class LotteryBean {
            /**
             * Id : 0
             * contract_id : 678
             * random_number :
             * random :
             * signature :
             * open_time : 0
             * height : 0
             * block_hash :
             * open_height : 0
             * open_block_hash :
             * status : 0
             * lotteries_numbers : []
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
            private List<?> lotteries_numbers;

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

            public List<?> getLotteries_numbers() {
                return lotteries_numbers;
            }

            public void setLotteries_numbers(List<?> lotteries_numbers) {
                this.lotteries_numbers = lotteries_numbers;
            }
        }

        public static class PurchaseNumbersBean {
            /**
             * Id : 2156
             * contract_id : 678
             * user_id : 2
             * purchase_identifier : c4abe601c268896104faf1eca2ce96c0a53bbaab
             * order_no : 1
             * award_number : 966
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
}
