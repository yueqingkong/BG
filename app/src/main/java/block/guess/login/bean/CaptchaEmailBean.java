package block.guess.login.bean;

public class CaptchaEmailBean {

    private String captchaId;
    private String captcha;
    private String email;

    public CaptchaEmailBean(String captchaId, String captcha, String email) {
        this.captchaId = captchaId;
        this.captcha = captcha;
        this.email = email;
    }
}
