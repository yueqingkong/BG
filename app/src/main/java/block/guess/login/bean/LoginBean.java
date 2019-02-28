package block.guess.login.bean;

public class LoginBean {

    private String email;
    private String password;
    private String captcha_id;
    private String captcha;

    public LoginBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LoginBean(String email, String password, String captcha_id, String captcha) {
        this.email = email;
        this.password = password;
        this.captcha_id = captcha_id;
        this.captcha = captcha;
    }
}
