import java.io.*;
import java.nio.charset.StandardCharsets;

public class Writer {

    Writer() {
    }

    public BufferedWriter toWrite(String fileName) {
        File file = new File("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output\\" + fileName);
        try {
            return new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output" + fileName), StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
