package com.avoris.modelado.model;

import com.avoris.modelado.exception.EstudianteMenorEdadException;

import java.util.Collections;
import java.util.List;

public final class Estudiante {
    private final String nombre;
    private final Integer edad;
    private final Fecha fechaFinalizacion;
    private final List<Materia> materias;


    public Estudiante(String nombre, Integer edad, Fecha fechaFinalizacion, List<Materia> materias) throws EstudianteMenorEdadException {

        this.nombre=nombre;
        this.edad=edad;
        this.fechaFinalizacion=fechaFinalizacion;
        materias=Collections.unmodifiableList(materias);
        this.materias=materias;

    }

    public String getNombre() {
        return nombre;
    }
    public Integer getEdad() {
        return edad;

    } public Fecha getFecha() {
        return fechaFinalizacion;
    } public List<Materia> getMaterias() {
        return materias;
    }

}
