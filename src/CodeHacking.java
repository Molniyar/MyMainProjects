import test1.PlaySound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.AttributedCharacterIterator;

public class CodeHacking {
    public static void main(String[] args) {
        Color white = new Color(255,255,255);

        int l = 6;
        if (args.length > 0){
            l = Integer.parseInt(args[0]);
        }
        byte[][] blocks = new byte[l][l];


        JFrame frame = new JFrame("Pixel art");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,770,800);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (int i = 0; i < blocks.length; i++){
                    for (int j = 0; j < blocks.length; j++){
                        int num = Math.min(getWidth(),getHeight());
                        int X = getWidth()  / blocks.length * i;
                        int Y = getHeight() / blocks.length * j;

                        int x = getWidth() / blocks.length;
                        int y = getHeight() / blocks.length;

                        g.setColor(new Color(0,0,0));
                        g.fillRect(X,Y,x,y);

                        int[] xs = {X,X+(x/8),X+(x/8*2),X+(x/8*3),X+(x/8*4),X+(x/8*5),X+(x/8*6),X+(x/8*7),X+(x)};
                        int[] ys = {Y,Y+(y/8),Y+(y/8*2),Y+(y/8*3),Y+(y/8*4),Y+(y/8*5),Y+(y/8*6),Y+(y/8*7),Y+y};
                        int xh = X+(x/16);
                        int yh = Y+(y/16);

                        //if (blocks[i][j] == 0){break;}
                        if ((blocks[i][j]&0x0f) < 12){
                            switch (blocks[i][j]>>4){
                                case 0 -> g.setColor(new Color(255,255,255));
                                case 1 -> g.setColor(new Color(255,0,0));
                                case 2 -> g.setColor(new Color(255,255,0));
                                case 3 -> g.setColor(new Color(0,255,0));
                                case 4 -> g.setColor(new Color(127,255,0));
                            }
                            switch (blocks[i][j] & 0x0f){
                                case 1 ->{
                                    g.fillPolygon(new int[]{xs[2],xs[2],xs[3],xs[5],xs[6],xs[6],xs[5],xs[3]},new int[]{ys[6],ys[2],ys[1],ys[1],ys[2],ys[6],ys[7],ys[7]},8);
                                }
                                //case 2 ->{g.fillPolygon();}
                                //case 3 ->{g.fillPolygon();}
                                //case 4 ->{g.fillPolygon();}
                                //case 5 ->{g.fillPolygon();}
                                //case 6 ->{g.fillPolygon();}
                                //case 7 ->{g.fillPolygon();}
                                //case 8 ->{g.fillPolygon();}
                                //case 9 ->{g.fillPolygon();}
                                //case 10->{g.fillPolygon();}

                            }
                        }

                    }

                }
            }
        };

        frame.add(panel);
        panel.setVisible(true);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                int mmx = x / (Math.min(panel.getWidth(),panel.getHeight()) / blocks.length);
                int mmy = y / (Math.min(panel.getWidth(),panel.getHeight()) / blocks.length);

                try {
                    switch (e.getButton()){
                        case MouseEvent.BUTTON1 -> blocks[mmx][mmy] = (byte) (Math.clamp((blocks[mmx][mmy] & 0x0f)+1,1,10));

                        //case MouseEvent.BUTTON2 -> keepColor[0] = blocks[x / (Math.min(panel.getWidth(),panel.getHeight()) / blocks.length)][y / (Math.min(panel.getWidth(),panel.getHeight()) / blocks.length)];
                        case MouseEvent.BUTTON3 -> blocks[mmx][mmy] = (byte) (Math.clamp((blocks[mmx][mmy] & 0x0f)-1,1,10));
                    }
                }catch (ArrayIndexOutOfBoundsException exception){
                    new PlaySound("1",1,500,20);
                }


                panel.updateUI();
            }
        });
    }
}
