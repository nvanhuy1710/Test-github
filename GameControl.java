package goldrush;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

import goldrush.Charac.Charac;

import java.awt.BorderLayout;

public class GameControl implements KeyListener {

    Charac charac;
    GameInfor create;
    JFrame frame;

    public GameControl(Charac charac, GameInfor create, JFrame frame) {
        this.charac = charac;
        this.create = create;
        this.frame = frame;
    }

    public void checkGame() {
        if (!charac.alive()) {
            System.exit(1);
        } else if (charac.getGoldenBag() >= create.goldToWin) {
            System.exit(0);
        }
        System.out.println("health: " + charac.getHealth());
        System.out.println("Gold: " + charac.getGoldenBag());
        System.out.println();
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new TestPane(this.create, this.charac));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void checkPlayer() {
        if (create.map[charac.getPos1()][charac.getPos2()] != null) {
            if (create.map[charac.getPos1()][charac.getPos2()].getValue() < 0) {
                charac.lostHealth(create.map[charac.getPos1()][charac.getPos2()].getValue());
                ;
            } else if (create.map[charac.getPos1()][charac.getPos2()].getValue() > 0) {
                charac.takeGold(create.map[charac.getPos1()][charac.getPos2()].getValue());
            }
            create.map[charac.getPos1()][charac.getPos2()].got();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 38) {
            // up arrow
            charac.movey(-1, create.row);
            checkPlayer();
            checkGame();
        } else if (e.getKeyCode() == 40) {
            // down arrow
            charac.movey(1, create.row);
            checkPlayer();
            checkGame();
        } else if (e.getKeyCode() == 37) {
            // left arrow
            charac.movex(-1, create.column);
            checkPlayer();
            checkGame();
        } else if (e.getKeyCode() == 39) {
            // right arrow
            charac.movex(1, create.column);
            checkPlayer();
            checkGame();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
