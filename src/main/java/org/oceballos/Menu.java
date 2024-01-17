package org.oceballos;

public class Menu {
    private Lector lector;

    public Menu() {
        this.lector = new Lector();
    }

    public int mostrarMenuPrincipal() {
        System.out.println("Main Menu:");
        System.out.println("1. Create new task list");
        System.out.println("2. View task lists");
        System.out.println("3. View tasks of a list");
        System.out.println("4. Update task list");
        System.out.println("5. Delete task list");
        System.out.println("6. Exit");
        System.out.print("Select an option: ");
        return lector.leerEntero();
    }

    public int mostrarMenuTareas() {
        System.out.println("Task Management Options:");
        System.out.println("1. Add new task");
        System.out.println("2. Delete task");
        System.out.println("3. Mark task as done");
        System.out.println("4. Back");
        System.out.print("Select an option: ");
        return lector.leerEntero();
    }
}
