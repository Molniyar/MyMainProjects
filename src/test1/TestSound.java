package test1;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;

public class TestSound extends JFrame {
    private static final int SAMPLE_RATE = 44100;
    private static final int BUFFER_SIZE = 4096;

    private boolean running = true;
    private SourceDataLine line;
    private JSlider frequencySlider;
    private JComboBox<String> waveTypeBox;

    public TestSound() {
        // Создаем графический интерфейс
        setTitle("Audio Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Ползунок для управления частотой
        frequencySlider = new JSlider(JSlider.HORIZONTAL, 100, 2000, 440);
        frequencySlider.setMajorTickSpacing(500);
        frequencySlider.setMinorTickSpacing(50);
        frequencySlider.setPaintTicks(true);
        frequencySlider.setPaintLabels(true);

        // Выбор типа волны
        waveTypeBox = new JComboBox<>(new String[]{"Sine", "Triangle", "Pulse"});

        // Панель управления
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(new JLabel("Frequency: "), BorderLayout.WEST);
        controlPanel.add(frequencySlider, BorderLayout.CENTER);
        controlPanel.add(waveTypeBox, BorderLayout.EAST);

        // Добавляем панель управления к окну
        add(controlPanel, BorderLayout.NORTH);

        // Инициализация аудио
        initAudio();

        // Запуск звука в фоновом потоке
        Thread audioThread = new Thread(this::generateSound);
        audioThread.start();

        // Добавляем обработчик события изменения ползунка
        frequencySlider.addChangeListener(e -> updateFrequency());

        // Устанавливаем размер окна и показываем его
        setSize(400, 100);
        setVisible(true);
    }

    private void initAudio() {
        try {
            AudioFormat format = new AudioFormat(SAMPLE_RATE, 16, 1, true, true);
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format, BUFFER_SIZE);
            line.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void generateSound() {
        byte[] buffer = new byte[BUFFER_SIZE * 2];
        double phase = 0.0;

        while (running) {
            double frequency = frequencySlider.getValue();
            String waveType = (String) waveTypeBox.getSelectedItem();

            for (int i = 0; i < buffer.length / 2; i++) {
                double sample= switch(waveType) {
                    case "Sine"->Math.sin(2 * Math.PI * phase); // Генерация синусоиды
                    case "Triangle"-> 2 * Math.abs(2 * (phase - Math.floor(phase + 0.5))) - 1; // Генерация треугольной волны
                    case "Pulse" -> (phase-Math.floor(phase)<0.5)? -1:1; // Генерация прямоугольной волны
                    default -> 0;
                };

                // Увеличиваем фазу
                phase += frequency / SAMPLE_RATE;

                // Устанавливаем значение в буфере
                short value = (short) (sample * Short.MAX_VALUE);
                buffer[i * 2] = (byte) (value >> 8);
                buffer[i * 2 + 1] = (byte) value;
            }

            // Воспроизведение буфера
            line.write(buffer, 0, buffer.length);
        }
    }

    private void updateFrequency() {
        // Обновление частоты (в данном случае просто вызов метод для актуальности)
    }

    public static void main(String[] args) {
        new TestSound();
    }
}
