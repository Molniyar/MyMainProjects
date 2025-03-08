import test1.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameBlockEXample {
    public static void main(String[] args) {
        int l = 8;

        byte[][] blocks = new byte[l][l];

        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j < blocks.length; j++){
                blocks[i][j] = 0;
            }
        }

        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,816);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int num = Math.min(getWidth(),getHeight());
                int x = num / blocks.length;
                int y = num / blocks.length;

                for (int i = 0; i < blocks.length; i++){
                    for (int j = 0; j < blocks.length; j++){
                        int coordX = num  / blocks.length * i;
                        int coordY = num / blocks.length * j;



                        ResepiesMethod.drawItem(g,coordX,coordY,x,y,blocks[i][j],(i < 3 && j < 3)||(i == 4 && j == 1),i == 3 && j == 1);
                    }
                }

            }
        };

        frame.add(panel);
        panel.setVisible(true);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.setFocusable(true); // Установите фокус на панель, чтобы она могла принимать ввод с клавиатуры
        panel.requestFocusInWindow();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {

                }
            }
        });
    }
}
