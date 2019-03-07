package block.guess.betting.bean;

import java.io.Serializable;
import java.util.List;

public class PayResultBean implements Serializable {

    /**
     * id : 1097
     * identifier : 6cf6c7c8b0afff2e915b05abff748ae20fc252f4
     * user_id : 1
     * contract_id : 53
     * times : 1
     * unit : 50000
     * total_amount : 50000
     * tx_hash : 817381f750d13baadbac256ce04ad5469e9fbde39b4b740ea1bbd96f34d210b6
     * status : 1
     * category : 1
     * created_at : 1551930223
     * award_numbers : ["081"]
     * period : 0
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
    private int period;
    private List<String> award_numbers;

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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public List<String> getAward_numbers() {
        return award_numbers;
    }

    public void setAward_numbers(List<String> award_numbers) {
        this.award_numbers = award_numbers;
    }
}
