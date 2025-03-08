import java.awt.*;

public class Textures {
    public Textures(){}
    public static PixelArt air(Color background) {
        PixelArt res = new PixelArt(8,background);

        return res;
    }
    public static PixelArt void_() {
        PixelArt res = new PixelArt(8);
        res.fillPixel(0,0,3,3,new Color(255,0,255));
        res.fillPixel(4,4,7,7,new Color(255,0,255));
        res.fillPixel(4,0,7,3,new Color(0,0,0));
        res.fillPixel(0,4,3,7,new Color(0,0,0));
        return res;
    }
    public static PixelArt marsStone() {
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

        return res;
    }
    public static PixelArt marsSoil() {
        PixelArt res = new PixelArt(8,new Color(221,116,0));

        res.setPixel(6,0,new Color(255,157,38));

        res.setPixel(1,1,new Color(240,126,0));
        res.setPixel(2,1,new Color(204,107,0));
        res.setPixel(4,1,new Color(240,126,0));
        res.setPixel(7,1,new Color(240,126,0));

        res.setPixel(0,2,new Color(204,107,0));
        res.setPixel(3,2,new Color(255,157,38));
        res.setPixel(5,2,new Color(240,126,0));

        res.setPixel(2,3,new Color(240,126,0));
        res.setPixel(4,3,new Color(204,107,0));
        res.setPixel(5,3,new Color(204,107,0));
        res.setPixel(6,3,new Color(240,126,0));

        res.setPixel(6,4,new Color(240,126,0));

        res.setPixel(2,5,new Color(204,107,0));
        res.setPixel(4,5,new Color(255,157,38));

        res.setPixel(1,6,new Color(240,126,0));
        res.setPixel(7,6,new Color(240,126,0));

        res.setPixel(5,7,new Color(204,107,0));

        return res;
    }
    public static PixelArt ice() {
        PixelArt res = new PixelArt(8,new Color(150,220,230));

        return res;
    }
    public static PixelArt acid(Color background) {
        PixelArt res = new PixelArt(8,background);
        res.fillPixel(0,2,7,7,new Color(0,255,0));
        return res;
    }
    public static PixelArt acid_left(Color background) {
        PixelArt res = new PixelArt(8,background);
        res.fillPixel(7,2,7,2,new Color(0,255,0));
        res.fillPixel(6,3,7,3,new Color(0,255,0));
        res.fillPixel(4,4,7,4,new Color(0,255,0));
        res.fillPixel(3,5,7,5,new Color(0,255,0));
        res.fillPixel(1,6,7,6,new Color(0,255,0));
        res.fillPixel(0,7,7,7,new Color(0,255,0));
        return res;
    }
    public static PixelArt acid_right(Color background) {
        PixelArt res = new PixelArt(8,background);
        res.fillPixel(0,2,0,2,new Color(0,255,0));
        res.fillPixel(0,3,1,3,new Color(0,255,0));
        res.fillPixel(0,4,3,4,new Color(0,255,0));
        res.fillPixel(0,5,4,5,new Color(0,255,0));
        res.fillPixel(0,6,6,6,new Color(0,255,0));
        res.fillPixel(0,7,7,7,new Color(0,255,0));
        return res;
    }
    public static PixelArt mushroom(Color background) {
        PixelArt res = new PixelArt(8,background);
        res.fillPixel(1,3,6,4,new Color(176,164,221));
        res.fillPixel(3,3,6,3,new Color(200,191,231));
        res.setPixel(6,4,new Color(200,191,231));
        res.fillPixel(3,5,3,7,new Color(125,107,199));
        res.fillPixel(4,5,4,7,new Color(150,135,239));
        return res;
    }
    public static PixelArt mushroom_cap() {
        PixelArt res = new PixelArt(8,new Color(200,191,231));
        return res;
    }
    public static PixelArt mushroom_stem() {
        PixelArt res = new PixelArt(8,new Color(125,107,199));
        res.fillPixel(2,0,2,4,new Color(150,135,239));
        res.fillPixel(4,3,4,7,new Color(150,135,239));
        res.fillPixel(6,1,6,5,new Color(150,135,239));
        return res;
    }
    public static PixelArt mushroom_planks() {
        PixelArt res = new PixelArt(8);
        return Textures.void_();
    }
    public static PixelArt iron_ore() {
        PixelArt res = Textures.marsStone();



        return res;
    }
    public static PixelArt gold_ore() {
        PixelArt res = Textures.marsStone();



        return res;
    }
    public static PixelArt mushroom_spore(Color background) {
        PixelArt res = new PixelArt(8, background);
        res.fillPixel(2,4,5,7,new Color(255,201,14));
        res.fillPixel(2,4,5,4,new Color(255,242,0));
        res.setPixel(2,5,new Color(255,242,0));
        res.fillPixel(3,7,5,7,new Color(255,127,39));
        res.setPixel(5,6,new Color(255,127,39));
        return res;
    }
    public static PixelArt mushroom_spore_2(Color background) {
        PixelArt res = new PixelArt(8, background);
        res.fillPixel(0,4,3,7,new Color(255,201,14));
        res.fillPixel(0,4,3,4,new Color(255,242,0));
        res.setPixel(0,5,new Color(255,242,0));
        res.fillPixel(1,7,3,7,new Color(255,127,39));
        res.setPixel(3,6,new Color(255,127,39));

        res.fillPixel(4,4,7,7,new Color(255,201,14));
        res.fillPixel(4,4,7,4,new Color(255,242,0));
        res.setPixel(4,5,new Color(255,242,0));
        res.fillPixel(5,7,7,7,new Color(255,127,39));
        res.setPixel(7,6,new Color(255,127,39));
        return res;
    }
    public static PixelArt mushroom_spore_2_(Color background) {
        PixelArt res = new PixelArt(8, background);

        res.fillPixel(2,0,5,3,new Color(255,201,14));
        res.fillPixel(2,0,5,0,new Color(255,242,0));
        res.setPixel(2,1,new Color(255,242,0));
        res.fillPixel(3,3,5,3,new Color(255,127,39));
        res.setPixel(5,2,new Color(255,127,39));

        res.fillPixel(2,4,5,7,new Color(255,201,14));
        res.fillPixel(2,4,5,4,new Color(255,242,0));
        res.setPixel(2,5,new Color(255,242,0));
        res.fillPixel(3,7,5,7,new Color(255,127,39));
        res.setPixel(5,6,new Color(255,127,39));

        return res;
    }
    public static PixelArt mushroom_spore_3(Color background) {
        PixelArt res = new PixelArt(8, background);
        res.fillPixel(2,0,5,3,new Color(255,201,14));
        res.fillPixel(2,0,5,0,new Color(255,242,0));
        res.setPixel(2,1,new Color(255,242,0));
        res.fillPixel(3,3,5,3,new Color(255,127,39));
        res.setPixel(5,2,new Color(255,127,39));

        res.fillPixel(0,4,3,7,new Color(255,201,14));
        res.fillPixel(0,4,3,4,new Color(255,242,0));
        res.setPixel(0,5,new Color(255,242,0));
        res.fillPixel(1,7,3,7,new Color(255,127,39));
        res.setPixel(3,6,new Color(255,127,39));

        res.fillPixel(4,4,7,7,new Color(255,201,14));
        res.fillPixel(4,4,7,4,new Color(255,242,0));
        res.setPixel(4,5,new Color(255,242,0));
        res.fillPixel(5,7,7,7,new Color(255,127,39));
        res.setPixel(7,6,new Color(255,127,39));
        return res;
    }
    public static PixelArt mushroom_spore_4(Color background) {
        PixelArt res = new PixelArt(8, background);

        res.fillPixel(0,0,3,3,new Color(255,201,14));
        res.fillPixel(0,0,3,0,new Color(255,242,0));
        res.setPixel(0,1,new Color(255,242,0));
        res.fillPixel(1,3,3,3,new Color(255,127,39));
        res.setPixel(3,2,new Color(255,127,39));

        res.fillPixel(4,0,7,3,new Color(255,201,14));
        res.fillPixel(4,0,7,0,new Color(255,242,0));
        res.setPixel(4,1,new Color(255,242,0));
        res.fillPixel(5,3,7,3,new Color(255,127,39));
        res.setPixel(7,2,new Color(255,127,39));


        res.fillPixel(0,4,3,7,new Color(255,201,14));
        res.fillPixel(0,4,3,4,new Color(255,242,0));
        res.setPixel(0,5,new Color(255,242,0));
        res.fillPixel(1,7,3,7,new Color(255,127,39));
        res.setPixel(3,6,new Color(255,127,39));

        res.fillPixel(4,4,7,7,new Color(255,201,14));
        res.fillPixel(4,4,7,4,new Color(255,242,0));
        res.setPixel(4,5,new Color(255,242,0));
        res.fillPixel(5,7,7,7,new Color(255,127,39));
        res.setPixel(7,6,new Color(255,127,39));

        return res;
    }
    public static PixelArt mushroom_cap_with_spore() {
        PixelArt res = new PixelArt(8,new Color(200,191,231));
        res.setPixel(2,2,new Color(255,242,0));
        res.setPixel(6,3,new Color(255,201,14));
        res.setPixel(4,6,new Color(255,127,39));
        return res;
    }
}
