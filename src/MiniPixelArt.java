public class MiniPixelArt {
    static int size = 8;
    static int[][] art = new int[size][size];

    public void printArt() {
        StringBuilder print = new StringBuilder();
        for (int[] shorts : art) {
            for (int j = 0; j < art.length; j++) {
                String color = "\u001B[48;5;" + shorts[j] + "m";
                String ANSI_RESET = "\u001B[0m";
                print.append(color).append("   ").append(ANSI_RESET);
            }
            print.append("\n");
        }
        System.out.print(print);
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


        for (int i = lowX; i <= highX; i++){
            for (int j = lowY; j <= highY; j++){
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
    public OldPixelArt toPixelArt() {
        OldPixelArt result = new OldPixelArt((byte) 16);
        for (int i = 0; i < art.length * 2; i++){
            for (int j = 0; j < art.length * 2; j++){
                result.setPixel(i, j, (short) art[j / 2][i / 2]);
            }
        }
        return result;
    }

    public void randomWalking(int startX, int startY, int walkCount, int color) {
        for (int i = 0; i < walkCount; i++){
            startX = Math.clamp(startX, 0, 7);
            startY = Math.clamp(startY, 0, 7);
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
}
