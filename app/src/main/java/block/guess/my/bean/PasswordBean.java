package block.guess.my.bean;

public class PasswordBean {

    private String old_password;
    private String new_password;

    public PasswordBean(String old_password, String new_password) {
        this.old_password = old_password;
        this.new_password = new_password;
    }
}
