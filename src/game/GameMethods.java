package game;

import java.util.Scanner;

public class GameMethods {
    static boolean[] lockPicking(boolean[] code) {
        Scanner input = new Scanner(System.in);
        boolean[] result = new boolean[2];
        int count = 0;
        for (int i = 0; i < code.length; i++){
            String l = input.nextLine();
            boolean check;
            switch (l.charAt(0)){
                case '1' -> check = true;
                case '0' -> check = false;
                default -> System.out.println();
            }
        }
        return result;
    }
}
