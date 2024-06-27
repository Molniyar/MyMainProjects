import java.awt.*;

public class OldPixelArt {
    //static int Size = 16;
    OldPixelArt(int size){
        size = Math.clamp(size,1,128);
        art = new short[size][size];
    }
    OldPixelArt(int vertical, int horizontal){
        vertical = Math.clamp(vertical,1,128);
        horizontal = Math.clamp(horizontal,1,128);
        art = new short[vertical][horizontal];
    }
    short[][] art;

    public void printArt() {
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < art.length; i++) {
            for (int j = 0; j < art[0].length; j++) {
                String color = "\u001B[48;5;" + art[i][j] + "m";
                String ANSI_RESET = "\u001B[0m";
                print.append(color).append("   ").append(ANSI_RESET);
            }
            print.append("\n");
        }
        System.out.print(print);
    }
    public void fillArtRandom() {
        for (int i = 0; i < art.length; i++){
            for (int j = 0; j < art[i].length; j++){
                int small = 0;
                int big = 255;
                int z = small + (int) (Math.random() * (big - small + 1));
                art[i][j] = (short) z;
            }
        }
    }
    public void setPixel(int x, int y, short color){
        x = Math.clamp(x, 0, art.length - 1);
        y = Math.clamp(y, 0, art.length - 1);
        art[x][y] = color;
    }
    public void setPixel(int x, int y, int color){
        x = Math.clamp(x, 0, art.length - 1);
        y = Math.clamp(y, 0, art.length - 1);
        art[x][y] = (short) color;
    }
    public void fillArt(short color) {
        for (int i = 0; i < art.length; i++){
            for (int j = 0; j < art[0].length; j++){
                art[i][j] = color;
            }
        }
    }
    public void fillArt(int color) {
        for (int i = 0; i < art.length; i++){
            for (int j = 0; j < art[0].length; j++){
                art[i][j] = (short) color;
            }
        }
    }
    public void fillPixel(int x1, int y1, int x2, int y2, short color) {
        int lowY = Math.min(y1, y2);

        int highY = Math.max(y1, y2);

        int lowX = Math.min(x1, x2);

        int highX = Math.max(x1, x2);


        for (int i = lowX; i <= highX; i++){
            for (int j = lowY; j <= highY; j++){
                art[i][j] = color;
            }
        }
    }
    public String getColor(int x, int y) {
        String ANSI_RESET = "\u001B[0m";
        String background_color = "\u001B[38;5;" + Math.clamp(art[x][y], 0, 255) + "m";
        return background_color + "   " + ANSI_RESET;
    }

    public int getColorCode(int x, int y) {
        return art[Math.clamp(x,0,art.length-1)][Math.clamp(y,0,art.length-1)];
    }

    public OldPixelArt toBigPixelArt() {
        OldPixelArt result = new OldPixelArt(art.length*2);
        for (int i = 0; i < art.length * 2; i++){
            for (int j = 0; j < art.length * 2; j++){
                result.setPixel(i, j, art[i / 2][j / 2]);
            }
        }
        return result;
    }
    public void randomWalking(int startX, int startY, int walkCount, short color){
        for (int i = 0; i < walkCount; i++){
            startX = Math.clamp(startX, 0, art.length - 1);
            startY = Math.clamp(startY, 0, art[0].length - 1);
            art[startX][startY] = color;
            int random = (int)(Math.random() * 4 + 1);
            switch (random){
                case 1 -> startX++;
                case 2 -> startY++;
                case 3 -> startX--;
                case 4 -> startY--;
            }
        }
    }

    public void setPixel(int i, int j, Color color) {
    }
}
