package goldrush;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GameJFrame extends JFrame {

    GameSetUp setUp = new GameSetUp();

    public GameJFrame() {
        setUp.setUpGame();

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException ex) {
            }

            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.add(new TestPane(setUp.create, setUp.charac));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.addKeyListener(new GameControl(setUp.charac, setUp.create, frame));
        });

    }
}
