package org.oceballos;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Lector {
    private Scanner scanner;

    public Lector() {
        scanner = new Scanner(System.in);
    }

    public int leerEntero() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // Descarta la entrada incorrecta
                System.out.print("Entrada inválida. Por favor, ingrese un número: ");
            }
        }
    }

    public String leerString() {
        return scanner.nextLine();
    }
}
