package block.guess.login.bean;

public class ForgetBean {

    private String email;
    private String captcha_id;
    private String captcha;

    public ForgetBean(String email, String captcha_id, String captcha) {
        this.email = email;
        this.captcha_id = captcha_id;
        this.captcha = captcha;
    }
}
