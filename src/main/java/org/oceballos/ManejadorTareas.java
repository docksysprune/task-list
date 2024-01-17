package org.oceballos;

import org.oceballos.model.ListaTareas;
import org.oceballos.model.Tarea;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManejadorTareas {
    private ListaTareas listaSeleccionada;
    private List<Tarea> tareas;

    public ManejadorTareas() {
        this.tareas = new ArrayList<>();
    }

    public void agregarNuevaTarea(String nombre) {
        if (listaSeleccionada != null) {
            Tarea nuevaTarea = new Tarea(nombre);
            listaSeleccionada.agregarTarea(nuevaTarea); // Utilizamos el método de ListaTareas
            System.out.println("Nueva tarea agregada: " + nombre);
            listarTareas();
        } else {
            System.out.println("No se ha seleccionado ninguna lista de tareas. Use 'verListasTareas' para elegir una lista de tareas.");
        }
    }

    public void eliminarTarea(int numeroTarea) {
        if (listaSeleccionada != null) {
            listaSeleccionada.eliminarTarea(numeroTarea); // Utilizamos el método de ListaTareas
            listarTareas();
        } else {
            System.out.println("No se ha seleccionado ninguna lista de tareas. Use 'verListasTareas' para elegir una lista de tareas.");
        }
    }

    public void marcarTareaComoRealizada(int numeroTarea) {
        if (listaSeleccionada != null) {
            listaSeleccionada.marcarTareaComoRealizada(numeroTarea); // Utilizamos el método de ListaTareas
            listarTareas();
        } else {
            System.out.println("No se ha seleccionado ninguna lista de tareas. Use 'verListasTareas' para elegir una lista de tareas.");
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
}
