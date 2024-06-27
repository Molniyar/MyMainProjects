public class Arts {
    public static void main(String[] args) {
        MiniPixelArt art = new MiniPixelArt();
        //MolniyarMethod.fakeException("main");
        MolniyarMethod.fakeEnd();
        whiteNoise(art);whiteNoise(art);
        whiteNoise(art);whiteNoise(art);
        blueBall(art,300);blueBall(art,300);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ant(art, 300);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        islandGenerating(art, 100, 200);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        blueBall(art,300);blueBall(art,300);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        colourfulChanges(art, 300);colourfulChanges(art, 300);colourfulChanges(art, 300);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pattern(300, 20);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        potionAdvertising(art, 300);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ant(art, 300);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        islandGenerating(art, 100, 150);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        islandGenerating(art, 100, 190);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        blueBall(art,300);blueBall(art,300);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pattern(300, 10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        blueBall(art,300);blueBall(art,300);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ant(art, 300);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        islandGenerating(art, 100, 250);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        whiteNoise(art);whiteNoise(art);
    }
    public static void whiteNoise(MiniPixelArt art) {
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                int r = MolniyarMethod.randomNumber(232, 256);
                if (r == 256){art.setPixel(i, j, 231);}
                else art.setPixel(i, j, r);
            }
        }
        art.printArt();
        System.out.println();
        System.out.println();
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void blueBall(MiniPixelArt art, int millis) {
        art.fillArt(231);
        art.setPixel(1,0,240);//move
        art.setPixel(1,1,16);
        art.setPixel(2,2,16);
        art.setPixel(3,3,16);
        art.setPixel(5,5,16);
        art.setPixel(4,6,16);
        art.setPixel(3,7,16);
        art.setPixel(6,4,16);
        art.setPixel(7,3,16);
        art.setPixel(7,2,16);
        art.setPixel(7,1,16);
        art.setPixel(0, 0, 21);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(0,1,21);
        art.setPixel(0,0,231);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(0,1, 231);
        art.setPixel(1,2, 21);
        art.setPixel(1,0, 231);
        art.setPixel(2,0, 240);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(1,2,231);
        art.setPixel(2,3,21);
        art.setPixel(2,0,231);
        art.setPixel(3,0,240);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(2,3,231);
        art.setPixel(3,4,21);
        art.setPixel(3,0,231);
        art.setPixel(4,0,240);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(3,4,231);
        art.setPixel(4,5,21);
        art.setPixel(4,0,231);
        art.setPixel(5,0,240);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(4,5,231);
        art.setPixel(3,6,21);
        art.setPixel(5,0,231);
        art.setPixel(6,0,240);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(3,6,231);
        art.setPixel(4,5,21);
        art.setPixel(6,0,231);
        art.setPixel(7,0,240);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(4,5,231);
        art.setPixel(5,4,21);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(5,4,231);
        art.setPixel(6,3,21);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(6,3,231);
        art.setPixel(6,2,21);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(6,2,231);
        art.setPixel(6,1,21);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(6,1,231);
        art.setPixel(6,0,21);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(5,0,21);
        art.setPixel(6,0,240);
        art.setPixel(7,0,231);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(4,0,21);
        art.setPixel(5,0,240);
        art.setPixel(6,0,231);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(3,0,21);
        art.setPixel(4,0,240);
        art.setPixel(5,0,231);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(2,0,21);
        art.setPixel(3,0,240);
        art.setPixel(4,0,231);
        art.printArt();
        //System.out.println();
        //System.out.println();
        //System.out.println();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(1,0,21);
        art.setPixel(2,0,240);
        art.setPixel(3,0,231);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(0,0,21);
        art.setPixel(1,0,240);
        art.setPixel(2,0,231);
        art.printArt();
    }
    public static void colourfulChanges(MiniPixelArt art, int millis) {
        art.fillArt(231);
        int one = 82;
        int two = 21;
        int three = 196;
        for (int i = 0; i < 3; i++) {
            art.fillPixel(2, 2, 3, 3, one);
            art.fillPixel(2, 4, 3, 5, two);
            art.fillPixel(4, 4, 5, 5, three);
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            art.fillPixel(3, 2, 4, 3, one);
            art.fillPixel(2, 2, 2, 3, 231);
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            art.fillPixel(4, 2, 5, 3, one);
            art.fillPixel(3, 2, 3, 3, 231);
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            art.fillPixel(2, 3, 3, 4, two);
            art.fillPixel(2, 5, 3, 5, 231);
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            art.fillPixel(2, 2, 3, 3, two);
            art.fillPixel(2, 4, 3, 4, 231);
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            art.fillPixel(3, 4, 4, 5, three);
            art.fillPixel(5, 4, 5, 5, 231);
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            art.fillPixel(2, 4, 3, 5, three);
            art.fillPixel(4, 4, 4, 5, 231);
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            art.fillPixel(4, 3, 5, 4, one);
            art.fillPixel(4, 2, 5, 2, 231);
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            art.fillPixel(4, 4, 5, 5, one);
            art.fillPixel(4, 3, 5, 3, 231);
            art.printArt();
            int keep = one;
            one = two;
            two = three;
            three = keep;
        }
    }
    public static void potionAdvertising(MiniPixelArt art, int millis) {
        art.fillArt(231);
        art.fillPixel(3,0,5,0,45);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.fillPixel(3,1,5,1,45);
        art.setPixel(4, 0, 201);
        art.setPixel(2, 0, 130);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.fillPixel(3,2,5,2,45);
        art.setPixel(4, 1, 201);
        art.setPixel(4, 0, 45);
        art.setPixel(2, 0, 231);
        art.setPixel(2, 1, 130);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.fillPixel(3,3,5,3,45);
        art.fillPixel(3,0,5,0,231);
        art.setPixel(4, 2, 201);
        art.setPixel(4, 1, 45);
        art.setPixel(2, 1, 231);
        art.setPixel(2, 2, 130);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.fillPixel(3,4,5,4,45);
        art.fillPixel(3,1,5,1,231);
        art.setPixel(4, 3, 201);
        art.setPixel(4, 2, 45);
        art.setPixel(2, 2, 231);
        art.setPixel(2, 3, 130);
        art.printArt();
        try {
            Thread.sleep(millis + millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(4,3,106);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(4,3,98);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(4,3,201);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(2,3,231);
        art.setPixel(2,4,130);
        art.setPixel(3,2,231);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(3,3,130);
        art.setPixel(2,4,231);
        art.setPixel(3,2,45);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(3,2,231);
        art.setPixel(5,2,231);
        art.setPixel(3,4,231);
        art.setPixel(5,4,231);
        art.printArt();
        try {
            Thread.sleep(millis / 2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.fillPixel(3,2,5,4,231);
        art.setPixel(3,2,219);
        art.setPixel(5,2,219);
        art.setPixel(3,4,219);
        art.setPixel(5,4,219);
        art.printArt();
        try {
            Thread.sleep(millis / 2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.fillPixel(3,2,5,4,231);
        art.setPixel(3,1,219);
        art.setPixel(2,2,219);
        art.setPixel(6,2,219);
        art.setPixel(5,1,219);
        art.setPixel(2,4,219);
        art.setPixel(3,5,219);
        art.setPixel(6,4,219);
        art.setPixel(5,5,219);
        art.printArt();
        try {
            Thread.sleep(millis / 2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        art.setPixel(3,1,231);
        art.setPixel(2,0,219);

        art.setPixel(2,2,231);

        art.setPixel(6,2,231);
        art.setPixel(7,7,219);

        art.setPixel(5,1,231);
        art.setPixel(7,3,219);

        art.setPixel(2,4,231);

        art.setPixel(3,5,231);
        art.setPixel(1,7,219);

        art.setPixel(6,4,231);
        art.setPixel(5,5,231);
        art.printArt();
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void ant(MiniPixelArt map, int millis){
        map.fillArt(231);
        int foodX = MolniyarMethod.randomNumber(0, 7);
        int foodY = MolniyarMethod.randomNumber(0, 7);

        int walkCount = 16;
        int x = MolniyarMethod.randomNumber(0, 7);
        int y = MolniyarMethod.randomNumber(0, 7);
        map.setPixel(x,y,16);
        map.printArt();
        for (int i = 0; true; i++){
            map.setPixel(x, y, 255);
            //int r = MolniyarMethod.randomNumber(0, 1);
            if (foodX < x){x--;walkCount--;}
            if (foodX > x){x++;walkCount--;}
            if (foodY < y){y--;walkCount--;}
            if (foodY > y){y++;walkCount--;}
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (x == foodX && y == foodY){
                foodX = MolniyarMethod.randomNumber(0,7);
                foodY = MolniyarMethod.randomNumber(0,7);
                map.setPixel(foodX, foodY,214);
                walkCount += 5;
                map.setPixel(x, y, 228);
            }
            map.setPixel(x, y, 16);
            map.printArt();
            if (walkCount == 0){
                try {
                    Thread.sleep(650);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }
    public static void islandGenerating(MiniPixelArt art, int millis, int walkCount){
        art.fillArt(21);
        int x = MolniyarMethod.randomNumber(0,7);
        int y = MolniyarMethod.randomNumber(0,7);
        for (int i = 0; i < walkCount; i++) {
            int random = (int) (Math.random() * 4 + 1);
            switch (random) {
                case 1 -> x++;
                case 2 -> x--;
                case 3 -> y++;
                case 4 -> y--;
            }
            x = Math.clamp(x, 0, 7);
            y = Math.clamp(y, 0, 7);
            switch (art.getColorCode(x, y)) {
                case 17  -> art.setPixel(x, y, 18);//deep ocean
                case 18  -> art.setPixel(x, y, 19);//deep ocean
                case 19  -> art.setPixel(x, y, 20);//deep ocean
                case 20  -> art.setPixel(x, y, 21);//ocean
                case 21  -> art.setPixel(x, y, 27);//ocean
                case 27  -> art.setPixel(x, y, 33);//ocean
                case 33  -> art.setPixel(x, y, 39);//ocean
                case 39  -> art.setPixel(x, y, 45);//ocean
                case 45  -> art.setPixel(x, y, 123);//ocean
                case 123 -> art.setPixel(x, y, 228);//beach
                case 228 -> art.setPixel(x, y, 190);//beach
                case 190 -> art.setPixel(x, y, 82);//beach with plants
                case 82  -> art.setPixel(x, y, 46);//land
                case 46  -> art.setPixel(x, y, 76);//land
                case 76  -> art.setPixel(x, y, 70);//land
                case 70  -> art.setPixel(x, y, 64);//hill
                case 64  -> art.setPixel(x, y, 58);//hill
                case 58  -> art.setPixel(x, y, 246);//cliffs
                case 246 -> art.setPixel(x, y, 241);//cliffs
                case 241 -> art.setPixel(x, y, 238);//high cliffs
            }
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void pattern(int millis, int repeatCount) {
        MiniPixelArt art = new MiniPixelArt();
        for (int i = 0; i < repeatCount; i++){
            art.randomWalking(3,3,8, MolniyarMethod.randomNumber(204,207));
            art.printArt();
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            art.fillArt(231);
        }
    }
    public static void movingObject(MiniPixelArt art, int millis, int repeatCount) {
        for (int i = 0; i < repeatCount; i++){

        }
    }
}
