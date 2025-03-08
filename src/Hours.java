import java.util.Scanner;

public class Hours {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hours = 19;
        int minutes = 23;
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
