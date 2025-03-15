import java.awt.*;
import java.util.Arrays;

public class PolygonArt {
    Polygon[] polygons;
    Color[]   colors;
    public PolygonArt(Polygon[] polygons,Color[] colors){
        this.polygons = polygons;
        this.colors = colors;
    }
    public void addPolygon(Polygon polygon,Color color){
        Polygon[] keep = new Polygon[polygons.length+1];
        System.arraycopy(keep,0,polygons,0,polygons.length);
        keep[keep.length-1] = polygon;

        Color[] keep_ = new Color[colors.length+1];
        System.arraycopy(keep_,0,colors,0,colors.length);
        keep_[keep_.length-1] = color;

        this.polygons = keep;
        this.colors =  keep_;
    }
    public void draw(Graphics g, int x, int y, int xSize, int ySize) {
        Polygon[] polygons_ = polygons.clone();

        for (int i = 0; i < polygons_.length; i++) {
            Polygon pol = polygons_[i];

            g.setColor(colors[i]);

            // Масштабирование координат
            int[] xp = new int[pol.xpoints.length];
            int[] yp = new int[pol.ypoints.length];

            for (int j = 0; j < xp.length; j++) {
                xp[j] = (int) (x + pol.xpoints[j] * ((float)(xSize) / 8)); // Масштабируем по X
            }

            for (int j = 0; j < yp.length; j++) {
                yp[j] = (int) (y + pol.ypoints[j] * ((float)(ySize) / 8)); // Масштабируем по Y
            }

            // Создаем новый Polygon с новыми координатами
            Polygon newPol = new Polygon(xp, yp, xp.length);

            // Рисуем полигон
            g.fillPolygon(newPol);
        }
    }
    public void drawTransparent(Graphics g, int x, int y, int xSize, int ySize) {
        Polygon[] polygons_ = polygons.clone();

        for (int i = 0; i < polygons_.length; i++) {
            Polygon pol = polygons_[i];

            g.setColor(new Color(colors[i].getRed(),colors[i].getGreen(),colors[i].getBlue(),180));

            // Масштабирование координат
            int[] xp = new int[pol.xpoints.length];
            int[] yp = new int[pol.ypoints.length];

            for (int j = 0; j < xp.length; j++) {
                xp[j] = (int) (x + pol.xpoints[j] * ((float)(xSize) / 8)); // Масштабируем по X
            }

            for (int j = 0; j < yp.length; j++) {
                yp[j] = (int) (y + pol.ypoints[j] * ((float)(ySize) / 8)); // Масштабируем по Y
            }

            // Создаем новый Polygon с новыми координатами
            Polygon newPol = new Polygon(xp, yp, xp.length);

            // Рисуем полигон
            g.fillPolygon(newPol);
        }
    }
    public void drawWithTurn(Graphics g, int x, int y, int xSize, int ySize,int direction) {
        Polygon[] polygons_ = polygons.clone();

        for (int i = 0; i < polygons_.length; i++) {
            Polygon pol = polygons_[i];

            g.setColor(colors[i]);

            // Масштабирование координат
            int[] xp = new int[pol.xpoints.length];
            int[] yp = new int[pol.ypoints.length];


            switch (direction%4){
                case 0 -> {
                    for (int j = 0; j < xp.length; j++) {xp[j] = (int) (x + pol.xpoints[j] * ((float)(xSize) / 8));}
                    for (int j = 0; j < yp.length; j++) {yp[j] = (int) (y + pol.ypoints[j] * ((float)(ySize) / 8));}
                }
                case 1 -> {
                    for (int j = 0; j < xp.length; j++) {xp[j] = (int) (x + (8-pol.ypoints[j]) * ((float)(xSize) / 8));}
                    for (int j = 0; j < yp.length; j++) {yp[j] = (int) (y + pol.xpoints[j] * ((float)(ySize) / 8));}
                }
                case 2 -> {
                    for (int j = 0; j < xp.length; j++) {xp[j] = (int) (x + (8-pol.xpoints[j]) * ((float)(xSize) / 8));}
                    for (int j = 0; j < yp.length; j++) {yp[j] = (int) (y + (8-pol.ypoints[j]) * ((float)(ySize) / 8));}
                }
                case 3 -> {
                    for (int j = 0; j < xp.length; j++) {xp[j] = (int) (x + pol.ypoints[j] * ((float)(xSize) / 8));}
                    for (int j = 0; j < yp.length; j++) {yp[j] = (int) (y + (8-pol.xpoints[j]) * ((float)(ySize) / 8));}
                }
            }

            // Создаем новый Polygon с новыми координатами
            Polygon newPol = new Polygon(xp, yp, xp.length);

            // Рисуем полигон
            g.fillPolygon(newPol);
        }
    }
    public void drawOneColor(Graphics g, int x, int y, int xSize, int ySize, Color color) {
        Polygon[] polygons_ = polygons.clone();

        for (int i = 0; i < polygons_.length; i++) {
            Polygon pol = polygons_[i];

            g.setColor(color);

            // Масштабирование координат
            int[] xp = new int[pol.xpoints.length];
            int[] yp = new int[pol.ypoints.length];

            for (int j = 0; j < xp.length; j++) {
                xp[j] = (int) (x + pol.xpoints[j] * ((float)(xSize) / 8)); // Масштабируем по X
            }

            for (int j = 0; j < yp.length; j++) {
                yp[j] = (int) (y + pol.ypoints[j] * ((float)(ySize) / 8)); // Масштабируем по Y
            }

            // Создаем новый Polygon с новыми координатами
            Polygon newPol = new Polygon(xp, yp, xp.length);

            // Рисуем полигон
            g.fillPolygon(newPol);
        }
    }
}
