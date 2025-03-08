import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseMotionListener;

public class MouseDrawExample extends JPanel {
    private int mouseX = -1;
    private int mouseY = -1;

    public MouseDrawExample() {
        // Добавляем слушатель мыши для отслеживания перемещения
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Получаем координаты мыши
                mouseX = e.getX();
                mouseY = e.getY();
                // Перерисовываем панель
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Если координаты мыши заданы, рисуем квадрат
        if (mouseX != -1 && mouseY != -1) {
            g.setColor(Color.RED); // Устанавливаем цвет квадрата
            g.fillRect(mouseX - 10, mouseY - 10, 20, 20); // Рисуем квадрат размером 20x20
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Draw Example");
        MouseDrawExample panel = new MouseDrawExample();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
