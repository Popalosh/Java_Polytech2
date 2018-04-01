import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Tar {

    public static void main(String[] args) throws Exception {

        if (Objects.equals(args.length, 2) && args[0].equals("-u")) {
            List<String> lines = Files.readAllLines(Paths.get(
                    "C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\input\\" + args[1]));

            Map<String, ArrayList<String>> contents = new HashMap<>();

            int files = Integer.parseInt(lines.get(0));
            int i = 1;
            int counter = 1;

            while (i <= files) {

                String[] file = lines.get(counter).split(" ");
                String name = file[0];

                int size = Integer.parseInt(file[1]);
                int line = counter + 1;
                contents.put(name, new ArrayList<>());

                for (int index = line; index < line + size; index++) {
                    contents.get(name).add(lines.get(index));
                }
                counter += size + 1;
                i++;
            }

            toWrite(contents);

        } else {
            if (args[0].equals("tar") && args[args.length - 2].equals("-out")) {

                Map<String, ArrayList<String>> contents = new HashMap<>();
                List<Integer> sizes = new ArrayList<>();

                for (int i = 1; i < args.length - 2; i++) {
                    contents.put(args[i], new ArrayList<>(Files.readAllLines(Paths.get(
                            "C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\input\\" + args[i]))));
                    sizes.add(new ArrayList<>(Files.readAllLines(Paths.get(
                            "C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\input\\" + args[i]))).size());
                }

                toWrite(contents, sizes, args[args.length - 1]);

            } else throw new Exception();
        }
    }

    private static void toWrite(Map<String, ArrayList<String>> contents) throws Exception {

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
    }

    private static void toWrite(Map<String, ArrayList<String>> contents, List<Integer> sizes, String outputName) throws Exception {

        File file = new File("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output\\" + outputName);
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.toURI()));

        writer.write(String.valueOf(sizes.size()));
        writer.newLine();

        int counter = 0;

        for (String name : contents.keySet()) {

            writer.write(name + " " + sizes.get(counter));
            writer.newLine();
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