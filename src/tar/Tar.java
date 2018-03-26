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

        switch (command[0]) {
            case "-u": {
                List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\input\\" + command[1]));

                Map<String, ArrayList<String>> map = new HashMap<>();
                int counter = 0;
                String[] names = new String[2];

                for (String line : lines) {
                    if (line.startsWith("_") && line.endsWith(".txt_")) {
                        map.put(line.substring(1, line.length() - 2), new ArrayList<>());
                        names[counter] = line.substring(1, line.length() - 2);
                        counter++;
                    } else {
                        map.get(names[counter - 1]).add(line);
                    }
                }

                for (String name : names) {

                    BufferedWriter writer;
                    Writer write = new Writer();
                    writer = write.toWrite(name);

                    for (String line : map.get(name)) {
                        writer.write(line);
                        if (map.get(name).indexOf(line) != map.get(name).size() - 1){
                            writer.newLine();
                        }
                    }
                    writer.close();
                }
            }
            case "tar": {
                break;
                // сюда объединение
            }
        }
    }

}