package goldrush.Charac;

public abstract class Charac {
    int goldenBag = 0;
    int health = 5;
    int pos1, pos2;
    int shield = 1;

    public abstract boolean alive();

    public abstract String getName();

    public abstract int getShield();

    public abstract void lostHealth(int trap);

    public abstract void takeGold(int gold);

    public abstract void movex(int x, int maxx);

    public abstract void movey(int y, int maxy);

    public void lostShield() {
        shield--;
    }

    public int getHealth() {
        return health;
    }

    public int getGoldenBag() {
        return goldenBag;
    }

    public int getPos1() {
        return pos1;
    }

    public int getPos2() {
        return pos2;
    }
}
