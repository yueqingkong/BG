package block.guess.login.bean;

import java.io.Serializable;

public class ServerBean<T> implements Serializable {

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public boolean success() {
        return code == 2000;
    }
}
