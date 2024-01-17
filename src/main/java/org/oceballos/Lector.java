package org.oceballos;
import java.util.Scanner;
public class Lector {
    private Scanner scanner;

    public Lector() {
        scanner = new Scanner(System.in);
    }

    public int leerEntero() {
        return scanner.nextInt();
    }

    public String leerString() {
        return scanner.nextLine();
    }
}
