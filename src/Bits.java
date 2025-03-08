import test1.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bits {
    public static void main(String[] args) {
        PixelArt art = new PixelArt(16, Color.black);

        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,800);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g = art.draw(g,0,0,800,800);
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

                if (art.getColor(x / (Math.min(panel.getWidth(),panel.getHeight()) / 8),y / (Math.min(panel.getWidth(),panel.getHeight()) / 8)) == Color.white)
                try {
                    switch (e.getButton()){
                        //case MouseEvent.BUTTON1 -> colors[x / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)] = keepColor[0];
                        //case MouseEvent.BUTTON2 -> keepColor[0] = colors[x / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)];
                        //case MouseEvent.BUTTON3 -> colors[x / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)] = keepColor[1];
                    }
                }catch (ArrayIndexOutOfBoundsException exception){
                    new PlaySound("1",1,500,20);
                }


                panel.updateUI();
            }
        });
    }
}
