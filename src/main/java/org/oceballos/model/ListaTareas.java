package org.oceballos.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaTareas implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private final Date fechaCreacion;
    private List<Tarea> tareas;

    public ListaTareas(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = new Date();
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < tareas.size()) {
            tareas.remove(indice);
        } else {
            System.out.println("Índice no válido. La tarea no se pudo eliminar.");
        }
    }

    public List<Tarea> obtenerTareas() {
        return tareas;
    }

    public void marcarTareaComoRealizada(int numeroTarea) {
        if (numeroTarea >= 1 && numeroTarea <= tareas.size()) {
            Tarea tarea = tareas.get(numeroTarea - 1);
            tarea.marcarComoRealizada();
            System.out.println("Tarea marcada como realizada: " + tarea.getNombre());
        } else {
            System.out.println("Número de tarea no válido. La tarea no se pudo marcar como realizada.");
        }
    }

    public int obtenerNumeroTareas() {
        return tareas.size();
    }

    public void imprimirNombresTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas en la lista de tareas.");
        } else {
            System.out.println("Tareas en la lista de tareas '" + nombre + "':");
            for (int i = 0; i < tareas.size(); i++) {
                System.out.println((i + 1) + ". " + tareas.get(i).getNombre());
            }
        }
    }

    public void actualizarNombreTarea(int indice, String nuevoNombre) {
        if (indice >= 0 && indice < tareas.size()) {
            Tarea tarea = tareas.get(indice);
            tarea.setNombre(nuevoNombre);
            System.out.println("Nombre de la tarea actualizado: " + nuevoNombre);
        } else {
            System.out.println("Índice no válido. No se pudo actualizar el nombre de la tarea.");
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Tareas: '").append(nombre).append("'\n");
        sb.append("Fecha de Creación: ").append(dateFormat.format(fechaCreacion)).append("\n");
        sb.append("Tareas:\n");

        if (tareas.isEmpty()) {
            sb.append("   No hay tareas en esta lista.\n");
        } else {
            for (int i = 0; i < tareas.size(); i++) {
                sb.append("   ").append(i + 1).append(". ").append(tareas.get(i).getNombre()).append("\n");
            }
        }

        return sb.toString();
    }
}
