package dpiqb.math;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MathApp {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input.txt";
        Scanner scanner = new Scanner(new File(filename));
        String expression = scanner.nextLine();

    }
}
