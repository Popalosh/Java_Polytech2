import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

class Methods {

    private String flag;
    final Map<String, ArrayList<String>> contents;
    final List<Integer> sizes;
    final List<String> names;

    Methods() {
        this.flag = "";
        this.contents = new LinkedHashMap<>();
        this.sizes = new ArrayList<>();
        this.names = new ArrayList<>();
    }


    String parseCommand(String[] args) {
        try {
            if (args[0].equals("-u") && args.length == 2) {
                flag = args[0];
                names.add(args[1]);
                return flag;
            } else if (args[0].equals("tar") && args[args.length - 2].equals("-out")) {
                flag = args[0];
                for (String name : args)
                    if (!name.equals("tar") && !name.equals("-out"))
                        names.add(name);
                return flag;
            } else {
                throw new IOException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    void toRead(String flag, List<String> names) throws Exception {

        if (flag.equals("-u")) {
            File file = new File("input\\", names.get(0));
            List<String> lines = Files.readAllLines(file.toPath());

            int files = Integer.parseInt(lines.get(0));
            int counter = 1;

            for (int i = 1; i <= files; i++) {

                String[] memory = lines.get(counter).split(" ");
                String name = memory[0];

                int size = Integer.parseInt(memory[1]);

                if (size != 0) {
                    int line = counter + 1;
                    contents.put(name, new ArrayList<>());

                    for (int index = line; index < line + size; index++) {
                        contents.get(name).add(lines.get(index));
                    }
                    counter += size + 1;
                } else {
                    contents.put(name, new ArrayList<>());
                    counter += 1;
                }
            }
        } else {
            for (int i = 0; i < names.size() - 1; i++) {
                File file = new File("input\\", names.get(i));
                contents.put(names.get(i), new ArrayList<>(Files.readAllLines(file.toPath())));
                sizes.add(new ArrayList<>(Files.readAllLines(file.toPath())).size());
            }
        }
    }

    void toWrite(Map<String, ArrayList<String>> contents) throws Exception {

        for (String name : contents.keySet()) {

            File file = new File("output\\", name);

            BufferedWriter writer = Files.newBufferedWriter(file.toPath());

            if (contents.get(name).isEmpty()) {
                writer.close();
            } else {
                for (String line : contents.get(name)) {
                    writer.write(line);
                    if (contents.get(name).indexOf(line) != contents.get(name).size() - 1) {
                        writer.newLine();
                    }
                }
                writer.close();
            }
        }
    }

    void toWrite(Map<String, ArrayList<String>> contents, List<Integer> sizes, String outputName) throws Exception {

        File file = new File("output\\", outputName);
        BufferedWriter writer = Files.newBufferedWriter(file.toPath());

        writer.write(String.valueOf(sizes.size()));
        writer.newLine();

        int counter = 0;

        for (String name : contents.keySet()) {

            writer.write(name + " " + sizes.get(counter));
            if (!contents.get(name).isEmpty()) {
                writer.newLine();
            }
            for (String line : contents.get(name)) {
                writer.write(line);
                if (contents.get(name).indexOf(line) != contents.get(name).size() - 1) {
                    writer.newLine();
                }
            }
            if (counter < sizes.size()) {
                writer.newLine();
                counter++;
            }
        }
        writer.close();
    }
}