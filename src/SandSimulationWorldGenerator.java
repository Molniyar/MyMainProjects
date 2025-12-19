import java.util.Arrays;

public class SandSimulationWorldGenerator {
    public static boolean isInBounds(int x, int y) {
        return x >= 0 && x < 100 && y >= 0 && y < 100;
    }
    public static void continueGrow(int x, int y,int[][] grid, int i) {
        if (isInBounds(x+1,y)&&grid[y][x+1]==SandSimulation.AIR&&(grid[y+1][x+1]==SandSimulation.AIR || grid[y+1][x+1]==SandSimulation.LEAVES)){grid[y][x+1]=SandSimulation.LEAVES;}
        if (isInBounds(x-1,y)&&grid[y][x-1]==SandSimulation.AIR&&(grid[y+1][x-1]==SandSimulation.AIR || grid[y+1][x-1]==SandSimulation.LEAVES)){grid[y][x-1]=SandSimulation.LEAVES;}
        if ((MolniyarMethod.random(25)||i>=10)&&i>3){
            grid[y-1][x] = SandSimulation.LEAVES;
        }
        else {
            grid[y - 1][x] = SandSimulation.TREE_LOG;
            continueGrow(x,y-1,grid,i+1);
        }
    }
    public static void growTree(int x, int y,int[][] grid) {
        grid[y - 1][x] = SandSimulation.TREE_LOG;
        continueGrow(x,y-1,grid,0);

    }
    public static void generate(int[][] grid, int l) {
        int[] depths = new int[l];
        depths[0] = 40;
        for (int i = 1; i < l; i++){
            depths[i] = DepthChangeChance(depths[i-1],50,50,1);
        }
        for (int i = l-1; i >= 0; i--) {
            int depth_ = depths[i];
            for (int j = depth_; j < l; j++) {
                grid[j][i] = SandSimulation.STONE;
            }
            for (int j = depth_; j < l && j < depth_+5; j++) {
                grid[j][i] = SandSimulation.SAND;
            }
            if (depth_<=50 && MolniyarMethod.random(40)){
                grid[depth_][i] = SandSimulation.BIOMASS;
                if (MolniyarMethod.random(20)){
                    growTree(i,depth_+1,grid);
                }
            }
            for (int j = 99; j < l; j++) {
                grid[j][i] = SandSimulation.LAVA;
            }
        }
        for (int i = l-1; i >= 0; i--) {
            for (int j = 50; j < l; j++) {
                if (grid[j][i] == SandSimulation.AIR) grid[j][i] = SandSimulation.WATER;
                if (grid[j][i] == SandSimulation.SAND) grid[j][i] = SandSimulation.WET_SAND;
            }
        }
        for (int i = l-1; i >= 0; i--) {
            if (grid[50][i] == SandSimulation.WATER && MolniyarMethod.random(50)) grid[50][i] = SandSimulation.ICE;
        }
    }
    public static int DepthChangeChance(int currentDepth, int targetHeight, int maxVariation, int maxHeightChange) {
        // Определяем возможное изменение высоты
        //int maxChange = maxHeightChange; // Максимальное изменение за шаг

        // Случайное изменение от -maxHeightChange до +maxHeightChange
        int change = (int)(Math.random() * (maxHeightChange * 2 + 1)) - maxHeightChange;

        // Склоняемся к целевой высоте (targetHeight)
        if (currentDepth < targetHeight - 5) {
            change += 1; // Больше шансов подняться
        } else if (currentDepth > targetHeight + 5) {
            change -= 1; // Больше шансов опуститься
        }

        // Ограничиваем изменение для плавности
        change = Math.max(-maxHeightChange, Math.min(maxHeightChange, change));

        int newDepth = currentDepth + change;

        // Ограничиваем общие пределы высоты
        newDepth = Math.max(targetHeight - maxVariation,
                Math.min(targetHeight + maxVariation, newDepth));

        return newDepth;
    }
}