//  Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
//  который запишет эту строку в простой текстовый файл, обработайте исключения.
package Task2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        MakeFile();
    }

    public static String MakeString() {
        String str = "TEST".repeat(100);
        return str;
    }
    public static void MakeFile() {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("test.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            file.write(MakeString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}