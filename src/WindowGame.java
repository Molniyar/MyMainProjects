import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class WindowGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        JFrame frame = new JFrame("BallGame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,600);

        JSlider m = new JSlider(1,2048);
        m.setBounds(20,20,frame.getWidth()/2,30);

        JSlider e = new JSlider(1,2048);
        e.setBounds(20,70,frame.getWidth()/2,30);


        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                for (int i = 0; i < 8; i++){
                    for (int j = 0; j < 8; j++){
                        //g.setColor();
                        //g.fillRect();
                    }
                }
            }
        };
        frame.add(panel);

        frame.add(m);
        frame.add(e);

        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        frame.setVisible(true);
    }
}