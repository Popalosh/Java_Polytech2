import java.io.File;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestMethods {

    static void assertFileContent(String name, String expectedContent) throws Exception {
        File file = new File("output\\" + name);
        List<String> lines = Files.readAllLines(file.toPath());
        StringBuilder content = new StringBuilder();
        int counter = 1;
        for (String line : lines) {
            if (counter < lines.size()) {
                content.append(line).append("\n");
                counter++;
            } else {
                content.append(line);
            }
        }
        assertEquals(expectedContent, content.toString());
    }

    static void assertFileExist(String name) {
        File file = new File("output\\" + name);
        assertTrue(file.exists());
    }
}
