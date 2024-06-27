import game.GameMethods;

public class Animation {
    public static void main(String[] args) {
        int time = 50;
        MiniPixelArt art = new MiniPixelArt();
        art.fillArt(231);
        for (int i = 0; i < 10; i++){
            art.setPixel(3,3,16);
            art.setPixel(2,3,16);
            art.setPixel(1,3,16);
            art.setPixel(1,2,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(1,4,16);
            art.setPixel(1,3,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(2,4,16);
            art.setPixel(2,3,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(1,5,16);
            art.setPixel(1,4,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(2,5,16);
            art.setPixel(1,5,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(3,4,16);
            art.setPixel(2,4,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(3,5,16);
            art.setPixel(2,5,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(4,5,16);
            art.setPixel(3,5,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(4,4,16);
            art.setPixel(3,4,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(5,5,16);
            art.setPixel(4,5,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(5,4,16);
            art.setPixel(5,5,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(4,3,16);
            art.setPixel(4,4,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(5,3,16);
            art.setPixel(5,4,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(5,2,16);
            art.setPixel(5,3,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(4,2,16);
            art.setPixel(4,3,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(5,1,16);
            art.setPixel(5,2,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(4,1,16);
            art.setPixel(5,1,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(3,2,16);
            art.setPixel(4,2,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(3,1,16);
            art.setPixel(4,1,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(2,1,16);
            art.setPixel(3,1,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(2,2,16);
            art.setPixel(3,2,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(1,1,16);
            art.setPixel(2,1,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(1,2,16);
            art.setPixel(1,1,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            art.setPixel(2,3,16);
            art.setPixel(2,2,231);
            art.printArt();
            System.out.println();
            System.out.println();
            System.out.println();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
