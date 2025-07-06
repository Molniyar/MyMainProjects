import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Random;

public class SandSimulation extends JPanel implements ActionListener {
    static final int CELL_SIZE = 8;
    static final int WIDTH = 100;
    static final int HEIGHT = 100;

    static final int AIR = 0;
    static final int WATER = 1;
    static final int SAND = 2;
    static final int WET_SAND = 3;
    static final int CONCRETE = 4;
    static final int STEAM = 5;
    static final int HALF_WET_SAND = 6;
    static final int TREE_LOG = 7;
    static final int LEAVES = 8;
    static final int BIOMASS = 9;
    static final int MAGMA = 10;
    static final int STONE = 11;
    static final int FRUIT = 12;

    static int CHOSEN_BLOCK = 1;

    static boolean isUpdating = true;

    static final int[][] grid = new int[HEIGHT][WIDTH];
    static final boolean[][] updated = new boolean[HEIGHT][WIDTH];
    static final Random rand = new Random();

    static final Timer timer = new Timer(30, null);

    public SandSimulation() {
        setPreferredSize(new Dimension(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE));
        setBackground(Color.BLACK);

        SandSimulationWorldGenerator.generate(grid);

        // Управление мышью
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() / CELL_SIZE;
                int y = e.getY() / CELL_SIZE;
                if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        grid[y][x] = CHOSEN_BLOCK;
                    } else if (SwingUtilities.isRightMouseButton(e)) {
                        grid[y][x] = AIR;
                    } else {
                        CHOSEN_BLOCK = grid[y][x];
                    }
                }
            }
        });

        setFocusable(true); // Установите фокус на панель, чтобы она могла принимать ввод с клавиатуры
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_1 -> CHOSEN_BLOCK = 1;
                    case KeyEvent.VK_2 -> CHOSEN_BLOCK = 2;
                    case KeyEvent.VK_3 -> CHOSEN_BLOCK = 3;
                    case KeyEvent.VK_4 -> CHOSEN_BLOCK = 4;
                    case KeyEvent.VK_5 -> CHOSEN_BLOCK = 5;
                    case KeyEvent.VK_6 -> CHOSEN_BLOCK = 6;
                    case KeyEvent.VK_7 -> CHOSEN_BLOCK = 7;
                    case KeyEvent.VK_8 -> CHOSEN_BLOCK = 8;
                    case KeyEvent.VK_9 -> CHOSEN_BLOCK = 9;
                    case KeyEvent.VK_0 -> CHOSEN_BLOCK = 10;
                    case KeyEvent.VK_MINUS -> CHOSEN_BLOCK = 11;
                    case KeyEvent.VK_EQUALS -> CHOSEN_BLOCK = 12;
                    case KeyEvent.VK_SPACE -> {
                        isUpdating = !isUpdating;
                    }
                }
            }
        });

        timer.addActionListener(this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (grid[y][x] == FRUIT){
                    int X = x*CELL_SIZE;
                    int Y = y*CELL_SIZE;
                    g.setColor(new Color(137, 191, 22));
                    g.fillPolygon(new int[]{X,X,X+CELL_SIZE/2,X+CELL_SIZE,X+CELL_SIZE}, new int[]{Y+CELL_SIZE,Y+CELL_SIZE/2,Y,Y+CELL_SIZE/2,Y+CELL_SIZE/2}, 5);
                    g.setColor(new Color(37, 89, 38));
                    g.fillPolygon(new int[]{X+CELL_SIZE/2,X+CELL_SIZE/2,X+CELL_SIZE}, new int[]{Y+CELL_SIZE/2,Y,Y}, 3);
                    continue;
                }
                switch (grid[y][x]) {
                    case AIR -> g.setColor(Color.BLACK);
                    case WATER -> g.setColor(Color.BLUE);
                    case SAND -> g.setColor(new Color(194, 178, 128));
                    case HALF_WET_SAND -> g.setColor(new Color(160, 130, 90));
                    case WET_SAND -> g.setColor(new Color(124, 100, 67));
                    case CONCRETE -> g.setColor(Color.GRAY);
                    case STEAM -> g.setColor(new Color(200, 200, 255, 120));
                    case TREE_LOG -> g.setColor(new Color(76, 54, 26, 255));
                    case LEAVES -> g.setColor(new Color(18, 133, 24, 255));
                    case BIOMASS -> g.setColor(new Color(126, 93, 32, 255));
                    case MAGMA -> g.setColor(new Color(255, 106, 0, 255));
                    case STONE -> g.setColor(new Color(87, 87, 87, 255));
                }
                g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Сброс обработанных флагов
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                updated[y][x] = false;
            }
        }




        for (int y = HEIGHT - 1; y >= 0; y--) {
            if (!isUpdating){break;}
            for (int x = 0; x < WIDTH; x++) {
                if (updated[y][x]) continue;
                int cell = grid[y][x];
                switch (cell){
                    case WATER -> updateWater(x, y);
                    case SAND -> updateSand(x, y);
                    case WET_SAND -> updateWetSand(x, y);
                    case STEAM -> updateSteam(x, y);
                    case HALF_WET_SAND -> updateHalfWetSand(x, y);
                    case TREE_LOG -> updateLog(x, y);
                    case BIOMASS -> updateBioMass(x, y);
                    case LEAVES -> updateLeaves(x, y);
                    case CONCRETE -> updateConcrete(x, y);
                    case STONE -> updateStone(x, y);
                }
            }
        }

        repaint();
    }
    private void updateWater(int x, int y) {
        if (updated[y][x]) return;

        if (tryFall(x, y)) return;

        // Диагонали вниз
        boolean moved = false;
        if (rand.nextBoolean()) {
            moved = tryMove(x, y, x - 1, y + 1) || tryMove(x, y, x + 1, y + 1);
        } else {
            moved = tryMove(x, y, x + 1, y + 1) || tryMove(x, y, x - 1, y + 1);
        }
        if (moved) return;

        // В стороны (выравнивание)
        for (int dx = 1; dx <= 3; dx++) {
            if (tryMove(x, y, x - dx, y)) return;
            if (tryMove(x, y, x + dx, y)) return;
        }

        if (isInBounds(x, y + 1) && grid[y + 1][x] == SAND) {
            grid[y + 1][x] = WET_SAND;
            grid[y][x] = AIR;
            updated[y + 1][x] = true;
            updated[y][x] = true;
            return;
        }

        updated[y][x] = true; // если никуда не пошла, всё равно помечаем
    }

    private void updateSand(int x, int y) {
        if (tryFall(x, y)) return;

        boolean moved = rand.nextBoolean()
                ? tryMove(x, y, x - 1, y + 1) || tryMove(x, y, x + 1, y + 1)
                : tryMove(x, y, x + 1, y + 1) || tryMove(x, y, x - 1, y + 1);

        if (moved) return;

        if (isInBounds(x, y + 1) && grid[y + 1][x] == WATER) {
            grid[y + 1][x] = WET_SAND;
            grid[y][x] = AIR;

            updated[y + 1][x] = true;
            updated[y][x] = true;
            return;
        }
    }

    private void updateBioMass(int x, int y) {
        if (tryFall(x, y)) return;

        boolean moved = rand.nextBoolean()
                ? tryMove(x, y, x - 1, y + 1) || tryMove(x, y, x + 1, y + 1)
                : tryMove(x, y, x + 1, y + 1) || tryMove(x, y, x - 1, y + 1);

        if (moved) return;
    }

    private void updateWetSand(int x, int y) {
        if (MolniyarMethod.random(0.1)){
            if (tryPlace(STEAM,x,y-1)) {grid[y][x]=HALF_WET_SAND;return;}

            if (tryPlace(STEAM,x-1,y)) {grid[y][x]=HALF_WET_SAND;return;}
            if (tryPlace(STEAM,x+1,y)) {grid[y][x]=HALF_WET_SAND;return;}

            if (tryPlace(STEAM,x-1,y-1)) {grid[y][x]=HALF_WET_SAND;return;}
            if (tryPlace(STEAM,x+1,y-1)) {grid[y][x]=HALF_WET_SAND;return;}

            if (tryPlace(STEAM,x,y+1)) {grid[y][x]=HALF_WET_SAND;return;}

            if (tryPlace(STEAM,x-1,y+1)) {grid[y][x]=HALF_WET_SAND;return;}
            if (tryPlace(STEAM,x+1,y+1)) {grid[y][x]=HALF_WET_SAND;return;}
        }

        if (isInBounds(x,y+1)&&grid[y+1][x]==SAND&&MolniyarMethod.random(0.1)){grid[y][x]=HALF_WET_SAND;grid[y+1][x]=HALF_WET_SAND;return;}
        if (isInBounds(x+1,y)&&grid[y][x+1]==SAND&&MolniyarMethod.random(0.1)){grid[y][x]=HALF_WET_SAND;grid[y][x+1]=HALF_WET_SAND;return;}
        if (isInBounds(x-1,y)&&grid[y][x-1]==SAND&&MolniyarMethod.random(0.1)){grid[y][x]=HALF_WET_SAND;grid[y][x-1]=HALF_WET_SAND;return;}

        if (tryFall(x, y)) return;

        boolean moved = rand.nextBoolean()
                ? tryMove(x, y, x - 1, y + 1) || tryMove(x, y, x + 1, y + 1)
                : tryMove(x, y, x + 1, y + 1) || tryMove(x, y, x - 1, y + 1);
        if (moved) return;

        if (isInBounds(x+1,y)&&isInBounds(x-1,y)&&grid[y][x+1]!=AIR&&grid[y][x+1]!=WATER&&grid[y][x+1]!=STEAM&&grid[y][x-1]!=AIR&&grid[y][x-1]!=WATER&&grid[y][x-1]!=STEAM){return;}
        boolean moved_ = rand.nextBoolean()
                ? tryMove(x, y, x - 2, y+1) || tryMove(x, y, x + 2, y+1)
                : tryMove(x, y, x + 2, y+1) || tryMove(x, y, x - 2, y+1);
        if (moved_) return;
    }

    private void updateSteam(int x, int y) {
        if (MolniyarMethod.random(0.01)){grid[y][x]=WATER;return;}
        if (updated[y][x]) return;

        // Вверх
        if (tryMove(x, y, x, y - 1)) return;

        // Диагонали вверх
        boolean moved = rand.nextBoolean()
                ? tryMove(x, y, x - 1, y - 1) || tryMove(x, y, x + 1, y - 1)
                : tryMove(x, y, x + 1, y - 1) || tryMove(x, y, x - 1, y - 1);
        if (moved) return;

        // Горизонтальное растекание
        for (int dx = 1; dx <= 3; dx++) {
            if (tryMove(x, y, x - dx, y)) return;
            if (tryMove(x, y, x + dx, y)) return;
        }

        updated[y][x] = true;
    }

    private void updateLog(int x, int y) {
        if(MolniyarMethod.random(soilTypePercent(x,y+1))){grid[y][x] = BIOMASS;}

        if (MolniyarMethod.random(0.2)&&isInBounds(x,y-1)&&grid[y-1][x]==AIR){grid[y-1][x]=TREE_LOG;return;}
        if (MolniyarMethod.random(0.005)&&isInBounds(x+1,y)&&grid[y][x+1]==AIR&&grid[y+1][x+1]==AIR){grid[y][x+1]=TREE_LOG;return;}
        if (MolniyarMethod.random(0.005)&&isInBounds(x-1,y)&&grid[y][x-1]==AIR&&grid[y+1][x-1]==AIR){grid[y][x-1]=TREE_LOG;return;}

        if (MolniyarMethod.random(0.05)&&isInBounds(x,y-1)&&grid[y-1][x]==AIR){grid[y-1][x]=LEAVES;return;}
        if (MolniyarMethod.random(0.05)&&isInBounds(x+1,y)&&grid[y][x+1]==AIR&& (grid[y+1][x+1]==AIR||grid[y+1][x+1]==LEAVES)){grid[y][x+1]=LEAVES;return;}
        if (MolniyarMethod.random(0.05)&&isInBounds(x-1,y)&&grid[y][x-1]==AIR&& (grid[y+1][x-1]==AIR||grid[y+1][x-1]==LEAVES)){grid[y][x-1]=LEAVES;return;}

        updated[y][x] = true;
    }

    private void updateLeaves(int x, int y) {
        if (
                (!isInBounds(x+1,y+1)||(grid[y+1][x+1]!=TREE_LOG))&&
                (!isInBounds(x,y+1)||(grid[y+1][x]!=TREE_LOG))&&
                (!isInBounds(x-1,y+1)||(grid[y+1][x-1]!=TREE_LOG))&&
                (!isInBounds(x+1,y)||(grid[y][x+1]!=TREE_LOG))&&
                (!isInBounds(x-1,y)||(grid[y][x-1]!=TREE_LOG))&&
                (!isInBounds(x+1,y-1)||(grid[y-1][x+1]!=TREE_LOG))&&
                (!isInBounds(x,y-1)||(grid[y-1][x]!=TREE_LOG))&&
                (!isInBounds(x-1,y-1)||(grid[y-1][x-1]!=TREE_LOG))
        ) {grid[y][x]=BIOMASS;}
    }

    private void updateHalfWetSand(int x, int y) {
        if (MolniyarMethod.random(0.01) &&
                (
                        tryPlace(STEAM,x+1,y)||
                        tryPlace(STEAM,x-1,y)||
                        tryPlace(STEAM,x,y+1)||
                        tryPlace(STEAM,x,y-1)
                )
        ) {
            grid[y][x] = SAND;
            return;
        }
        if (y+1<HEIGHT&&(isInBounds(x+1,y+1)&&(grid[y+1][x+1]!=HALF_WET_SAND||grid[y][x+1]!=HALF_WET_SAND)) && (isInBounds(x-1,y+1)&&(grid[y+1][x-1]!=HALF_WET_SAND||grid[y][x-1]!=HALF_WET_SAND)) && (grid[y+1][x-1]!=HALF_WET_SAND||grid[y+1][x+1]!=HALF_WET_SAND) && (grid[y][x-1]!=HALF_WET_SAND||grid[y][x+1]!=HALF_WET_SAND)){
            if (tryFall(x, y)) return;
        }
        if (isInBounds(x,y+1)&&grid[y+1][x]==SAND&&MolniyarMethod.random(0.2)){grid[y][x]=SAND;grid[y+1][x]=HALF_WET_SAND;}
    }

    private void updateConcrete(int x, int y) {
        if (MolniyarMethod.random(0.001)) {grid[y][x] = HALF_WET_SAND;return;}
        if (y+1<HEIGHT&&(isInBounds(x+1,y+1)&&(grid[y+1][x+1]!=CONCRETE||grid[y][x+1]!=CONCRETE)) && (isInBounds(x-1,y+1)&&(grid[y+1][x-1]!=CONCRETE||grid[y][x-1]!=CONCRETE)) && (grid[y+1][x-1]!=CONCRETE||grid[y+1][x+1]!=CONCRETE) && (grid[y][x-1]!=CONCRETE||grid[y][x+1]!=CONCRETE)){
            if (tryFall(x, y)) return;
        }
        if (isInBounds(x,y+1)&&grid[y+1][x]==SAND&&MolniyarMethod.random(0.05)){grid[y][x]=SAND;grid[y+1][x]=CONCRETE;}
    }

    private void updateStone(int x, int y) {
        if (y+1<HEIGHT&&(isInBounds(x+1,y+1)&&(grid[y+1][x+1]!=STONE||grid[y][x+1]!=STONE)) && (isInBounds(x-1,y+1)&&(grid[y+1][x-1]!=STONE||grid[y][x-1]!=STONE)) && (grid[y+1][x-1]!=STONE||grid[y+1][x+1]!=STONE) && (grid[y][x-1]!=STONE||grid[y][x+1]!=STONE)){
            if (tryFall(x, y)) return;
        }
    }

    private boolean tryMove(int fromX, int fromY, int toX, int toY) {
        if (!isInBounds(toX, toY)) return false;
        if (updated[toY][toX]) return false;

        int fromType = grid[fromY][fromX];
        int toType = grid[toY][toX];

        if (canReplace(fromType, toType)) {
            moveParticle(fromX, fromY, toX, toY);
            return true;
        }

        //песок может замещать воду становясь мокрым песком
        if (fromType == SAND && toType == WATER) {
            grid[toY][toX] = WET_SAND;
            grid[fromY][fromX] = AIR;

            updated[toY][toX] = true;
            updated[fromY][fromX] = true;
            return true;
        }

        return false;
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
    }

    private void moveParticle(int fromX, int fromY, int toX, int toY) {
        int keep = grid[toY][toX];
        grid[toY][toX] = grid[fromY][fromX];
        grid[fromY][fromX] = keep;
        updated[toY][toX] = true;
        updated[fromY][fromX] = true;
    }

    boolean tryPlace(int type, int x, int y) {
        if (!isInBounds(x,y)){return false;}
        if (canReplace(type,grid[y][x])) {
            grid[y][x] = type;
            return true;
        }
        return false;
    }

    boolean canReplace(int fromType, int toType) {
        return switch (fromType) {
            case WET_SAND -> toType == STEAM || toType == AIR || toType == WATER;
            case HALF_WET_SAND -> toType == STEAM || toType == AIR || toType == WATER;
            case SAND  -> toType == STEAM || toType == AIR || toType == WATER;
            case WATER -> toType == STEAM || toType == AIR;
            case STEAM -> toType == AIR;
            case BIOMASS -> toType == AIR || toType == STEAM || toType == WATER;
            case CONCRETE -> toType == AIR || toType == STEAM || toType == WATER || toType == LEAVES;
            case STONE -> toType == AIR || toType == STEAM || toType == WATER || toType == LEAVES;
            default -> false;
        };
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sand & Water Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new SandSimulation());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    boolean tryFall(int x, int y) {
        if (y+1>=HEIGHT){return false;}
        if (!canReplace(grid[y][x], grid[y+1][x])){return false;}

        int keep = grid[y][x];
        grid[y][x] = grid[y+1][x];
        grid[y+1][x] = keep;

        return true;
    }
    double soilTypePercent(int x, int y) {
        if (!isInBounds(x,y)){return 100;}
        return switch (grid[y][x]){//100% - (rand(0-4) * 25%)
            case WATER -> 1;
            case SAND -> 0.01;
            case WET_SAND -> 0.01;
            case CONCRETE -> 1;
            case STEAM -> 100;
            case HALF_WET_SAND -> 0;
            case TREE_LOG -> 0;
            case LEAVES -> 0;
            case BIOMASS -> 0;
            default -> 100;
        };
    }
}