import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class ElementCreator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,800,800);

        AtomicReference<Element> element = new AtomicReference<>(new Element(1, 1));

        Color[][] colors = new Color[8][8];
        for (int i = 0; i < colors.length; i++){
            for (int j = 0; j < colors.length; j++){
                colors[i][j] = new Color(255,255,255);
            }
        }

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int j = 0; j < colors.length; j++) {
                    for (int i = 0; i < colors.length; i++) {
                        int num = Math.min(getWidth(), getHeight());
                        int coordX = num / colors.length * i;
                        int coordY = num / colors.length * j;

                        int l = num / colors.length;

                        g.setColor(colors[i][j]);
                        g.fillRect(coordY, coordX, l, l);
                    }
                }
            }
        };
        panel.setBounds(340,340,400,400);

        JSlider mass = new JSlider(1, 2048, 1);
        mass.setBounds(20, 20, 500, 50);
        mass.setPaintTicks(true);
        mass.setPaintLabels(true);
        mass.setMinorTickSpacing(1);
        mass.setMajorTickSpacing(128); // Настроим разметку так, чтобы каждое 8е значение было отмечено

        JSlider energy = new JSlider(1, 2048, 1);
        energy.setBounds(20, 90, 500, 50);
        energy.setPaintTicks(true);
        energy.setPaintLabels(true);
        energy.setMinorTickSpacing(1);
        energy.setMajorTickSpacing(128); // Аналогично для второго слайдера

        frame.add(mass);
        frame.add(energy);

        JTextArea textField = new JTextArea("нет информации");
        textField.setBounds(20,280,300,300);
        frame.add(textField);

        JButton button = new JButton("Создать");
        button.addActionListener(e -> {
            for (int i = 0; i < colors.length; i++) {
                for (int j = 0; j < colors.length; j++) {
                    element.set(new Element(mass.getValue(), energy.getValue()));
                    OldPixelArt art = element.get().getArt();
                    colors[i][j] = MolniyarMethod.integerToColor(art.getColorCode(i,j));
                }
            }
            textField.setText(element.get().getElement());
            panel.updateUI();
        });

        button.setBounds(20,160,200,100);
        frame.add(button);

        frame.add(panel);
        panel.setVisible(true);

        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
