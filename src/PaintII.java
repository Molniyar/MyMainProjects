import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintII {
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

                switch (e.getButton()){
                    case MouseEvent.BUTTON1 -> colors[x / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)] = keepColor[0];
                    case MouseEvent.BUTTON2 -> keepColor[0] = colors[x / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)];
                    case MouseEvent.BUTTON3 -> colors[x / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / colors.length)] = keepColor[1];
                }

                panel.updateUI();
            }
        });
    }
}
