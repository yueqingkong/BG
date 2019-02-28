package block.guess.main.bean;

import java.util.List;

public class LotteryPageBean {

    /**
     * id : 651
     * period : 643
     * coin : 2
     * prev_period_coin : 0
     * unit : 50000
     * status : 3
     * address : 19ph8L92Q1uUKUNExksgGYRXrGMaD1daXW
     * tx_hash :
     * create_tx_hash : f0fa4325c35f22c982a413ed9caca94ba31384aff84358e2b49303df8f7d6dde
     * to_server_tx_hash : d5400a3a38c3f69e627dd484188ae36d97b92d1cf37a5ec223b5147d5b71a988
     * category : 1
     * total_amount : 9
     * total_users : 1
     * total_order : 2
     * result :
     * start : 1535789299
     * end : 1535796499
     * height : 545955
     * award_number : 335
     * times : 200
     * remaining : 0
     * winners : []
     * total_reward : 0
     * max_prize : 0
     * lottery : {"Id":648,"contract_id":651,"random_number":"172","random":"{\"method\":\"generateSignedIntegers\",\"hashedApiKey\":\"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==\",\"n\":3,\"min\":0,\"max\":9,\"replacement\":true,\"base\":10,\"data\":[1,7,2],\"completionTime\":\"2018-09-01 10:08:21Z\",\"serialNumber\":1757}","signature":"W1DhHWLQ+SSJ0hVVnbLQXQEu+OpNldcTpxChrWxsUyFbOhJ5HLjobyVkUhdbnh2Z60iVu59ruRmqvpzsI5TqFUogh818so8ihvYEDFrg/qMyghd+ByNODgIGWKg/h8Sg1SLnXVabOb9tWYJuAYZzYxcSFiutbx3gH1gIkPEEX511UGJOtYEGyN1mjvswsXdUL/vSsHVkemrlV0J5QKKSE7wdW8akKO72aduWjn+JgArKtPF/f9yv3gI2JLw+sz7Ww3GMekHCpikftgGvcgCXS1CKKadNwmSJwv0g23EM6UKK0Rlwe8b4DmoBIlPKoHoV8oCkH6JLiyP5hwGlFX54qBhMiLqFacOfMVsHKdsetSgqFqebFW5Jdv2uyM325xdr2t+9EPqKppDa1YKGl1CdKaeyw9thLT9zoWUMVQ/qbZPdY07BbA0FwJ63nVnoY4J/jxEX2ZJIMdAqmGhurmPm0borOhzEHieXDXXf6i2OBIQ8gRyR7TxMiCXE/1fTgdp0dxWPS3/IS6gqAkKdyrcj8hURTQSN0+Babd6QytNuCzdcfIrMG725c6VZkWExCV3CTC2fZH+7fjRSG6N1jp/1jgEilw63Bbhx6qQnX49N+Z7m3IXnFP/dmqRYfQd1rJURYGhBMH9DG41u7om+Rfu2GePymaKgWbwXzhHXM+DT1Jk=","open_time":1535796891,"height":545955,"block_hash":"","open_height":545956,"open_block_hash":"000000000000000001e6a13e5d5588025c03606887ff2729e05d445023ac18cf","status":4,"lotteries_numbers":[{"Id":642,"contract_id":651,"award_number":"335","open_time":1535796891,"height":545956,"category":1}]}
     * free_shot : 0
     * free_shot_used : 0
     * free_shot_count : 0
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
    private long start;
    private long end;
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
    private boolean is_win;
    private List<?> winners;

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

    public boolean isIs_win() {
        return is_win;
    }

    public void setIs_win(boolean is_win) {
        this.is_win = is_win;
    }

    public List<?> getWinners() {
        return winners;
    }

    public void setWinners(List<?> winners) {
        this.winners = winners;
    }

    public static class LotteryBean {
        /**
         * Id : 648
         * contract_id : 651
         * random_number : 172
         * random : {"method":"generateSignedIntegers","hashedApiKey":"czDUUhbuh9nYxT0e0+svT7b2hBk+Dfh7Qjk+ps1OSqAQ/uFy5ljjJT+nWzozv4yHiStH2YaHRXmzMlPwAK2Fjw==","n":3,"min":0,"max":9,"replacement":true,"base":10,"data":[1,7,2],"completionTime":"2018-09-01 10:08:21Z","serialNumber":1757}
         * signature : W1DhHWLQ+SSJ0hVVnbLQXQEu+OpNldcTpxChrWxsUyFbOhJ5HLjobyVkUhdbnh2Z60iVu59ruRmqvpzsI5TqFUogh818so8ihvYEDFrg/qMyghd+ByNODgIGWKg/h8Sg1SLnXVabOb9tWYJuAYZzYxcSFiutbx3gH1gIkPEEX511UGJOtYEGyN1mjvswsXdUL/vSsHVkemrlV0J5QKKSE7wdW8akKO72aduWjn+JgArKtPF/f9yv3gI2JLw+sz7Ww3GMekHCpikftgGvcgCXS1CKKadNwmSJwv0g23EM6UKK0Rlwe8b4DmoBIlPKoHoV8oCkH6JLiyP5hwGlFX54qBhMiLqFacOfMVsHKdsetSgqFqebFW5Jdv2uyM325xdr2t+9EPqKppDa1YKGl1CdKaeyw9thLT9zoWUMVQ/qbZPdY07BbA0FwJ63nVnoY4J/jxEX2ZJIMdAqmGhurmPm0borOhzEHieXDXXf6i2OBIQ8gRyR7TxMiCXE/1fTgdp0dxWPS3/IS6gqAkKdyrcj8hURTQSN0+Babd6QytNuCzdcfIrMG725c6VZkWExCV3CTC2fZH+7fjRSG6N1jp/1jgEilw63Bbhx6qQnX49N+Z7m3IXnFP/dmqRYfQd1rJURYGhBMH9DG41u7om+Rfu2GePymaKgWbwXzhHXM+DT1Jk=
         * open_time : 1535796891
         * height : 545955
         * block_hash :
         * open_height : 545956
         * open_block_hash : 000000000000000001e6a13e5d5588025c03606887ff2729e05d445023ac18cf
         * status : 4
         * lotteries_numbers : [{"Id":642,"contract_id":651,"award_number":"335","open_time":1535796891,"height":545956,"category":1}]
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
             * Id : 642
             * contract_id : 651
             * award_number : 335
             * open_time : 1535796891
             * height : 545956
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
}
