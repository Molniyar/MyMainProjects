import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class PixelArt {
    Color[][] pixelArt;
    PixelArt(int size){
        pixelArt = new Color[size][size];
    }
    PixelArt(int xSize, int ySize){
        pixelArt = new Color[ySize][xSize];
    }
    PixelArt(int size, Color background){
        pixelArt = new Color[size][size];

        for (Color[] colors : pixelArt) {
            Arrays.fill(colors, background);
        }
    }
    PixelArt(int xSize, int ySize, Color background){
        pixelArt = new Color[ySize][xSize];

        for (Color[] colors : pixelArt) {
            Arrays.fill(colors, background);
        }
    }


    PixelArt(String codedPixelArt){
        pixelArt = new Color[codedPixelArt.charAt(1)][codedPixelArt.charAt(0)];

        for (int i = 0, index = 2; i < pixelArt.length; i++){
            for (int j = 0; j < pixelArt[i].length; j++, index++){
                pixelArt[i][j] = new Color(codedPixelArt.charAt(index));
            }
        }
    }


    public OldPixelArt toBiggerPixelArt() {//?
        OldPixelArt result = new OldPixelArt(pixelArt.length*2);
        for (int i = 0; i < pixelArt.length * 2; i++){
            for (int j = 0; j < pixelArt.length * 2; j++){
                result.setPixel(i, j, pixelArt[i / 2][j / 2]);
            }
        }
        return result;
    }

    public OldPixelArt toSmallerPixelArt() {//?
        OldPixelArt result = new OldPixelArt(pixelArt.length/2);
        for (int i = 0; i < pixelArt.length / 2; i++){
            for (int j = 0; j < pixelArt.length / 2; j++){
                Color _1 = pixelArt[i * 2][j * 2];
                Color _2 = pixelArt[i * 2 +1][j * 2];
                Color _3 = pixelArt[i * 2][j * 2 +1];
                Color _4 = pixelArt[i * 2 +1][j * 2 +1];
                Color set = new Color(
                        (_1.getRed()  +_2.getRed()  +_3.getRed()  +_4.getRed())  /4,
                        (_1.getGreen()+_2.getGreen()+_3.getGreen()+_4.getGreen())/4,
                        (_1.getBlue() +_2.getBlue() +_3.getBlue() +_4.getBlue()) /4
                );
                result.setPixel(i, j, set);
            }
        }
        return result;
    }

    public void setPixel(int x, int y, Color color){//V
        x = Math.clamp(x, 0, pixelArt.length - 1);
        y = Math.clamp(y, 0, pixelArt.length - 1);
        pixelArt[y][x] = color;
    }

    public void fillArt(Color color) {
        for (int i = 0; i < pixelArt.length; i++){
            for (int j = 0; j < pixelArt[0].length; j++){
                pixelArt[i][j] = color;
            }
        }
    }

    public void fillPixel(int x1, int y1, int x2, int y2, Color color) {//V
        int lowY = Math.min(y1, y2);

        int highY = Math.max(y1, y2);

        int lowX = Math.min(x1, x2);

        int highX = Math.max(x1, x2);


        for (int i = lowX; i <= highX; i++){
            for (int j = lowY; j <= highY; j++){
                pixelArt[j][i] = color;
            }
        }
    }
    public Color getColor(int x, int y) {
        return pixelArt[y][x];
    }

    public String toString() {//X
        StringBuilder result = new StringBuilder();
        for (Color[] colors : pixelArt) {
            for (Color c : colors) {
                result.append("\033[48;2;"+c.getRed()+";"+c.getGreen()+";"+c.getBlue()+"m" + "   " + "\u001B[0m");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public Graphics draw(Graphics g, int width, int height) {//V
        for (int i = 0; i < pixelArt.length; i++){
            for (int j = 0; j < pixelArt[i].length; j++){
                int coordX = width / pixelArt.length * i;
                int coordY = height / pixelArt[i].length * j;

                int x = width / pixelArt.length;
                int y = height / pixelArt[i].length;

                g.setColor(pixelArt[i][j]);
                g.fillRect(coordY,coordX,y,x);
            }
        }
        return g;
    }
    public Graphics draw(Graphics g,int x,int y, int width, int height) {//V
        for (int i = 0; i < pixelArt.length; i++){
            for (int j = 0; j < pixelArt[i].length; j++){
                if (pixelArt[i][j] == null){continue;}

                int coordX = width / pixelArt.length * j;
                int coordY = height / pixelArt[i].length * i;

                int X = width / pixelArt.length;
                int Y = height / pixelArt[i].length;

                g.setColor(pixelArt[i][j]);
                g.fillRect(coordX+x,coordY+y,Y,X);
            }
        }
        return g;
    }
    public void toBlack_White() {//V
        for (int i = 0; i < pixelArt.length; i++){
            for (int j = 0; j < pixelArt[i].length; j++){
                int c = (pixelArt[i][j].getRed()+pixelArt[i][j].getGreen()+pixelArt[i][j].getBlue())/3;
                pixelArt[i][j] = new Color(c,c,c);
            }
        }
    }
    public void setArt(Color[][] colors) {//V
        pixelArt = colors.clone();
    }

    public String code() {
        char[] res = new char[2+pixelArt.length*pixelArt[0].length];
        res[0] = (char) pixelArt.length;
        res[1] = (char) pixelArt[0].length;

        for (int i = 0, index = 2; i < pixelArt.length; i++){
            for (int j = 0; j < pixelArt[i].length; j++, index++){
                res[index] = (char) pixelArt[i][j].getRGB();
            }
        }

        return new String(res);
    }

}