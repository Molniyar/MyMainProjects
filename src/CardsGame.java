import java.util.Arrays;

public class CardsGame {
    public static void main(String[] args) {
        GiantPixelArt art2 = new GiantPixelArt();
        //                 21 ocean
        //                 19 deep ocean
        //                 18 deeper ocean
        //                 17 the deepest ocean
        //                 17 the deepest ocean
        //                 17 the deepest ocean
        //                 46 mountains and land
        art2.fillArt(21);
        int pathCount = 5;
        int walkCount = 1500;
        for (int x = 0; x < pathCount; x++) {
            int rx2 = (int) (Math.random() * 64);
            int ry2 = (int) (Math.random() * 64);
            for (int i = 0; i < walkCount; i++) {
                int random = (int) (Math.random() * 4 + 1);
                switch (random) {
                    case 1 -> rx2++;
                    case 2 -> rx2--;
                    case 3 -> ry2++;
                    case 4 -> ry2--;
                }
                rx2 = Math.clamp(rx2, 0, 63);
                ry2 = Math.clamp(ry2, 0, 63);
                switch (art2.getColorCode(rx2, ry2)) {
                    case 17  -> art2.setPixel(rx2, ry2, 18);//deep ocean
                    case 18  -> art2.setPixel(rx2, ry2, 19);//deep ocean
                    case 19  -> art2.setPixel(rx2, ry2, 20);//deep ocean
                    case 20  -> art2.setPixel(rx2, ry2, 21);//ocean
                    case 21  -> art2.setPixel(rx2, ry2, 27);//ocean
                    case 27  -> art2.setPixel(rx2, ry2, 33);//ocean
                    case 33  -> art2.setPixel(rx2, ry2, 39);//ocean
                    case 39  -> art2.setPixel(rx2, ry2, 45);//ocean
                    case 45  -> art2.setPixel(rx2, ry2, 123);//ocean
                    case 123 -> art2.setPixel(rx2, ry2, 228);//beach
                    case 228 -> art2.setPixel(rx2, ry2, 190);//beach
                    case 190 -> art2.setPixel(rx2, ry2, 82);//beach with plants
                    case 82  -> art2.setPixel(rx2, ry2, 46);//land
                    case 46  -> art2.setPixel(rx2, ry2, 76);//land
                    case 76  -> art2.setPixel(rx2, ry2, 70);//land
                    case 70  -> art2.setPixel(rx2, ry2, 64);//hill
                    case 64  -> art2.setPixel(rx2, ry2, 58);//hill
                    case 58  -> art2.setPixel(rx2, ry2, 246);//cliffs
                    case 246 -> art2.setPixel(rx2, ry2, 241);//cliffs
                    case 241 -> art2.setPixel(rx2, ry2, 238);//high cliffs
                }
            }
        }
        art2.printArt();
    }
}
