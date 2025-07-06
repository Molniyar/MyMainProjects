public class SandSimulationWorldGenerator {
    public static void generate(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++){
            for (int j = 40; j < grid.length; j++){
                grid[j][i] = SandSimulation.WATER;
            }
        }

        for (int i = 0; i < grid[0].length; i++){
            for (int j = 50; j < grid.length; j++){
                grid[j][i] = SandSimulation.SAND;
            }
        }

        for (int i = 0; i < grid[0].length; i++){
            for (int j = 70; j < grid.length; j++){
                grid[j][i] = SandSimulation.HALF_WET_SAND;
            }
        }

        for (int i = 0; i < grid[0].length; i++){
            for (int j = 80; j < grid.length; j++){
                grid[j][i] = SandSimulation.STONE;
            }
        }
    }
}
