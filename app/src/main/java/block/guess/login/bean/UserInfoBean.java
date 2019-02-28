package block.guess.login.bean;

public class UserInfoBean {

    /**
     * id : 17
     * username : pujin
     * email : pujin@protonmail.com
     * identifier : d093a181b66087d2fb461307dce4c06cf3bc465a
     * avatar : https://www.gravatar.com/avatar/7e183a38ea3cc4bc4455b65ae40b33d8.jpg
     * invite_code : rYXM
     * invite_by_code : wxsg
     * status : 3
     * PrivateKey :
     * address : 17BCRiVBMB2VhWiBjky54Z3Qvx4ZuQAm1G
     * created_at : 1535896647
     * token : 47a2108742744b2bf312e64fd0514ffbdce9b9a0ded0ab81755982428001f36f
     */

    private int id;
    private String username;
    private String email;
    private String identifier;
    private String avatar;
    private String invite_code;
    private String invite_by_code;
    private int status;
    private String PrivateKey;
    private String address;
    private int created_at;
    private String token;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getInvite_code() {
        return invite_code;
    }

    public void setInvite_code(String invite_code) {
        this.invite_code = invite_code;
    }

    public String getInvite_by_code() {
        return invite_by_code;
    }

    public void setInvite_by_code(String invite_by_code) {
        this.invite_by_code = invite_by_code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPrivateKey() {
        return PrivateKey;
    }

    public void setPrivateKey(String PrivateKey) {
        this.PrivateKey = PrivateKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
