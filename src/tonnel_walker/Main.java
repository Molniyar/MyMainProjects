package tonnel_walker;

public class Main {
    public static final String STONE = "\u001B[48;5;238m";
    public static final String AIR = "\u001B[48;5;248m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        int[][] generation = new int[64][64];

        System.out.println("    ");
        for (int i = 0; i < generation.length; i++){
            for (int j = 0; j < generation.length; j++){
                int count = 0;
                if (generation[i][Math.clamp(j - 1, 0, generation.length - 1)] > 0){
                    count++;
                }
                if (generation[Math.clamp(i - 1, 0, generation.length - 1)][j] > 0) {
                    count++;
                }
                if (generation[Math.clamp(i - 1, 0, generation.length - 1)][Math.clamp(j + 1, 0, generation.length - 1)] > 0) {
                    count++;
                }//                               15           33
                //                                4            43
                //                                2            30
                if (MolniyarMethod.random(2 + (count * 31))){
                    generation[i][j] = 1;
                }
            }
        }
        print(generation);
    }
    public static void print(int[][] map) {
        for (int i = 0; i < map.length; i++){
            String print = "";
            for (int j = 0; j < map.length; j++){
                switch (map[i][j]){
                    case 0  -> print = print + STONE  + "   " + ANSI_RESET;
                    case 1  -> print = print + AIR + "   " + ANSI_RESET;
                }
            }
            System.out.println(print);
        }
    }
}
