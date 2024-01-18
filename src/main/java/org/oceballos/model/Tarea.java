package org.oceballos.model;

import java.io.Serializable;
import java.util.Date;

public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private final Date fechaCreacion;
    private Date fechaExpiracion;
    private boolean realizada;
    private Date fechaRealizacion;

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = new Date();
        this.realizada = false;
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

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void marcarComoRealizada() {
        this.realizada = true;
        this.fechaRealizacion = new Date();
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    @Override
    public String toString() {
        return String.format("Tarea: %s, Creada en: %s, Expira en: %s, Estado: %s, Fecha de Realización: %s",
                nombre,
                fechaCreacion,
                fechaExpiracion != null ? fechaExpiracion.toString() : "N/A",
                realizada ? "Realizada" : "Pendiente",
                realizada && fechaRealizacion != null ? fechaRealizacion.toString() : "N/A");
    }
}