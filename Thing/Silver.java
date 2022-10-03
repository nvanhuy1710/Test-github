package goldrush.Thing;

public class Silver extends Thing {
    @Override
    public int getValue() {
        if (get == 1) {
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public String getName() {
        return "Silver";
    }
}
