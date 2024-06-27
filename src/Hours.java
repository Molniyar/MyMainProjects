import java.util.Scanner;

public class Hours {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hours = 7;
        int minutes = 7;
        for (;;){
            if (minutes == 60){
                minutes = 0;
                hours++;
            }
            System.out.println(hours+":"+minutes);
            MolniyarMethod.sleep(60000);
            minutes++;
        }
    }
}
