public class PrintItem {
    public static void printFire() {

    }
    public static void printDiamond() {
        System.out.println(MolniyarMethod.getColorText("   А   Л   М   А   З    ", 0, 231));
        MiniPixelArt diamond = new MiniPixelArt();
        diamond.fillArt(231);
        diamond.setPixel(3,2,159);diamond.setPixel(3,3,123);diamond.setPixel(3,4,123);
        diamond.setPixel(4,1,159);diamond.setPixel(4,2,123);diamond.setPixel(4,3,51);diamond.setPixel(4,4,51);diamond.setPixel(4,5,51);
        diamond.setPixel(5,2,123);diamond.setPixel(5,3,51);diamond.setPixel(5,4,87);
        diamond.setPixel(6,3,87);
        diamond.printArt();
    }
    public static void printBox() {
        System.out.println(MolniyarMethod.getColorText("    Я    Щ    И    К    ", 0, 231));

        MiniPixelArt healthPotion = new MiniPixelArt();
        healthPotion.fillArt(231);
        healthPotion.fillPixel(1, 1, 6, 6, 130);
        healthPotion.fillPixel(2, 2, 5, 5, 172);
        for (int i = 0; i < 6; i++){
            healthPotion.setPixel(6 - i, i + 1, 130);
        }
        healthPotion.printArt();
        System.out.println(MolniyarMethod.getColorText("поставить: w,s,a,d + put", 0, 231));
        System.out.println(MolniyarMethod.getColorText("сломать: w,s,a,d + break", 0, 231));
    }
    public static void printApple() {
        System.out.println(MolniyarMethod.getColorText("    Я  Б  Л  О  К  О    ", 0, 231));

        MiniPixelArt apple = new MiniPixelArt();
        apple.fillArt(231);

        apple.fillPixel(4, 1, 6, 5, 160);
        apple.fillPixel(3, 2, 7, 4, 196);
        apple.fillPixel(4, 2, 6, 4, 160);
        apple.fillPixel(7, 2, 7, 4, 88);
        apple.fillPixel(4, 1, 4, 3, 196);
        apple.fillPixel(5, 1, 5, 2, 196);
        apple.setPixel(4, 2, 204);
        apple.setPixel(6, 5, 88);
        apple.setPixel(5, 5, 88);

        apple.setPixel(3, 3, 52);
        apple.setPixel(2, 3, 52);
        apple.setPixel(1, 2, 52);

        apple.setPixel(2, 4, 40);
        apple.setPixel(1, 5, 40);
        apple.setPixel(2, 5, 28);
        apple.setPixel(1, 6, 34);

        apple.printArt();

        System.out.println(MolniyarMethod.getColorText("Здоровье + 1            ", 0, 231));
        System.out.println(MolniyarMethod.getColorText("Голод - 2               ", 0, 231));
    }
    public static void printRedPillow() {
        System.out.println(MolniyarMethod.getColorText("  К  Р  А  С  Н  А  Я   ", 0, 231));
        System.out.println(MolniyarMethod.getColorText(" Т  А  Б  Л  Е  Т  К  А ", 0, 231));
        MiniPixelArt redPillow = new MiniPixelArt();
        redPillow.fillArt(231);
        redPillow.fillPixel(2, 3, 4, 5, 160);
        redPillow.fillPixel(3, 2, 5, 4, 252);
        redPillow.fillPixel(6, 2, 6, 3, 252);
        redPillow.fillPixel(4, 1, 5, 1, 252);
        redPillow.setPixel(3, 4, 160);
        redPillow.fillPixel(2, 6, 3, 6, 124);
        redPillow.fillPixel(1, 4, 1, 5, 160);
        redPillow.setPixel(4, 5, 124);
        redPillow.setPixel(5, 4, 249);
        redPillow.setPixel(6, 3, 249);
        redPillow.setPixel(4, 4, 251);
        redPillow.setPixel(6, 2, 251);
        redPillow.setPixel(2, 4, 204);
        redPillow.setPixel(3, 3, 254);
        redPillow.setPixel(4, 2, 255);
        redPillow.printArt();
        System.out.println(MolniyarMethod.getColorText("здоровье + 3            ", 0, 231));
    }
    public static void printBluePillow() {
        System.out.println(MolniyarMethod.getColorText("     С  И  Н  Я  Я      ", 0, 231));
        System.out.println(MolniyarMethod.getColorText(" Т  А  Б  Л  Е  Т  К  А ", 0, 231));
        MiniPixelArt bluePillow = new MiniPixelArt();
        bluePillow.fillArt(231);
        bluePillow.fillPixel(2, 3, 4, 5, 20);//160
        bluePillow.fillPixel(3, 2, 5, 4, 252);
        bluePillow.fillPixel(6, 2, 6, 3, 252);
        bluePillow.fillPixel(4, 1, 5, 1, 252);
        bluePillow.setPixel(3, 4, 20);
        bluePillow.fillPixel(2, 6, 3, 6, 19);//124
        bluePillow.fillPixel(1, 4, 1, 5, 20);
        bluePillow.setPixel(4, 5, 19);
        bluePillow.setPixel(5, 4, 249);
        bluePillow.setPixel(6, 3, 249);
        bluePillow.setPixel(4, 4, 251);
        bluePillow.setPixel(6, 2, 251);
        bluePillow.setPixel(2, 4, 57);
        bluePillow.setPixel(3, 3, 254);
        bluePillow.setPixel(4, 2, 255);
        bluePillow.printArt();
        System.out.println(MolniyarMethod.getColorText("голод - 3               ", 0, 231));
    }
    public static void printLuckyBlock() {
        System.out.println(MolniyarMethod.getColorText(" Л А К И   -   Б Л О К  ", 0, 231));

        MiniPixelArt healthPotion = new MiniPixelArt();
        healthPotion.fillArt(231);
        healthPotion.fillPixel(1, 1, 6, 6, 214);
        healthPotion.fillPixel(2, 2, 5, 5, 226);
        healthPotion.setPixel(5, 3, 220);
        healthPotion.setPixel(3, 4, 220);
        healthPotion.setPixel(2, 4, 220);
        healthPotion.setPixel(2, 3, 220);
        healthPotion.setPixel(1, 1, 208);
        healthPotion.setPixel(6, 1, 208);
        healthPotion.setPixel(1, 6, 208);
        healthPotion.fillPixel(3, 6, 6, 6, 208);
        healthPotion.setPixel(6, 6, 202);
        healthPotion.setPixel(5, 6, 208);
        healthPotion.setPixel(4, 6, 208);
        healthPotion.printArt();
        System.out.println(MolniyarMethod.getColorText("раскрыть: open          ", 0, 231));
        System.out.println(MolniyarMethod.getColorText("lucky - block           ", 0, 231));
    }

