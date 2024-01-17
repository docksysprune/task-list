package org.oceballos.model;

import java.util.Date;

public class Tarea {
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
}