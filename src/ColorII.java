import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class ColorII {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,800);

        AtomicReference<Color> color = new AtomicReference<>(new Color(0, 0, 0));

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(color.get());
                g.fillRect(0,0,frame.getWidth()/2,frame.getHeight()/2);
            }
        };
        panel.setBounds(frame.getWidth()/2,frame.getHeight()/2,frame.getWidth()/2,frame.getHeight()/2);

        JSlider red   = new JSlider(0, 255, 0);
        red.setBounds(0,0,frame.getWidth()/4*3,frame.getHeight()/2/3);
        red.setPaintTicks(true);
        red.setPaintLabels(true);
        red.setMinorTickSpacing(1);
        red.setMajorTickSpacing(15);

        JSlider green = new JSlider(0, 255, 0);
        green.setBounds(0,frame.getHeight()/2/3,frame.getWidth()/4*3,frame.getHeight()/2/3);
        green.setPaintTicks(true);
        green.setPaintLabels(true);
        green.setMinorTickSpacing(1);
        green.setMajorTickSpacing(15);

        JSlider blue  = new JSlider(0, 255, 0);
        blue.setBounds(0,frame.getHeight()/2/3*2,frame.getWidth()/4*3,frame.getHeight()/2/3);
        blue.setPaintTicks(true);
        blue.setPaintLabels(true);
        blue.setMinorTickSpacing(1);
        blue.setMajorTickSpacing(15);



        JTextField rValue = new JTextField(red  .getValue());
        rValue.setBounds(frame.getWidth()/4*3,0,frame.getWidth()/4,frame.getHeight()/2/3);

        JTextField gValue = new JTextField(green.getValue());
        gValue.setBounds(frame.getWidth()/4*3,frame.getHeight()/2/3,frame.getWidth()/4,frame.getHeight()/2/3);

        JTextField bValue = new JTextField(blue .getValue());
        bValue.setBounds(frame.getWidth()/4*3,frame.getHeight()/2/3*2,frame.getWidth()/4,frame.getHeight()/2/3);



        JButton showCol = new JButton("Show colors");
        showCol.setBounds(0,frame.getHeight()/2,frame.getWidth()/4,frame.getHeight()/2);
        showCol.addActionListener(e -> {
            rValue.setText(red.getValue()+"");
            gValue.setText(green.getValue()+"");
            bValue.setText(blue.getValue()+"");
        });


        JButton create = new JButton("create");
        create.setBounds(frame.getWidth()/4,frame.getHeight()/2,frame.getWidth()/4,frame.getHeight()/2);
        create.addActionListener(e -> {
            color.set(new Color(red.getValue(), green.getValue(), blue.getValue()));
            panel.repaint();
        });


        frame.add(red);
        frame.add(green);
        frame.add(blue);

        frame.add(rValue);
        frame.add(gValue);
        frame.add(bValue);

        frame.add(showCol);

        frame.add(create);

        frame.add(panel);
        panel.setVisible(true);

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
