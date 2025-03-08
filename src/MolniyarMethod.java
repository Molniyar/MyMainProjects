import javax.sound.sampled.*;
import java.awt.*;

public class MolniyarMethod {
    public static boolean random(int persent){return Math.random()<persent*.01;}
    public static String getColorText(String print, int textColor, int backgroundColor){
        boolean background = true;
        if (backgroundColor == -1){
            background = false;
        }
        else textColor = Math.clamp(textColor, 0, 255);

        String ANSI_RESET = "\u001B[0m";
        String text_color = "\u001B[38;5;" + Math.clamp(textColor, 0, 255) + "m";
        String background_color = "\u001B[48;5;" + Math.clamp(backgroundColor, 0, 255) + "m";

        if (!background){
            return text_color + print + ANSI_RESET;
        }
        else return  background_color + text_color + print + ANSI_RESET;
    }
    public static String getColorPixel(int r, int g, int b){
        return "\033[48;2;" + r +";" + g + ";" + b + "m" + "   " + "\u001B[0m";
    }
    public static String getRGBText(Color color, String text){
        return "\033[38;2;" + color.getRed() +";" + color.getGreen() + ";" + color.getBlue() + "m" + text + "\u001B[0m";
    }
    public static String getMixedColor(int r, int g, int b, int r2, int g2, int b2){
        return "\033[48;2;" + ((r + r2) / 2) +";" + ((g + g2) / 2) + ";" + ((b + b2) / 2) + "m" + "   " + "\u001B[0m";
    }
    public static void printRandom(){
        for (int i = 0; i < 64; i++){
            String print = "";
            for (int j = 0; j < 64; j++){
                int random = (int) (Math.random() * 3);
                switch (random){
                    case 0: {
                        if (MolniyarMethod.random(1)){
                            if (MolniyarMethod.random(1)){
                                print = print + MolniyarMethod.getColorText("   ", 0, 208);
                            }
                            else print = print + MolniyarMethod.getColorText("   ", 0, 51);
                        }
                        else print = print + MolniyarMethod.getColorText("   ", 0, 18);//21
                        break;
                    }
                    case 1: {
                        print = print + MolniyarMethod.getColorText("   ", 0, 88);//160
                        break;
                    }
                    case 2: {
                        print = print + MolniyarMethod.getColorText("   ", 0, 22);//34
                        break;
                    }
                }
            }
            System.out.println(print);
        }
    }
    public static void randomGeneration(int size){
        for (int i = 0; i < size; i++){
            StringBuilder print = new StringBuilder();
            for (int j = 0; j < size; j++){
                if (MolniyarMethod.random(3)){
                    if (MolniyarMethod.random(1)){
                        if (MolniyarMethod.random(1)){
                            if (MolniyarMethod.random(1)){
                                if (MolniyarMethod.random(1)){
                                    print.append(MolniyarMethod.getColorText("   ", 0, 200));
                                }
                                else print.append(MolniyarMethod.getColorText("   ", 0, 46));
                            }
                            else print.append(MolniyarMethod.getColorText("   ", 0, 208));
                        }
                        else print.append(MolniyarMethod.getColorText("   ", 0, 81));
                    }
                    else print.append(MolniyarMethod.getColorText("   ", 0, 231));
                }
                else print.append(MolniyarMethod.getColorText("   ", 0, 16));
            }
            System.out.println(print);
        }
    }
    public static int randomNumber(int min, int max){
        return min + (int) (Math.random() * (max - min + 1));
    }
    public static void fakeEnd(){
        System.out.println("Process finished with exit code 0");
    }
    public static void fakeException(String method){
        System.out.println(MolniyarMethod.getColorText("Exception in thread \""+method+"\" java.lang.ArithmeticException: / by zero",9,0));
        //
    }
    public static String diamond() {return "\uD83D\uDC8E";}
    public static String code(String s, int code) {
        if (code != 145820) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            switch (s.toLowerCase().charAt(i)){//☉  ᛚ  ⇂  ○   ⊡  ⍋   ↽   ᛋ   Ⰽ  ⊗  ᛝ
                case 'а' -> result.append("⍋");
                case 'б' -> result.append("」");
                case 'в' -> result.append("Ⰽ");
                case 'г' -> result.append("ⴴ");
                case 'д' -> result.append("ᛝ");
                case 'е' -> result.append("ᖷⲻ");
                case 'ё' -> result.append("ᖷⲻ");
                case 'ж' -> result.append("▽");
                case 'з' -> result.append("▽");
                case 'и' -> {
                    if (s.charAt(i+1) == 'й'){
                        result.append('_');
                    }
                    else result.append("⊡");
                }
                case 'й' -> result.append("☒");
                case 'к' -> result.append("Ǝ");
                case 'л' -> result.append("ᛋ");
                case 'м' -> result.append("ᒣ⟨");
                case 'н' -> result.append("Ⱎ");
                case 'о' -> result.append("⇂");
                case 'п' -> result.append("⟐");
                case 'р' -> result.append("ᛚ");
                case 'с' -> result.append("↽");
                case 'т' -> result.append("ⴳ");
                case 'у' -> result.append("○");
                case 'ф' -> result.append("У");
                case 'х' -> result.append("_");
                case 'ц' -> result.append("ʁ");
                case 'ч' -> result.append("ʁ");
                case 'ш' -> result.append("◁▷");
                case 'щ' -> result.append("◁▷");//◁▷
                case 'ъ' -> result.append("_");
                case 'ы' -> result.append("⊡");
                case 'ь' -> result.append("ᛧ");
                case 'э' -> result.append("⊗");
                case 'ю' -> result.append("⦺");
                case 'я' -> {
                    if (i > 0){
                        char c = s.charAt(i-1);
                        if (c!='б'&&c!='в'&&c!='г'&&c!='д'&&c!='ж'&&c!='з'&&c!='й'&&c!='к'&&c!='л'&&c!='м'&&c!='н'&&c!='п'&&c!='р'&&c!='с'&&c!='т'&&c!='ф'&&c!='х'&&c!='ц'&&c!='ч'&&c!='ш'&&c!='щ'&&c!='ь'){
                            result.append("☒");
                        }
                    }
                    if (i == 0){
                        result.append("☒");//☒⍋
                    }
                    result.append("⍋");
                }
                default -> result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
    public static String decode(String s, int code) {
        if (code != 145820) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){//☉  ᛚ  ⇂  ○   ⊡  ⍋   ↽   ᛋ   Ⰽ  ⊗  ᛝ  ʁ
                case '⍋' -> result.append("а");
                case '」' -> result.append("б");
                case 'Ⰽ' -> result.append("в");
                case 'ⴴ' -> result.append("г");
                case 'ᛝ' -> result.append("д");
                case 'ᖷ' -> {if (s.charAt(i+1) == 'ⲻ'){result.append('е');i++;}}
                //case 'ё' -> result.append("_");
                case '▽' -> result.append("ж");
                case '⊡' -> result.append("и");
                case '☒' -> {if (s.charAt(i+1) == '⍋'){result.append('я');i++;}else result.append("й");}
                case 'Ǝ' -> result.append("к");
                case 'ᛋ' -> result.append("л");
                case 'ᒣ' -> {if (s.charAt(i+1) == '⟨'){result.append("м");i++;}}
                case 'Ⱎ' -> result.append("н");
                case '⇂' -> result.append("о");
                case '⟐' -> result.append("п");
                case 'ᛚ' -> result.append("р");
                case '↽' -> result.append("с");
                case 'ⴳ' -> result.append("т");
                case '○' -> result.append("у");
                case 'У' -> result.append("ф");
                //case 'х' -> result.append("_");
                //case 'ц' -> result.append("_");
                case 'ʁ' -> result.append("ч");
                case '◁' -> {if (s.charAt(i+1) == '▷'){result.append("ш");i++;}else result.append("◁");}
                //case 'ъ' -> result.append("_");
                case 'ᛧ' -> result.append("ь");
                case '⊗' -> result.append("э");
                case '⦺' -> result.append("ю");
                default -> result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static Color integerToColor(int value){
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
        return color;
    }
}
