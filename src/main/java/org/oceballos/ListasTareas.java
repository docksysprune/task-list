package org.oceballos;

import org.oceballos.model.ListaTareas;
import org.oceballos.model.Tarea;

import java.util.ArrayList;
import java.util.List;

public class ListasTareas {
    private List<ListaTareas> listasTareas;
    private ListaTareas listaSeleccionada;
    private Lector lector;
    private Menu menu;
    private ManejadorTareas manejadorTareas;

    public ListasTareas() {
        this.listasTareas = new ArrayList<>();
        this.lector = new Lector();
        this.menu = new Menu();
        this.manejadorTareas = new ManejadorTareas(menu); // Pasa la instancia del menú
    }

    public void crearListaTareas() {
        System.out.print("Ingrese el nombre de la nueva lista de tareas: ");
        String nombreLista = lector.leerString();

        // Validar que el nombre no esté vacío
        if (!nombreLista.trim().isEmpty()) {
            ListaTareas nuevaListaTareas = new ListaTareas(nombreLista);
            listasTareas.add(nuevaListaTareas);
            System.out.printf("Nueva lista de tareas creada: %s%n", nombreLista);
        } else {
            System.out.println("El nombre de la lista de tareas no puede estar vacío. Intente nuevamente.");
        }
    }

    public void verListasTareas() {
        System.out.println("Listas de Tareas Disponibles:");
        for (int i = 0; i < listasTareas.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, listasTareas.get(i).getNombre());
        }

        if (!listasTareas.isEmpty()) {
            System.out.print("Ingrese el número de la lista de tareas que desea seleccionar: ");
            int numeroSeleccionado = lector.leerEntero();

            if (numeroSeleccionado >= 1 && numeroSeleccionado <= listasTareas.size()) {
                listaSeleccionada = listasTareas.get(numeroSeleccionado - 1);
                System.out.println("Lista de tareas seleccionada: " + listaSeleccionada.getNombre());
            } else {
                System.out.println("Número de selección inválido. Intente nuevamente.");
            }
        } else {
            System.out.println("No hay listas de tareas disponibles. Cree una nueva lista de tareas primero.");
        }
    }

    // En el método verTareasDeLista de la clase ListasTareas
    public void verTareasDeLista() {
        if (listaSeleccionada != null) {
            List<Tarea> tareas = listaSeleccionada.obtenerTareas();
            System.out.println("Tareas en la lista de tareas seleccionada (" + listaSeleccionada.getNombre() + "):");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
            }

            // Actualizar la lista seleccionada en ManejadorTareas antes de llamar a gestionarTareas
            manejadorTareas.setListaSeleccionada(this.listaSeleccionada);

            // Llamar al método gestionarTareas de ManejadorTareas
            manejadorTareas.gestionarTareas();
        } else {
            System.out.println("No se ha seleccionado ninguna lista de tareas. Use 'verListasTareas' para elegir una lista de tareas.");
        }
    }


    public void actualizarListaTareas() {
        if (listasTareas.isEmpty()) {
            System.out.println("No hay listas de tareas disponibles. Cree una nueva lista de tareas primero.");
            return;
        }

        System.out.println("Listas de Tareas Disponibles:");
        for (int i = 0; i < listasTareas.size(); i++) {
            System.out.println((i + 1) + ". " + listasTareas.get(i).getNombre());
        }

        System.out.print("Ingrese el número de la lista de tareas que desea actualizar: ");
        int numeroLista = lector.leerEntero();

        if (numeroLista >= 1 && numeroLista <= listasTareas.size()) {
            ListaTareas listaSeleccionada = listasTareas.get(numeroLista - 1);

            listaSeleccionada.imprimirNombresTareas();

            System.out.print("Ingrese el número de la tarea que desea actualizar: ");
            int numeroTarea = lector.leerEntero();

            if (numeroTarea >= 1 && numeroTarea <= listaSeleccionada.obtenerNumeroTareas()) {
                System.out.print("Ingrese el nuevo nombre para la tarea: ");
                String nuevoNombre = lector.leerString();

                listaSeleccionada.actualizarNombreTarea(numeroTarea - 1, nuevoNombre);
            } else {
                System.out.println("Número de tarea inválido. La tarea no se pudo actualizar.");
            }
        } else {
            System.out.println("Número de lista inválido. La lista de tareas no se pudo actualizar.");
        }
    }

    public void eliminarListaTareas() {
        if (listaSeleccionada != null) {
            var nombreLista = listaSeleccionada.getNombre();
            listasTareas.remove(listaSeleccionada);
            listaSeleccionada = null;
            System.out.printf("La lista de tareas %s fue eliminada.%n", nombreLista);
        } else {
            System.out.println("No se ha seleccionado ninguna lista de tareas. Use 'verListasTareas' para elegir una lista de tareas.");
        }
    }
}
