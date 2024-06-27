public class BuildingSet {
    public static void setHouse(OldPixelArt art, int x, int y){
        art.fillPixel(x,y,x+3,y+3, (short) 249);
        art.setPixel(x+1,y+1, (short) 159);art.setPixel(x+1,y+2, (short) 195);
        art.setPixel(x+2,y+1, (short) 159);art.setPixel(x+2,y+2, (short) 123);
    }
    public static void setRoof(OldPixelArt art, int x, int y){
        art.setPixel(x,y+1, (short) 247);art.setPixel(x,y+2, (short) 246);
        art.setPixel(x+1,y, (short) 247);art.setPixel(x+1,y+1, (short) 246);art.setPixel(x+1,y+2, (short) 246);art.setPixel(x+1,y+3, (short) 246);
    }
    public static void setLeftRoof(OldPixelArt art, int x, int y){
        art.setPixel(x,y+3, 160);//124
        art.setPixel(x+1,y+2, 160);art.setPixel(x+1,y+3, 124);
        art.setPixel(x+2,y+1, 160);art.setPixel(x+2,y+2, 124);art.setPixel(x+2,y+3, 124);
        art.setPixel(x+3,y, 160);art.setPixel(x+3,y+1, 124);art.setPixel(x+3,y+2, 124);art.setPixel(x+3,y+3, 124);
    }
    public static void setRightRoof(OldPixelArt art, int x, int y){
        art.setPixel(x,y, 160);//124
        art.setPixel(x+1,y, 124);art.setPixel(x+1,y+1, 160);
        art.setPixel(x+2,y, 124);art.setPixel(x+2,y+1, 124);art.setPixel(x+2,y+2, 160);
        art.setPixel(x+3,y, 124);art.setPixel(x+3,y+1, 124);art.setPixel(x+3,y+2, 124);art.setPixel(x+3,y+3, 160);
    }
    public static void setLeftPodporka(OldPixelArt art, int x, int y){
        art.setPixel(x,y,252);art.setPixel(x,y+1,252);
        art.setPixel(x+1,y,252);
    }
    public static void setRightPodporka(OldPixelArt art, int x, int y){
        art.setPixel(x,y,252);art.setPixel(x,y+1,252);
        art.setPixel(x+1,y+1,252);
    }
}
