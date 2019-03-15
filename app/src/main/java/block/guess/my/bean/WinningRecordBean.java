package block.guess.my.bean;

public class WinningRecordBean {


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
    private long created_at;

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

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }
}
