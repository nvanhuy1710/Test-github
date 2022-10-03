package goldrush;

import java.util.Random;

import goldrush.Thing.ClampTrap;
import goldrush.Thing.Gold;
import goldrush.Thing.Silver;
import goldrush.Thing.StoneTrap;
import goldrush.Thing.Thing;
import goldrush.Thing.ThornTrap;
import goldrush.Thing.Wood;

public class GameSetting {

    static Random rand = new Random();

    public static void randomMap(Thing[][] map, GameInfor create) {
        int count = 0;
        while (count < create.numberOfGold) {
            int pos1 = rand.nextInt(create.row);
            int pos2 = rand.nextInt(create.column);
            if (create.map[pos1][pos2] == null && (pos1 != 0 || pos2 != 0)) {
                int num = rand.nextInt(3) + 1;
                create.map[pos1][pos2] = put(num);
                count++;
            }
        }
        count = 0;
        while (count < create.numberOfTrap) {
            int pos1 = rand.nextInt(create.row);
            int pos2 = rand.nextInt(create.column);
            if (create.map[pos1][pos2] == null && (pos1 != 0 || pos2 != 0)) {
                int num = -(rand.nextInt(3) + 1);
                create.map[pos1][pos2] = put(num);
                count++;
            }
        }
    }

    public static int randomPos(int number) {
        Random rand = new Random();
        int pos = rand.nextInt(number);
        return pos;
    }

    public static Thing put(int num) {
        if (num == 1) {
            return new Wood();
        } else if (num == 2) {
            return new Silver();
        } else if (num == 3) {
            return new Gold();
        } else if (num == -1) {
            return new ThornTrap();
        } else if (num == -2) {
            return new StoneTrap();
        } else if (num == -3) {
            return new ClampTrap();
        } else {
            return null;
        }
    }
}
