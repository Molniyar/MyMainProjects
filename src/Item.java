import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Item {
    public static void main(String[] args) throws IOException {
        List lines = Files.readAllLines(Paths.get("C:\\Users\\Yar\\IdeaProjects\\MyMainProjects\\src\\WaBFile"));
        System.out.println(Arrays.toString(lines.toArray()));
//перебираете циклом
        for(int i = 0; i < lines.size(); i++) {
            lines.set(i,"12345");
            MolniyarMethod.sleep(1000);
        }
        System.out.println(Arrays.toString(lines.toArray()));
/* Если нужно удалить - для перебора используйте Iterator.
Не забудьте : */
        Files.write(Paths.get("C:\\Users\\Yar\\IdeaProjects\\MyMainProjects\\src\\WaBFile"), lines);
//иначе результат не запишется
    }
}
