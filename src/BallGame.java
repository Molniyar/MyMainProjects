import test1.PlaySound;

import java.io.IOException;
import java.util.Scanner;

public class BallGame {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        int volume = 50;

        System.out.println("выберите сложность");
        int difficulty = Math.clamp(input.nextInt(),1,3);
        input.nextLine();

        System.out.println("выберите текстурпак (1 - классический, 2 - яркий, 3 - тусклый, 4 - пастельный, 5 - чёрно-белый)");
        String texture = input.nextLine();

        int red = 9;
        int green = 10;
        int blue = 12;
        int yellow = 11;
        int violet = 13;
        int bomb = 8;
        int void_ = 231;

        switch (texture){
            case "2" ->{
                red = 196;
                yellow = 226;
                green = 46;
                blue = 21;
                violet = 200;
                bomb = 240;
            }
            case "3" ->{
                red = 124;
                yellow = 178;
                green = 106;
                blue = 18;
                violet = 91;
                bomb = 235;
                void_ = 252;
            }
            case "4" ->{
                red = 219;
                yellow = 228;
                green = 157;
                blue = 45;
                violet = 93;
                bomb = 58;
            }
            case "5" ->{
                red = 237;
                yellow = 250;
                green = 243;
                blue = 236;
                violet = 244;
                bomb = 233;
            }
            case "6" ->{
                red = 205;
                yellow = 226;
                green = 118;
                blue = 123;
                violet = 212;
                void_ = 16;
            }
        }
        OldPixelArt Art = new OldPixelArt(12);
        Art.fillArt((short) void_);

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 12; j++){
                switch (MolniyarMethod.randomNumber(1,difficulty + 3)){
                    case 1 -> Art.setPixel(i,j, (short) red);
                    case 2 -> Art.setPixel(i,j, (short) green);
                    case 3 -> Art.setPixel(i,j, (short) blue);
                    case 4 -> {
                        if (MolniyarMethod.random(10)){
                            Art.setPixel(i, j, (short) bomb);
                        }
                        Art.setPixel(i, j, (short) void_);
                    }
                    case 5 -> Art.setPixel(i,j, (short) yellow);
                    case 6 -> Art.setPixel(i,j, (short) violet);
                }
            }
        }
        int count = 0;
        for (boolean isRunning = true; isRunning;){
            int color = 0;
            switch (MolniyarMethod.randomNumber(1,difficulty + 3)){
                case 1 -> color = red;
                case 2 -> color = blue;
                case 3 -> color = green;
                case 4 -> color = bomb;
                case 5 -> color = yellow;
                case 6 -> color = violet;
            }
            Art.printArt();
            System.out.println(MolniyarMethod.getColorText(" 1  2  3  4  5  6  7  8  9 10 11 12 ",100,void_));
            System.out.println();
            System.out.println(MolniyarMethod.getColorText("   ",0,color));

            int in = Math.clamp(input.nextInt(),1,12);
            Art.setPixel(11,in - 1, (short) color);
            int i = 11;
            for (;true;){
                if (i == 0 || Art.getColorCode(i-1,in - 1) != void_){
                    break;
                }
                else {
                    Art.setPixel(i,in - 1, (short) void_);
                    i--;
                    Art.setPixel(i,in - 1, (short) color);
                    MolniyarMethod.sleep(100);
                    Art.printArt();
                    System.out.println();
                }
            }
            int y = in - 1;
            if (color == bomb){
                Art.setPixel(i-1, y-1, (short) void_);Art.setPixel(i, y-1, (short) void_);Art.setPixel(i+1, y-1, (short) void_);
                Art.setPixel(i-1, y,      (short) void_);Art.setPixel(i, y,      (short) void_);Art.setPixel(i+1, y,       (short) void_);
                Art.setPixel(i-1, y+1, (short) void_);Art.setPixel(i, y+1, (short) void_);Art.setPixel(i+1, y+1, (short) void_);
                new PlaySound("3",1,40,volume);
                MolniyarMethod.sleep(100);
                Art.printArt();
                System.out.println();
            }
            else {
                boolean del = false;
                if (y < 11){
                    if (Art.getColorCode(i, y + 1) == color) {Art.setPixel(i, y + 1, (short) void_);del = true;}
                    if (Art.getColorCode(i + 1, y + 1) == color) {Art.setPixel(i + 1, y + 1, (short) void_);del = true;}
                    if (i > 0){
                        if (Art.getColorCode(i - 1, y + 1) == color) {Art.setPixel(i - 1, y + 1, (short) void_);del = true;}
                    }
                }

                if (y > 0){
                    if (Art.getColorCode(i + 1, y - 1) == color) {Art.setPixel(i + 1, y - 1, (short) void_);del = true;}
                    if (Art.getColorCode(i, y - 1) == color) {Art.setPixel(i, y - 1, (short) void_);del = true;}
                    if (i > 0){
                        if (Art.getColorCode(i - 1, y - 1) == color) {Art.setPixel(i - 1, y - 1, (short) void_);del = true;}
                    }
                }

                if (Art.getColorCode(i + 1, y) == color) {Art.setPixel(i + 1, y, (short) void_);del = true;}
                if (i > 0){
                    if (Art.getColorCode(i - 1, y) == color) {Art.setPixel(i - 1, y, (short) void_);del = true;}
                }

                if (del) {Art.setPixel(i, y, (short) void_);new PlaySound("2",1,780,volume);}
                else new PlaySound("1",1,110,volume);



                MolniyarMethod.sleep(100);
                Art.printArt();
                System.out.println();
            }
            boolean continue_ = false;
            for (int x = 0; x < 12; x++){
                for (int j = 0; j < 12; j++){
                    if (Art.getColorCode(x,j) != void_){
                        continue_ = true;
                        break;
                    }
                }
            }
            count++;
            isRunning = continue_;
        }
        new PlaySound("2",2,261,volume);
        MolniyarMethod.sleep(200);
        new PlaySound("2",4,392,volume);
        MolniyarMethod.sleep(400);
        System.out.println(MolniyarMethod.getColorText("количество шагов: " + count,100,void_));
    }
}
