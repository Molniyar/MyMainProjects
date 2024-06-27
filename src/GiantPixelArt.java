public class GiantPixelArt {
    static int size = 64;
    static int[][] art = new int[size][size];

    public void printArt() {
        for (int i = 0; i < art.length; i++){
            StringBuilder print = new StringBuilder();
            for (int j = 0; j < art.length; j++){
                String color = "\u001B[48;5;" + art[i][j] + "m";
                String ANSI_RESET = "\u001B[0m";
                print.append(color).append("   ").append(ANSI_RESET);
            }
            System.out.println(print);
        }
    }

    public void fillArtRandom() {
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                int small = 1;
                int big = 20;
                int z = small + (int) (Math.random() * (big - small + 1));
                art[i][j] = z;
            }
        }
    }
    public void setPixel(int x, int y, int color){
        x = Math.clamp(x, 0, art.length - 1);
        y = Math.clamp(y, 0, art.length - 1);
        art[x][y] = color;
    }
    public void setRandomPixel(int x, int y){
        x = Math.clamp(x, 0, art.length - 1);
        y = Math.clamp(y, 0, art.length - 1);
        int small = 0;
        int big = 255;
        int z = small + (int) (Math.random() * (big - small + 1));
        art[x][y] = z;
    }
    public void fillArt(int color) {
        for (int i = 0; i < art.length; i++){
            for (int j = 0; j < art.length; j++){
                art[i][j] = color;
            }
        }
    }
    public void fillPixel(int x1, int y1, int x2, int y2, int color) {
        int lowY = Math.min(y1, y2);

        int highY = Math.max(y1, y2);

        int lowX = Math.min(x1, x2);

        int highX = Math.max(x1, x2);


        for (int i = lowY; i <= highY; i++){
            for (int j = lowX; j <= highX; j++){
                art[i][j] = color;

            }
        }
    }
    public String getColor(int x, int y) {
        String ANSI_RESET = "\u001B[0m";
        String background_color = "\u001B[38;5;" + Math.clamp(art[y][x], 0, 255) + "m";
        return background_color + "   " + ANSI_RESET;
    }

    public int getColorCode(int x, int y) {
        return art[x][y];
    }
}
