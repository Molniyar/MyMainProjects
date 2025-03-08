public class RandomGeneration {
    public static final String COLOR_FOR_TREE = "\u001B[38;5;022m";
    public static final String COLOR_FOR_FLOWERS = "\u001B[38;5;171m";
    public static final String LAND = "\u001B[48;5;034m";
    public static final String LAND_WITH_TREES = "\u001B[48;5;022m";
    public static final String LAVA = "\u001B[48;5;208m";
    public static final String SEA = "\u001B[48;5;021m";
    public static final String MUSHROOM_LAND = "\u001B[48;5;090m";
    public static final String MOUNTAIN_LAND = "\u001B[48;5;244m";
    public static final String SNOWY_MOUNTAIN_LAND = "\u001B[48;5;231m";
    public static final String BEACH = "\u001B[48;5;228m";

    public static final String ANSI_RESET = "\u001B[0m";

    public static String landWithTree = LAND + COLOR_FOR_TREE + " * " + ANSI_RESET;

    public static void main(String[] args) {
        int size = 80;

        int[][] generation = new int[size][size];
        print(generation);
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
                //                                2            31
                if (MolniyarMethod.random(2 + (count * 32))){
                    generation[i][j] = 1;
                }
            }
        }
        print(generation);
        System.out.println("    ");
        for (int i = 1; i < generation.length - 1; i++) {
            for (int j = 1; j < generation.length - 1; j++) {
                if (generation[i][j] == 0) {
                    int landCount = 0;
                    int landCount2 = 0;
                    int waterCount = 0;
                    int waterCount2 = 0;
                    if (generation[i][j + 1] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i + 1][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i][j - 1] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i - 1][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i + 1][j + 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i + 1][j - 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i - 1][j + 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i - 1][j - 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (landCount > 2) {
                        if (MolniyarMethod.random((landCount * 20) + (landCount2 * 10))) {
                            generation[i][j] = 1;
                        }
                    }
                }
                if (generation[i][j] == 1) {
                    int landCount = 0;
                    int landCount2 = 0;
                    int waterCount = 0;
                    int waterCount2 = 0;
                    if (generation[i][j + 1] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i + 1][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i][j - 1] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i - 1][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i + 1][j + 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i + 1][j - 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i - 1][j + 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i - 1][j - 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (waterCount == 4 && waterCount2 == 4) {
                        if (MolniyarMethod.random(2)) {
                            generation[i][j] = 3;
                        } else if (MolniyarMethod.random(100)) {
                            generation[i][j] = 0;
                        }
                    } else if (MolniyarMethod.random(waterCount * 15)) {
                        generation[i][j] = 2;
                    } else if (landCount == 4) {
                        if (MolniyarMethod.random(30)) {
                            generation[i][j] = 5;
                        }
                    }


                }


            }
        }
        print(generation);
        System.out.println("    ");
        for (int i = 1; i < generation.length - 1; i++) {
            for (int j = 1; j < generation.length - 1; j++) {
                if (generation[i][j] == 0) {
                    int landCount = 0;
                    int landCount2 = 0;
                    int waterCount = 0;
                    int waterCount2 = 0;
                    if (generation[i][j + 1] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i + 1][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i][j - 1] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i - 1][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i + 1][j + 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i + 1][j - 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i - 1][j + 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i - 1][j - 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (landCount > 2) {
                        if (MolniyarMethod.random((landCount * 20) + (landCount2 * 10))) {
                            generation[i][j] = 1;
                        }
                    }
                }
                if (generation[i][j] == 1) {
                    int landCount = 0;
                    int landCount2 = 0;
                    int landCount3 = 0;
                    if (generation[i][Math.clamp(j + 2, 0, generation.length - 1)] != 0) {
                        landCount3++;
                    }
                    if (generation[i][Math.clamp(j - 2, 0, generation.length - 1)] != 0) {
                        landCount3++;
                    }
                    if (generation[Math.clamp(i + 2, 0, generation.length - 1)][j] != 0) {
                        landCount3++;
                    }
                    if (generation[Math.clamp(i - 2, 0, generation.length - 1)][j] != 0) {
                        landCount3++;
                    }

                    int waterCount = 0;
                    int waterCount2 = 0;
                    if (generation[i][j + 1] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i + 1][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i][j - 1] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i - 1][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i + 1][j + 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i + 1][j - 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i - 1][j + 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (generation[i - 1][j - 1] == 0) {
                        waterCount2++;
                    } else landCount2++;
                    if (waterCount == 4 && waterCount2 == 4) {
                        if (MolniyarMethod.random(2)) {
                            generation[i][j] = 3;
                        } else if (MolniyarMethod.random(80)) {
                            generation[i][j] = 0;
                        }
                    } else if (MolniyarMethod.random(waterCount * 15)) {
                        generation[i][j] = 2;
                    } else if (landCount == 4) {
                        if (MolniyarMethod.random(40)) {
                            generation[i][j] = 5;
                        }
                    }
                    else if (landCount > 2){
                        if (MolniyarMethod.random(20)){
                            generation[i][j] = 8;
                        }
                    }
                    else if (landCount == 0){
                        if (MolniyarMethod.random(35)){
                            generation[i][j] = 0;
                        }
                    }
                    else if (landCount + landCount2 == 1){
                        if (MolniyarMethod.random(50)){
                            generation[i][j] = 0;
                        }
                    }
                    else if (landCount + landCount2 == 2){
                        if (MolniyarMethod.random(30)){
                            generation[i][j] = 0;
                        }
                    }
                    else if (landCount2 == 3 || landCount < 2){
                        if (MolniyarMethod.random(35)){
                            generation[i][j] = 0;
                        }
                    }

                    int treeCount = 0;
                    if (generation[i][j + 1] == 5){
                        treeCount++;
                    }
                    if (generation[i][j - 1] == 5){
                        treeCount++;
                    }
                    if (generation[i + 1][j] == 5){
                        treeCount++;
                    }
                    if (generation[i - 1][j] == 5){
                        treeCount++;
                    }
                    if (treeCount > 2){
                        if (MolniyarMethod.random(40 + (treeCount - 2) * 20)){
                            generation[i][j] = 9;
                        }
                    }

                }


            }
        }
        print(generation);
        System.out.println("    ");
        for (int i = 1; i < generation.length - 1; i++) {
            for (int j = 1; j < generation.length - 1; j++) {
                if (generation[i][j] == 2) {
                    int landCount = 0;
                    int landCount2 = 0;
                    int waterCount = 0;
                    int waterCount2 = 0;
                    if (generation[i][Math.clamp(j + 1, 0, generation.length)] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[Math.clamp(i + 1, 0, generation.length)][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i][j - 1] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (generation[i - 1][j] == 0) {
                        waterCount++;
                    } else landCount++;
                    if (landCount == 4) {
                        generation[i][j] = 1;
                    }
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
                    case 0  -> print = print + SEA  + "   " + ANSI_RESET;
                    case 1  -> print = print + LAND + "   " + ANSI_RESET;
                    case 2  -> print = print + BEACH + "   " + ANSI_RESET;
                    case 3  -> print = print + MUSHROOM_LAND + "   " + ANSI_RESET;
                    case 4  -> print = print + MOUNTAIN_LAND + "   " + ANSI_RESET;

                    case 5  -> print = print + landWithTree;
                    case 6  -> print = print + LAVA + "   " + ANSI_RESET;

                    case 7  -> print = print + SNOWY_MOUNTAIN_LAND + "   " + ANSI_RESET;
                    case 8  -> print = print + LAND + COLOR_FOR_FLOWERS + ":\"." + ANSI_RESET;
                    case 9  -> print = print + LAND_WITH_TREES + "   " + ANSI_RESET;

                }
            }
            System.out.println(print);
        }
    }
}
