package goldrush.Charac;

public class SuperCharac extends Charac {

    @Override
    public boolean alive() {
        if (health <= 0)
            return false;
        else
            return true;
    }

    @Override
    public String getName() {
        return "Superthief";
    }

    @Override
    public void lostHealth(int trap) {
        if (shield == 0) {
            health += trap;
        } else {
            lostShield();
        }
    }

    @Override
    public void takeGold(int gold) {
        goldenBag += gold;
    }

    @Override
    public void movex(int x, int maxx) {
        if (x < 0) {
            if (pos2 > 0) {
                pos2 += x;
            }
        } else {
            if (pos2 < maxx - 1) {
                pos2 += x;
            }
        }
    }

    @Override
    public void movey(int y, int maxy) {
        if (y < 0) {
            if (pos1 > 0) {
                pos1 += y;
            }
        } else {
            if (pos1 < maxy - 1) {
                pos1 += y;
            }
        }
    }

    @Override
    public int getShield() {
        return shield;
    }
}
