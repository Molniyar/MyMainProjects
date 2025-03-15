import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaB_Block {
    static String name;
    static PolygonArt[] textures;
    static int strength;
    static boolean walkable;
    static int lightStrength = 0;
    static boolean directionable = false;
    static int textureIndex = 0;
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textureIndex = Math.clamp(0,textures.length-1,textureIndex+1);
        }
    });
    public WaB_Block(String name, PolygonArt texture, int strength, boolean walkable){//
        WaB_Block.name = name;
        textures = new PolygonArt[]{texture};
        WaB_Block.strength = strength;
        WaB_Block.walkable = walkable;
    }
    public WaB_Block(String name, PolygonArt[] textures, int strength, boolean walkable, int TTSTMillis){
        WaB_Block.name = name;
        WaB_Block.textures = textures;
        WaB_Block.strength = strength;
        WaB_Block.walkable = walkable;
        timer.setDelay(TTSTMillis);
    }
    public static String name()          {return name;}
    public static int strength()         {return strength;}
    public static boolean walkable()     {return walkable;}
    public static int lightStrength()    {return lightStrength;}
    public static boolean directionable(){return directionable;}

}
