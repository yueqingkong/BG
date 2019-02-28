package block.guess.login.bean;

public class RegisterBean {

    private String invite_by_code;
    private String username;
    private String email;
    private String password;
    private String token;

    public RegisterBean(String invite_by_code, String username, String email, String password, String token) {
        this.invite_by_code = invite_by_code;
        this.username = username;
        this.email = email;
        this.password = password;
        this.token = token;
    }
}
