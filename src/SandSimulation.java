import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
enum direction {
    upper,lower,left,right;
}
record SSPoint(int x, int y) {}
public class SandSimulation extends JPanel implements ActionListener {
    static final int CELL_SIZE = 8;

    static final int SIZE = 100;

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
    static final int KELP = 13;
    static final int KELP_TOP = 14;
    static final int DETONATING_CRYSTAL = 15;
    static final int LAVA = 16;
    static final int HOT_STONE = 17;
    static final int DETONATED_CRYSTAL = 18;
    static final int ICE = 19;
    static final int ACID = 20;
    static final int IRON = 21;
    static final int HALF_RUSTED_IRON = 22;
    static final int RUSTED_IRON = 23;
    static final int RUST = 24;

    static final int ANY_BLOCK = -1;//

    static int CHOSEN_BLOCK = KELP;

    static final Image fruit_png;

    static {
        try {
            fruit_png = ImageIO.read(new File("C:\\Users\\Yar\\Pictures\\WS_fruit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int[] items = new int[17];

    static final int CREATIVE = 0;
    static final int SURVIVAL = 1;
    static int gamemode = CREATIVE;

    static boolean isUpdating = true;

    static final int[][] grid = new int[SIZE][SIZE];
    static final boolean[][] updated = new boolean[SIZE][SIZE];
    static final Random rand = new Random();

    static final Timer timer = new Timer(30, null);

    public SandSimulation() {
        setPreferredSize(new Dimension(SIZE * CELL_SIZE, SIZE * CELL_SIZE));
        setBackground(Color.BLACK);

        SandSimulationWorldGenerator.generate(grid, SIZE);

        // Управление мышью
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() / CELL_SIZE;
                int y = e.getY() / CELL_SIZE;
                if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
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
                    case KeyEvent.VK_1 -> CHOSEN_BLOCK = WATER;
                    case KeyEvent.VK_2 -> CHOSEN_BLOCK = SAND;
                    case KeyEvent.VK_3 -> CHOSEN_BLOCK = WET_SAND;
                    case KeyEvent.VK_4 -> CHOSEN_BLOCK = CONCRETE;
                    case KeyEvent.VK_5 -> CHOSEN_BLOCK = ICE;
                    case KeyEvent.VK_6 -> CHOSEN_BLOCK = STONE;
                    case KeyEvent.VK_7 -> CHOSEN_BLOCK = ACID;
                    case KeyEvent.VK_8 -> CHOSEN_BLOCK = MAGMA;
                    case KeyEvent.VK_9 -> CHOSEN_BLOCK = DETONATING_CRYSTAL;
                    case KeyEvent.VK_0 -> CHOSEN_BLOCK = LAVA;
                    case KeyEvent.VK_I -> CHOSEN_BLOCK = IRON;
                    case KeyEvent.VK_MINUS -> CHOSEN_BLOCK = 17;
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
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (grid[y][x] == FRUIT){
                    g.drawImage(fruit_png, x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE, this);
                    continue;
                }
                switch (grid[y][x]) {
                    case AIR -> g.setColor(new Color(1,1,1,0)/*Color.BLACK*/);
                    case WATER -> g.setColor(Color.BLUE);
                    case SAND -> g.setColor(new Color(194, 178, 128));
                    case HALF_WET_SAND -> g.setColor(new Color(160, 130, 90));
                    case WET_SAND -> g.setColor(new Color(124, 100, 67));
                    case CONCRETE -> g.setColor(Color.GRAY);
                    case STEAM -> g.setColor(new Color(200, 200, 255, 120));
                    case TREE_LOG -> g.setColor(new Color(76, 54, 26, 255));
                    case LEAVES -> g.setColor(new Color(18, 133, 24, 255));
                    case BIOMASS -> g.setColor(new Color(126, 93, 32, 255));
                    case MAGMA -> g.setColor(new Color(255, 77, 0, 255));
                    case STONE -> g.setColor(new Color(87, 87, 87, 255));
                    case KELP -> g.setColor(new Color(0, 94, 19, 255));
                    case KELP_TOP -> g.setColor(new Color(10, 69, 0, 255));
                    case DETONATING_CRYSTAL -> g.setColor(new Color(186, 0, 255));
                    case LAVA -> g.setColor(new Color(255, 128, 0));
                    case HOT_STONE -> g.setColor(new Color(113, 32, 32));
                    case DETONATED_CRYSTAL -> g.setColor(Color.WHITE);
                    case ICE -> g.setColor(new Color(59, 196, 255));
                    case ACID -> g.setColor(new Color(0, 255, 0));
                    case IRON -> g.setColor(new Color(150, 150, 150));
                    case HALF_RUSTED_IRON -> g.setColor(new Color(133, 116, 107));
                    case RUSTED_IRON -> g.setColor(new Color(110, 80, 58));
                    case RUST -> g.setColor(new Color(113, 43, 13));
                }
                g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Сброс обработанных флагов
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                updated[y][x] = false;
            }
        }



        for (int y = SIZE - 1; y >= 0; y--) {
            if (!isUpdating){break;}
            for (int x = 0; x < SIZE; x++) {
                if (updated[y][x]) continue;
                int cell = grid[y][x];
                switch (cell){
                    case WATER -> updateWater(x, y);
                    case SAND -> {
                        updateSand(x, y);
                        sand(x,y,1);
                    }
                    case WET_SAND -> {
                        updateWetSand(x, y);
                        sand(x, y, 2);
                    }
                    case STEAM -> updateSteam(x, y);
                    case HALF_WET_SAND -> updateHalfWetSand(x, y);
                    case TREE_LOG -> {
                        updateLog(x, y);
                    }
                    case BIOMASS -> sand(x, y,1);
                    case LEAVES -> {
                        updateLeaves(x, y);
                    }
                    case CONCRETE -> updateConcrete(x, y);
                    case STONE -> {
                        change_blocks_around(x,y,0.5,8,HOT_STONE,MAGMA,HOT_STONE);
                        concrete(x, y, STONE);
                    }
                    case KELP -> {
                        updateKelp(x,y);
                        grow(x,y,0.02,0,0,KELP_TOP,AIR,AIR,WATER);
                        grow(x,y,0.1,0,0,KELP,AIR,AIR,WATER);
                    }
                    case KELP_TOP -> {
                        updateKelp(x,y);
                    }
                    case LAVA -> {
                        change_blocks_around(x,y,100,10,MAGMA,ICE,WATER);
                        change_blocks_around(x,y,100,5,MAGMA,WATER,STEAM);
                        change_blocks_around(x,y,10,5,MAGMA,STONE,HOT_STONE);

                        change_blocks_around(x,y,100,0,MAGMA,LEAVES,BIOMASS);

                        liquid(x,y,20);
                    }
                    case MAGMA -> {
                        change_blocks_around(x,y,15,2,HOT_STONE,ICE,WATER);
                        change_blocks_around(x,y,20,1,HOT_STONE,WATER,STEAM);

                        change_blocks_around(x,y,70,0,HOT_STONE,LEAVES,BIOMASS);

                        concrete(x,y,MAGMA);
                    }
                    case HOT_STONE -> {
                        change_blocks_around(x,y,5,1,STONE,ICE,WATER);
                        change_blocks_around(x,y,5,0.5,STONE,WATER,STEAM);
                        change_blocks_around(x,y,2,4,MAGMA,LAVA,MAGMA);

                        change_blocks_around(x,y,10,0,STONE,LEAVES,FRUIT);
                        change_blocks_around(x,y,50,0,STONE,LEAVES,BIOMASS);

                        concrete(x,y,HOT_STONE);
                    }
                    case ICE -> {
                        change_blocks_around(x,y,10,0.5,WATER,STEAM,WATER);
                        concrete(x,y,ICE);
                        updateIce(x,y);
                    }
                    case DETONATED_CRYSTAL -> {
                        if (MolniyarMethod.random(50))explode(x, y, DETONATING_CRYSTAL, AIR, 0);
                    }
                    case DETONATING_CRYSTAL -> {
                        detonatingMaterial(x,y,new int[] {LAVA,MAGMA,HOT_STONE,STEAM}, new double[] {10,2,0.1,0.01}, AIR);
                        sand(x, y,1);
                    }
                    case FRUIT -> {
                        if (isInBounds(x,y)&&grid[y-1][x]==AIR&&MolniyarMethod.random(0.01))grid[y][x] = TREE_LOG;
                        sand(x, y,1);
                    }
                    case ACID -> {
                        change_blocks_around(x,y,1,0,AIR,IRON,HALF_RUSTED_IRON);
                        change_blocks_around(x,y,1,0,AIR,HALF_RUSTED_IRON,RUSTED_IRON);
                        change_blocks_around(x,y,1,0,AIR,RUSTED_IRON,RUST);
                        change_blocks_around(x,y,20,0,AIR,BIOMASS,STEAM);
                        change_blocks_around(x,y,20,0,AIR,LEAVES,BIOMASS);
                        change_blocks_around(x,y,20,0,AIR,TREE_LOG,BIOMASS);
                        liquid(x,y,80);
                    }
                    case IRON -> {
                        concrete(x,y,IRON);
                    }
                    case HALF_RUSTED_IRON -> {
                        concrete(x,y,HALF_RUSTED_IRON);
                    }
                    case RUSTED_IRON -> {
                        sand(x,y,0);
                    }
                    case RUST -> {
                        sand(x,y,1);
                    }
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
        for (int dx = 1; dx <= 2; dx++) {
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
        /*
        if (tryFall(x, y)) return;

        boolean moved = rand.nextBoolean()
                ? tryMove(x, y, x - 1, y + 1) || tryMove(x, y, x + 1, y + 1)
                : tryMove(x, y, x + 1, y + 1) || tryMove(x, y, x - 1, y + 1);
        /*/
        if (isInBounds(x, y + 1) && grid[y + 1][x] == WATER) {
            grid[y + 1][x] = WET_SAND;
            grid[y][x] = AIR;

            updated[y + 1][x] = true;
            updated[y][x] = true;
            return;
        }

        //if (moved) return;
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

        /*if (tryFall(x, y)) return;

        boolean moved = rand.nextBoolean()
                ? tryMove(x, y, x - 1, y + 1) || tryMove(x, y, x + 1, y + 1)
                : tryMove(x, y, x + 1, y + 1) || tryMove(x, y, x - 1, y + 1);
        if (moved) return;

        if (isInBounds(x+1,y)&&isInBounds(x-1,y)&&grid[y][x+1]!=AIR&&grid[y][x+1]!=WATER&&grid[y][x+1]!=STEAM&&grid[y][x-1]!=AIR&&grid[y][x-1]!=WATER&&grid[y][x-1]!=STEAM){return;}
        boolean moved_ = rand.nextBoolean()
                ? tryMove(x, y, x - 2, y+1) || tryMove(x, y, x + 2, y+1)
                : tryMove(x, y, x + 2, y+1) || tryMove(x, y, x - 2, y+1);
        //if (moved_) return;//*/
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
        for (int dx = 1; dx <= 2; dx++) {
            if (tryMove(x, y, x - dx, y)) return;
            if (tryMove(x, y, x + dx, y)) return;
        }

        updated[y][x] = true;
    }

    private void updateLog(int x, int y) {
        if(MolniyarMethod.random(soilTypePercent(x,y+1))){grid[y][x] = BIOMASS;}
        tryMove(x,y,x,y+1);

        if (MolniyarMethod.random(0.2)&&isInBounds(x,y-1)&&grid[y-1][x]==AIR){grid[y-1][x]=TREE_LOG;return;}
        if (MolniyarMethod.random(0.01)&&isInBounds(x+1,y)&&grid[y][x+1]==AIR&&grid[y+1][x+1]==AIR){grid[y][x+1]=TREE_LOG;return;}
        if (MolniyarMethod.random(0.01)&&isInBounds(x-1,y)&&grid[y][x-1]==AIR&&grid[y+1][x-1]==AIR){grid[y][x-1]=TREE_LOG;return;}

        if (MolniyarMethod.random(0.05)&&isInBounds(x,y-1)&&grid[y-1][x]==AIR){grid[y-1][x]=LEAVES;return;}
        if (MolniyarMethod.random(0.05)&&isInBounds(x+1,y)&&grid[y][x+1]==AIR&& (grid[y+1][x+1]==AIR||grid[y+1][x+1]==LEAVES)){grid[y][x+1]=LEAVES;return;}
        if (MolniyarMethod.random(0.05)&&isInBounds(x-1,y)&&grid[y][x-1]==AIR&& (grid[y+1][x-1]==AIR||grid[y+1][x-1]==LEAVES)){grid[y][x-1]=LEAVES;return;}

        updated[y][x] = true;
    }

    private void updateKelp(int x, int y) {
        if (!isInBounds(x,y+1)||(grid[y+1][x]!=WET_SAND&&grid[y+1][x]!=KELP)){grid[y][x] = WATER;}

        updated[y][x] = true;
    }

    private void updateIce(int x, int y) {
        //if (isInBounds(x,y-1)&&grid[y-1][x]==WATER){grid[y][x]=WATER;grid[y-1][x]=ICE;}
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
        ) {grid[y][x]=MolniyarMethod.random(10)?FRUIT:BIOMASS;}
    }

    private void updateHalfWetSand(int x, int y) {
        if (MolniyarMethod.random(0.01)) {
            boolean placed_steam = false;
            if (tryPlace(STEAM,x+1,y)){placed_steam = true;}
            else if (tryPlace(STEAM,x-1,y)) {placed_steam = true;}
            else if (tryPlace(STEAM,x,y+1)) {placed_steam = true;}
            else if (tryPlace(STEAM,x,y-1)) {placed_steam = true;}
            if (placed_steam) {
                grid[y][x] = SAND;
                return;
            }
        }
        if (y+1<SIZE&&(isInBounds(x+1,y+1)&&(grid[y+1][x+1]!=HALF_WET_SAND||grid[y][x+1]!=HALF_WET_SAND)) && (isInBounds(x-1,y+1)&&(grid[y+1][x-1]!=HALF_WET_SAND||grid[y][x-1]!=HALF_WET_SAND)) && (grid[y+1][x-1]!=HALF_WET_SAND||grid[y+1][x+1]!=HALF_WET_SAND) && (grid[y][x-1]!=HALF_WET_SAND||grid[y][x+1]!=HALF_WET_SAND)){
            if (tryFall(x, y)) return;
        }
        if (isInBounds(x,y+1)&&grid[y+1][x]==SAND&&MolniyarMethod.random(0.2)){grid[y][x]=SAND;grid[y+1][x]=HALF_WET_SAND;}
    }

    private void updateConcrete(int x, int y) {
        if (MolniyarMethod.random(0.0005)) {grid[y][x] = HALF_WET_SAND;return;}

        if (y+1<SIZE&&(isInBounds(x+1,y+1)&&(grid[y+1][x+1]!=CONCRETE||grid[y][x+1]!=CONCRETE)) && (isInBounds(x-1,y+1)&&(grid[y+1][x-1]!=CONCRETE||grid[y][x-1]!=CONCRETE)) && (grid[y+1][x-1]!=CONCRETE||grid[y+1][x+1]!=CONCRETE) && (grid[y][x-1]!=CONCRETE||grid[y][x+1]!=CONCRETE)){
            if (tryFall(x, y)) return;
        }
        if (isInBounds(x,y+1)&&grid[y+1][x]==SAND&&MolniyarMethod.random(0.05)){grid[y][x]=SAND;grid[y+1][x]=CONCRETE;}
    }
//attributes
    private void concrete(int x, int y, int material) {
        int currBlock = grid[y][x];
        if (y+1<SIZE&&(isInBounds(x+1,y+1)&&(grid[y+1][x+1]!=material||grid[y][x+1]!=material)) && (isInBounds(x-1,y+1)&&(grid[y+1][x-1]!=material||grid[y][x-1]!=material)) && (grid[y+1][x-1]!=material||grid[y+1][x+1]!=material) && (grid[y][x-1]!=material||grid[y][x+1]!=material)){
            if (tryFall(x, y)) return;
        }
        updated[y][x] = true;
    }
    private void sand(int x, int y, int sandness) {
        if (tryFall(x, y)) return;

        int currBlock = grid[y][x];

        for (int i = 1; i <= sandness; i++){
            int allow = 0;
            if (isInBounds(x-i,y+1)&&canReplace(currBlock,grid[y+1][x-i])) {
                if (!canReplace(currBlock,grid[y][x-i]))return;
                allow |= 1;
            }
            if (isInBounds(x+i,y+1)&&canReplace(currBlock,grid[y+1][x+i])) {
                if (!canReplace(currBlock,grid[y][x+i]))return;
                allow |= 2;
            }
            switch(allow){
                case 0 -> {continue;}
                case 1 -> {grid[y][x] = grid[y+1][x-i]; grid[y+1][x-i] = currBlock;}
                case 2 -> {grid[y][x] = grid[y+1][x+i]; grid[y+1][x+i] = currBlock;}
                case 3 -> {
                    if (rand.nextBoolean()){grid[y][x] = grid[y+1][x-i]; grid[y+1][x-i] = currBlock;}
                    else                   {grid[y][x] = grid[y+1][x+i]; grid[y+1][x+i] = currBlock;}}
            }
            if (allow!=0){
                break;
            }
        }
    }
    private void liquid(int x, int y, double speed) {
        if (updated[y][x]) return;

        if (tryFall(x, y)) return;

        if (MolniyarMethod.random(100.0-speed)){
            return;
        }

        // Диагонали вниз
        boolean moved = false;
        if (rand.nextBoolean()) {
            moved = tryMove(x, y, x - 1, y + 1) || tryMove(x, y, x + 1, y + 1);
        } else {
            moved = tryMove(x, y, x + 1, y + 1) || tryMove(x, y, x - 1, y + 1);
        }
        if (moved) return;

        // В стороны (выравнивание)
        for (int dx = 1; dx <= 2; dx++) {
            if (tryMove(x, y, x - dx, y)) return;
            if (tryMove(x, y, x + dx, y)) return;
        }

        updated[y][x] = true; // если никуда не пошла, всё равно помечаем
    }
    private void gas(int x, int y) {
        int currBlock = grid[y][x];
        if (y+1<SIZE&&(isInBounds(x+1,y+1)&&(grid[y+1][x+1]!=currBlock||grid[y][x+1]!=currBlock)) && (isInBounds(x-1,y+1)&&(grid[y+1][x-1]!=currBlock||grid[y][x-1]!=currBlock)) && (grid[y+1][x-1]!=currBlock||grid[y+1][x+1]!=currBlock) && (grid[y][x-1]!=currBlock||grid[y][x+1]!=currBlock)){
            if (tryFall(x, y)) return;
        }
    }
    private void change_blocks_around(int x, int y, double chance_to_change, double chance_to_self_change, int self_next_block, int from_block, int to_block) {
        int currBlock = grid[y][x];
        if (isInBounds(x,y+1) && grid[y+1][x] == from_block && MolniyarMethod.random(chance_to_change)){grid[y+1][x] = to_block;if (MolniyarMethod.random(chance_to_self_change)){grid[y][x] = self_next_block;}}
        if (isInBounds(x,y-1) && grid[y-1][x] == from_block && MolniyarMethod.random(chance_to_change)){grid[y-1][x] = to_block;if (MolniyarMethod.random(chance_to_self_change)){grid[y][x] = self_next_block;}}
        if (isInBounds(x+1,y) && grid[y][x+1] == from_block && MolniyarMethod.random(chance_to_change)){grid[y][x+1] = to_block;if (MolniyarMethod.random(chance_to_self_change)){grid[y][x] = self_next_block;}}
        if (isInBounds(x-1,y) && grid[y][x-1] == from_block && MolniyarMethod.random(chance_to_change)){grid[y][x-1] = to_block;if (MolniyarMethod.random(chance_to_self_change)){grid[y][x] = self_next_block;}}
    }

    private void change_and_place(int x, int y, boolean check_angles, double chance_to_self_change, int number_of_blocks, int self_next_block, int from_block, int to_block) {
        int currBlock = grid[y][x];//not done yet
        int[] free_space = new int[check_angles?8:4];
        int blocks_can_place = 0;
        if (isInBounds(x,y+1) && grid[y+1][x] == from_block && MolniyarMethod.random(0)){grid[y+1][x] = to_block;if (MolniyarMethod.random(chance_to_self_change)){grid[y][x] = self_next_block;}}
        if (isInBounds(x,y-1) && grid[y-1][x] == from_block && MolniyarMethod.random(0)){grid[y-1][x] = to_block;if (MolniyarMethod.random(chance_to_self_change)){grid[y][x] = self_next_block;}}
        if (isInBounds(x+1,y) && grid[y][x+1] == from_block && MolniyarMethod.random(0)){grid[y][x+1] = to_block;if (MolniyarMethod.random(chance_to_self_change)){grid[y][x] = self_next_block;}}
        if (isInBounds(x-1,y) && grid[y][x-1] == from_block && MolniyarMethod.random(0)){grid[y][x-1] = to_block;if (MolniyarMethod.random(chance_to_self_change)){grid[y][x] = self_next_block;}}
    }

    private void grow(int x, int y, double spread_up_chance, double spread_sides_chance, double spread_upper_sides_chance, int up_block, int sides_block, int upper_sides_block, int block_spread_on) {
        if (isInBounds(x,y-1) && grid[y-1][x] == block_spread_on && MolniyarMethod.random(spread_up_chance)){grid[y-1][x] = up_block;}
        if (isInBounds(x+1,y) && grid[y][x+1] == block_spread_on && MolniyarMethod.random(spread_sides_chance)){grid[y][x+1] = sides_block;}
        if (isInBounds(x-1,y) && grid[y][x-1] == block_spread_on && MolniyarMethod.random(spread_sides_chance)){grid[y][x-1] = sides_block;}
        if (isInBounds(x+1,y-1) && grid[y][x+1] == block_spread_on && MolniyarMethod.random(spread_upper_sides_chance)){grid[y][x+1] = upper_sides_block;}
        if (isInBounds(x-1,y-1) && grid[y][x-1] == block_spread_on && MolniyarMethod.random(spread_upper_sides_chance)){grid[y][x-1] = upper_sides_block;}
    }

    private void detonatingMaterial(int x, int y, int[] triggers, double[] chances, int replace) {
        int currBlock = grid[y][x];
        for (int i = 0; i < triggers.length; i++){
            double chance = 0;
            if (isInBounds(x,y+1) && grid[y+1][x] == triggers[i]){chance+=chances[i];}
            if (isInBounds(x,y-1) && grid[y-1][x] == triggers[i]){chance+=chances[i];}
            if (isInBounds(x+1,y) && grid[y][x+1] == triggers[i]){chance+=chances[i];}
            if (isInBounds(x-1,y) && grid[y][x-1] == triggers[i]){chance+=chances[i];}
            if (MolniyarMethod.random(chance) && isInBounds(x,y)){
                grid[y][x] = DETONATED_CRYSTAL;
            }
        }
    }
    private void explode(int x, int y, int self, int replace, int nExpl) {
        //MolniyarMethod.sleep(MolniyarMethod.randomNumber(20,60));
        explComp(x-1,y-2,self,replace,nExpl);
        explComp(x+0,y-2,self,replace,nExpl);
        explComp(x+1,y-2,self,replace,nExpl);
        explComp(x-2,y-1,self,replace,nExpl);
        explComp(x-1,y-1,self,replace,nExpl);
        explComp(x+0,y-1,self,replace,nExpl);
        explComp(x+1,y-1,self,replace,nExpl);
        explComp(x+2,y-1,self,replace,nExpl);
        explComp(x-2,y-0,self,replace,nExpl);
        explComp(x-1,y-0,self,replace,nExpl);
        explComp(x+0,y-0,self,replace,nExpl);
        explComp(x+1,y-0,self,replace,nExpl);
        explComp(x+2,y-0,self,replace,nExpl);
        explComp(x-2,y+1,self,replace,nExpl);
        explComp(x-1,y+1,self,replace,nExpl);
        explComp(x+0,y+1,self,replace,nExpl);
        explComp(x+1,y+1,self,replace,nExpl);
        explComp(x+2,y+1,self,replace,nExpl);
        explComp(x-1,y+2,self,replace,nExpl);
        explComp(x+0,y+2,self,replace,nExpl);
        explComp(x+1,y+2,self,replace,nExpl);
    }
    void explComp(int x, int y, int self, int replace, int nExpl){
        if (isInBounds(x,y)){
            updated[y][x] = true;
            if (grid[y][x]==self && nExpl < 100){
                grid[y][x] = DETONATED_CRYSTAL;
                return;
            }
            grid[y][x] = replace;
        }
    }

    boolean contains(int[] arr, int target) {
        for (int el : arr){
            if (el == target) return true;
        }
        return false;
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
            //updated[fromY][fromX] = true;
            return true;
        }

        return false;
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    private void moveParticle(int fromX, int fromY, int toX, int toY) {
        int keep = grid[toY][toX];
        grid[toY][toX] = grid[fromY][fromX];
        grid[fromY][fromX] = keep;
        updated[toY][toX] = true;
        updated[fromY][fromX] = true;
    }

    boolean tryPlace(int type, int x, int y) {
        if (!isInBounds(x, y)) {
            return false;
        }
        if (grid[y][x]==0/*canReplace(type, grid[y][x])*/) {
            grid[y][x] = type;
            return true;
        }
        return false;
    }

    boolean canReplace(int fromType, int toType) {
        return switch (fromType) {
            case WET_SAND -> toType == STEAM || toType == AIR || toType == WATER || toType == LAVA || toType == ACID;
            case HALF_WET_SAND -> toType == STEAM || toType == AIR || toType == WATER || toType == LAVA || toType == ACID;
            case SAND  -> toType == STEAM || toType == AIR || toType == WATER || toType == LAVA || toType == ACID;
            case STEAM  -> toType == AIR || toType == WATER || toType == ACID;
            case WATER -> toType == STEAM || toType == AIR;
            case BIOMASS -> toType == AIR || toType == STEAM || toType == WATER || toType == LAVA || toType == ACID;
            case CONCRETE -> toType == AIR || toType == STEAM || toType == WATER || toType == LEAVES || toType == LAVA || toType == ACID;
            case STONE -> toType == AIR || toType == STEAM || toType == WATER || toType == LEAVES || toType == LAVA || toType == ACID;
            case MAGMA -> toType == AIR || toType == STEAM || toType == WATER || toType == LEAVES || toType == LAVA || toType == ACID;
            case LAVA -> toType == AIR || toType == STEAM || toType == WATER || toType == ACID;
            case HOT_STONE -> toType == AIR || toType == STEAM || toType == WATER || toType == LAVA || toType == LEAVES || toType == ACID;
            case DETONATING_CRYSTAL -> toType == AIR || toType == STEAM || toType == WATER;
            case FRUIT -> toType == AIR || toType == STEAM || toType == WATER || toType == ACID;
            case ICE -> toType == AIR || toType == STEAM;
            default -> toType == AIR;
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
        if (y+1>=SIZE){return false;}
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
            case STEAM -> 10;
            case HALF_WET_SAND -> 0;
            case TREE_LOG -> 0;
            case LEAVES -> 0;
            case BIOMASS -> 0;
            case AIR -> 10;
            default -> 100;
        };
    }
}