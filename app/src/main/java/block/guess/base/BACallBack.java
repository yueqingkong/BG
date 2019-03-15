package block.guess.base;

public abstract class BACallBack<T> {

    public abstract void success(T t);

    public abstract void error(int code, String err);

    public abstract void error();
}
