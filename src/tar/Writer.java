import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Writer {

    Writer() {
    }

    public void toWrite(List names, Map<String, ArrayList<String>> map) throws IOException {
        if (names.size() > 1) {

            for (String name : map.keySet()) {

                File file = new File("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\" + name);

                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\" + name), StandardCharsets.UTF_8));

                for (String line : map.get(name)) {

                    writer.write(line);
                    if (map.get(name).indexOf(line) != map.get(name).size() - 1) {
                        writer.newLine();
                    }
                }
                writer.close();
            }
        } else {

            File file = new File("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\" + names.get(0));

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\" + names.get(0)), StandardCharsets.UTF_8));

            int counter = 1;
            for (String name : map.keySet()) {
                writer.write("_" + name + ".txt_");
                writer.newLine();
                for (String line : map.get(name)) {

                    writer.write(line);
                    if (map.get(name).indexOf(line) != map.get(name).size() - 1) {
                        writer.newLine();
                    }
                }
                if (counter != map.size()) {
                    writer.newLine();
                }
                counter++;
            }
            writer.close();
        }
    }
}