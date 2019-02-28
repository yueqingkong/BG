package block.guess.login.bean;

public class ResetForgetBean {
    private String email;
    private String token;
    private String new_password;

    public ResetForgetBean(String email, String token, String new_password) {
        this.email = email;
        this.token = token;
        this.new_password = new_password;
    }
}
