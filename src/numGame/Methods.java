package numGame;

public class Methods {
    public static String getColorText(String print, int textColor, int backgroundColor){
        boolean background = true;
        if (backgroundColor == -1){
            background = false;
        }
        else textColor = Math.clamp(textColor, 0, 255);

        String ANSI_RESET = "\u001B[0m";
        String text_color = "\u001B[38;5;" + Math.clamp(textColor, 0, 255) + "m";
        String background_color = "\u001B[48;5;" + Math.clamp(backgroundColor, 0, 255) + "m";

        if (!background){
            return text_color + print + ANSI_RESET;
        }
        else return  background_color + text_color + print + ANSI_RESET;
    }

}
