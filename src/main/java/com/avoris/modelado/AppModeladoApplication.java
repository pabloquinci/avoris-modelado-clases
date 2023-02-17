package com.avoris.modelado;

import com.avoris.modelado.model.Estudiante;
import com.avoris.modelado.model.Fecha;
import com.avoris.modelado.exception.EstudianteMenorEdadException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class AppModeladoApplication {
	public static final Integer MINIMO_EDAD=18;

	public static void main(String[] args) throws EstudianteMenorEdadException {
		SpringApplication.run(AppModeladoApplication.class, args);

	}

}
