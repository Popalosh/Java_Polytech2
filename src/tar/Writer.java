import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Writer {

    public static void toWrite(Map<String, ArrayList<String>> contents, List<Integer> sizes,String outputName) throws IOException {
        if (!(sizes.size() > 1)) {

            for (String name : contents.keySet()) {

                File file = new File("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output\\" + name);

                BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.toURI()));

                for (String line : contents.get(name)) {
                    writer.write(line);
                    if (contents.get(name).indexOf(line) != contents.get(name).size() - 1) {
                        writer.newLine();
                    }
                }
                writer.close();
            }
        } else {
            int i = 0;

            File file = new File("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output\\" + outputName);

            BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.toURI()));
            int counter = 0;
            writer.write(String.valueOf(sizes.size()));
            writer.newLine();
            for (String name : contents.keySet()) {

                writer.write(name + " " + sizes.get(i));
                writer.newLine();
                for (String line : contents.get(name)) {
                    writer.write(line);
                    if (contents.get(name).indexOf(line) != contents.get(name).size() - 1) {
                        writer.newLine();
                    }
                }
                if (counter < sizes.size()){
                    writer.newLine();
                    counter++;
                }
                i++;
            }
            writer.close();
        }
    }
}