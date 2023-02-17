package com.avoris.modelado.model;

import com.avoris.modelado.constantes.MensajesExceptions;
import com.avoris.modelado.exception.ParametrosNullException;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

public final class Materia {

    private final String nombre;
    private final Double calificacion;

    public Materia(String nombre, Double calificacion) {
        if(Strings.isEmpty(nombre) || Strings.isBlank(nombre) || Objects.isNull(calificacion)){
            throw new ParametrosNullException(MensajesExceptions.PARAMS_NULL);
        }
        this.nombre=nombre;
        this.calificacion=calificacion;

    }

}
