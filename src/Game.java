import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BigPixelArt map = new BigPixelArt();
        int x = 15;
        int y = 15;
        map.fillArt(238);//238

        map.fillPixel(9, 1, 11, 30, 247);
        map.fillPixel(14, 14, 16, 16, 247);
        map.fillPixel(1, 1, 7, 8, 247);
        map.fillPixel(1, 10, 7, 17, 247);
        map.fillPixel(1, 18, 1, 24, 247);
        map.fillPixel(1, 24, 5, 24, 247);
        map.fillPixel(5, 24, 5, 30, 247);
        map.fillPixel(5, 30, 10, 30, 247);
        map.setPixel( 5, 8, 247);
        map.fillPixel(12, 15, 14, 15, 247);
        map.setPixel(1, 11, 178);
        map.setPixel(1, 9, 178);
        map.setPixel(1, 1, 178);
        map.setPixel(1, 3, 178);
        map.setPixel(1, 4, 178);
        map.setPixel(8, 7, 178);
        map.setPixel(10, 1, 178);
        map.setPixel(10, 4, 178);
        map.setPixel(10, 6, 178);
        map.setPixel(8, 1, 172);

        int hunger = 10;
        int health = 10;

        int appleCount = 0;
        int redPillow = 0;
        int bluePillow = 0;

        int boxCount = 0;
        int luckyBlock = 0;
        int item = 0;

        int breakCount = 0;
        int putCount = 0;
        int lootingCount = 0;
        int eatAppleCount = 0;
        int eatRedPillowCount = 0;
        int eatBluePillowCount = 0;
        int luckyBlocksOpened = 0;

        for (;true;){
            String moveCommand = input.nextLine();
            switch (moveCommand.trim()){
                case "show items": {
                    PrintItem.printInventory(appleCount, redPillow, bluePillow, hunger, health, boxCount);
                }
                case "use": {
                    String s = input.nextLine();
                    switch (s.trim().toLowerCase()){
                        case "apple": {
                            if (appleCount > 0){
                                health++;
                                if (health > 10){
                                    health = 10;
                                }
                                hunger += 2;
                                if (hunger > 10){
                                    hunger = 10;
                                }
                                eatAppleCount++;
                            }
                        }
                        case "red pillow": {
                            if (redPillow > 0){
                                health += 3;
                                if (health > 10){
                                    health = 10;
                                }
                                eatRedPillowCount++;
                            }
                        }
                        case "blue pillow": {
                            if (bluePillow > 0){
                                hunger += 3;
                                if (hunger > 10){
                                    hunger = 10;
                                }
                                eatBluePillowCount++;
                            }
                        }
                    }
                }
                case "w": {
                    if (map.getColorCode(x - 1, y) != 238 && map.getColorCode(x - 1, y) != 172){
                        x--;
                    }
                    if (MolniyarMethod.random(5)){
                        hunger--;
                    }
                    break;
                }
                case "s": {
                    if (map.getColorCode(x + 1, y) != 238 && map.getColorCode(x + 1, y) != 172){
                        x++;
                    }
                    if (MolniyarMethod.random(5)){
                        hunger--;
                    }
                    break;
                }
                case "a": {
                    if (map.getColorCode(x, y - 1) != 238 && map.getColorCode(x, y - 1) != 172){
                        y--;
                    }
                    if (MolniyarMethod.random(5)){
                        hunger--;
                    }
                    break;
                }
                case "d": {
                    if (map.getColorCode(x, y + 1) != 238 && map.getColorCode(x, y + 1) != 172){
                        y++;
                    }
                    if (MolniyarMethod.random(5)){
                        hunger--;
                    }
                    break;
                }
                case "W": {
                    if (map.getColorCode(x - 1, y) != 238 && map.getColorCode(x - 1, y) != 172){
                        x--;
                    }
                    if (map.getColorCode(x - 1, y) != 238 && map.getColorCode(x + 1, y) != 172 && hunger > 3){
                        x--;
                    }
                    if (MolniyarMethod.random(25)){
                        hunger--;
                    }
                    break;
                }
                case "S": {
                    if (map.getColorCode(x + 1, y) != 238 && map.getColorCode(x + 1, y) != 172){
                        x++;
                    }
                    if (map.getColorCode(x + 1, y) != 238 && map.getColorCode(x + 1, y) != 172 && hunger > 3){
                        x++;
                    }
                    if (MolniyarMethod.random(25)){
                        hunger--;
                    }
                    break;
                }
                case "A": {
                    if (map.getColorCode(x, y - 1) != 238 && map.getColorCode(x, y - 1) != 172){
                        y--;
                    }
                    if (map.getColorCode(x, y - 1) != 238 && map.getColorCode(x, y - 1) != 172 && hunger > 3){
                        y--;
                    }
                    if (MolniyarMethod.random(25)){
                        hunger--;
                    }
                    break;
                }
                case "D": {
                    if (map.getColorCode(x, y + 1) != 238 && map.getColorCode(x, y + 1) != 172){
                        y++;
                    }
                    if (map.getColorCode(x, y + 1) != 238 && map.getColorCode(x, y + 1) != 172 && hunger > 3){
                        y++;
                    }
                    if (MolniyarMethod.random(25)){
                        hunger--;
                    }
                    break;
                }
                case "w break": {
                    if (map.getColorCode(x - 1, y) == 172){
                        map.setPixel(y, x - 1, 247);
                        boxCount++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (MolniyarMethod.random(20)){
                            hunger--;
                        }
                        breakCount++;
                    }
                    break;
                }
                case "s break": {
                    if (map.getColorCode(x + 1, y) == 172){
                        map.setPixel(y, x + 1, 247);
                        boxCount++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (MolniyarMethod.random(20)){
                            hunger--;
                        }
                        breakCount++;
                    }
                    break;
                }
                case "a break": {
                    if (map.getColorCode(x, y - 1) == 172){
                        map.setPixel(y - 1, x, 247);
                        boxCount++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (MolniyarMethod.random(20)){
                            hunger--;
                        }
                        breakCount++;
                    }
                    break;
                }
                case "d break": {
                    if (map.getColorCode(x, y + 1) == 172){
                        map.setPixel(x + 1, y, 247);
                        boxCount++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (MolniyarMethod.random(20)){
                            hunger--;
                        }
                        breakCount++;
                    }
                    break;
                }
                case "w put": {
                    if (boxCount > 0 && map.getColorCode(x - 1, y) == 247){
                        map.setPixel(y, x - 1, 172);
                        boxCount--;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (MolniyarMethod.random(15)){
                            hunger--;
                        }
                        putCount++;
                    }
                    break;
                }
                case "s put": {
                    if (boxCount > 0 && map.getColorCode(x + 1, y) == 247){
                        map.setPixel(y, x + 1, 172);
                        boxCount--;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (MolniyarMethod.random(15)){
                            hunger--;
                        }
                        putCount++;
                    }
                    break;
                }
                case "a put": {
                    if (boxCount > 0 && map.getColorCode(x, y - 1) == 247){
                        map.setPixel(y - 1, x, 172);
                        boxCount--;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (MolniyarMethod.random(15)){
                            hunger--;
                        }
                        putCount++;
                    }
                    break;
                }
                case "d put": {
                    if (boxCount > 0 && map.getColorCode(x, y + 1) == 247){
                        map.setPixel(y + 1, x, 172);
                        boxCount--;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (MolniyarMethod.random(15)){
                            hunger--;
                        }
                        putCount++;
                    }
                    break;
                }
                case "stop": {
                    System.out.println("Выйти из игры?");
                    System.out.println("усли вы выйдете из игры, весь прогресс сбросится");
                    String s = input.nextLine();
                    if (s.trim().equals("да") || s.trim().equals("покинуть игру") || s.trim().equals("выйти из игры") || s.trim().equals("true") || s.trim().equals("yes")){
                        System.out.println();
                        return;
                    }

                }
            }
            if (map.getColorCode(x, y) == 178){
                map.setPixel(x, y, 247);
                System.out.println(MolniyarMethod.getColorText(" В Ы  П О Л У Ч И Л И : ", 0, 231));
                System.out.println(MolniyarMethod.getColorText("                        ", 0, 231));
                if (MolniyarMethod.random(35)){
                    PrintItem.printRedPillow();
                    redPillow++;
                }
                if (MolniyarMethod.random(15)){
                    PrintItem.printBluePillow();
                    bluePillow++;
                }
                if (MolniyarMethod.random(20)){
                    PrintItem.printApple();
                    appleCount++;
                }
                if (MolniyarMethod.random(70)){
                    PrintItem.printBox();
                    boxCount++;
                }
                System.out.println(MolniyarMethod.getColorText("                        ", 0, 231));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (hunger <= 0){
                health--;
                if (hunger < 0){
                    hunger = 0;
                }
            }
            if (health <= 0){
                System.out.println(MolniyarMethod.getColorText("                        ", 16, 160));
                System.out.println(MolniyarMethod.getColorText("       Вы умерли.       ", 16, 160));
                System.out.println(MolniyarMethod.getColorText("                        ", 16, 160));
                hunger = 10;
                health = 10;
                x = 15;
                y = 15;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            map.printArtWithPlayer(x, y);
        }
    }
}