import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Выберите сложность от 1 до 5: ");
        int level = input.nextInt();
        switch (level){
            case 1 -> veryEasy();
            case 2 -> easy();
            case 3 -> standart();
            case 4 -> hard();
            case 5 -> veryhard();
            default -> System.out.print("такой сложности не существует, выберите другую.");
        }
    }
    public static void veryEasy () {
        Scanner input = new Scanner(System.in);
        System.out.println("Вы выбрали очень легкий уровень сложности, вы должны отгодать число от 1 до 50 за 20 попыток");
        int min2 = 1;
        int max2 = 50;
        int x = min2 + (int) (Math.random() * (max2 - min2 + 1));
        int c = 0;
        while (c < 20) {
            int a1 = input.nextInt();
            if (x > a1)
                System.out.println("это число больше " + a1);
            else if (x < a1)
                System.out.println("это число меньше " + a1);
            else {
                System.out.print("Поздравляем, вы отгадали число!");
                break;
            }
            if (c == 19 && a1 != x)
                System.out.print("Вы проиграли.");
            c++;
        }
    }
    public static void easy () {
        Scanner input = new Scanner(System.in);
        System.out.println("Вы выбрали легкий уровень сложности, вы должны отгодать число от 1 до 100 за 20 попыток");
        int min2 = 1;
        int max2 = 100;
        int x = min2 + (int) (Math.random() * (max2 - min2 + 1));
        int c = 0;
        while (c < 20) {
            int a1 = input.nextInt();
            if (a1 > max2)
                System.out.println("слишком большое число");
            if (x > a1)
                System.out.println("это число больше " + a1);
            else if (x < a1)
                System.out.println("это число меньше " + a1);
            else {
                System.out.print("Поздравляем, вы отгадали число!");
                break;
            }
            if (c == 19 && a1 != x)
                System.out.print("Вы проиграли.");
            c++;
        }
    }
        public static void standart () {
            Scanner input = new Scanner(System.in);
            System.out.println("Вы выбрали стандартный уровень сложности, вы должны отгодать число от 1 до 100 за 10 попыток");
            int min2 = 1;
            int max2 = 100;
            int x = min2 + (int) (Math.random() * (max2 - min2 + 1));
            int c = 0;
            while (c < 10) {
                int a1 = input.nextInt();
                if (a1 > max2)
                    System.out.println("слишком большое число");
                if (x > a1)
                    System.out.println("это число больше " + a1);
                else if (x < a1)
                    System.out.println("это число меньше " + a1);
                else {
                    System.out.print("Поздравляем, вы отгадали число!");
                    break;
                }
                if (c == 9 && a1 != x)
                    System.out.print("Вы проиграли.");
                c++;
            }
        }
        public static void hard () {
            Scanner input = new Scanner(System.in);
            System.out.println("Вы выбрали сложный уровень сложности, вы должны отгодать число от 1 до 100 за 7 попыток");
            int min2 = 1;
            int max2 = 100;
            int x = min2 + (int) (Math.random() * (max2 - min2 + 1));
            int c = 0;
            while (c < 7) {
                int a1 = input.nextInt();
                if (a1 > max2)
                    System.out.println("слишком большое число");
                if (x > a1)
                    System.out.println("это число больше " + a1);
                else if (x < a1)
                    System.out.println("это число меньше " + a1);
                else {
                    System.out.print("Поздравляем, вы отгадали число!");
                    break;
                }
                if (c == 6 && a1 != x)
                    System.out.print("Вы проиграли.");
                c++;
            }
        }
        public static void veryhard () {
            Scanner input = new Scanner(System.in);
            System.out.println("Вы выбрали очень сложный уровень сложности, вы должны отгодать число от 1 до 1000 за 10 попыток");
            int min2 = 1;
            int max2 = 1000;
            int x = min2 + (int) (Math.random() * (max2 - min2 + 1));
            int c = 0;
            while (c < 7) {
                int a1 = input.nextInt();
                if (a1 > max2)
                    System.out.println("слишком большое число");
                if (x > a1)
                    System.out.println("это число больше " + a1);
                else if (x < a1)
                    System.out.println("это число меньше " + a1);
                else {
                    System.out.print("Поздравляем, вы отгадали число!");
                    break;
                }
                if (c == 6 && a1 != x)
                    System.out.print("Вы проиграли.");
                c++;
            }
        }
    }