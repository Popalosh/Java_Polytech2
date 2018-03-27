import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Tar {
    public static void main(String[] args) throws Exception {

        if (Objects.equals(args.length, 2) && args[0].equals("-u")) {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\input\\" + args[1]));

            Map<String, ArrayList<String>> map = new HashMap<>();
            int counter = -1;
            List names = new ArrayList();

            for (String line : lines) {
                if (line.startsWith("_") && line.endsWith(".txt_")) {
                    map.put(line.substring(1, line.length() - 2), new ArrayList<>());
                    names.add(line.substring(1, line.length() - 2));
                    counter++;
                } else {
                    map.get(names.get(counter)).add(line);
                }
            }

            Writer writer = new Writer();
            writer.toWrite(names, map);
        } else {
            if (args[0].equals("tar") && args[args.length - 2].equals("-out")) {
                Map<String, ArrayList<String>> map = new HashMap<>();

                for (int i = 1; i < args.length - 2; i++) {
                    map.put(args[i], new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\input\\" + args[i]))));
                }

                for (String name : map.keySet()) {

                    String outputName = args[args.length - 1];
                    List<String> listOfNames = new ArrayList<>(Collections.singleton(outputName));
                    Writer writer = new Writer();
                    writer.toWrite(listOfNames, map);

                }
            } else throw new IllegalArgumentException();
        }
    }
}