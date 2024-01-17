package org.oceballos;

import org.oceballos.model.ListaTareas;
import org.oceballos.model.Tarea;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManejadorTareas {
    private ListaTareas listaSeleccionada;
    private List<Tarea> tareas;
    private Menu menu;

    public ManejadorTareas(Menu menu) { // Constructor que recibe una instancia de Menu
        this.tareas = new ArrayList<>();
        this.menu = menu; // Usamos la instancia pasada
    }

    public void agregarNuevaTarea(String nombre) {
        if (listaSeleccionada != null) {
            if (nombre != null && !nombre.trim().isEmpty()) { // Validación para el nombre no vacío
                Tarea nuevaTarea = new Tarea(nombre);
                listaSeleccionada.agregarTarea(nuevaTarea); // Utilizamos el método de ListaTareas
                System.out.println("Nueva tarea agregada: " + nombre);
                listarTareas();
            } else {
                System.out.println("El nombre de la tarea no puede estar vacío.");
            }
        } else {
            System.out.println("No se ha seleccionado ninguna lista de tareas. Use 'verListasTareas' para elegir una lista de tareas.");
        }
    }

    public void eliminarTarea(int numeroTarea) {
        // Validación del índice
        int indiceTarea = numeroTarea - 1;
        if (listaSeleccionada != null && indiceTarea >= 0 && indiceTarea < listaSeleccionada.obtenerTareas().size()) {
            listaSeleccionada.eliminarTarea(indiceTarea);
            System.out.printf("Tarea %d eliminada.%n", numeroTarea);
            listarTareas();
        } else {
            System.out.println("Índice no válido. La tarea no se pudo eliminar.");
        }
    }

    public void marcarTareaComoRealizada(int numeroTarea) {
        // Validación del índice
        int indiceTarea = numeroTarea - 1;
        if (listaSeleccionada != null && indiceTarea >= 0 && indiceTarea < listaSeleccionada.obtenerTareas().size()) {
            Tarea tareaSeleccionada = listaSeleccionada.obtenerTareas().get(indiceTarea);
            if (!tareaSeleccionada.isRealizada()) {
                tareaSeleccionada.marcarComoRealizada();
                System.out.printf("Tarea %d marcada como realizada.%n", numeroTarea);
            } else {
                System.out.printf("La tarea %d ya está marcada como realizada.%n", numeroTarea);
            }
            listarTareas();
        } else {
            System.out.println("Número de tarea inválido o no se ha seleccionado ninguna lista de tareas.");
        }
    }


    public void setListaSeleccionada(ListaTareas listaSeleccionada) {
        this.listaSeleccionada = listaSeleccionada;
    }

    private void listarTareas() {
        if (listaSeleccionada != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            List<Tarea> tareas = listaSeleccionada.obtenerTareas();

            System.out.println("Tareas en la lista seleccionada (" + listaSeleccionada.getNombre() + "):");
            for (int i = 0; i < tareas.size(); i++) {
                Tarea tarea = tareas.get(i);
                String estado = tarea.isRealizada() ? "Completada" : "Pendiente";
                String fechaRealizacion = tarea.getFechaRealizacion() != null
                        ? dateFormat.format(tarea.getFechaRealizacion())
                        : "";
                System.out.println((i + 1) + ". " + tarea.getNombre() + " - Estado: " + estado + " - Fecha de Completación: " + fechaRealizacion);
            }
        } else {
            System.out.println("No se ha seleccionado ninguna lista de tareas. Use 'verListasTareas' para elegir una lista de tareas.");
        }
    }

    public void gestionarTareas() {
        if (listaSeleccionada == null) {
            System.out.println("No se ha seleccionado ninguna lista de tareas. Use 'verListasTareas' para elegir una lista de tareas.");
            return; // Regresar al menú principal
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            opcion = menu.mostrarMenuTareas(); // Usamos la instancia de menu
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la nueva tarea: ");
                    String nombreTarea = scanner.nextLine();
                    if (!nombreTarea.trim().isEmpty()) {
                        agregarNuevaTarea(nombreTarea);
                    } else {
                        System.out.println("El nombre de la tarea no puede estar vacío.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el índice de la tarea que desea eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea restante
                    eliminarTarea(indiceEliminar);
                    break;
                case 3:
                    System.out.print("Ingrese el índice de la tarea que desea marcar como realizada: ");
                    int indiceMarcar = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea restante
                    marcarTareaComoRealizada(indiceMarcar);
                    break;
                case 4:
                    System.out.println("Regresando al menú anterior...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    scanner.nextLine(); // Consumir entrada no válida
            }
        } while (opcion != 4);
    }
}
