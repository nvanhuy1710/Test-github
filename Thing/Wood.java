package goldrush.Thing;

public class Wood extends Thing {
    @Override
    public int getValue() {
        if (get == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String getName() {
        return "Wood";
    }
}
