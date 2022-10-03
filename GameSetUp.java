package goldrush;

import goldrush.Charac.Charac;

public class GameSetUp {
    GameInfor create = new GameInfor();
    Charac charac;

    public void setUpGame() {
        create.createInfor();
        this.charac = create.charac;
        GameSetting.randomMap(create.map, create);
    }
}
