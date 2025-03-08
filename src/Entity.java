import java.awt.event.KeyEvent;

public class Entity {
    static int x;
    static int y;
    static int direction;
    static int health;
    static PolygonArt[] textures;
    public Entity(int x, int y, int direction, int health, PolygonArt[] displayDirections, int type) throws Exception {
        if (displayDirections.length != 4){throw new Exception("displayDirections.length should be equal to 4");}
        if (direction >= 4){throw new Exception("direction can't be more than 3");}
        Entity.x = x;
        Entity.y = y;
        Entity.direction = direction;
        Entity.health = health;
        textures = displayDirections;
    }
    public void move(int direction_,int[][] world,boolean[] areWalkable){
        switch (direction_) {
            case KeyEvent.VK_W -> {
                if (y <= 0) {break;}
                if (direction == 0 && areWalkable[world[y - 1][x]]) {y = Math.clamp(y - 1, 0, world.length - 1);}
                else direction = 0;
            }
            case KeyEvent.VK_S -> {
                if (y >= world.length - 1) {break;}
                if (direction == 2 && areWalkable[world[y + 1][x]]) {y = Math.clamp(y + 1, 0, world.length - 1);}
                else direction = 2;
            }
            case KeyEvent.VK_A -> {
                if (x <= 0) {break;}
                if (direction == 3 && areWalkable[world[y][x - 1]]) {x = Math.clamp(x - 1, 0, world.length - 1);}
                else direction = 3;
            }
            case KeyEvent.VK_D -> {
                if (x >= world.length - 1) {break;}
                if (direction == 1 && areWalkable[world[y][x + 1]]) {x = Math.clamp(x + 1, 0, world.length - 1);}
                else direction = 1;
            }
        }
    }
    public void hit(int[][] world,int itemInHand){
        switch (itemInHand){
            case 19 -> health-=3;
            case 21 -> health-=4;
            case 23 -> health-=5;
            default -> health--;
        }
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getD(){return direction;}
}
