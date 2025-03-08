import test1.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class Resepies {
    public static void main(String[] args) {
        int l = 8;
        if (args.length > 0){
            l = Integer.parseInt(args[0]);
        }
        byte[][] blocks = new byte[l][l];

        for (int i = 0; i < blocks.length; i++){
            for (int j = 0; j < blocks.length; j++){
                blocks[i][j] = 0;
            }
        }

        final int[] keepBlock = {0,0};

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
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int num = Math.min(panel.getWidth(),panel.getHeight());
                int x = e.getX();
                int y = e.getY();
                var d = "\uD83C\uDF0E";
                int keyCode = e.getButton();
                if (keyCode == MouseEvent.BUTTON1) {
                    int keep = blocks[x / (num / blocks.length)][y / (num / blocks.length)];
                    blocks[x / (num / blocks.length)][y / (num / blocks.length)] = (byte) keepBlock[0];
                    keepBlock[0] = keep;

                    switch (blocks[x / (num / blocks.length)][y / (num / blocks.length)]){
                        case 3 -> new PlaySound("2",1,2000,40);
                    }
                }
                if (keyCode == MouseEvent.BUTTON3) {
                    keepBlock[0] = blocks[x / (num / blocks.length)][y / (num / blocks.length)];
                }

                if (keyCode == MouseEvent.BUTTON2) {
                    blocks[x / (num / blocks.length)][y / (num / blocks.length)] = (byte) keepBlock[0];
                }



                panel.updateUI();
            }
        });

        panel.setFocusable(true); // Установите фокус на панель, чтобы она могла принимать ввод с клавиатуры
        panel.requestFocusInWindow();
        int finalL = l;
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_0 -> keepBlock[0] = 0;
                    case KeyEvent.VK_1 -> keepBlock[0] = 1;
                    case KeyEvent.VK_2 -> keepBlock[0] = 6;
                    case KeyEvent.VK_3 -> keepBlock[0] = 3;
                    case KeyEvent.VK_4 -> keepBlock[0] = 4;
                    case KeyEvent.VK_5 -> keepBlock[0] = 8;
                    case KeyEvent.VK_6 -> keepBlock[0] = 0;
                    case KeyEvent.VK_7 -> keepBlock[0] = 0;
                    case KeyEvent.VK_8 -> keepBlock[0] = 0;
                    case KeyEvent.VK_9 -> keepBlock[0] = 0;
                    case KeyEvent.VK_ENTER -> {
                        int[] counts = new int[20];
                        for (int i = 0; i < 3;i++){
                            for (int j = 0; j < 3;j++){
                                counts[blocks[i][j]]++;
                            }
                        }

                        if (counts[2] == 2 && counts[3] == 2 && areAllEqual0(counts,new int[]{2,3})){
                            Craft(blocks, (byte) 5);
                        }
                        if (counts[2] == 1 && counts[3] == 1 && counts[4] == 1 && areAllEqual0(counts,new int[]{2,3,4})){
                            Craft(blocks, (byte) 5);
                        }
                        if (counts[6] == 1 && areAllEqual0(counts,new int[]{6})){
                            Craft(blocks, (byte) 2);
                        }
                        if (counts[1] == 2 && counts[3] == 2 && areAllEqual0(counts,new int[]{1,3})){
                            Craft(blocks, (byte) 7);
                        }
                        if (counts[1] == 3 && counts[5] == 1 && counts[3] == 1 && areAllEqual0(counts,new int[]{1,5,3})){
                            Craft(blocks, (byte) 10);
                        }
                        if (counts[1] == 3 && counts[2] == 2 && counts[4] == 1 && areAllEqual0(counts,new int[]{1,2,4})){
                            Craft(blocks, (byte) 11);
                        }
                        if (counts[10] == 1 && counts[11] == 1 && areAllEqual0(counts,new int[]{10,11})){
                            Craft(blocks, (byte) 12);
                        }
                        if (counts[8] == 4 && areAllEqual0(counts,new int[]{8})){
                            Craft(blocks, (byte) 9);
                        }
                        if (counts[9] == 2 && counts[7] == 1 && counts[3] == 1 && areAllEqual0(counts,new int[]{9,7,3,15})){
                            Craft(blocks, (byte) 13);
                        }
                        if (counts[1] == 3 && counts[5] == 1 && counts[3] == 2 && areAllEqual0(counts,new int[]{1,5,3})){
                            Craft(blocks, (byte) 14);
                        }
                        if (counts[8] == 1 && counts[2] == 1 && areAllEqual0(counts,new int[]{8,2})){
                            Craft(blocks, (byte) 15);
                        }
                        if (counts[9] == 2 && counts[15] == 1 && areAllEqual0(counts,new int[]{9,15})){
                            Craft(blocks, (byte) 16);
                        }
                        if (counts[12] == 1 && counts[11] == 1 && counts[5] == 1 && counts[4] == 1 && areAllEqual0(counts,new int[]{12,11,5,4})){
                            Craft(blocks, (byte) 17);
                        }

                        panel.updateUI();
                    }
                }
            }
        });
    }
    public static void Craft(byte[][] blocks, byte resBlock){
        if (blocks[4][1] != 0){
            new PlaySound("2",3,100,40);
            return;
        }

        blocks[0][0] = 0;
        blocks[0][1] = 0;
        blocks[0][2] = 0;
        blocks[1][0] = 0;
        blocks[1][1] = 0;
        blocks[1][2] = 0;
        blocks[2][0] = 0;
        blocks[2][1] = 0;
        blocks[2][2] = 0;
        blocks[4][1] = resBlock;
    }

    public static boolean areAllEqual0(int[] counts, int[] exceptions){
        for (int i = 1; i < counts.length; i++){
            if (contains(exceptions,i)){continue;}
            if (counts[i] > 0){return false;}
        }
        return true;
    }
    public static boolean contains(int[] arr, int num){
        for (int j : arr) {
            if (j == num) {
                return true;
            }
        }
        return false;
    }
}
