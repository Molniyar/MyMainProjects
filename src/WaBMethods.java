import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WaBMethods {
    public static void generateCliffs(int[][] world,int set_block,int check_block,int startChance,int upperLefter,int upper,int upperRighter,int lefter,int righter,int downerLefter,int downer,int downerRighter){
        for (int i = 0; i < world.length; i++){
            for (int j = 0; j < world.length; j++){//will be useful for generation
                if (world[i][j] != 0){continue;}

                int percent = startChance;
                boolean existsUBlock = i>0;
                boolean existsLBlock = j>0;
                boolean existsRBlock = j!=world.length-1;
                boolean existsDBlock = i!=world.length-1;
                if (existsUBlock && existsLBlock && world[i-1][j-1]==check_block){percent+=upperLefter;}
                if (existsUBlock                 && world[i-1][j]  ==check_block){percent+=upper;}
                if (existsUBlock && existsRBlock && world[i-1][j+1]==check_block){percent+=upperRighter;}

                if (existsLBlock && world[i][j-1]==check_block){percent+=lefter;}
                if (existsRBlock && world[i][j+1]==check_block){percent+=righter;}

                if (existsDBlock && existsLBlock && world[i+1][j-1]==check_block){percent+=downerLefter;}
                if (existsDBlock                 && world[i+1][j]  ==check_block){percent+=downer;}
                if (existsDBlock && existsRBlock && world[i+1][j+1]==check_block){percent+=downerRighter;}

                if (MolniyarMethod.random(percent)){world[i][j] = set_block;}
            }
        }
    }
    public static void generateCliffs(int[][] world,int set_block,int check_block,int replaceBlock,int startChance,int upperLefter,int upper,int upperRighter,int lefter,int righter,int downerLefter,int downer,int downerRighter){
        for (int i = 0; i < world.length; i++){
            for (int j = 0; j < world.length; j++){//will be useful for generation
                if (world[i][j] != replaceBlock){continue;}

                int percent = startChance;
                boolean existsUBlock = i>0;
                boolean existsLBlock = j>0;
                boolean existsRBlock = j!=world.length-1;
                boolean existsDBlock = i!=world.length-1;
                if (existsUBlock && existsLBlock && world[i-1][j-1]==check_block){percent+=upperLefter;}
                if (existsUBlock                 && world[i-1][j]  ==check_block){percent+=upper;}
                if (existsUBlock && existsRBlock && world[i-1][j+1]==check_block){percent+=upperRighter;}

                if (existsLBlock && world[i][j-1]==check_block){percent+=lefter;}
                if (existsRBlock && world[i][j+1]==check_block){percent+=righter;}

                if (existsDBlock && existsLBlock && world[i+1][j-1]==check_block){percent+=downerLefter;}
                if (existsDBlock                 && world[i+1][j]  ==check_block){percent+=downer;}
                if (existsDBlock && existsRBlock && world[i+1][j+1]==check_block){percent+=downerRighter;}

                if (MolniyarMethod.random(percent)){world[i][j] = (byte) set_block;}
            }
        }
    }
    public static void throwBlocks(int[][] world,int block,int replaceable_block,int chance){
        for (int i = 0; i < world.length; i++){
            for (int j = 0; j < world.length; j++){//will be useful for generation
                if (world[i][j]!=replaceable_block){continue;}
                if (MolniyarMethod.random(chance)){world[i][j] = block;}
            }
        }
    }
    public static void generateTrees(int[][] world,int chance,int log, int leaves_block, int leaves){
        for (int i = 1; i < world.length-1; i++){
            for (int j = 1; j < world.length-1; j++){
                if (MolniyarMethod.random(chance)&&world[i][j]==0){
                    growTree(world,j,i,log,leaves_block,leaves);
                }
            }
        }
    }
    public static HashMap getItemsHashMap(){
        HashMap<String,Integer> names = new HashMap<>();
        names.put("oak_log",1);
        names.put("leaves_block",2);
        names.put("leaves",3);
        names.put("rocks",4);
        names.put("stone",5);
        names.put("magnetite",6);
        names.put("oak_planks",7);
        names.put("stick",8);
        names.put("apple",9);
        names.put("campfire",10);
        names.put("sapling",11);
        names.put("grass",12);
        names.put("iron_ore",13);
        names.put("iron_ingot",14);
        names.put("coal",15);
        names.put("torch",16);
        names.put("lanten",17);

        names.put("wooden_pickaxe",18);
        names.put("wooden_axe",19);

        names.put("stone_pickaxe",20);
        names.put("stone_axe",21);

        names.put("iron_pickaxe",22);
        names.put("iron_axe",23);

        names.put("wheat_seeds",24);
        names.put("wheat_small_grass",25);
        names.put("wheat_grass",26);
        names.put("wheat_big_grass",27);
        names.put("wheat_grown_grass",28);
        names.put("wheat",29);
        names.put("dough",30);
        names.put("bread",31);
        names.put("copper_ore",32);
        names.put("copper_ingot",33);
        names.put("copper_chain",34);
        names.put("copper_active_chain",35);
        names.put("copper_NOT",36);
        names.put("copper_active_NOT",37);
        names.put("copper_giving_chain",38);
        names.put("copper_giving_active_chain",39);

        return names;
    }
    public static int[] getLoot(int block,int handItem){
        switch (block&255){
            case 0 -> {return new int[]{};}
            case 2 -> {
                int[] res = {0,0,0,0};
                if (MolniyarMethod.random(40)){res[0]=11;}
                if (MolniyarMethod.random(50)){res[1]=3;}
                if (MolniyarMethod.random(60)){res[2]=8;}
                if (MolniyarMethod.random(25)){res[3]=9;}
                return res;
            }
            case 6 -> {
                if (handItem!=20 && handItem!=22){return new int[]{};}
                int[] res = {0,0,0,0};
                if (MolniyarMethod.random(60)){res[0]=4;}
                if (MolniyarMethod.random(80)){res[1]=13;}
                if (MolniyarMethod.random(50)){res[2]=15;}
                if (MolniyarMethod.random(50)){res[2]=32;}
                return res;
            }
            case 5 -> {
                if (handItem!=18 && handItem!=20 && handItem!=22){return new int[]{};}
            }
            case 12 -> {
                if (MolniyarMethod.random(30)) {return new int[]{24};}
                return new int[]{};
            }
            case 25 -> {return new int[]{24};}
            case 26 -> {return new int[]{24};}
            case 27 -> {return new int[]{24,24};}
            case 28 -> {return new int[]{24,29};}
        }
        return new int[]{block&255};
    }
    public static void checkInventoryForAir(int[][][] inventory){
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory[i].length; j++) {
                if (inventory[i][j][0]==0 ^ inventory[i][j][1]==0){inventory[i][j] = new int[]{0, 0};}
            }
        }
    }
    public static void placeItem(int[][][] inventory, int item){
        if (item==0){return;}
        for (int j = inventory.length-1; j >= 0; j--) {
            for (int i = 0; i < inventory[0].length; i++) {
                if (inventory[j][i][0]==item && inventory[j][i][1]<16){
                    inventory[j][i] = new int[]{item,inventory[j][i][1]+1};
                    return;
                }
            }
        }
        for (int j = inventory.length-1; j >= 0; j--) {
            for (int i = 0; i < inventory[0].length; i++) {
                if (inventory[j][i][0]==0){
                    inventory[j][i] = new int[]{item,1};
                    return;
                }
            }
        }
    }
    public static boolean canPlaceItem(int[][][] inventory,int item){
        if (item==0){return true;}
        for (int j = inventory.length-1; j >= 0; j--) {
            for (int i = 0; i < inventory[0].length; i++) {
                if (inventory[j][i][0]==0)return true;
                if (inventory[j][i][0]==item && inventory[j][i][1]<16)return true;
            }
        }
        return false;
    }
    public static void updateWorld(int[][] world,int darkness){
        for (int i = 0; i < world.length; i++){
            for (int j = 0; j < world.length; j++){
                if (world[i][j]==11&&MolniyarMethod.random(3-(Math.clamp(darkness,0,200)/40))){growTree(world,j,i,1,2,3);}

                if (world[i][j]==27&&MolniyarMethod.random(3-(Math.clamp(darkness,0,200)/40))){world[i][j]=28;}
                if (world[i][j]==26&&MolniyarMethod.random(3-(Math.clamp(darkness,0,200)/40))){world[i][j]=27;}
                if (world[i][j]==25&&MolniyarMethod.random(3-(Math.clamp(darkness,0,200)/40))){world[i][j]=26;}
                if (world[i][j]==24&&MolniyarMethod.random(3-(Math.clamp(darkness,0,200)/40))){world[i][j]=25;}
            }
        }
    }
    public static boolean growTree(int[][] world,int x, int y,int log, int leaves_block, int leaves){
        if (x==0||y==0||x== world[0].length-1||y== world.length-1){return false;}
        if (world[y+1][x]!=0|| world[y-1][x]!=0||world[y][x+1]!=0||world[y][x-1]!=0){return false;}
        if (world[y+1][x+1]!=0|| world[y-1][x+1]!=0||world[y+1][x-1]!=0||world[y-1][x-1]!=0){return false;}
        world[y][x] = log;
        world[y+1][x] = leaves_block;
        world[y-1][x] = leaves_block;
        world[y][x+1] = leaves_block;
        world[y][x-1] = leaves_block;
        if (MolniyarMethod.random(70)){world[y-1][x-1] = leaves;}
        if (MolniyarMethod.random(70)){world[y+1][x-1] = leaves;}
        if (MolniyarMethod.random(70)){world[y+1][x+1] = leaves;}
        if (MolniyarMethod.random(70)){world[y-1][x+1] = leaves;}
        System.out.println("yes");
        return true;
    }
    public static int getDarkness(int[][] world, int x, int y, int darkness, boolean[] areWalkable){
        if (world[y][x]==10||world[y][x]==17||
                getOrDefault(world,x+1,y,0)==10||getOrDefault(world,x-1,y,0)==10||getOrDefault(world,x,y+1,0)==10||getOrDefault(world,x,y-1,0)==10)
        {return darkness/6;}
        if (world[y][x]==16||
                getOrDefault(world,x+1,y,0)==17||getOrDefault(world,x-1,y,0)==17||getOrDefault(world,x,y+1,0)==17||getOrDefault(world,x,y-1,0)==17||
                getOrDefault(world,x+1,y+1,0)==10||getOrDefault(world,x-1,y+1,0)==10||getOrDefault(world,x+1,y-1,0)==10||getOrDefault(world,x-1,y-1,0)==10)
        {return darkness/2;}
        if (getOrDefault(world,x+1,y,0)==16||getOrDefault(world,x-1,y,0)==16||getOrDefault(world,x,y+1,0)==16||getOrDefault(world,x,y-1,0)==16||
                getOrDefault(world,x+1,y+1,0)==17||getOrDefault(world,x-1,y+1,0)==17||getOrDefault(world,x+1,y-1,0)==17||getOrDefault(world,x-1,y-1,0)==17||
                (getOrDefault(world,x+2,y,-1)==10&&areWalkable[getOrDefault(world,x+1,y,-1)])||(getOrDefault(world,x-2,y,-1)==10&&areWalkable[getOrDefault(world,x-1,y,-1)])||(getOrDefault(world,x,y+2,-1)==10&&areWalkable[getOrDefault(world,x,y+1,-1)])||(getOrDefault(world,x,y-2,-1)==10&&areWalkable[getOrDefault(world,x,y-1,-1)]))
        {return (int) (darkness/1.5);}
        if (getOrDefault(world,x+1,y+1,0)==16||getOrDefault(world,x-1,y+1,0)==16||getOrDefault(world,x+1,y-1,0)==16||getOrDefault(world,x-1,y-1,0)==16||
                (getOrDefault(world,x+2,y,-1)==17&&getOrDefault(world,x+1,y,-1)==0)||(getOrDefault(world,x-2,y,-1)==17&&getOrDefault(world,x-1,y,-1)==0)||(getOrDefault(world,x,y+2,-1)==17&&getOrDefault(world,x,y+1,-1)==0)||(getOrDefault(world,x,y-2,-1)==17&&getOrDefault(world,x,y-1,-1)==0)||
                ((getOrDefault(world,x+2,y+1,-1)==10||getOrDefault(world,x+2,y-1,-1)==10)&&areWalkable[getOrDefault(world,x+1,y,-1)])||
                ((getOrDefault(world,x-2,y+1,-1)==10||getOrDefault(world,x-2,y-1,-1)==10)&&areWalkable[getOrDefault(world,x-1,y,-1)])||
                ((getOrDefault(world,x+1,y+2,-1)==10||getOrDefault(world,x-1,y+2,-1)==10)&&areWalkable[getOrDefault(world,x,y+1,-1)])||
                ((getOrDefault(world,x+1,y-2,-1)==10||getOrDefault(world,x-1,y-2,-1)==10)&&areWalkable[getOrDefault(world,x,y-1,-1)]))
        {return (int) (darkness/1.2);}
        return darkness;
    }
    public static int getOrDefault(int[][] world, int x, int y, int default_){
        if (y<0||y>=world.length||x<0||x>=world[0].length){return default_;}
        return world[y][x];
    }
    public static int breakStrength(int breakingBlock, int item){
        if ((breakingBlock==1||breakingBlock==7||breakingBlock==10)){
            switch (item){
                case 19 -> {return 3;}
                case 21 -> {return 4;}
                case 23 -> {return 5;}
            }
        }
        if ((breakingBlock==4||breakingBlock==5||breakingBlock==6)){
            switch (item){
                case 18 -> {return 3;}
                case 20 -> {return 4;}
                case 22 -> {return 5;}
            }
        }
        return 1;
    }
    public static int breakItem(int item){
        boolean res = false;
        switch (item){
            case 18 -> {if (MolniyarMethod.random(10)){return 0;}}
            case 19 -> {if (MolniyarMethod.random(10)){return 18;}}
            case 20 -> {if (MolniyarMethod.random(5)){return 0;}}
            case 21 -> {if (MolniyarMethod.random(5)){return 20;}}
            case 22 -> {if (MolniyarMethod.random(1)){return 0;}}
            case 23 -> {if (MolniyarMethod.random(1)){return 22;}}
            default -> {return item;}
        }
        return item;
    }
    public static int getItem(int block){return block&255;}
    public static int getDirection(int block){return block>>8&2;}
    public static boolean getDirectionable(int block){return (block>>10&1)==0;}
    public static int getLightStrength(int block){
        return block&255;
    }
    public static void updateCopperCircuits(int[][] world_){
        int[][] world = world_.clone();
        for (int i = 1; i < world.length-1; i++){
            for (int j = 1; j < world.length-1; j++){
                if ((world[i][j]&255)==34){
                    if ((world[i][j+1]&255)==35&&getDirection(world[i][j-1])==0){world[i][j]=35|(world[i][j]&(256|512));}
                    if ((world[i-1][j]&255)==35&&getDirection(world[i][j-1])==1){world[i][j]=35|(world[i][j]&(256|512));}
                    if ((world[i][j-1]&255)==35&&getDirection(world[i][j-1])==2){world[i][j]=35|(world[i][j]&(256|512));}
                    if ((world[i+1][j]&255)==35&&getDirection(world[i][j-1])==3){world[i][j]=35|(world[i][j]&(256|512));}
                }
                if ((world[i][j]&255)==35){
                    if ((world[i][j+1]&255)!=35&&getDirection(world[i][j-1])==0){world[i][j]=34|(world[i][j]&(256|512));}
                    if ((world[i-1][j]&255)!=35&&getDirection(world[i][j-1])==1){world[i][j]=34|(world[i][j]&(256|512));}
                    if ((world[i][j-1]&255)!=35&&getDirection(world[i][j-1])==2){world[i][j]=34|(world[i][j]&(256|512));}
                    if ((world[i+1][j]&255)!=35&&getDirection(world[i][j-1])==3){world[i][j]=34|(world[i][j]&(256|512));}
                }
            }
        }
        world_=world.clone();
    }
}
