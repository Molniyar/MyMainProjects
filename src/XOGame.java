import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class XOGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,800);

        int[][] field = new int[3][3];
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field.length; j++){
                field[i][j] = 0;
            }
        }

        final int[] blue = {0};
        final int[] red = {0};

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < field.length; i++) {
                    for (int j = 0; j < field.length; j++) {
                        int num = Math.min(getWidth(), getHeight());
                        int coordX = num / field.length * i;
                        int coordY = num / field.length * j;

                        int l = num / field.length;

                        switch (field[j][i]){
                            case 0 -> {
                                g.setColor(new Color(255,255,255));
                                g.fillRect(coordX,coordY,l,l);
                            }
                            case 1 -> {
                                g.setColor(new Color(255,255,255));
                                g.fillRect(coordX,coordY,l,l);

                                g.setColor(new Color(0,0,255));
                                g.fillOval(coordX+l/8,coordY+l/8,l-l/4,l-l/4);

                                g.setColor(new Color(255,255,255));
                                g.fillOval(coordX+l/4,coordY+l/4,l-l/2,l-l/2);
                            }
                            case 2 -> {
                                g.setColor(new Color(255,255,255));
                                g.fillRect(coordX,coordY,l,l);

                                g.setColor(new Color(255,0,0));

                                int[] xPoints = {coordX+l/8*1, coordX+l/8*2, coordX+l/8*4, coordX+l/8*6, coordX+l/8*7, coordX+l/8*5, coordX+l/8*7, coordX+l/8*6, coordX+l/8*4, coordX+l/8*2, coordX+l/8*1, coordX+l/8*3};
                                int[] yPoints = {coordY+l/8*2, coordY+l/8*1, coordY+l/8*3, coordY+l/8*1, coordY+l/8*2, coordY+l/8*4, coordY+l/8*6, coordY+l/8*7, coordY+l/8*5, coordY+l/8*7, coordY+l/8*6, coordY+l/8*4};
                                g.fillPolygon(xPoints,yPoints,12);
                            }
                            case 3 -> {
                                g.setColor(new Color(123,123,255));
                                g.fillRect(coordX,coordY,l,l);

                                g.setColor(new Color(0,0,255));
                                g.fillOval(coordX+l/8,coordY+l/8,l-l/4,l-l/4);

                                g.setColor(new Color(123,123,255));
                                g.fillOval(coordX+l/4,coordY+l/4,l-l/2,l-l/2);
                            }
                            case 4 -> {
                                g.setColor(new Color(255,123,123));
                                g.fillRect(coordX,coordY,l,l);

                                g.setColor(new Color(255,0,0));

                                int[] xPoints = {coordX+l/8*1, coordX+l/8*2, coordX+l/8*4, coordX+l/8*6, coordX+l/8*7, coordX+l/8*5, coordX+l/8*7, coordX+l/8*6, coordX+l/8*4, coordX+l/8*2, coordX+l/8*1, coordX+l/8*3};
                                int[] yPoints = {coordY+l/8*2, coordY+l/8*1, coordY+l/8*3, coordY+l/8*1, coordY+l/8*2, coordY+l/8*4, coordY+l/8*6, coordY+l/8*7, coordY+l/8*5, coordY+l/8*7, coordY+l/8*6, coordY+l/8*4};
                                g.fillPolygon(xPoints,yPoints,12);
                            }
                            default -> JOptionPane.showMessageDialog(frame, "обнаружено число больше 4 (field[" +j+ "]["+i+"])", "Test", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                }

            }
        };
        frame.add(panel);
        panel.setVisible(true);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        AtomicBoolean canAttack = new AtomicBoolean(true);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (field[y / (Math.min(panel.getWidth(),panel.getHeight()) / field.length)][x / (Math.min(panel.getWidth(),panel.getHeight()) / field.length)] == 0){
                    if (canAttack.get()){
                        field[y / (Math.min(panel.getWidth(),panel.getHeight()) / field.length)][x / (Math.min(panel.getWidth(),panel.getHeight()) / field.length)] = 1;
                        canAttack.set(false);
                    }
                    else {
                        field[y / (Math.min(panel.getWidth(),panel.getHeight()) / field.length)][x / (Math.min(panel.getWidth(),panel.getHeight()) / field.length)] = 2;
                        canAttack.set(true);
                    }
                }

                boolean restartBlue = false;
                boolean restartRed = false;

                if (ArrayChange.numbersAreEquals(field[0], 2)){field[0][0] += 2;field[0][1] += 2;field[0][2] += 2;restartRed=true;}
                if (ArrayChange.numbersAreEquals(field[1], 2)){field[1][0] += 2;field[1][1] += 2;field[1][2] += 2;restartRed=true;}
                if (ArrayChange.numbersAreEquals(field[2], 2)){field[2][0] += 2;field[2][1] += 2;field[2][2] += 2;restartRed=true;}

                if ((field[0][0] == 2 && field[1][0] == 2 && field[2][0] == 2)){field[0][0] += 2;field[1][0] += 2;field[2][0] += 2;restartRed=true;}
                if ((field[0][1] == 2 && field[1][1] == 2 && field[2][1] == 2)){field[0][1] += 2;field[1][1] += 2;field[2][1] += 2;restartRed=true;}
                if ((field[0][2] == 2 && field[1][2] == 2 && field[2][2] == 2)){field[0][2] += 2;field[1][2] += 2;field[2][2] += 2;restartRed=true;}

                if ((field[0][0] == 2 && field[1][1] == 2 && field[2][2] == 2)){field[0][0] += 2;field[1][1] += 2;field[2][2] += 2;restartRed=true;}
                if ((field[0][2] == 2 && field[1][1] == 2 && field[2][0] == 2)){field[0][2] += 2;field[1][1] += 2;field[2][0] += 2;restartRed=true;}


                if (ArrayChange.numbersAreEquals(field[0], 1)){field[0][0] += 2;field[0][1] += 2;field[0][2] += 2;restartBlue=true;}
                if (ArrayChange.numbersAreEquals(field[1], 1)){field[1][0] += 2;field[1][1] += 2;field[1][2] += 2;restartBlue=true;}
                if (ArrayChange.numbersAreEquals(field[2], 1)){field[2][0] += 2;field[2][1] += 2;field[2][2] += 2;restartBlue=true;}

                if ((field[0][0] == 1 && field[1][0] == 1 && field[2][0] == 1)){field[0][0] += 2;field[1][0] += 2;field[2][0] += 2;restartBlue=true;}
                if ((field[0][1] == 1 && field[1][1] == 1 && field[2][1] == 1)){field[0][1] += 2;field[1][1] += 2;field[2][1] += 2;restartBlue=true;}
                if ((field[0][2] == 1 && field[1][2] == 1 && field[2][2] == 1)){field[0][2] += 2;field[1][2] += 2;field[2][2] += 2;restartBlue=true;}

                if ((field[0][0] == 1 && field[1][1] == 1 && field[2][2] == 1)){field[0][0] += 2;field[1][1] += 2;field[2][2] += 2;restartBlue=true;}
                if ((field[0][2] == 1 && field[1][1] == 1 && field[2][0] == 1)){field[0][2] += 2;field[1][1] += 2;field[2][0] += 2;restartBlue=true;}

                panel.updateUI();
                if (restartBlue){
                    JOptionPane.showMessageDialog(frame, "Нолики победили");
                    blue[0]++;

                    for (int i = 0; i < 3; i++){
                        for (int j = 0; j < 3; j++){
                            field[i][j] = 0;
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "O - " + blue[0] + ": X - " + red[0]);

                    if (canAttack.get()){
                        JOptionPane.showMessageDialog(frame, "Ходят нолики");
                    }
                    else JOptionPane.showMessageDialog(frame, "Ходят крестики");
                }
                if (restartRed){
                    JOptionPane.showMessageDialog(frame, "Крестики победили");
                    red[0]++;

                    for (int i = 0; i < 3; i++){
                        for (int j = 0; j < 3; j++){
                            field[i][j] = 0;
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "O - " + blue[0] + ": X - " + red[0]);

                    if (canAttack.get()){
                        JOptionPane.showMessageDialog(frame, "Ходят нолики");
                    }
                    else JOptionPane.showMessageDialog(frame, "Ходят крестики");
                }
                if (blue[0] == 10){
                    JOptionPane.showMessageDialog(frame, "Нолики окончательно победили");
                    return;
                }
                if (red[0] == 10){
                    JOptionPane.showMessageDialog(frame, "Крестики окончательно победили");
                    return;
                }
                panel.updateUI();
                if (!restartBlue && !restartRed){
                    boolean nothing = true;
                    for (int i = 0; i < 3; i++){
                        for (int j = 0; j < 3; j++){
                            if (field[i][j] == 0){
                                nothing = false;
                            }
                        }
                    }
                    if (nothing){
                        JOptionPane.showMessageDialog(frame, "Ничья");
                        for (int i = 0; i < 3; i++){
                            for (int j = 0; j < 3; j++){
                                field[i][j] = 0;
                            }
                        }

                        if (canAttack.get()){
                            JOptionPane.showMessageDialog(frame, "Ходят нолики");
                        }
                        else JOptionPane.showMessageDialog(frame, "Ходят крестики");
                    }
                }
                panel.updateUI();
            }
        });
    }
}
