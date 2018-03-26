import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Scanner;


public class Tar {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] command = input.split(" ");

        if (command.length == 2) {
            List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\input\\" + command[1]));

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
            Map<String, ArrayList<String>> map = new HashMap<>();

            for (int i = 1; i < command.length - 2; i++) {
                map.put(command[i], new ArrayList<>(Files.readAllLines(Paths.get("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\input\\" + command[i]))));
            }

            for (String name : map.keySet()) {

                String outputName =  command[command.length-1];
                List<String> listOfNames = new ArrayList<>(Collections.singleton(outputName));
                Writer writer = new Writer();
                writer.toWrite(listOfNames, map);

            }
        }
    }
}