import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

class TarTest {
    @Test
    void isEqualAfterSeparate() throws Exception {

        String[] command;

        command = "-u toSeparate.txt".split(" ");

        Main.main(command);

        TestMethods.assertFileExist("firstAfterSeparate.txt");
        TestMethods.assertFileContent("firstAfterSeparate.txt",
                "Как часто летнею порою,\n" +
                        "Когда прозрачно и светло\n" +
                        "Ночное небо над Невою\n" +
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

        TestMethods.assertFileExist("secondAfterSeparate.txt");
        TestMethods.assertFileContent("secondAfterSeparate.txt",
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

        Files.delete(Paths.get("\\output\\firstAfterSeparate.txt"));
        Files.delete(Paths.get("\\output\\secondAfterSeparate.txt"));

        command = "-u text.txt".split(" ");

        Main.main(command);

        TestMethods.assertFileExist("firstAfterSep.txt");
        TestMethods.assertFileContent("firstAfterSep.txt", "Class/Interface\n" +
                "Each class, interface, nested class and nested interface has its own separate page.\n" +
                "Each of these pages has three sections consisting of a class/interface description, summary tables, and detailed member descriptions:");

        TestMethods.assertFileExist("secondAfterSep.txt");
        TestMethods.assertFileContent("secondAfterSep.txt","\n" +
                "Class inheritance diagram\n" +
                "Direct Subclasses\n" +
                "All Known Subinterfaces\n" +
                "All Known Implementing Classes\n" +
                "Class/interface declaration\n" +
                "Class/interface description\n" +
                "Nested Class Summary\n" +
                "Field Summary\n" +
                "Constructor Summary\n" +
                "Method Summary\n" +
                "Field Detail\n" +
                "Constructor Detail\n" +
                "Method Detail\n" +
                "Each summary entry contains the first sentence from the detailed description for that item.\n" +
                "The summary entries are alphabetical, while the detailed descriptions are in the order they appear in the source code.\n" +
                "This preserves the logical groupings established by the programmer.");

        TestMethods.assertFileExist("LOLCODE.txt");
        TestMethods.assertFileContent("LOLCODE.txt","LOLCODE — эзотерический язык программирования, созданный под влиянием интернет-мема о lolcat’ах.\n" +
                "\n" +
                "На официальном сайте находится спецификация этого языка, и, хотя некоторые моменты в ней не описаны,\n" +
                "уже существуют несколько работающих интерпретаторов и компиляторов этого языка.\n" +
                "LOLCODE является Тьюринг-полным языком, так как возможна реализация интерпретатора Brainfuck на LOLCODE.");

        Files.delete(Paths.get("\\output\\firstAfterSep.txt"));
        Files.delete(Paths.get("\\output\\secondAfterSep.txt"));
        Files.delete(Paths.get("\\output\\LOLCODE.txt"));
    }

    @Test
    void isEqualAfterUnion() throws Exception {

        String[] command;

        command = "tar firstToUnion.txt emptyFile.txt secondToUnion.txt -out file.txt".split(" ");

        Main.main(command);

        TestMethods.assertFileExist("file.txt");
        TestMethods.assertFileContent("file.txt",
                "3\n" +
                        "firstToUnion.txt 14\n" +
                        "Как часто летнею порою,\n" +
                        "Когда прозрачно и светло\n" +
                        "Ночное небо над Невою\n" +
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
                        "emptyFile.txt 0\n" +
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

        Files.delete(Paths.get("\\output\\file.txt"));

        command = ("tar first.txt second.txt -out text.txt").split(" ");

        Main.main(command);

        TestMethods.assertFileExist("text.txt");

        TestMethods.assertFileContent("text.txt", "2\n" +
                "first.txt 5\n" +
                "text.txt rwx 04/09/2018 04:16:04 0.791015625 KB\n" +
                "schem1.rar rwx 04/01/2018 23:33:54 1.8837890625 KB\n" +
                "schedule.pdf rwx 04/07/2018 01:35:30 466.7880859375 KB\n" +
                "English rwx 04/09/2018 04:18:01 4.0 KB\n" +
                "compas.exe rwx 10/16/2005 14:54:58 1.762115478515625 MB\n" +
                "second.txt 5\n" +
                "compas.exe 111 1129460098000 1847712 Bytes\n" +
                "English 111 1523236681182 4096 Bytes\n" +
                "schedule.pdf 101 1523054130682 477991 Bytes\n" +
                "schem1.rar 111 1522614834920 1929 Bytes\n" +
                "text.txt 111 1523236564871 810 Bytes");

        Files.delete(Paths.get("\\output\\text.txt"));
    }
}