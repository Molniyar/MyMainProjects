import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LifeGameII {
    public static void main(String[] args) {
        int l = 8;
        if (args.length > 0){l = Integer.parseInt(args[0]);}

        byte[][] blocks = new byte[l][l];

        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,816);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < blocks.length; i++){
                    for (int j = 0; j < blocks.length; j++){
                        if (blocks[i][j] == 0){continue;}

                        int num = Math.min(getWidth(),getHeight());
                        int coordX = num  / blocks.length * i;
                        int coordY = num / blocks.length * j;

                        int x = num / blocks.length;
                        int y = num / blocks.length;

                        switch (blocks[i][j]){
                            case 1 -> g.setColor(new Color(0,0,0));
                            case 2 -> g.setColor(new Color(255,0,0));
                            case 3 -> g.setColor(new Color(0,255,255));
                        }
                        g.fillRect(coordX, coordY, x, y);
                    }

                }
            }
        };

        frame.add(panel);
        panel.setVisible(true);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        final int[] keepBlock = {0,0};
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Math.min(panel.getWidth(),panel.getHeight());
                int x = e.getX();
                int y = e.getY();

                int keyCode = e.getButton();
                if (keyCode == MouseEvent.BUTTON1) {
                    blocks[x / (num / blocks.length)][y / (num / blocks.length)] = (byte) keepBlock[0];
                }
                if (keyCode == MouseEvent.BUTTON3) {
                    blocks[x / (num / blocks.length)][y / (num / blocks.length)] = (byte) keepBlock[1];
                }
                panel.updateUI();
            }
        });
        panel.setFocusable(true); // Установите фокус на панель, чтобы она могла принимать ввод с клавиатуры
        panel.requestFocusInWindow();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_1 -> keepBlock[0] = 0;
                    case KeyEvent.VK_2 -> keepBlock[0] = 1;
                    case KeyEvent.VK_3 -> keepBlock[0] = 2;
                    case KeyEvent.VK_4 -> keepBlock[0] = 3;
                    case KeyEvent.VK_ENTER -> {
                        byte code = (byte) (1<<7);
                        byte dec  = (byte) (1+2+4+8+16+32+64);

                        for (int i = 0; i < blocks.length;i++){
                            for (int j = 0; j < blocks.length;j++){
                                int aliveCount = 0;

                                boolean jLess = j > 0;
                                boolean jMore = j+1 < blocks.length;

                                if (i+1 < blocks.length){
                                    if (jMore && (blocks[i+1][j+1]&dec) == 1){aliveCount++;}
                                    if ((blocks[i+1][j]&dec)==1){aliveCount++;}
                                    if (jLess && (blocks[i+1][j-1]&dec)==1){aliveCount++;}
                                }
                                if (jMore && (blocks[i][j+1]&dec)==1){aliveCount++;}
                                if (jLess && (blocks[i][j-1]&dec)==1){aliveCount++;}
                                if (i>0){
                                    if (jMore && (blocks[i-1][j+1]&dec)==1){aliveCount++;}
                                    if ((blocks[i-1][j]&dec)==1){aliveCount++;}
                                    if (jLess && (blocks[i-1][j-1]&dec)==1){aliveCount++;}
                                }

                                if (blocks[i][j] == 0 && aliveCount == 3){
                                    blocks[i][j] = (byte) (0|code);
                                }
                                if (blocks[i][j] == 1 && (aliveCount != 3 && aliveCount != 2)){
                                    blocks[i][j] = (byte) (1|code);
                                }
                                System.out.println(aliveCount);
                            }
                        }
                        for (int i = 0; i < blocks.length;i++) {
                            for (int j = 0; j < blocks.length; j++) {
                                if ((blocks[i][j] & code) != 0){blocks[i][j] = (byte) ((blocks[i][j] & dec)^1);}
                                else blocks[i][j] = (byte) ((blocks[i][j] & dec));
                            }
                        }
                        panel.updateUI();
                    }
                }
            }
        });
    }
}
