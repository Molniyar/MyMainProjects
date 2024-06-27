import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class CharArt {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Char art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,900,900);

        Polygon[] polygons = {
                new Polygon(new int[]{200,250,300,300,250,200},new int[]{150,100,150,350,400,350},6),
                new Polygon(new int[]{200,250,300,300,250,200},new int[]{450,400,450,650,700,650},6),

                new Polygon(new int[]{300,250,300,500,550,500},new int[]{150,100,50,50,100,150}  ,6),
                new Polygon(new int[]{300,250,300,500,550,500},new int[]{450,400,350,350,400,450},6),
                new Polygon(new int[]{300,250,300,500,550,500},new int[]{750,700,650,650,700,750},6),

                new Polygon(new int[]{500,550,600,600,550,500},new int[]{150,100,150,350,400,350},6),
                new Polygon(new int[]{500,550,600,600,550,500},new int[]{450,400,450,650,700,650},6),
        };


        AtomicReferenceArray<Boolean> char_ = new AtomicReferenceArray<>(7);
        for (int i = 0; i < 7; i++){
            char_.set(i,false);
        }
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0,0,0));
                for (int i = 0; i < 7; i++){
                    if (char_.get(i)){
                        g.setColor(new Color(0,0,0));
                    }
                    else g.setColor(new Color(200,200,200));
                    g.fillPolygon(polygons[i]);
                    g.setColor(new Color(240,240,240));
                    g.drawPolygon(polygons[i]);
                }
            }
        };
        panel.setBounds(0,0,800,800);

        JRadioButton _1 = new JRadioButton();
        JRadioButton _2 = new JRadioButton();
        _1.setBounds(100,800,50,50);
        _2.setBounds(150,800,50,50);

        JRadioButton _3 = new JRadioButton();
        JRadioButton _4 = new JRadioButton();
        JRadioButton _5 = new JRadioButton();
        _3.setBounds(250,800,50,50);
        _4.setBounds(300,800,50,50);
        _5.setBounds(350,800,50,50);

        JRadioButton _6 = new JRadioButton();
        JRadioButton _7 = new JRadioButton();
        _6.setBounds(450,800,50,50);
        _7.setBounds(500,800,50,50);

        JButton paint = new JButton("paint");
        paint.setBounds(800,800,50,50);
        paint.addActionListener(e -> {
            char_.set(0,_1.isSelected());
            char_.set(1,_2.isSelected());

            char_.set(2,_3.isSelected());
            char_.set(3,_4.isSelected());
            char_.set(4,_5.isSelected());

            char_.set(5,_6.isSelected());
            char_.set(6,_7.isSelected());

            panel.repaint();
        });

        frame.add(panel);
        panel.setVisible(true);

        frame.add(_1);
        frame.add(_2);

        frame.add(_3);
        frame.add(_4);
        frame.add(_5);

        frame.add(_6);
        frame.add(_7);

        frame.add(paint);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
        panel.setFocusable(true); // Установите фокус на панель, чтобы она могла принимать ввод с клавиатуры
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode){
                    case KeyEvent.VK_0 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,true);
                        }
                        char_.set(3,false);
                        panel.repaint();
                    }
                    case KeyEvent.VK_1 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,false);
                        }
                        char_.set(5,true);
                        char_.set(6,true);
                        panel.repaint();
                    }
                    case KeyEvent.VK_2 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,false);
                        }
                        char_.set(1,true);
                        char_.set(2,true);
                        char_.set(3,true);
                        char_.set(4,true);
                        char_.set(5,true);
                        panel.repaint();
                    }
                    case KeyEvent.VK_3 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,false);
                        }
                        char_.set(2,true);
                        char_.set(3,true);
                        char_.set(4,true);
                        char_.set(5,true);
                        char_.set(6,true);
                        panel.repaint();
                    }
                    case KeyEvent.VK_4 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,false);
                        }
                        char_.set(0,true);
                        char_.set(3,true);
                        char_.set(5,true);
                        char_.set(6,true);
                        panel.repaint();
                    }
                    case KeyEvent.VK_5 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,false);
                        }
                        char_.set(0,true);
                        char_.set(2,true);
                        char_.set(3,true);
                        char_.set(4,true);
                        char_.set(6,true);
                        panel.repaint();
                    }
                    case KeyEvent.VK_6 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,true);
                        }
                        char_.set(5,false);
                        panel.repaint();
                    }
                    case KeyEvent.VK_7 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,false);
                        }
                        char_.set(2,true);
                        char_.set(5,true);
                        char_.set(6,true);
                        panel.repaint();
                    }
                    case KeyEvent.VK_8 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,true);
                        }
                        panel.repaint();
                    }
                    case KeyEvent.VK_9 -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,true);
                        }
                        char_.set(1,false);
                        panel.repaint();
                    }
                    case KeyEvent.VK_SPACE -> {
                        for (int i = 0; i < 7; i++){
                            char_.set(i,false);
                        }
                        panel.repaint();
                    }
                }
            }
        });
    }
}
