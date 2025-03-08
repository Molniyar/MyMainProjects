public class Clicker {
    public static void main(String[] args) {
        for (int r = 0; r < 4; r++){
            for (int g = 0; g < 4; g++){
                for (int b = 0; b < 4; b++){
                    System.out.print(MolniyarMethod.getColorPixel(r*85,g*85,b*85));
                }
                System.out.println();
            }
        }

    }
}
