import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuildGame {
    public static void main(String[] args) {

        int l = 8;
        if (args.length > 0){
            l = Integer.parseInt(args[0]);
        }
        int[][] blocks = new int[l][l];

        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j < blocks.length; j++){
                blocks[i][j] = 0;
            }
        }


        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,800);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < blocks.length; i++){
                    for (int j = 0; j < blocks.length; j++){
                        int coordX = getWidth()  / blocks.length * i;
                        int coordY = getHeight() / blocks.length * j;

                        int x = getWidth() / blocks.length;
                        int y = getHeight() / blocks.length;

                        switch (blocks[i][j]) {
                            case 1 -> {
                                g.setColor(new Color(123, 123, 123));
                                g.fillRect(getWidth() / blocks.length * i, getHeight() / blocks.length * j, getWidth() / blocks.length, getHeight() / blocks.length);
                                g.setColor(new Color(61, 61, 61));
                                g.drawRect(getWidth() / blocks.length * i, getHeight() / blocks.length * j, getWidth() / blocks.length, getHeight() / blocks.length);

                                g.setColor(new Color(0, 200, 255));
                                g.fillRect(coordX + x / 4, coordY + y / 4, x / 2, y / 2);
                                g.setColor(new Color(0, 255, 255));
                                g.fillRect(coordX + x / 4, coordY + y / 4, x / 4, y / 4);
                                g.setColor(new Color(0, 170, 255));
                                g.fillRect(coordX + x / 2, coordY + y / 2, x / 4, y / 4);
                            }
                            case 2 -> {
                                g.setColor(new Color(123, 123, 123));
                                g.fillRect(getWidth() / blocks.length * i, getHeight() / blocks.length * j, getWidth() / blocks.length, getHeight() / blocks.length);
                                g.setColor(new Color(61, 61, 61));
                                g.drawRect(getWidth() / blocks.length * i, getHeight() / blocks.length * j, getWidth() / blocks.length, getHeight() / blocks.length);

                                g.setColor(new Color(100, 60, 0));
                                g.fillRect(coordX + x / 4, coordY + y / 4, x / 2, y / 4 * 3);
                            }
                            case 3 -> {
                                g.setColor(new Color(255,255,255));
                                g.fillRect(coordX,coordY,x,y);

                                g.setColor(new Color(170, 40, 0));
                                g.fillPolygon(new int[]{coordX,coordX + x,coordX + x},new int[]{coordY + y,coordY + y,coordY},3);
                            }
                            case 4 -> {
                                g.setColor(new Color(255,255,255));
                                g.fillRect(coordX,coordY,x,y);

                                g.setColor(new Color(170, 40, 0));
                                g.fillPolygon(new int[]{coordX,coordX,coordX + x},new int[]{coordY,coordY + y,coordY + y},3);
                            }
                            case 5 -> {
                                g.setColor(new Color(255,255,255));
                                g.fillRect(coordX,coordY,x,y);

                                g.setColor(new Color(170, 40, 0));
                                g.fillPolygon(new int[]{coordX,coordX + (x/2),coordX + x},new int[]{coordY + y,coordY + (y/2),coordY + y},3);
                            }
                            case 6 -> {
                                g.setColor(new Color(255,255,255));
                                g.fillRect(coordX,coordY,x,y);

                                g.setColor(new Color(100, 50, 0));
                                g.fillRect(coordX+x/3,coordY,x/3,y);
                                g.setColor(new Color(0, 184, 0));
                                g.fillRect(coordX,coordY,x,y/2);

                                g.setColor(new Color(255,255,255));
                                g.drawRect(coordX,coordY,x,y);
                                g.setColor(new Color(100, 50, 0));
                                g.fillRect(coordX+x/3,coordY+y/2,x/3,y/2);
                            }
                            case 9 -> {
                                g.setColor(new Color(0, 123, 0));
                                g.fillRect(getWidth() / blocks.length * i, getHeight() / blocks.length * j, getWidth() / blocks.length, getHeight() / blocks.length);

                            }
                            default -> {
                                g.setColor(new Color(255, 255, 255));
                                g.fillRect(coordX, coordY, x, y);
                            }
                        }
                    }
                }
            }
        };

        frame.add(panel);
        panel.setVisible(true);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        final int[] keepBlock = {0};
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                int keep = blocks[x / (panel.getWidth() / blocks.length)][y / (panel.getHeight() / blocks.length)];
                blocks[x / (panel.getWidth() / blocks.length)][y / (panel.getHeight() / blocks.length)] = keepBlock[0];

                panel.updateUI();
            }
        });

        panel.setFocusable(true); // Установите фокус на панель, чтобы она могла принимать ввод с клавиатуры
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_0 -> keepBlock[0] = 0;
                    case KeyEvent.VK_1 -> keepBlock[0] = 1;
                    case KeyEvent.VK_2 -> keepBlock[0] = 2;
                    case KeyEvent.VK_3 -> keepBlock[0] = 3;
                    case KeyEvent.VK_4 -> keepBlock[0] = 4;
                    case KeyEvent.VK_5 -> keepBlock[0] = 5;
                    case KeyEvent.VK_6 -> keepBlock[0] = 6;
                    case KeyEvent.VK_7 -> keepBlock[0] = 7;
                    case KeyEvent.VK_8 -> keepBlock[0] = 8;
                    case KeyEvent.VK_9 -> keepBlock[0] = 9;

                }
            }
        });
    }
}
