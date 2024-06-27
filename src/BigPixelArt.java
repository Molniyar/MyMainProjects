public class BigPixelArt {
    static int size = 32;
    static int[][] art = new int[size][size];
    static int[][] artChars = new int[size][size];
    static int[][] artCharsColor = new int[size][size];

    public void printArt() {
        for (int i = 0; i < art.length; i++){
            StringBuilder print = new StringBuilder();
            for (int j = 0; j < art.length; j++){
                String plus = "   ";
                switch (artChars[i][j]){
                    case 1 -> plus = " ↑ ";
                    case 2 -> plus = " ↓ ";
                    case 3 -> plus = " ← ";
                    case 4 -> plus = " → ";
                    case 5 -> plus = " • ";
                    case 6 -> plus = " ○ ";
                    case 7 -> plus = " ◉ ";
                    case 8 -> plus = " □ ";
                    case 9 -> plus = " ■ ";
                    case 10-> plus = "█  ";
                    case 11-> plus = "  █";
                    case 12-> plus = "▄▄▄";
                    case 13-> plus = "█▄▄";
                    case 14-> plus = "▄▄█";
                    case 15-> plus = "█▄█";
                    case 16-> plus = "█ █";
                    case 17-> plus = "▀▀▀";
                    case 18-> plus = "█▀▀";
                    case 19-> plus = "▀▀█";
                    case 20-> plus = "█▀█";
                    case 21-> plus = " █ ";
                    case 22-> plus = ";•.";
                }
                if (art[i][j] == 256){
                    print.append(plus);
                }
                else {
                    String color = "\u001B[48;5;" + art[i][j] + "m";
                    String charColor = "\u001B[38;5;" + artCharsColor[i][j] + "m";
                    String ANSI_RESET = "\u001B[0m";
                    print.append(charColor).append(color).append(plus).append(ANSI_RESET);
                }

            }
            System.out.println(print);
        }
    }

    public void setSymbol(int x, int y, String name) {
        switch (name.toLowerCase().trim()){
            case "1", "up arrow"                -> artChars[x][y] = 1;
            case "2", "down arrow"              -> artChars[x][y] = 2;
            case "3", "left arrow"              -> artChars[x][y] = 3;
            case "4", "right arrow"             -> artChars[x][y] = 4;
            case "5", "point"                   -> artChars[x][y] = 5;
            case "6", "circle"                  -> artChars[x][y] = 6;
            case "7", "filled circle"           -> artChars[x][y] = 7;
            case "8", "square"                  -> artChars[x][y] = 8;
            case "9", "filled square"           -> artChars[x][y] = 9;
            case "10", "left border"            -> artChars[x][y] = 10;
            case "11", "right border"           -> artChars[x][y] = 11;
            case "12", "down border"            -> artChars[x][y] = 12;
            case "13", "down left border", "left down border"   -> artChars[x][y] = 13;
            case "14", "down right border", "right down border" -> artChars[x][y] = 14;
            case "15", "down left right border", "down right left border", "right left down border", "left right down border"-> artChars[x][y] = 15;
            case "16", "left right border", "right left border" -> artChars[x][y] = 16;
            case "17", "up border"              -> artChars[x][y] = 17;
            case "18", "up left border", "up down border"       -> artChars[x][y] = 18;
            case "19", "up right border", "right up border"     -> artChars[x][y] = 19;
            case "20", "up left right border", "up right left border", "up left down border", "up right down border"         -> artChars[x][y] = 20;
            case "21", "middle border"           -> artChars[x][y] = 21;
            case "22", "points"           -> artChars[x][y] = 22;
            case "0"-> artChars[x][y] = 0;
        }
    }

    public void fillBorder(int x, int y, int x2, int y2, int color) {
        int lowY = Math.min(y, y2);
        int highY = Math.max(y, y2);
        int lowX = Math.min(x, x2);
        int highX = Math.max(x, x2);
        artChars[lowX][lowY] = 18;
        artChars[lowX][highY] = 19;
        artChars[highX][lowY] = 13;
        artChars[highX][highY] = 14;

        artCharsColor[lowX][lowY] = color;
        artCharsColor[lowX][highY] = color;
        artCharsColor[highX][lowY] = color;
        artCharsColor[highX][highY] = color;
        for (int i = lowY + 1; i < highY; i++){
            artChars[lowX][i] = 17;
            artChars[highX][i] = 12;
            artCharsColor[lowX][i] = color;
            artCharsColor[highX][i] = color;
        }
        for (int i = lowX + 1; i < highX; i++){
            artChars[i][lowY] = 10;
            artChars[i][highY] = 11;
            artCharsColor[i][lowY] = color;
            artCharsColor[i][highY] = color;
        }
    }

    public void setSymbolColor(int x, int y, int color) {
        artCharsColor[x][y] = Math.clamp(color, 0, 255);
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
        String background_color = "\u001B[38;5;" + Math.clamp(art[x][y], 0, 255) + "m";
        return background_color + "   " + ANSI_RESET;
    }
    public int getColorCode(int x, int y){
        return art[x][y];
    }
    public void printArtWithPlayer(int x, int y) {
        for (int i = 0; i < art.length; i++){
            StringBuilder print = new StringBuilder();
            for (int j = 0; j < art.length; j++){
                String ANSI_RESET = "\u001B[0m";
                if (i == x && j == y){
                    String color = "\u001B[48;5;100m";
                    print.append(color).append("   ").append(ANSI_RESET);
                }
                else {
                    String color = "\u001B[48;5;" + art[i][j] + "m";
                    print.append(color).append("   ").append(ANSI_RESET);
                }
            }
            System.out.println(print);
        }
    }
    public void resetPixel(int x, int y) {
        x = Math.clamp(x, 0, 31);
        y = Math.clamp(y, 0, 31);
        art[x][y] = 256;
    }
    public GiantPixelArt toGiantPixelArt(int x, int y) {
        GiantPixelArt result = new GiantPixelArt();
        for (int i = 0; i < art.length * 2; i++){
            for (int j = 0; j < art.length * 2; j++){
                result.setPixel(i, j, art[j / 2][i / 2]);
            }
        }
        return result;
    }
}
