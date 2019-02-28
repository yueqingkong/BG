package block.guess.my.bean;

public class PartnerInviteeBean {

    /**
     * id : 8
     * username : notfound
     * avatar : https://www.gravatar.com/avatar/a143548142ce218b0f26279445ade3c5.jpg
     * PrivateKey :
     * default_pwd : 0
     * created_at : 1528947623
     * updated_at : 0
     * free_count : 0
     */

    private int id;
    private String username;
    private String avatar;
    private String PrivateKey;
    private int default_pwd;
    private long created_at;
    private long updated_at;
    private long free_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPrivateKey() {
        return PrivateKey;
    }

    public void setPrivateKey(String PrivateKey) {
        this.PrivateKey = PrivateKey;
    }

    public int getDefault_pwd() {
        return default_pwd;
    }

    public void setDefault_pwd(int default_pwd) {
        this.default_pwd = default_pwd;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public long getFree_count() {
        return free_count;
    }

    public void setFree_count(long free_count) {
        this.free_count = free_count;
    }
}
