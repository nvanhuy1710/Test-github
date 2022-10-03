package goldrush.Thing;

public class Gold extends Thing {
    @Override
    public int getValue() {
        if (get == 1) {
            return 3;
        } else {
            return 0;
        }
    }

    @Override
    public String getName() {
        return "Gold";
    }

}
