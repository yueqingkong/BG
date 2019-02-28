package block.guess.betting.bean;

public class GiftSendBean {

    private String identifier;
    private String send_to_friend_address;
    private String email;

    public GiftSendBean(String identifier, String send_to_friend_address, String email) {
        this.identifier = identifier;
        this.send_to_friend_address = send_to_friend_address;
        this.email = email;
    }
}
