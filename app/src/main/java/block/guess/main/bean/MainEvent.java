package block.guess.main.bean;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;

public class MainEvent {

    private HomeType homeType;
    private Serializable[] serializables;

    public enum HomeType {
        LOGIN_SUCCESS,
        BALANCE,
    }

    public static void send(HomeType event, Serializable... array) {
        MainEvent serviceEvent = new MainEvent(event, array);
        EventBus.getDefault().post(serviceEvent);
    }

    public MainEvent(HomeType event, Serializable... array) {
        this.homeType = event;
        serializables = array;
    }

    public HomeType event() {
        return homeType;
    }

    public Serializable[] serializables() {
        return serializables;
    }
}
