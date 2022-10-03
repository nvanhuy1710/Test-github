package goldrush.Thing;

public abstract class Thing {
    int get = 1;

    public abstract int getValue();

    public abstract String getName();

    public void got() {
        get--;
    }
}
