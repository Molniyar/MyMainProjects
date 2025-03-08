import test1.PlaySound;

import java.awt.*;
import java.util.Arrays;

public class Decoder {
    public static void main(String[] args) {
        PixelArt res = new PixelArt(8,new Color(136,0,21));

        res.setPixel(1,0,new Color(166,0,4));
        res.setPixel(2,0,new Color(166,0,4));
        res.setPixel(4,0,new Color(166,0,4));
        res.setPixel(5,0,new Color(166,0,4));
        res.setPixel(6,0,new Color(166,0,4));
        res.setPixel(7,0,new Color(166,0,4));

        res.setPixel(0,1,new Color(166,0,4));
        res.setPixel(1,1,new Color(166,0,4));
        res.setPixel(4,1,new Color(166,0,4));
        res.setPixel(5,1,new Color(166,0,4));
        res.setPixel(7,1,new Color(166,0,4));

        res.setPixel(5,2,new Color(166,0,4));

        res.setPixel(2,3,new Color(166,0,4));
        res.setPixel(3,3,new Color(166,0,4));
        res.setPixel(7,3,new Color(166,0,4));

        res.setPixel(1,5,new Color(166,0,4));
        res.setPixel(5,5,new Color(166,0,4));
        res.setPixel(6,5,new Color(166,0,4));
        res.setPixel(7,5,new Color(166,0,4));

        res.setPixel(2,6,new Color(166,0,4));
        res.setPixel(3,6,new Color(166,0,4));

        res.setPixel(5,7,new Color(166,0,4));
        res.setPixel(6,7,new Color(166,0,4));
        res.setPixel(7,7,new Color(166,0,4));

        System.out.println(Arrays.deepToString(res.pixelArt));

    }
}
