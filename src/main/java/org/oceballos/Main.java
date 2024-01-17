package org.oceballos;

public class Main {
    public static void main(String[] args) {
        ListasTareas listasTareas = new ListasTareas();
        Menu menu = new Menu();

        int opcion;
        do {
            opcion = menu.mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    listasTareas.crearListaTareas();
                    break;
                case 2:
                    listasTareas.verListasTareas();
                    break;
                case 3:
                    listasTareas.verTareasDeLista();
                    break;
                case 4:
                    listasTareas.actualizarListaTareas();
                    break;
                case 5:
                    listasTareas.eliminarListaTareas();
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }
}
