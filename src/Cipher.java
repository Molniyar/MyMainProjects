import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte[] nums = {(byte) MolniyarMethod.randomNumber(0,9),(byte) MolniyarMethod.randomNumber(0,9),(byte) MolniyarMethod.randomNumber(0,9),(byte) MolniyarMethod.randomNumber(0,9)};
        boolean i1 = false;
        boolean i2 = false;
        boolean i3 = false;
        boolean i4 = false;
        for (; !i1 || !i2 || !i3 || !i4;){
            String s = input.nextLine();
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < s.length(); i++){
                char char_ = s.charAt(i);
                if (char_ > '9' || char_ < '0'){
                    i--;
                    continue;
                }
                if (i < 4 && char_ - 48 == nums[i]){out.append(MolniyarMethod.getColorText(char_ + "",40,257));
                    switch (i){
                        case 0 -> i1 = true;
                        case 1 -> i2 = true;
                        case 2 -> i3 = true;
                        case 3 -> i4 = true;
                    }
                }
                else if (nums[0] ==char_-48 || nums[1] ==char_-48 || nums[2] ==char_-48 || nums[3] ==char_-48){
                    out.append(MolniyarMethod.getColorText(char_ + "",184,257));
                }
                else out.append(MolniyarMethod.getColorText(char_ + "",160,257));
            }
            System.out.println(out);
        }
    }
}