    public static void printInventory(int appleCount, int redPillow, int bluePillow, int hunger, int health, int boxCount) {
        System.out.println(MolniyarMethod.getColorText("\uD83C\uDF4E - " + appleCount + " шт              ", 0, 231));
        System.out.println(MolniyarMethod.getColorText("\uD83D\uDC8A - " + redPillow  + " шт              ", 0, 231));
        System.out.println(MolniyarMethod.getColorText("\uD83D\uDC8A - " + bluePillow + " шт              ", 0, 231));
        System.out.println(MolniyarMethod.getColorText("\uD83D\uDCE6 - " + boxCount   + " шт              ", 0, 231));
        System.out.println(MolniyarMethod.getColorText(" ? ", 202,226) + MolniyarMethod.getColorText(" - " + boxCount   + " шт             ", 0, 231));
        //System.out.print(MolniyarMethod.getColorText("  ", 20, 231));
        for (int i = 1; i <= 10; i++){
            if (i <= health) {
                System.out.print(MolniyarMethod.getColorText("♥", 160, 231));
            }
            else System.out.print(MolniyarMethod.getColorText("♥", 231, 231));
            System.out.print(MolniyarMethod.getColorText("♥", 231, 231));
        }
        System.out.println(" ");
        for (int i = 1; i <= 10; i++){
            if (i <= hunger) {
                System.out.print(MolniyarMethod.getColorText("\uD83C\uDF57", 0, 231));
            }//                                                      🍗
            else System.out.print(MolniyarMethod.getColorText("  ", 0, 231));
        }
        System.out.println(" ");
    }
}
