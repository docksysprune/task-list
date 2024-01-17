package org.oceballos;

public class Menu {
    private Lector lector;

    public Menu() {
        this.lector = new Lector();
    }

    public int mostrarMenuPrincipal() {
        System.out.println("Menu principal:");
        System.out.println("1. Crear nueva lista de tareas");
        System.out.println("2. Ver listas de tareas");
        System.out.println("3. Ver las tareas de una lista");
        System.out.println("4. Actualizar lista de tareas");
        System.out.println("5. Eliminar lista de tareas");
        System.out.println("6. Cargar lista de tareas");
        System.out.println("7. Salir y guardar");
        System.out.println("8. Salir sin guardar");
        System.out.print("Selecciona una opcion: ");
        return lector.leerEntero();
    }

    public int mostrarMenuTareas() {
        System.out.println("Menu tareas:");
        System.out.println("1. Agregar nueva tarea");
        System.out.println("2. Eliminar tarea");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Regresar al menu principal");
        System.out.print("Selecciona una opcion: ");
        return lector.leerEntero();
    }
}
