import java.util.Scanner;

public class LegoAirplaneRules {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int redCount    = 0;
        int whiteCount  = 0;
        int greenCount  = 0;
        int orangeCount = 0;
        int yellowCount = 0;

        int blueCount = 0;

        for (int i = 0; i < 5; i++){
            System.out.println("Введите цвет или цифру в зависимости от цвета: нет цвета - 0, красный - 1, белый или голубой - 2, зелёный - 3, оранжевый - 4, жёлтый - 5");
            String s = input.nextLine();
            switch (s.trim()){
                case "1", "красный" -> redCount++;
                case "2", "белый", "голубой" -> whiteCount++;
                case "3", "зелёный" -> greenCount++;
                case "4", "оранжевый" -> orangeCount++;
                case "5", "жёлтый" -> yellowCount++;
                case "6", "синий" -> blueCount++;
            }

        }
        String out = "";
        if (redCount > 3){
            out = out + "неправильное обозночение: красных лампочек не должно быть больше 3-х.";
        }
        if (redCount == 0){
            out = out + "неправильное обозночение: должна быть хотя-бы одна красная лампочка.";
        }
        else if (greenCount == 1 && orangeCount == 1){
            out = out + "неправильное обозночение: зелёная и оранжевая лампочка несовместимы, для них есть своё обозначение: жёлтая лампочка. ";
        }
        else if (whiteCount > 3){
            out = out + "неправильное обозночение: белых или голубых лампочек не должно быть больше 2-х.";
        }
        else if (yellowCount > 1){
            out = out + "неправильное обозночение: жёлтых лампочек не должно быть больше 1, ";
        }
        else if (greenCount > 1){
            out = out + "неправильное обозночение: зелёных лампочек не должно быть больше 1, ";
        }
        else if (orangeCount > 1){
            out = out + "неправильное обозночение: оранжевых лампочек не должно быть больше 1, ";
        }
        else if (blueCount > 1){
            out = out + "неправильное обозночение: синих лампочек не должно быть больше 1, ";
        }
        else if (orangeCount + yellowCount + greenCount > 1){
            out = out + "неправильное обозночение: оранжевые, жёлтые и зелёные лампочки не могут быть размещены вместе.";
        }
        else {
            if (redCount > 0) {
                if (whiteCount + greenCount + orangeCount + yellowCount == 0) {
                    if (redCount < 3) {
                        out = out + "это вышка или небоскрёб";
                    } else if (redCount == 3) {
                        out = out + "это квадрокоптер";
                    }
                } else if (redCount < 3 && whiteCount > 0) {
                    out = out + "это самолёт ";
                    if (redCount == 2) {
                        if (whiteCount == 2) {
                            out = out + "спасательный, ";
                        } else out = out + "военный, ";
                    } else if (whiteCount == 2) {
                        out = out + "пассажирский, ";
                    }
                    if (greenCount == 1) {
                        out = out + "маленький, ";
                    }
                    if (whiteCount == 3){
                        out = out + "скоростной, ";
                    }
                    if (yellowCount > 0){
                        out = out + "скоростной, ";
                    }
                    if (blueCount > 0){
                        out = out + "сверхзвуковой, ";
                    }

                }
            }
        }
        System.out.print(out);

    }
}
