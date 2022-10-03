package goldrush;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import goldrush.Charac.Charac;

public class TestPane extends JPanel {

    public TestPane(GameInfor create, Charac charac) {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < create.row; i++) {
            for (int j = 0; j < create.column; j++) {
                gbc.gridx = j;
                gbc.gridy = i;
                if ((charac.getPos1() + 1 == i || charac.getPos1() - 1 == i || charac.getPos1() == i) &&
                        (charac.getPos2() + 1 == j || charac.getPos2() - 1 == j || charac.getPos2() == j)) {
                    if (charac.getPos1() == i && charac.getPos2() == j) {
                        CellPane cellPane = new CellPane(charac.getName(),Integer.toString(charac.getHealth()), Integer.toString(charac.getGoldenBag()), Color.CYAN);
                        Border border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                        cellPane.setBorder(border);
                        add(cellPane, gbc);
                    } else if ((create.map[i][j] != null && create.map[i][j].getValue() == 0)
                            || create.map[i][j] == null) {
                        CellPane cellPane = new CellPane(null, null, null, Color.lightGray);
                        Border border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                        cellPane.setBorder(border);
                        add(cellPane, gbc);
                    } else {
                        if (create.map[i][j] != null) {
                            if (create.map[i][j].getValue() > 0) {
                                CellPane cellPane = new CellPane(create.map[i][j].getName(), null, null, Color.YELLOW);
                                Border border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                                cellPane.setBorder(border);
                                add(cellPane, gbc);
                            } else if (create.map[i][j].getValue() < 0) {
                                CellPane cellPane = new CellPane(create.map[i][j].getName(), null, null, Color.RED);
                                Border border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                                cellPane.setBorder(border);
                                add(cellPane, gbc);
                            }
                        }
                    }
                } else {

                    
                    //   String num = null;
                    //  if (create.map[i][j] != null) {
                    //   if (create.map[i][j].getValue() != 0) {
                    //  num = create.map[i][j].getName();
                    //  }
                    //    }
                    // CellPane cellPane = new CellPane(num,null,null, Color.lightGray);
                     
                    CellPane cellPane = new CellPane(null, null, null, Color.lightGray);
                    Border border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                }
            }
        }
    }

    public static class CellPane extends JPanel {

        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel("", JLabel.CENTER);
        JLabel jLabel2 = new JLabel("", JLabel.CENTER);
        JPanel jPanel2 = new JPanel();
        JLabel jLabel3 = new JLabel();


        public CellPane(String infor1,String infor2, String infor3, Color color) {
            jPanel1.setBackground(color);
            jPanel2.setBackground(color);
            jLabel1.setText(infor1);
            this.add(jPanel1);
            jPanel1.add(jLabel1);
            this.add(jPanel2);
            if(infor2 != null) {
                String a = "Health: ";
                a = a.concat(infor2);
                jLabel2.setText(a);
            } 
            jPanel2.add(jLabel2);
            if(infor3 != null) {
                String b = "Gold: ";
                b = b.concat(infor3);
                jLabel3.setText(b);
            }
            this.add(jLabel3);
            setBackground(color);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {                   
                }

                @Override
                public void mouseExited(MouseEvent e) {                  
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }
    }
}