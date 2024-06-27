import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RandomArtGame {
    public static void main(String[] args) {
        Color black = new Color(0,0,0);
        Color[][] colors = {
                {black,black,black,black,black,black,black,black},
                {black,black,black,black,black,black,black,black},
                {black,black,black,black,black,black,black,black},
                {black,black,black,black,black,black,black,black},
                {black,black,black,black,black,black,black,black},
                {black,black,black,black,black,black,black,black},
                {black,black,black,black,black,black,black,black},
                {black,black,black,black,black,black,black,black}
        };


        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,800);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < 8; i++){
                    for (int j = 0; j < 8; j++){
                        g.setColor(colors[i][j]);
                        g.fillRect(getWidth()/8 * i, getHeight()/8 * j, getWidth()/8, getHeight()/8);
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
                colors[x/(panel.getWidth()/8)][y/(panel.getHeight()/8)] = new Color(MolniyarMethod.randomNumber(0,255),MolniyarMethod.randomNumber(0,255),MolniyarMethod.randomNumber(0,255));
                panel.updateUI();
                if (KeyEvent.VK_SPACE == 20){
                    colors[MolniyarMethod.randomNumber(0,7)][MolniyarMethod.randomNumber(0,7)] = black;
                }
            }
        });
        panel.setFocusable(true); // Установите фокус на панель, чтобы она могла принимать ввод с клавиатуры

        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_SPACE) {
                    int randomX = MolniyarMethod.randomNumber(0, 7);
                    int randomY = MolniyarMethod.randomNumber(0, 7);
                    colors[randomX][randomY] = black;
                    panel.repaint(); // Перерисовать панель для отображения изменений
                }
            }
        });
    }
}
