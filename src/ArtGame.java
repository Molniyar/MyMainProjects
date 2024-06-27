import test1.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArtGame {
    public static void main(String[] args) {
        Color white = new Color(255,255,255);

        int l = 8;
        if (args.length > 0){
            l = Integer.parseInt(args[0]);
        }
        Color[][] colors = new Color[l][l];

        for (int i = 0; i < colors.length; i++){
            for (int j = 0; j < colors.length; j++){
                colors[i][j] = white;
            }
        }

        final Color[] keepColor = {new Color(0, 0, 0),new Color(0, 0, 0)};


        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,800);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < colors.length; i++){
                    for (int j = 0; j < colors.length; j++){
                        int num = Math.min(getWidth(),getHeight());
                        int coordX = num  / colors.length * i;
                        int coordY = num / colors.length * j;

                        int l = num / colors.length;

                        int r = colors[i][j].getRed();
                        switch (r){
                            case 1 ->{
                                g.setColor(white);
                                g.fillRect(coordX,coordY, l, l);

                                g.setColor(keepColor[1]);
                                g.fillRect(coordX + l /3,coordY + l /3, l /3, l /3);

                                if (j+1 <colors.length && (colors[i][j+1].getRed() == 1)){g.fillRect(coordX + l /3,coordY + l /3*2, l /3, l /3);}
                                if (j-1 >= 0           && (colors[i][j-1].getRed() == 1)){g.fillRect(coordX + l /3,coordY,           l /3, l /3);}
                                if (i+1 <colors.length && (colors[i+1][j].getRed() == 1)){g.fillRect(coordX + l /3*2,coordY + l /3, l /3, l /3);}
                                if (i-1 >= 0           && (colors[i-1][j].getRed() == 1)){g.fillRect(coordX,coordY + l /3,           l /3, l /3);}
                            }
                            case 2 ->{
                                g.setColor(white);
                                g.fillRect(coordX,coordY, l, l);

                                g.setColor(new Color(200,90,0));
                                g.fillRect(coordX + l /3,coordY + l /3, l /3, l /3);


                                if (j+1 <colors.length && colors[i][j+1].getRed() == 2){g.fillRect(coordX + l /3,coordY + l /3*2, l /3, l /3);}
                                if (j-1 >= 0           && colors[i][j-1].getRed() == 2){g.fillRect(coordX + l /3,coordY,           l /3, l /3);}
                                if (i+1 <colors.length && colors[i+1][j].getRed() == 2){g.fillRect(coordX + l /3*2,coordY + l /3, l /3, l /3);}
                                if (i-1 >= 0           && colors[i-1][j].getRed() == 2){g.fillRect(coordX,coordY + l /3,           l /3, l /3);}
                            }
                            case 3 ->{
                                g.setColor(new Color(0,255,0));
                                g.fillRect(coordX+ l /4,coordY+ l /4, l /2, l /2);

                                g.setColor(new Color(123,255,123));
                                g.fillPolygon(new int[]{coordX,coordX+ l /4,coordX+ l /4,coordX},new int[]{coordY,coordY+ l /4,coordY+ l /4*3,coordY+ l},4);

                                g.setColor(new Color(173,255,173));
                                g.fillPolygon(new int[]{coordX+ l /4,coordX+ l /4,coordX+ l /4*3,coordX+ l /2},new int[]{coordY+ l /2,coordY+ l /4*3,coordY+ l /4,coordY+ l /4},4);

                                g.setColor(new Color(153,255,153));//---------------------------------||
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /4*3,coordX+ l /4},new int[]{coordY,coordY,coordY+ l /4,coordY+ l /4},4);

                                g.setColor(new Color(0,200,0));
                                g.fillPolygon(new int[]{coordX+ l,coordX+ l,coordX+ l /4*3,coordX+ l /4*3},new int[]{coordY,coordY+ l,coordY+ l /4*3,coordY+ l /4},4);

                                g.setColor(new Color(0,170,0));
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /4*3,coordX+ l /4},new int[]{coordY+ l,coordY+ l,coordY+ l /4*3,coordY+ l /4*3},4);
                            }
                            case 4 ->{
                                int red = 0;
                                int gre = 0;
                                int blu = 0;
                                int div = 0;
                                if (j+1 <colors.length ){
                                    red += colors[i][j+1].getRed();
                                    gre += colors[i][j+1].getGreen();
                                    blu += colors[i][j+1].getBlue();

                                    div++;
                                }
                                if (j-1 >= 0           ){
                                    red += colors[i][j-1].getRed();
                                    gre += colors[i][j-1].getGreen();
                                    blu += colors[i][j-1].getBlue();

                                    div++;
                                }
                                if (i+1 <colors.length ){
                                    red += colors[i+1][j].getRed();
                                    gre += colors[i+1][j].getGreen();
                                    blu += colors[i+1][j].getBlue();

                                    div++;
                                }
                                if (i-1 >= 0           ){
                                    red += colors[i-1][j].getRed();
                                    gre += colors[i-1][j].getGreen();
                                    blu += colors[i-1][j].getBlue();

                                    div++;
                                }

                                g.setColor(new Color(red/div,gre/div,blu/div));
                                g.fillRect(coordX,coordY, l, l);
                                colors[i][j] = new Color(red/div,gre/div,blu/div);
                            }
                            case 151 ->{
                                if (colors[i][j].getGreen() > 10){
                                    g.setColor(colors[i][j]);
                                    g.fillRect(coordX, coordY, l, l);
                                    break;
                                }
                                if (colors[i][j].getBlue() < 220){
                                    g.setColor(colors[i][j]);
                                    g.fillRect(coordX, coordY, l, l);
                                    break;
                                }
                                g.setColor(new Color(170,120,255));
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY,coordY,coordY+ l /2},3);

                                g.setColor(new Color(170,80,255));
                                g.fillPolygon(new int[]{coordX,coordX,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(151,0,255));
                                g.fillPolygon(new int[]{coordX+ l,coordX+ l,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(101,0,210));
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY+ l,coordY+ l,coordY+ l /2},3);

                            }
                            case 5 ->{
                                if (j+1 <colors.length ){
                                    g.setColor(new Color(colors[i][j+1].getRed(),colors[i][j+1].getGreen(),colors[i][j+1].getBlue()));
                                    g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY+ l,coordY+ l,coordY+ l /2},3);
                                }
                                if (j-1 >= 0           ){
                                    g.setColor(new Color(colors[i][j-1].getRed(),colors[i][j-1].getGreen(),colors[i][j-1].getBlue()));
                                    g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY,coordY,coordY+ l /2},3);
                                }
                                if (i+1 <colors.length ){
                                    g.setColor(new Color(colors[i+1][j].getRed(),colors[i+1][j].getGreen(),colors[i+1][j].getBlue()));
                                    g.fillPolygon(new int[]{coordX+ l,coordX+ l,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);
                                }
                                if (i-1 >= 0           ){
                                    g.setColor(new Color(colors[i-1][j].getRed(),colors[i-1][j].getGreen(),colors[i-1][j].getBlue()));
                                    g.fillPolygon(new int[]{coordX,coordX,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);
                                }
                            }
                            case 6 ->{
                                if (j+1 <colors.length ){
                                    g.setColor(new Color(colors[i][j+1].getRed(),colors[i][j+1].getGreen(),colors[i][j+1].getBlue()));
                                    g.fillRect(coordX+ l /2,coordY+ l /2, l - l /2, l - l /2);
                                }
                                if (j-1 >= 0           ){
                                    g.setColor(new Color(colors[i][j-1].getRed(),colors[i][j-1].getGreen(),colors[i][j-1].getBlue()));
                                    g.fillRect(coordX,coordY, l - l /2, l - l /2);
                                }
                                if (i+1 <colors.length ){
                                    g.setColor(new Color(colors[i+1][j].getRed(),colors[i+1][j].getGreen(),colors[i+1][j].getBlue()));
                                    g.fillRect(coordX+ l /2,coordY, l - l /2, l - l /2);
                                }
                                if (i-1 >= 0           ){
                                    g.setColor(new Color(colors[i-1][j].getRed(),colors[i-1][j].getGreen(),colors[i-1][j].getBlue()));
                                    g.fillRect(coordX,coordY+ l /2, l - l /2, l - l /2);
                                }
                            }
                            case 7 ->{
                                if (j+1 <colors.length ){
                                    g.setColor(new Color(colors[i][j+1].getRed(),colors[i][j+1].getGreen(),colors[i][j+1].getBlue()));
                                    g.fillRect(coordX,coordY, l, l);
                                }
                                if (j-1 >= 0           ){
                                    g.setColor(new Color(colors[i][j-1].getRed(),colors[i][j-1].getGreen(),colors[i][j-1].getBlue()));
                                    g.fillRect(coordX+ l /8,coordY+ l /8, l /4*3, l /4*3);
                                }
                                if (i+1 <colors.length ){
                                    g.setColor(new Color(colors[i+1][j].getRed(),colors[i+1][j].getGreen(),colors[i+1][j].getBlue()));
                                    g.fillRect(coordX+ l /8*2,coordY+ l /8*2, l /4*2, l /4*2);
                                }
                                if (i-1 >= 0           ){
                                    g.setColor(new Color(colors[i-1][j].getRed(),colors[i-1][j].getGreen(),colors[i-1][j].getBlue()));
                                    g.fillRect(coordX+ l /8*3,coordY+ l /8*3, l /4, l /4);
                                }
                            }
                            case 8 ->{
                                g.setColor(new Color(255,0,0));
                                g.fillPolygon(new int[]{coordX,coordX+ l /3,coordX+ l /2},new int[]{coordY,coordY,coordY+ l /2},3);

                                g.setColor(new Color(255,123,0));
                                g.fillPolygon(new int[]{coordX+ l /3,coordX+ l /3*2,coordX+ l /2},new int[]{coordY,coordY,coordY+ l /2},3);

                                g.setColor(new Color(255,255,0));
                                g.fillPolygon(new int[]{coordX+ l /3*2,coordX+ l,coordX+ l /2},new int[]{coordY,coordY,coordY+ l /2},3);

                                g.setColor(new Color(123,255,0));
                                g.fillPolygon(new int[]{coordX+ l,coordX+ l,coordX+ l /2},new int[]{coordY,coordY+ l /3,coordY+ l /2},3);

                                g.setColor(new Color(0,255,0));
                                g.fillPolygon(new int[]{coordX+ l,coordX+ l,coordX+ l /2},new int[]{coordY+ l /3,coordY+ l /3*2,coordY+ l /2},3);

                                g.setColor(new Color(0,255,123));
                                g.fillPolygon(new int[]{coordX+ l,coordX+ l,coordX+ l /2},new int[]{coordY+ l /3*2,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(0,255,255));
                                g.fillPolygon(new int[]{coordX+ l /3,coordX+ l,coordX+ l /2},new int[]{coordY+ l,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(0,123,255));
                                g.fillPolygon(new int[]{coordX+ l /3*2,coordX+ l /3,coordX+ l /2},new int[]{coordY+ l,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(0,0,255));
                                g.fillPolygon(new int[]{coordX,coordX+ l /3,coordX+ l /2},new int[]{coordY+ l,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(123,0,255));
                                g.fillPolygon(new int[]{coordX,coordX,coordX+ l /2},new int[]{coordY+ l /3*2,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(255,0,255));
                                g.fillPolygon(new int[]{coordX,coordX,coordX+ l /2},new int[]{coordY+ l /3,coordY+ l /3*2,coordY+ l /2},3);

                                g.setColor(new Color(255,0,123));
                                g.fillPolygon(new int[]{coordX,coordX,coordX+ l /2},new int[]{coordY,coordY+ l /3,coordY+ l /2},3);
                            }
                            case 9 ->{
                                g.setColor(new Color(0,255,255));
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY,coordY,coordY+ l /2},3);

                                g.setColor(new Color(0,184,255));
                                g.fillPolygon(new int[]{coordX,coordX,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(0,123,255));
                                g.fillPolygon(new int[]{coordX+ l,coordX+ l,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(0,61,210));
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY+ l,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(0,200,255));
                                g.fillRect(coordX+ l /3,coordY+ l /3, l /3, l /3);
                            }
                            case 254 ->{
                                g.setColor(new Color(254,255,0));
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY,coordY,coordY+ l /2},3);

                                g.setColor(new Color(254,184,0));
                                g.fillPolygon(new int[]{coordX,coordX,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(254,123,0));
                                g.fillPolygon(new int[]{coordX+ l,coordX+ l,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(254,61,0));
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY+ l,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(255,255,123));
                                g.drawRect(coordX,coordY, l, l);
                            }
                            case 16 ->{
                                Color k = keepColor[1];

                                g.setColor(new Color(Math.clamp(k.getRed()* 4L /3,0,255),Math.clamp(k.getGreen()* 4L /3,0,255),Math.clamp(k.getBlue()* 4L /3,0,255)));
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY,coordY,coordY+ l /2},3);

                                g.setColor(keepColor[1]);
                                g.fillPolygon(new int[]{coordX,coordX,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(Math.clamp(k.getRed()* 3L /4,0,255),Math.clamp(k.getGreen()* 3L /4,0,255),Math.clamp(k.getBlue()* 3L /4,0,255)));
                                g.fillPolygon(new int[]{coordX+ l,coordX+ l,coordX+ l /2},new int[]{coordY,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(Math.clamp(k.getRed()/2,0,255),Math.clamp(k.getGreen()/2,0,255),Math.clamp(k.getBlue()/2,0,255)));
                                g.setColor(new Color(keepColor[1].getRed()/2,keepColor[1].getGreen()/2,keepColor[1].getBlue()/2));
                                g.fillPolygon(new int[]{coordX,coordX+ l,coordX+ l /2},new int[]{coordY+ l,coordY+ l,coordY+ l /2},3);

                                g.setColor(new Color(255,255,255));
                                g.drawRect(coordX,coordY, l, l);
                            }

                            default -> {
                                g.setColor(colors[i][j]);
                                g.fillRect(coordX, coordY, l, l);
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

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                try {
                    switch (e.getButton()){
                        case MouseEvent.BUTTON1 -> colors[x / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)] = keepColor[0];
                        case MouseEvent.BUTTON2 -> keepColor[0] = colors[x / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)];
                        case MouseEvent.BUTTON3 -> colors[x / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)] = keepColor[1];
                    }
                }catch (ArrayIndexOutOfBoundsException exception){
                    new PlaySound("1",1,500,20);
                }


                panel.updateUI();
            }
        });

        panel.setFocusable(true); // Установите фокус на панель, чтобы она могла принимать ввод с клавиатуры
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_1      -> keepColor[0] = new Color(255,0,0);
                    case KeyEvent.VK_2      -> keepColor[0] = new Color(255,123,0);
                    case KeyEvent.VK_3      -> keepColor[0] = new Color(255,255,0);
                    case KeyEvent.VK_4      -> keepColor[0] = new Color(123,255,0);
                    case KeyEvent.VK_5      -> keepColor[0] = new Color(0,255,0);
                    case KeyEvent.VK_6      -> keepColor[0] = new Color(0,255,123);
                    case KeyEvent.VK_7      -> keepColor[0] = new Color(0,255,255);
                    case KeyEvent.VK_8      -> keepColor[0] = new Color(0,123,255);
                    case KeyEvent.VK_9      -> keepColor[0] = new Color(0,0,255);
                    case KeyEvent.VK_0      -> keepColor[0] = new Color(123,0,255);
                    case KeyEvent.VK_MINUS  -> keepColor[0] = new Color(255,0,255);
                    case KeyEvent.VK_EQUALS -> keepColor[0] = new Color(255,0,123);

                    case KeyEvent.VK_PLUS -> keepColor[0] = new Color(2,0,0);

                    case KeyEvent.VK_ENTER -> {
                        int r = Math.clamp(keepColor[0].getRed()   - 15,0,255);
                        int g = Math.clamp(keepColor[0].getGreen() - 15,0,255);
                        int b = Math.clamp(keepColor[0].getBlue()  - 15,0,255);

                        keepColor[0] = new Color(r, g, b);
                    }
                    case KeyEvent.VK_BACK_SPACE -> {
                        int r = Math.clamp(keepColor[0].getRed()   + 15,0,255);
                        int g = Math.clamp(keepColor[0].getGreen() + 15,0,255);
                        int b = Math.clamp(keepColor[0].getBlue()  + 15,0,255);

                        keepColor[0] = new Color(r, g, b);
                    }

                    case KeyEvent.VK_SPACE -> keepColor[0] = new Color(255,255,255);

                    case KeyEvent.VK_H -> {
                        JOptionPane.showMessageDialog(frame, "используйте клавиши от '1' до '0', а так же '-' и '=' для выбора цвета");
                        JOptionPane.showMessageDialog(frame, "нажмите на 'Enter' что бы сделать цвет темнее или на 'BackSpace' что бы светлее");
                        JOptionPane.showMessageDialog(frame, "что бы выбрать белый, нажмите пробел");
                        JOptionPane.showMessageDialog(frame, "что бы всё очистить, нажмите 'Shift'");
                        JOptionPane.showMessageDialog(frame, "нажатие на колёсиео мыши работает как пипетка");
                    }


                    case KeyEvent.VK_F -> keepColor[0] = new Color(1,0,0);
                    case KeyEvent.VK_C -> keepColor[0] = new Color(3,255,3);
                    case KeyEvent.VK_M -> keepColor[0] = new Color(4,0,0);
                    case KeyEvent.VK_S -> keepColor[0] = new Color(151,0,255);
                    case KeyEvent.VK_Q -> keepColor[0] = new Color(5,0,0);
                    case KeyEvent.VK_O -> keepColor[0] = new Color(6,0,0);
                    case KeyEvent.VK_K -> keepColor[0] = new Color(7,0,0);
                    case KeyEvent.VK_R -> keepColor[0] = new Color(8,255,123);
                    case KeyEvent.VK_I -> keepColor[0] = new Color(9,230,255);
                    case KeyEvent.VK_L -> keepColor[0] = new Color(254,184,0);

                    case KeyEvent.VK_SHIFT -> {
                        for (int i = 0; i < colors.length; i++){
                            for (int j = 0; j < colors.length; j++){
                                colors[i][j] = white;
                            }
                        }
                        panel.updateUI();
                    }

                    case KeyEvent.VK_W ->{
                        int random = MolniyarMethod.randomNumber(0,colors.length-1);
                        int r2 = MolniyarMethod.randomNumber(0,colors.length-1);
                        if ((random == 0 && r2 == 0) || (r2 == colors.length-1 && random == colors.length-1)){
                            return;
                        }
                        colors[random][r2] = new Color(4,0,0);
                        panel.updateUI();
                    }
                    case KeyEvent.VK_CONTROL -> keepColor[1] = new Color(keepColor[0].getRGB());
                    case KeyEvent.VK_N -> keepColor[0] = new Color(16,16,16);

                    case KeyEvent.VK_A -> {
                        int r = keepColor[0].getRed();
                        int g = keepColor[0].getGreen();
                        int b = keepColor[0].getBlue();
                        keepColor[0] = new Color(255-r,255-g,255-b);
                    }
                }
            }
        });
    }
}
