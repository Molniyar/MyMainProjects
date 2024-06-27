public class Ant {
    public static void main(String[] args) {
        BigPixelArt map = new BigPixelArt();
        map.fillArt(231);

        int foodX = MolniyarMethod.randomNumber(0, 31);
        int foodY = MolniyarMethod.randomNumber(0, 31);
        map.setPixel(foodX, foodY, 214);

        int walkCount = 100;
        int x = MolniyarMethod.randomNumber(0, 31);
        int y = MolniyarMethod.randomNumber(0, 31);
        int eatenFoodCount = 0;
        int totalWalkCount = 0;
        map.setPixel(x,y,16);
        map.printArt();
        for (int i = 0; true; i++){
            map.setPixel(x, y, 255);
            //int r = MolniyarMethod.randomNumber(0, 1);
            if (foodX < x){x--;walkCount--;totalWalkCount++;}
            if (foodX > x){x++;walkCount--;totalWalkCount++;}
            if (foodY < y){y--;walkCount--;totalWalkCount++;}
            if (foodY > y){y++;walkCount--;totalWalkCount++;}
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (x == foodX && y == foodY){
                foodX = MolniyarMethod.randomNumber(0,31);
                foodY = MolniyarMethod.randomNumber(0,31);
                map.setPixel(foodX, foodY,214);
                walkCount += 21;
                map.setPixel(x, y, 228);
                eatenFoodCount++;
            }
            map.setPixel(x, y, 16);
            map.printArt();
            System.out.println(MolniyarMethod.getColorText("Осталось шагов: " + walkCount, 0, 120));
            System.out.println(MolniyarMethod.getColorText("Съедено еды: " + eatenFoodCount, 0, 154));
            System.out.println(MolniyarMethod.getColorText("Пройдено шагов: " + totalWalkCount, 0, 105));
            if (walkCount == 0){
                break;
            }
        }
        System.out.println(MolniyarMethod.getColorText("Всего съедено еды: " + eatenFoodCount, 0, 154));
        System.out.println(MolniyarMethod.getColorText("Всего пройдено шагов: " + totalWalkCount, 0, 105));
    }
}