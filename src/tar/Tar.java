import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Tar {
    public static void main(String[] args) throws Exception {

        if (Objects.equals(args.length, 2) && args[0].equals("-u")) {
            List<String> lines = Files.readAllLines(Paths.get(
                    "C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\input\\" + args[1]));

            Map<String,ArrayList<String>> contents = new HashMap<>();
            int counter = 1;
            int i = 1;

            int files = Integer.parseInt(lines.get(0));
            while (i <= files){

                String[] file = lines.get(counter).split(" ");
                String name = file[0];

                int size = Integer.parseInt(file[1]);
                int line = counter + 1;
                contents.put(name,new ArrayList<>());
                for (int index = line; index < line + size; index++) {
                    contents.get(name).add(lines.get(index));
                }
                counter += size + 1;
                i++;
            }


            Writer.toWrite(contents,new ArrayList<>(),"");

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

                    Writer.toWrite(contents,sizes,args[args.length-1]);
            } else throw new IOException();
        }
    }
}