package block.guess.betting.bean;

import java.util.List;

public class BCH3dBuyBean {

    private long contract_id;
    private int times;
    private List<String> award_numbers;
    private List<RandomItem> free_shot_numbers;
    private int category;//1:bch3d 2:WINTREASURE 3:LOTTO 4:BCH3DFREE
    private String[][] red_numbers;
    private String[][] blue_numbers;

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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String[][] getRed_numbers() {
        return red_numbers;
    }

    public void setRed_numbers(String[][] red_numbers) {
        this.red_numbers = red_numbers;
    }

    public String[][] getBlue_numbers() {
        return blue_numbers;
    }

    public void setBlue_numbers(String[][] blue_numbers) {
        this.blue_numbers = blue_numbers;
    }
}
