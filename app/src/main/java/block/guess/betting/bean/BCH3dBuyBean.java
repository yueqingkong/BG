package block.guess.betting.bean;

import java.util.List;

public class BCH3dBuyBean {

    private long contract_id;
    private int times;
    private List<String> award_numbers;
    private List<RandomItem> free_shot_numbers;

    public class RandomItem {
        private String number;
        private String identifier;
    }

    public BCH3dBuyBean() {
    }

    public BCH3dBuyBean(long contract_id, int times, List<String> award_numbers) {
        this.contract_id = contract_id;
        this.times = times;
        this.award_numbers = award_numbers;
    }

    public long getContract_id() {
        return contract_id;
    }

    public void setContract_id(long contract_id) {
        this.contract_id = contract_id;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public List<String> getAward_numbers() {
        return award_numbers;
    }

    public void setAward_numbers(List<String> award_numbers) {
        this.award_numbers = award_numbers;
    }

    public List<RandomItem> getFree_shot_numbers() {
        return free_shot_numbers;
    }

    public void setFree_shot_numbers(List<RandomItem> free_shot_numbers) {
        this.free_shot_numbers = free_shot_numbers;
    }
}
