package org.oceballos;
import java.util.Scanner;
public class Reader {
    private Scanner scanner;

    public Reader() {
        scanner = new Scanner(System.in);
    }

    public int readOption() {
        return scanner.nextInt();
    }
}
