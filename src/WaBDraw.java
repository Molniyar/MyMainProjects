import java.awt.*;

public class WaBDraw {
    public static void drawWorld(Graphics g, int[][] world, int divider, int[] strengths, int[] currentBlock, int[] player, boolean[] areWalkable,  PolygonArt[] blocks, PolygonArt[] breakingProgress, PolygonArt playerView, int darkness){
        int num = Math.min(getWidth(), getHeight());
        int D = divider;
        int x = num / D;
        int y = num / D;

        for (int i = 0; i < D; i++) {
            for (int j = 0; j < D; j++) {
                int coordX = num / D * j;
                int coordY = num / D * i;

                if (blocks[world[i][j]&255] != null) {
                    blocks[world[i][j]&255].drawWithTurn(g, coordX, coordY, x, y,(world[i][j]>>8)&3);
                }
                if (i == currentBlock[0] && j == currentBlock[1]) {
                    int index = (int)((float)(strengths[world[i][j]]-currentBlock[2])/strengths[world[i][j]]*breakingProgress.length);
                    breakingProgress[index].drawOneColor(g, coordX, coordY, x, y, new Color(0,0,0,100));
                }
                if (i == player[0] && j == player[1]) {
                    playerView.drawWithTurn(g,coordX,coordY,x,y,player[2]);
                }

                g.setColor(new Color(0, 0, 0, WaBMethods.getDarkness(world, j, i, Math.clamp(darkness, 0, 200), areWalkable)));
                g.fillRect(coordX, coordY, x, y);
            }
        }

    }
    public static void drawHotBar(Graphics g, int[][] world){

    }
    public static void drawInventory(Graphics g, int[][] world){

    }
}
