package org.oceballos;

public class Main {
    public static void main(String[] args) {
        ListasTareas listasTareas = new ListasTareas();
        Menu menu = new Menu();
        //ManejadorTareas manejadorTareas = new ManejadorTareas(menu, listasTareas); // Crea ManejadorTareas con ListasTareas y Menu
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
                    listasTareas = ListasTareas.cargarListasTareas();
                    System.out.println("Listas de tareas cargadas.");
                    break;
                case 7:
                    listasTareas.guardarListasTareas();
                    System.out.println("Listas de tareas guardadas.");
                    break;
                case 8:
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);
    }
}
