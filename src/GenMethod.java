public class GenMethod {
    public static BigPixelArt generate4x4(BigPixelArt art){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                int landCount = 0;
                if (isLand4x4(art, i, j - 4)){landCount++;}
                if (isLand4x4(art, i, j + 4)){landCount++;}
                if (isLand4x4(art, i - 4, j)){landCount++;}
                if (isLand4x4(art, i + 4, j)){landCount++;}
                if (isLand4x4(art, i + 4, j - 4)){landCount++;}
                if (isLand4x4(art, i - 4, j + 4)){landCount++;}
                if (isLand4x4(art, i - 4, j - 4)){landCount++;}
                if (isLand4x4(art, i + 4, j + 4)){landCount++;}
                if (MolniyarMethod.random(landCount * 15)){
                    set4x4(art, i * 4, j * 4, 34);
                }
                if (MolniyarMethod.random(100 - (landCount * 15))){
                    set4x4(art, i * 4, j * 4, 21);
                }
                if (landCount == 0) {
                    set4x4(art, i, j, 96);
                }
            }
        }
        return art;
    }
    public static boolean isLand4x4(BigPixelArt art, int x, int y){
        x = Math.clamp(x, 0, 7) * 4;
        y = Math.clamp(y, 0, 7) * 4;
        int landCount = 0;
        for (int i = x; i < x + 4; i++){
            for (int j = y; j < y + 4; j++){
                if (art.getColorCode(i, j) == 34){
                    landCount++;
                }
            }
        }
        return landCount == 16;
    }
    public static BigPixelArt set4x4(BigPixelArt art, int x, int y, int color){
        art.fillPixel(x, y, x + 3, y + 3, color);
        return art;
    }
}
