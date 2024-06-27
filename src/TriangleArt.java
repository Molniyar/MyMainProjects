import java.awt.*;
import java.util.Arrays;

public class TriangleArt {
    TriangleArt(int size, Color background){
        triangleArt = new Color[size][size];

        for (int i = 0, i2 = 1; i < size; i++, i2+=2){
            triangleArt[i] = new Color[i2];
            Arrays.fill(triangleArt[i], background);
        }
    }

    Color[][] triangleArt;
}
