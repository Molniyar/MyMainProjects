package test1;

import tonnel_walker.MolniyarMethod;

import javax.sound.sampled.*;
import javax.swing.*;

public class PlaySound extends JFrame {
    private static final int SAMPLE_RATE = 44100;
    private static final int BUFFER_SIZE = 4096;

    private boolean running = true;
    private SourceDataLine line;
    private JSlider frequencySlider;
    private JComboBox<String> waveTypeBox;



    public PlaySound(String type, int Time, double Frequency, int volume) {
        volume = Math.clamp(volume,0,100);
        // Инициализация аудио
        initAudio();
        // Запуск звука в фоновом потоке
        Thread audioThread = new Thread(this::generateSound);
        audioThread.start();
        waveType = type;
        time = Time;
        frequency = Frequency;
        Volume = volume;
    }
    String waveType;
    int time;
    double frequency;
    int Volume;

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
        while (time > 0) {
            for (int i = 0; i < buffer.length / 2; i++) {
                double sample= switch(waveType) {
                    case "1","Sine"     -> Math.sin(2 * Math.PI * phase); // Генерация синусоиды
                    case "2","Triangle" -> 2 * Math.abs(2 * (phase - Math.floor(phase + 0.5))) - 1; // Генерация треугольной волны
                    case "3","Pulse"    -> (phase-Math.floor(phase)<0.5)? -1:1; // Генерация прямоугольной волны
                    default -> 0;
                };
                sample *= ((double)(Volume))/100;

                // Увеличиваем фазу
                phase += frequency / SAMPLE_RATE;

                // Устанавливаем значение в буфере
                short value = (short) (sample * Short.MAX_VALUE);
                buffer[i * 2] = (byte) (value >> 8);
                buffer[i * 2 + 1] = (byte) value;
            }

            // Воспроизведение буфера
            line.write(buffer, 0, buffer.length);
            time--;
        }
    }

    private void updateFrequency() {
        // Обновление частоты (в данном случае просто вызов метод для актуальности)
    }
}

