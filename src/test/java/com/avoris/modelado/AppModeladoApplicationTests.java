package com.avoris.modelado;

import com.avoris.modelado.exception.EstudianteMenorEdadException;
import com.avoris.modelado.exception.ParametrosNullException;
import com.avoris.modelado.model.Estudiante;
import com.avoris.modelado.model.Fecha;
import com.avoris.modelado.model.Materia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AppModeladoApplicationTests {

	@Test
	void contextLoads() {
	}

	static List<Materia> materias= new ArrayList<>();

	@BeforeAll
	public static void setUp() throws Exception {
		Materia matematicaDiscreta= new Materia("Matematica Discreta", 8.0);
		Materia algebra= new Materia("Algebra y Geometria Analitica", 7.5);
		Materia analisisMat= new Materia("Analisis Matematico 1", 9.0);

		materias.add(algebra);
		materias.add(analisisMat);
		materias.add(matematicaDiscreta);

	}

	@Test
	public void estudianteOk() throws Exception {

		Fecha fecha=new Fecha(LocalDate.of(2021, 1, 3));
		Estudiante estudiante1= new Estudiante("Pablo", 32, fecha, materias);

		assertEquals("Pablo", estudiante1.getNombre());

	}

	@Test
	public void estudianteMenorDeEdad() throws Exception {
		assertThrows(EstudianteMenorEdadException.class, ()->{
			Estudiante estudiante1= new Estudiante("Pablo", 16, new Fecha(LocalDate.of(2021, 1, 3)), materias);
		});
	}

	@Test
	public void paramNombreNull() throws Exception {
		assertThrows(ParametrosNullException.class, ()->{
			Estudiante estudiante1= new Estudiante("", 22, new Fecha(LocalDate.of(2021, 1, 3)), materias);
		});
	}

	@Test
	public void paramfechaNull() throws Exception {
		assertThrows(ParametrosNullException.class, ()->{
			Estudiante estudiante1= new Estudiante("Pablo", 22, null, materias);
		});
	}

	@Test
	public void parammateriasNull() throws Exception {
		assertThrows(ParametrosNullException.class, ()->{
			Estudiante estudiante1= new Estudiante("Pablo", 22, new Fecha(LocalDate.of(2021, 1, 3)), null);
		});
	}


}
