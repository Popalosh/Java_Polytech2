import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

public class Writer {

    Writer() {
    }

    public void toWrite(String command, Map<String, ArrayList<String>> map) throws IOException {
        switch (command) {
            case "-u": {

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
            }

            case "tar": {
                StringBuilder newFileName = new StringBuilder();
                for (String name : map.keySet()) {
                    newFileName.append(name);
                }

                File file = new File("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\" + newFileName);

                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\" + newFileName), StandardCharsets.UTF_8));

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
                    if (counter == 1){
                        writer.newLine();
                    }
                    counter ++;
                }
                writer.close();
            }
        }
    }
}
