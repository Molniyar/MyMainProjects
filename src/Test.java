import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите секунды");
        int secondsIn = input.nextInt();
        secondsIn = Math.clamp(secondsIn, 0, 60);
        System.out.println("Введите минуты");
        int minutesIn = input.nextInt();
        secondsIn = Math.clamp(secondsIn, 0, 60);
        System.out.println("Введите часы");
        int hoursIn = input.nextInt();
        secondsIn = Math.clamp(secondsIn, 0, 24);
        int seconds = 0;
        int minutes = 0;
        int hours = 0;
        for (int i = 0; seconds < secondsIn || minutes < minutesIn || hours < hoursIn;){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            seconds++;
            if (seconds == 60){
                seconds = 0;
                minutes++;
            }
            if (minutes == 60){
                minutes = 0;
                hours++;
            }
            System.out.println(hours + ":" + minutes + ":" + seconds);
        }
    }
}