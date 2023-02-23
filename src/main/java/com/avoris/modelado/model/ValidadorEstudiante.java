package com.avoris.modelado.model;

import com.avoris.modelado.exception.CalificacionInvalidaException;
import com.avoris.modelado.exception.EstudianteMenorEdadException;
import com.avoris.modelado.exception.ParametrosNullException;
import org.apache.logging.log4j.util.Strings;

import java.util.Objects;

import static com.avoris.modelado.AppModeladoApplication.MINIMO_EDAD;
import static com.avoris.modelado.constantes.MensajesExceptions.*;

public class ValidadorEstudiante {


    public static Boolean validarEstudiante(Estudiante estudiante) {
        if (estudiante.getEdad() < MINIMO_EDAD) {
            throw new EstudianteMenorEdadException("El estudiante ingresado es menor de edad");
        }
        if (Strings.isEmpty(estudiante.getNombre()) || Objects.isNull(estudiante.getFecha()) || Objects.isNull(estudiante.getMaterias())) {
                throw new ParametrosNullException(PARAMS_NULL);
        }

        return true;
    }

    public static Boolean validarNotas(Estudiante estudiante){
        Boolean materiasValidas=estudiante.getMaterias()
                .stream()
                .allMatch(materia-> materia.getCalificacion().compareTo(NOTA_MINIMA)>0 &&
                        NOTA_MAXIMA.compareTo(materia.getCalificacion())>0);
        if (!materiasValidas || estudiante.getMaterias().isEmpty()){
            StringBuilder mensaje=new StringBuilder(CALIFICACIONES_INVALIDAS);
            throw new CalificacionInvalidaException(mensaje.append(estudiante.getNombre()).toString());
        }
        return true;
    }

}