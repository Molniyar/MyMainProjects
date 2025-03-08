import java.awt.*;

public class ResepiesMethod {
    public static void drawItem(Graphics g,int X , int Y, int x, int y, int item, boolean isCraftTabl, boolean isArrow) {


        int[] xs = {X,X+(x/8),X+(x/8*2),X+(x/8*3),X+(x/8*4),X+(x/8*5),X+(x/8*6),X+(x/8*7),X+(x)};
        int[] ys = {Y,Y+(y/8),Y+(y/8*2),Y+(y/8*3),Y+(y/8*4),Y+(y/8*5),Y+(y/8*6),Y+(y/8*7),Y+y};
        int xh = X+(x/16);
        int yh = Y+(y/16);

        if (isCraftTabl){
            g.setColor(new Color(200,200,200));
            g.fillRect(xs[2],ys[2],x/2,y/2);
        }
        if (isArrow){
            g.setColor(new Color(200,200,200));
            g.fillPolygon(new int[] {xs[4],xs[2],xs[2],xs[4],xs[4],xs[6],xs[4]},new int[] {ys[3],ys[3],ys[5],ys[5],ys[6],ys[4],ys[2]},7);
        }

        g.setColor(new Color(200,200,200));
        g.drawRect(X,Y,x,y);

        switch (item){
            case 0 -> {

            }
            case 1 -> {
                g.setColor(new Color(90,170,0));
                g.fillPolygon(new int[] {xs[1],xs[5],xs[7],xs[3]},new int[] {ys[1],ys[3],ys[7],ys[5]},4);
                g.setColor(new Color(20,70,0));
                g.drawLine(xs[2],ys[2],xs[7],ys[7]);

                g.setColor(new Color(0,0,0));
                g.drawString("лечебная трава",X,Y+y);
            }
            case 2 -> {
                g.setColor(new Color(220,220,220));
                g.fillPolygon(new int[] {xs[2],xs[1],xs[4],xs[7],xs[6]},new int[] {ys[6],ys[5],ys[2],ys[5],ys[6]},5);
                g.setColor(new Color(205,205,205));
                g.fillPolygon(new int[] {xs[4],xs[7],xs[6]},new int[] {ys[2],ys[5],ys[6]},3);
                g.drawLine(xs[2],ys[6],xs[6],ys[6]);
                g.setColor(new Color(230,230,235));
                g.fillRect(xs[3],ys[4],3,3);
                g.fillRect(xs[4],ys[3],3,3);
                g.fillRect(xs[2],ys[5],3,3);
                g.fillRect(xs[4],ys[4],3,3);
                g.drawLine(xs[1],ys[5],xs[4],ys[2]);

                g.setColor(new Color(0,0,0));
                g.drawString("порошок",X,Y+y);
            }
            case 3 -> {
                g.setColor(new Color(90,200,255));
                g.fillPolygon(new int[] {xs[1],xs[3],xs[7],xs[5]},new int[] {ys[7],ys[3],ys[1],ys[5]},4);
                g.setColor(new Color(140,255,255));
                g.fillPolygon(new int[] {xs[3],xs[3],xs[7]},new int[] {ys[5],ys[3],ys[1]},3);
                g.setColor(new Color(70,170,190));
                g.fillPolygon(new int[] {xs[1],xs[3],xs[5]},new int[] {ys[7],ys[5],ys[5]},3);

                g.setColor(new Color(0,0,0));
                g.drawString("осколок",X,Y+y);
            }
            case 4 -> {
                g.setColor(new Color(30,50,0));
                g.drawLine(xs[0],ys[3],xs[1],ys[2]);
                g.drawLine(xs[1],ys[2],xs[2],ys[4]);
                g.drawLine(xs[1],ys[2],xs[3],ys[2]);
                g.drawLine(xs[3],ys[2],xs[5],ys[3]);
                g.setColor(new Color(60,200,0));
                g.fillPolygon(new int[] {xs[3],xs[5],xs[8],xs[6]},new int[] {ys[2],ys[0],ys[0],ys[2]},4);
                g.setColor(new Color(200,0,0));
                g.fillPolygon(new int[] {xs[4],xs[4],xs[5],xs[6],xs[7],xs[7],xs[6],xs[5]},new int[] {ys[5],ys[4],ys[3],ys[3],ys[4],ys[5],ys[6],ys[6]},8);
                g.fillPolygon(new int[] {xs[1],xs[1],xs[2],xs[3],xs[4],xs[4],xs[3],xs[2]},new int[] {ys[6],ys[5],ys[4],ys[4],ys[5],ys[6],ys[7],ys[7]},8);

                g.setColor(new Color(0,0,0));
                g.drawString("лесная ягода",X,Y+y);
            }
            case 5 -> {
                g.setColor(new Color(100,0,255));
                g.fillPolygon(new int[] {xs[4],xs[5],xs[6],xs[5]},new int[] {ys[5],ys[4],ys[5],ys[6]},4);
                g.fillPolygon(new int[] {xs[2],xs[2],xs[3],xs[3]},new int[] {ys[2],ys[1],ys[2],ys[3]},4);
                g.fillPolygon(new int[] {xs[2],xs[2],xs[3],xs[3]},new int[] {ys[4],ys[6],ys[7],ys[6]},4);

                g.setColor(new Color(140,40,255));
                g.fillPolygon(new int[] {xs[4],xs[5],xs[5]},new int[] {ys[5],ys[4],ys[5]},3);
                g.fillPolygon(new int[] {xs[6],xs[7],xs[7]},new int[] {ys[3],ys[2],ys[3]},3);
                g.fillPolygon(new int[] {xs[3],xs[2],xs[2]},new int[] {ys[2],ys[1],ys[2]},3);


                g.setColor(new Color(0,0,0));
                g.drawString("мистические осколки",X,Y+y);
            }
            case 6 -> {
                g.setColor(new Color(205,205,205));
                g.fillPolygon(new int[] {xs[3],xs[3],xs[6],xs[6]},new int[] {ys[6],ys[3],ys[3],ys[6]},4);
                g.setColor(new Color(220,220,220));
                g.fillPolygon(new int[] {xs[2],xs[2],xs[3],xs[3]},new int[] {ys[5],ys[2],ys[3],ys[6]},4);
                g.setColor(new Color(230,230,235));
                g.fillPolygon(new int[] {xs[2],xs[5],xs[6],xs[3]},new int[] {ys[2],ys[2],ys[3],ys[3]},4);

                g.setColor(new Color(0,0,0));
                g.drawString("соляной кристалл",X,Y+y);
            }
            case 7 -> {
                g.setColor(new Color(0,255,128));
                g.fillPolygon(new int[] {xs[2],xs[1],xs[4],xs[7],xs[6]},new int[] {ys[2],ys[3],ys[6],ys[3],ys[2]},5);

                g.setColor(new Color(0,0,0));
                g.drawString("мятный алмаз",X,Y+y);
            }
            case 8 -> {
                g.setColor(new Color(100,80,0));
                g.fillPolygon(new int[] {xs[2],xs[2],xs[4],xs[6],xs[7],xs[6],xs[5]},new int[] {ys[5],ys[3],ys[1],ys[2],ys[4],ys[6],ys[7]},7);
                g.setColor(new Color(130,100,20));
                g.fillPolygon(new int[] {xs[2],xs[2],xs[4],xs[4]},new int[] {ys[5],ys[3],ys[1],ys[3]},4);
                g.setColor(new Color(115,90,20));
                g.fillPolygon(new int[] {xs[4],xs[4],xs[6],xs[6]},new int[] {ys[3],ys[1],ys[2],ys[3]},4);
                g.setColor(new Color(80,70,0));
                g.fillPolygon(new int[] {xs[5],xs[2],xs[6]},new int[] {ys[7],ys[5],ys[6]},3);
                g.setColor(new Color(70,100,0));
                g.fillPolygon(new int[] {xs[6],xs[6],xs[7]},new int[] {ys[3],ys[2],ys[4]},3);
                g.setColor(new Color(110,70,0));
                g.fillPolygon(new int[] {xs[4],xs[6],xs[6]},new int[] {ys[3],ys[3],ys[6]},3);

                g.setColor(new Color(0,0,0));
                g.drawString("железная руда",X,Y+y);
            }
            case 9 -> {
                g.setColor(new Color(140,140,140));
                g.fillPolygon(new int[] {xs[1],xs[1],xs[3],xs[3]},new int[] {ys[5],ys[3],ys[5],ys[7]},4);
                g.setColor(new Color(170,170,170));
                g.fillPolygon(new int[] {xs[3],xs[3],xs[7],xs[7]},new int[] {ys[7],ys[5],ys[3],ys[5]},4);
                g.setColor(new Color(200,200,200));
                g.fillPolygon(new int[] {xs[1],xs[5],xs[7],xs[3]},new int[] {ys[3],ys[1],ys[3],ys[5]},4);

                g.setColor(new Color(0,0,0));
                g.drawString("железный слиток",X,Y+y);
            }
            case 10 -> {
                g.setColor(new Color(100,100,100));
                g.drawLine(xs[0],ys[0],xs[2],ys[2]);
                g.setColor(new Color(160,180,0));
                g.fillPolygon(new int[] {xs[1],xs[3],xs[6],xs[4]},new int[] {ys[3],ys[1],ys[4],ys[6]},4);
                g.setColor(new Color(180,230,255));
                g.fillPolygon(new int[] {xs[4],xs[6],xs[7],xs[5]},new int[] {ys[6],ys[4],ys[5],ys[7]},4);
                g.drawPolygon(new int[] {xs[1],xs[3],xs[7],xs[5]},new int[] {ys[3],ys[1],ys[5],ys[7]},4);
                g.setColor(new Color(0,0,0));
                g.drawLine(xs[6],ys[8],xs[8],ys[6]);
                g.drawLine(xs[6],ys[6],xs[7],ys[7]);

                g.drawString("лекарство от",X,Y+y-12);
                g.drawString("зомби болезни",X,Y+y);
            }
            case 11 -> {
                g.setColor(new Color(100,100,100));
                g.drawLine(xs[0],ys[0],xs[2],ys[2]);
                g.setColor(new Color(0,190,60));
                g.fillPolygon(new int[] {xs[1],xs[3],xs[6],xs[4]},new int[] {ys[3],ys[1],ys[4],ys[6]},4);
                g.setColor(new Color(180,230,255));
                g.fillPolygon(new int[] {xs[4],xs[6],xs[7],xs[5]},new int[] {ys[6],ys[4],ys[5],ys[7]},4);
                g.drawPolygon(new int[] {xs[1],xs[3],xs[7],xs[5]},new int[] {ys[3],ys[1],ys[5],ys[7]},4);
                g.setColor(new Color(0,0,0));
                g.drawLine(xs[6],ys[8],xs[8],ys[6]);
                g.drawLine(xs[6],ys[6],xs[7],ys[7]);

                g.drawString("противоядие",X,Y+y);
            }
            case 12 -> {
                g.setColor(new Color(100,100,100));
                g.drawLine(xs[0],ys[0],xs[2],ys[2]);
                g.setColor(new Color(160,40,60));
                g.fillPolygon(new int[] {xs[1],xs[3],xs[6],xs[4]},new int[] {ys[3],ys[1],ys[4],ys[6]},4);
                g.setColor(new Color(180,230,255));
                g.fillPolygon(new int[] {xs[4],xs[6],xs[7],xs[5]},new int[] {ys[6],ys[4],ys[5],ys[7]},4);
                g.drawPolygon(new int[] {xs[1],xs[3],xs[7],xs[5]},new int[] {ys[3],ys[1],ys[5],ys[7]},4);
                g.setColor(new Color(0,0,0));
                g.drawLine(xs[6],ys[8],xs[8],ys[6]);
                g.drawLine(xs[6],ys[6],xs[7],ys[7]);

                g.drawString("лекарство от",X,Y+y-24);
                g.drawString("зомби болезни",X,Y+y-12);
                g.drawString("второй степени",X,Y+y);
            }
            case 13 -> {
                g.setColor(new Color(130,130,130));
                g.fillPolygon(new int[] {xs[1],xs[3],xs[7],xs[5]},new int[] {ys[3],ys[1],ys[5],ys[7]},4);
                g.setColor(new Color(0,255,255));
                g.fillPolygon(new int[] {xs[2],xs[4],xs[6],xs[4]},new int[] {ys[4],ys[2],ys[4],ys[6]},4);

                g.setColor(new Color(0,0,0));
                g.drawString("колба с плазмой",X,Y+y);
            }
            case 14 -> {
                g.setColor(new Color(100,100,100));
                g.drawLine(xs[0],ys[0],xs[2],ys[2]);
                g.setColor(new Color(160,180,0));
                g.fillPolygon(new int[] {xs[1],xs[3],xs[6],xs[4]},new int[] {ys[3],ys[1],ys[4],ys[6]},4);
                g.setColor(new Color(180,230,255));
                g.fillPolygon(new int[] {xs[4],xs[6],xs[7],xs[5]},new int[] {ys[6],ys[4],ys[5],ys[7]},4);
                g.drawPolygon(new int[] {xs[1],xs[3],xs[7],xs[5]},new int[] {ys[3],ys[1],ys[5],ys[7]},4);
                g.setColor(new Color(0,0,0));
                g.drawLine(xs[6],ys[8],xs[8],ys[6]);
                g.drawLine(xs[6],ys[6],xs[7],ys[7]);

                g.drawString("пекарство от",X,Y+y-12);
                g.drawString("зомби болезни",X,Y+y);
            }
            case 15 -> {
                g.setColor(new Color(110,110,110));
                g.fillPolygon(new int[] {xs[2],xs[1],xs[4],xs[7],xs[6]},new int[] {ys[6],ys[5],ys[2],ys[5],ys[6]},5);
                g.setColor(new Color(100,100,100));
                g.fillPolygon(new int[] {xs[4],xs[7],xs[6]},new int[] {ys[2],ys[5],ys[6]},3);
                g.drawLine(xs[2],ys[6],xs[6],ys[6]);
                g.setColor(new Color(120,120,120));
                g.fillRect(xs[3],ys[4],3,3);
                g.fillRect(xs[4],ys[3],3,3);
                g.fillRect(xs[2],ys[5],3,3);
                g.fillRect(xs[4],ys[4],3,3);
                g.drawLine(xs[1],ys[5],xs[4],ys[2]);

                g.setColor(new Color(0,0,0));
                g.drawString("порох",X,Y+y);
            }
            case 16 -> {
                g.setColor(new Color(170,140,90));
                g.fillPolygon(new int[] {xs[2],xs[2],xs[6],xs[6]},new int[] {ys[6],ys[4],ys[4],ys[6]},4);
                g.setColor(new Color(140,120,90));
                g.fillPolygon(new int[] {xs[1],xs[1],xs[2],xs[2]},new int[] {ys[5],ys[3],ys[4],ys[6]},4);
                g.setColor(new Color(200,160,90));
                g.fillPolygon(new int[] {xs[2],xs[1],xs[5],xs[6]},new int[] {ys[4],ys[3],ys[3],ys[4]},4);

                g.setColor(new Color(90,90,90));
                g.fillPolygon(new int[] {xs[3],xs[3],xs[5],xs[5]},new int[] {ys[6],ys[4],ys[4],ys[6]},4);
                g.setColor(new Color(120,120,120));
                g.fillPolygon(new int[] {xs[3],xs[2],xs[4],xs[5]},new int[] {ys[4],ys[3],ys[3],ys[4]},4);

                g.setColor(new Color(0,0,0));
                g.drawString("патроны",X,Y+y);
            }
            case 17 -> {
                g.setColor(new Color(100,100,100));
                g.drawLine(xs[0],ys[0],xs[2],ys[2]);
                g.setColor(new Color(60,40,160));
                g.fillPolygon(new int[] {xs[1],xs[3],xs[6],xs[4]},new int[] {ys[3],ys[1],ys[4],ys[6]},4);
                g.setColor(new Color(180,230,255));
                g.fillPolygon(new int[] {xs[4],xs[6],xs[7],xs[5]},new int[] {ys[6],ys[4],ys[5],ys[7]},4);
                g.drawPolygon(new int[] {xs[1],xs[3],xs[7],xs[5]},new int[] {ys[3],ys[1],ys[5],ys[7]},4);
                g.setColor(new Color(0,0,0));
                g.drawLine(xs[6],ys[8],xs[8],ys[6]);
                g.drawLine(xs[6],ys[6],xs[17],ys[7]);

                g.drawString("лекарство от",X,Y+y-24);
                g.drawString("зомби болезни",X,Y+y-12);
                g.drawString("третьей степени",X,Y+y);
            }
            case 18 -> {

            }
        }
    }
}
