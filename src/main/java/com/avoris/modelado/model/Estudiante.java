package com.avoris.modelado.model;

import com.avoris.modelado.AppModeladoApplication;
import com.avoris.modelado.exception.EstudianteMenorEdadException;

import java.util.Collections;
import java.util.List;

public class Estudiante {
    private final String nombre;
    private final Integer edad;
    private final Fecha fechaFinalizacion;
    private final List<Materia> materias;

    public Estudiante(String nombre, Integer edad, Fecha fechaFinalizacion, List<Materia> materias) throws EstudianteMenorEdadException {
        this.nombre=nombre;
        this.edad=edad;
        this.fechaFinalizacion=fechaFinalizacion;

        if(edad < AppModeladoApplication.MINIMO_EDAD){
            throw new EstudianteMenorEdadException("Estudiante menor de edad");

        }
        this.materias=materias;

    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad.intValue();
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion.getDiaYMes();
    }

    public List<Materia> getMaterias() throws Exception {

        return Collections.unmodifiableList(materias);
    }

}
