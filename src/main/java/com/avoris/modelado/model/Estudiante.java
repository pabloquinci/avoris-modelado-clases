package com.avoris.modelado.model;

import com.avoris.modelado.AppModeladoApplication;
import com.avoris.modelado.constantes.MensajesExceptions;
import com.avoris.modelado.exception.EstudianteMenorEdadException;
import com.avoris.modelado.exception.ParametrosNullException;
import org.apache.logging.log4j.util.Strings;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Estudiante {
    private final String nombre;
    private final Integer edad;
    private final Fecha fechaFinalizacion;
    private final List<Materia> materias;


    public Estudiante(String nombre, Integer edad, Fecha fechaFinalizacion, List<Materia> materias) throws EstudianteMenorEdadException {

        if(edad < MensajesExceptions.EDAD_MINIMA){
            throw new EstudianteMenorEdadException("Estudiante menor de edad");
        }

        if(Strings.isBlank(nombre) || Strings.isEmpty(nombre) || Objects.isNull(fechaFinalizacion) || Objects.isNull(materias)){
            throw new ParametrosNullException(MensajesExceptions.PARAMS_NULL);
        }
        this.nombre=nombre;
        this.edad=edad;
        this.fechaFinalizacion=fechaFinalizacion;
        this.materias=materias;

    }

    public String getNombre() {
        return nombre;
    }

}
