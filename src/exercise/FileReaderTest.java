package exercise;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FileReaderTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("exercise/src/excercise/file.txt"));
        while (in.hasNextInt()) {
            int value = in.nextInt();
            System.out.println(value);
        }
        in.close();

    }
}
