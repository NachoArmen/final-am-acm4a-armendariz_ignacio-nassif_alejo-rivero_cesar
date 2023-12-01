package com.example.ranchapp;

import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {
    private String titulo;
    private Date fecha;
    private String lugar;
    private String descripcion;

    public Evento(String titulo, Date fecha, String lugar, String descripcion) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", lugar='" + lugar + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
