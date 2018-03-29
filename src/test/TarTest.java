import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TarTest {

    private void assertFileContent(String name, String expectedContent) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output\\" + name));
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

    private void assertFileExist(String name) {
        File file = new File("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output\\" + name);
        assertTrue(file.exists());
    }

    @Test
    void isEqualAfterSeparate() throws Exception {

        String[] command;

        command = "-u toSeparate.txt".split(" ");

        Tar.main(command);

        assertFileExist("firstAfterSeparate.txt");
        assertFileContent( "firstAfterSeparate.txt",
                "Как часто летнею порою,\n" +
                        "Когда прозрачно и светло\n" +
                        "Ночное небо над Невою8\n" +
                        "И вод веселое стекло\n" +
                        "Не отражает лик Дианы,\n" +
                        "Воспомня прежних лет романы,\n" +
                        "Воспомня прежнюю любовь,\n" +
                        "Чувствительны, беспечны вновь,\n" +
                        "Дыханьем ночи благосклонной\n" +
                        "Безмолвно упивались мы!\n" +
                        "Как в лес зеленый из тюрьмы\n" +
                        "Перенесен колодник сонный,\n" +
                        "Так уносились мы мечтой\n" +
                        "К началу жизни молодой.");

        assertFileExist("secondAfterSeparate.txt");
        assertFileContent("secondAfterSeparate.txt",
                "Его нежданным появленьем,\n" +
                        "Мгновенной нежностью очей\n" +
                        "И странным с Ольгой поведеньем\n" +
                        "До глубины души своей\n" +
                        "Она проникнута; не может\n" +
                        "Никак понять его; тревожит\n" +
                        "Ее ревнивая тоска,\n" +
                        "Как будто хладная рука\n" +
                        "Ей сердце жмет, как будто бездна\n" +
                        "Под ней чернеет и шумит...\n" +
                        "«Погибну, — Таня говорит, —\n" +
                        "Но гибель от него любезна.\n" +
                        "Я не ропщу: зачем роптать?\n" +
                        "Не может он мне счастья дать».");

        Files.delete(Paths.get("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output\\firstAfterSeparate.txt"));
        Files.delete(Paths.get("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output\\secondAfterSeparate.txt"));
    }

    @Test
    void isEqualAfterUnion() throws Exception {

        String[] command;

        command = "tar firstToUnion.txt secondToUnion.txt -out file.txt".split(" ");

        Tar.main(command);

        assertFileExist("file.txt");
        assertFileContent("file.txt",
                "2\n" +
                        "firstToUnion.txt 14\n" +
                        "Как часто летнею порою,\n" +
                        "Когда прозрачно и светло\n" +
                        "Ночное небо над Невою8\n" +
                        "И вод веселое стекло\n" +
                        "Не отражает лик Дианы,\n" +
                        "Воспомня прежних лет романы,\n" +
                        "Воспомня прежнюю любовь,\n" +
                        "Чувствительны, беспечны вновь,\n" +
                        "Дыханьем ночи благосклонной\n" +
                        "Безмолвно упивались мы!\n" +
                        "Как в лес зеленый из тюрьмы\n" +
                        "Перенесен колодник сонный,\n" +
                        "Так уносились мы мечтой\n" +
                        "К началу жизни молодой.\n" +
                        "secondToUnion.txt 14\n" +
                        "Его нежданным появленьем,\n" +
                        "Мгновенной нежностью очей\n" +
                        "И странным с Ольгой поведеньем\n" +
                        "До глубины души своей\n" +
                        "Она проникнута; не может\n" +
                        "Никак понять его; тревожит\n" +
                        "Ее ревнивая тоска,\n" +
                        "Как будто хладная рука\n" +
                        "Ей сердце жмет, как будто бездна\n" +
                        "Под ней чернеет и шумит...\n" +
                        "«Погибну, — Таня говорит, —\n" +
                        "Но гибель от него любезна.\n" +
                        "Я не ропщу: зачем роптать?\n" +
                        "Не может он мне счастья дать».");

        Files.delete(Paths.get("C:\\Users\\Popalosh\\IdeaProjects\\Java_polytech2\\output\\file.txt"));
    }
}