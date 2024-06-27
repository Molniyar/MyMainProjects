import java.awt.*;

public class DrawSymbol {
    public static void a(Graphics g, int x, int y, int xl, int yl, Color color){
        g.setColor(color);
        g.drawLine(x,y+yl/2,x+xl, y+yl);
        g.drawLine(x,y+yl/2,x, y+yl);
        g.drawLine(x, y+yl,x, y+yl);

        //g.drawLine();
    }
}
