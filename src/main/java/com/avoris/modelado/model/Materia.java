package com.avoris.modelado.model;

public class Materia {

    private final String nombre;
    private final Double calificacion;

    public Materia(String nombre, Double calificacion) {
        this.nombre=nombre;
        this.calificacion=calificacion;

    }
    public String getNombre() {
        return nombre;
    }

    public Double getCalificacion() {
        return calificacion;
    }
}
