import java.awt.*;

public class Random {
    public static void main(String[] args) {
        int value = 18;//104
        int keep = value;
        if (value < 0 || value > 255) {
            throw new IllegalArgumentException("Value must be between 0 and 255");
        }

        // Массив с предопределенными цветами в палитре xterm-256color
        int[][] colors = {
                {0, 0, 0}, {255, 65, 65}, {45, 150, 45}, {128, 128, 0},
                {0, 0, 128}, {128, 0, 128}, {0, 128, 128}, {192, 192, 192},
                {128, 128, 128}, {255, 0, 0}, {0, 255, 0}, {255, 255, 0},
                {0, 0, 255}, {255, 0, 255}, {0, 255, 255}, {255, 255, 255}
        };

        // Определяем цвет в соответствии с переданным значением
        int[] rgb;
        if (value < 16) {
            rgb = colors[value];
        } else if (value < 232) {
            value -= 16;
            int r = (((value / 36) % 6) * 51) + 25;
            int g = (((value / 6) % 6) * 51) + 25;
            int b = ((value % 6) * 51) + 25;
            // Убеждаемся, что значения находятся в допустимом диапазоне
            r = Math.min(255, Math.max(0, r));
            g = Math.min(255, Math.max(0, g));
            b = Math.min(255, Math.max(0, b));
            rgb = new int[]{r, g, b};
        } else {
            int gray = ((value - 232) * 10) + 8 + 25;
            // Убеждаемся, что значения находятся в допустимом диапазоне
            gray = Math.min(255, Math.max(0, gray));
            rgb = new int[]{gray, gray, gray};
        }

        // Создаем цвет, используя полученные значения красного, зеленого и синего
        Color color = new Color(rgb[0], rgb[1], rgb[2]);
        System.out.println(keep);
        System.out.println(MolniyarMethod.getColorText("   ",0,keep));
        System.out.println(MolniyarMethod.getColorPixel(rgb[0], rgb[1], rgb[2]));
    }
}