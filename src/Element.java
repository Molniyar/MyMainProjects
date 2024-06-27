public class Element {
    public Element(int mass, int energy) {// 1 - 2048
        if (mass < 0 || mass > 2048) {
            throw new IllegalArgumentException("Mass must be between 1 and 2048");
        }
        if (energy < 0 || energy > 2048) {
            throw new IllegalArgumentException("Energy must be between 1 and 2048");
        }
        m = mass;
        e = energy;
    }
    public Element(int mass, int energy, int change) {// 1 - 2048
        if (mass < 0 || mass > 2048) {    throw new IllegalArgumentException("Mass isn't between 1 and 2048");}
        if (energy < 0 || energy > 2048) {throw new IllegalArgumentException("Energy isn't between 1 and 2048");}
        if (change < -16 || change > 16) {throw new IllegalArgumentException("Change isn't between -16 and 16");}
        m = mass;
        e = energy;
        c = change;
    }
    int m;
    int e;
    Integer c;
    public int getM(){return m;}
    public int getE(){return e;}
    public int getTP(){return -16 + m;}
    public int getTI(){return m + (e / 3);}
    public int getR(){
        int color2 = 0;
        if (e > 500){color2++;}
        if (e > 700){color2++;}
        if (e > 1000){color2++;}
        if (e > 1500){color2++;}
        if (e > 2000){color2++;}
        return color2;
    }
    public int getT(){
        int l = 0;
        if (m > e * 2){l++;}
        if (m > e * 3){l++;}
        if (m > e * 4){l++;}
        if (m > e * 5){l++;}
        return l;
    }
    public boolean isL(){return e * 2 > m;}
    public int getWeight(){return m/2;}

    //public void toPixelArt(){
    //}
    public String getElement(){
        StringBuilder result = new StringBuilder();
        result.append("температура плавления: ").append(-16 + m).append("\n");
        result.append("температура испарения: ").append(m + (e / 3)).append("\n");

        int color2 = 0;
        if (e > 500){color2++;}
        if (e > 700){color2++;}
        if (e > 1000){color2++;}
        if (e > 1500){color2++;}
        if (e > 2000){color2++;}

        result.append("уровень радиации: ").append(color2).append("\n");

        if (m > e){
            result.append("металл" + "\n");
            int l = 0;
            if (m > e * 2){l++;}
            if (m > e * 3){l++;}
            if (m > e * 4){l++;}
            if (m > e * 5){l++;}
            result.append("уровень хрупкости: ").append(l).append("\n");
        }
        if (m == e){
            result.append("полуметалл" + "\n");
        }
        if (m < e){
            result.append("неметалл" + "\n");
            result.append("люминофор: ").append(e > m * 2).append("\n");
        }
        result.append("вес: ").append(m / 2).append("\n");
        return result.toString();
    }
    public void printElementArt(){
        OldPixelArt art = new OldPixelArt(8);
        art.fillArt((short) 231);
        if (m > e){// 253 237
            int color = 253 - (m / 64);
            int color2 = 231;
            if (e > 500){color2 = 195;}
            if (e > 700){color2 = 194;}
            if (e > 1000){color2 = 193;}
            if (e > 1500){color2 = 192;}
            if (e > 2000){color2 = 191;}
            art.fillPixel(2,1,5,6, (short) color2);
            art.setPixel(3,2, (short) (color + 1));art.setPixel(3,3, (short) (color + 1));art.setPixel(3,4, (short) color);art.setPixel(3,5, (short) (color - 1));
            art.setPixel(4,2, (short) color);art.setPixel(4,3, (short) color);art.setPixel(4,4, (short) (color - 1));art.setPixel(4,5, (short) (color - 1));
            if (m > e * 2){
                art.setPixel(3,4, (short) color2);
            }
            if (m > e * 3){
                art.setPixel(4,3, (short) color2);
            }
            if (m > e * 4){
                art.setPixel(3,2, (short) color2);
            }
            if (m > e * 5){
                art.setPixel(3,3, (short) color2);
            }
        }
        else if (m == e){
            int color2 = 231;
            if (e > 500){color2 = 195;}
            if (e > 700){color2 = 194;}
            if (e > 1000){color2 = 193;}
            if (e > 1500){color2 = 192;}
            if (e > 2000){color2 = 191;}
            art.fillPixel(2,2,5,5, (short) color2);
            if (e > 2000){
                art.setPixel(3,3, (short) 104);art.setPixel(3,4, (short) 98);
                art.setPixel(4,3, (short) 103);art.setPixel(4,4, (short) 97);
            }
            else if (e > 1400){
                art.setPixel(3,3, (short) 151);art.setPixel(3,4, (short) 144);
                art.setPixel(4,3, (short) 144);art.setPixel(4,4, (short) 137);
            }
            else if (e > 900){
                art.setPixel(3,3, (short) 154);art.setPixel(3,4, (short) 118);
                art.setPixel(4,3, (short) 118);art.setPixel(4,4, (short) 112);
            }
            else if (e > 512){
                art.setPixel(3,3, (short) 154);art.setPixel(3,4, (short) 118);
                art.setPixel(4,3, (short) 118);art.setPixel(4,4, (short) 112);
            }
            else if (e > 256) {
                art.setPixel(3,3, (short) 195);art.setPixel(3,4, (short) 159);
                art.setPixel(4,3, (short) 159);art.setPixel(4,4, (short) 123);
            }
            else if (e > 64) {
                art.setPixel(3,3, (short) 228);art.setPixel(3,4, (short) 227);
                art.setPixel(4,3, (short) 227);art.setPixel(4,4, (short) 226);
            }
            else {
                art.setPixel(3,3, (short) 160);art.setPixel(3,4, (short) 124);
                art.setPixel(4,3, (short) 124);art.setPixel(4,4, (short) 88);
            }
        }
        else {
            int color2 = 231;
            if (e > 500){color2 = 195;}
            if (e > 700){color2 = 194;}
            if (e > 1000){color2 = 193;}
            if (e > 1500){color2 = 192;}
            if (e > 2000){color2 = 191;}
            art.fillPixel(3,1,5,5, (short) color2);
            art.setPixel(4,6, (short) color2);
            art.setPixel(2,2, (short) color2);
            art.setPixel(2,4, (short) color2);
            art.setPixel(1,3, (short) color2);
            int color;
            switch (m/ 64){
                case 0 -> color = 131;
                case 1 -> color = 95;
                case 2 -> color = 137;
                case 3 -> color = 101;
                case 4 -> color = 103;
                case 5 -> color = 97;
                case 6 -> color = 17;
                case 7 -> color = 19;
                case 8 -> color = 25;
                case 9 -> color = 67;
                case 10 -> color = 37;
                case 11 -> color = 43;
                case 12 -> color = 47;
                case 13 -> color = 119;
                case 14 -> color = 191;
                case 15 -> color = 227;
                case 16 -> color = 221;
                case 17 -> color = 205;
                case 18 -> color = 209;
                case 19 -> color = 203;
                case 20 -> color = 197;
                case 21 -> color = 91;
                default -> color = 55;
            }
            if (e > 512){
                color++;
            }
            art.setPixel(2,3, (short) ((short) color+1));
            art.setPixel(3,2, (short) ((short) color+1));art.setPixel(3,3, (short) color);art.setPixel(3,4, (short) color);
            art.setPixel(4,2, (short) color);art.setPixel(4,3, (short) color);art.setPixel(4,4, (short) ((short) color-1));art.setPixel(4,5, (short) ((short) color-1));
        }
        art.printArt();
    }
    public OldPixelArt getArt(){
        OldPixelArt art = new OldPixelArt(8);
        art.fillArt((short) 231);
        if (m > e){// 253 237
            int color = 253 - (m / 64);
            int color2 = 231;
            if (e > 500){color2 = 195;}
            if (e > 700){color2 = 194;}
            if (e > 1000){color2 = 193;}
            if (e > 1500){color2 = 192;}
            if (e > 2000){color2 = 191;}
            art.fillPixel(2,1,5,6, (short) color2);
            art.setPixel(3,2, (short) (color + 1));art.setPixel(3,3, (short) (color + 1));art.setPixel(3,4, (short) color);art.setPixel(3,5, (short) (color - 1));
            art.setPixel(4,2, (short) color);art.setPixel(4,3, (short) color);art.setPixel(4,4, (short) (color - 1));art.setPixel(4,5, (short) (color - 1));
            if (m > e * 2){
                art.setPixel(3,4, (short) color2);
            }
            if (m > e * 3){
                art.setPixel(4,3, (short) color2);
            }
            if (m > e * 4){
                art.setPixel(3,2, (short) color2);
            }
            if (m > e * 5){
                art.setPixel(3,3, (short) color2);
            }
        }
        else if (m == e){
            int color2 = 231;
            if (e > 500){color2 = 195;}
            if (e > 700){color2 = 194;}
            if (e > 1000){color2 = 193;}
            if (e > 1500){color2 = 192;}
            if (e > 2000){color2 = 191;}
            art.fillPixel(2,2,5,5, (short) color2);
            if (e > 2000){
                art.setPixel(3,3, (short) 104);art.setPixel(3,4, (short) 98);
                art.setPixel(4,3, (short) 103);art.setPixel(4,4, (short) 97);
            }
            else if (e > 1400){
                art.setPixel(3,3, (short) 151);art.setPixel(3,4, (short) 144);
                art.setPixel(4,3, (short) 144);art.setPixel(4,4, (short) 137);
            }
            else if (e > 900){
                art.setPixel(3,3, (short) 154);art.setPixel(3,4, (short) 118);
                art.setPixel(4,3, (short) 118);art.setPixel(4,4, (short) 112);
            }
            else if (e > 512){
                art.setPixel(3,3, (short) 154);art.setPixel(3,4, (short) 118);
                art.setPixel(4,3, (short) 118);art.setPixel(4,4, (short) 112);
            }
            else if (e > 256) {
                art.setPixel(3,3, (short) 195);art.setPixel(3,4, (short) 159);
                art.setPixel(4,3, (short) 159);art.setPixel(4,4, (short) 123);
            }
            else if (e > 64) {
                art.setPixel(3,3, (short) 228);art.setPixel(3,4, (short) 227);
                art.setPixel(4,3, (short) 227);art.setPixel(4,4, (short) 226);
            }
            else {
                art.setPixel(3,3, (short) 160);art.setPixel(3,4, (short) 124);
                art.setPixel(4,3, (short) 124);art.setPixel(4,4, (short) 88);
            }
        }
        else {
            int color2 = 231;
            if (e > 500){color2 = 195;}
            if (e > 700){color2 = 194;}
            if (e > 1000){color2 = 193;}
            if (e > 1500){color2 = 192;}
            if (e > 2000){color2 = 191;}
            art.fillPixel(3,1,5,5, (short) color2);
            art.setPixel(4,6, (short) color2);
            art.setPixel(2,2, (short) color2);
            art.setPixel(2,4, (short) color2);
            art.setPixel(1,3, (short) color2);
            int color;
            switch (m/ 64){
                case 0 -> color = 131;
                case 1 -> color = 95;
                case 2 -> color = 137;
                case 3 -> color = 101;
                case 4 -> color = 103;
                case 5 -> color = 97;
                case 6 -> color = 17;
                case 7 -> color = 19;
                case 8 -> color = 25;
                case 9 -> color = 67;
                case 10 -> color = 37;
                case 11 -> color = 43;
                case 12 -> color = 47;
                case 13 -> color = 119;
                case 14 -> color = 191;
                case 15 -> color = 227;
                case 16 -> color = 221;
                case 17 -> color = 205;
                case 18 -> color = 209;
                case 19 -> color = 203;
                case 20 -> color = 197;
                case 21 -> color = 91;
                default -> color = 55;
            }
            if (e > 512){
                color++;
            }
            art.setPixel(2,3, (short) ((short) color+1));
            art.setPixel(3,2, (short) ((short) color+1));art.setPixel(3,3, (short) color);art.setPixel(3,4, (short) color);
            art.setPixel(4,2, (short) color);art.setPixel(4,3, (short) color);art.setPixel(4,4, (short) ((short) color-1));art.setPixel(4,5, (short) ((short) color-1));
        }
        return art;
    }
}