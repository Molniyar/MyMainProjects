import javax.swing.*;
import java.awt.*;

public class Plants {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Char art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,900,900);

        PixelArt art = new PixelArt(16,new Color(255,255,255));

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0,0,0));
                art.draw(g,800,800);
            }
        };
        panel.setBounds(0,0,800,800);

        JComboBox<String> lColors = new JComboBox<>(new String[]{"Очень светлый","Светлый","Стандартный","Тёмный","Очень тёмный","Красноватый","Красный"});
        lColors.setBounds(800,200,100,70);
        Color[] LeavesColor = {
                new Color(170,255,80),
                new Color(120,220,20),
                new Color(80,175,80),
                new Color(0,123,0),
                new Color(81,100,0),
                new Color(97,70,20),
                new Color(145,50,70),
        };

        JComboBox<String> fColors = new JComboBox<>(new String[]{"Фиолетовый","Синий","Голубой","Небесно-голубой","белый","Розоватый","Розовый","Тёмно-озовый","Красный","Оранжевый","Жёлтый"});
        fColors.setBounds(800,400,100,70);
        Color[] FlowersColor = {
                new Color(120,20,140),
                new Color(0,60,200),
                new Color(20,200,200),
                new Color(150,200,200),
                new Color(200,200,200),
                new Color(200,150,200),
                new Color(180,70,170),
                new Color(170,20,140),
                new Color(130,0,0),
                new Color(190,70,0),
                new Color(150,140,10),
        };

        JComboBox<String> rootType = new JComboBox<>(new String[]{"Мочковатая","Стержневая","Корнеплод"});

        JButton generate = new JButton();
        generate.setBounds(800,800,80,80);
        generate.addActionListener(e -> {
            art.fillArt(Color.WHITE);
            Color F1 = FlowersColor[fColors.getSelectedIndex()];
            Color F2 = new Color(Math.clamp(F1.getRed()/4*3,0,255),
                    Math.clamp(F1.getGreen()/4*3,0,255),
                    Math.clamp(F1.getBlue()/4*3,0,255));

            Color F3 = new Color(Math.clamp(F1.getRed()/2,0,255),
                    Math.clamp(F1.getGreen()/2,0,255),
                    Math.clamp(F1.getBlue()/2,0,255));

            Color L1 = LeavesColor[lColors.getSelectedIndex()];
            Color L2 = new Color(Math.clamp(L1.getRed()/4*3,0,255),
                    Math.clamp(L1.getGreen()/4*3,0,255),
                    Math.clamp(L1.getBlue()/4*3,0,255));

            Color L3 = new Color(Math.clamp(L1.getRed()/2,0,255),
                    Math.clamp(L1.getGreen()/2,0,255),
                    Math.clamp(L1.getBlue()/2,0,255));

            Color __ = Color.WHITE;

            art.setArt(new Color[][]{
                    {__,__,__,__,__,__,__,__},
                    {__,__,__,F1,__,__,__,__},
                    {__,__,F1,F3,F2,__,__,__},
                    {__,__,__,F2,__,__,__,__},
                    {__,L1,__,L2,__,__,__,__},
                    {__,L2,L1,L2,__,__,__,__},
                    {__,__,L3,L2,L1,L2,__,__},
                    {__,__,__,L2,L3,__,__,__},
            });
            panel.repaint();
        });

        frame.add(panel);
        panel.setVisible(true);

        frame.add(generate);
        frame.add(lColors);
        frame.add(fColors);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
