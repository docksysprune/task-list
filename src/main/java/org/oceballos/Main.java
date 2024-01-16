package org.oceballos;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Reader reader = new Reader();
        TaskLists tasks = new TaskLists();
        int option;

        while (true) {
            menu.displayMenu();
            System.out.print("Select an option: ");
            option = reader.readOption();

            switch (option) {
                case 1:
                    tasks.createTaskList();
                    break;
                case 2:
                    tasks.viewTaskLists();
                    break;
                case 3:
                    tasks.viewTasksInList();
                    break;
                case 4:
                    tasks.updateTaskList();
                    break;
                case 5:
                    tasks.deleteTaskList();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}