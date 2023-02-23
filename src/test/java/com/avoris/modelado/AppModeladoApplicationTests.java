package com.avoris.modelado;

import com.avoris.modelado.exception.CalificacionInvalidaException;
import com.avoris.modelado.exception.EstudianteMenorEdadException;
import com.avoris.modelado.exception.ParametrosNullException;
import com.avoris.modelado.model.Estudiante;
import com.avoris.modelado.model.Fecha;
import com.avoris.modelado.model.Materia;
import com.avoris.modelado.model.ValidadorEstudiante;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Estudiante Test")
class AppModeladoApplicationTests {


	final static List<Materia> materiasOk= new ArrayList<>();
	final static List<Materia> materiasInvalidas= new ArrayList<>();

	static ValidadorEstudiante validadorEstudiante;
	static Estudiante estudianteOk;
	static Estudiante estudianteMenorEdad;
	static Estudiante estudianteNombreNull;

	static Estudiante estudianteFechaNull;

	static Estudiante estudianteMateriasInvalidas;

	static Estudiante estudianteNull;

	@BeforeAll
	public static void setUp() throws Exception {

		//Materias con Calificaciones Ok
		Materia matematicaDiscreta= new Materia("Matematica Discreta", 8.0);
		Materia algebra= new Materia("Algebra y Geometria Analitica", 7.5);
		Materia analisisMat= new Materia("Analisis Matematico 1", 9.0);

		//Materias con Calificaciones Invalidas
		Materia ingenieriaYSociedad= new Materia("Matematica Discreta", 8.0);
		Materia analisis2= new Materia("Algebra y Geometria Analitica", 1258.5);
		Materia fisica= new Materia("Analisis Matematico 1", 9.0);

		materiasOk.add(algebra);
		materiasOk.add(analisisMat);
		materiasOk.add(matematicaDiscreta);

		materiasInvalidas.add(ingenieriaYSociedad);
		materiasInvalidas.add(analisis2);
		materiasInvalidas.add(fisica);

		Fecha fecha=new Fecha(LocalDate.of(2021, 1, 3));

		estudianteOk= new Estudiante("Pablo", 32, fecha, materiasOk);
		estudianteMenorEdad= new Estudiante("Pablo", 16, fecha, materiasOk);
		estudianteNombreNull= new Estudiante("", 32, fecha, materiasOk);
		estudianteFechaNull= new Estudiante("Pablo", 32,null , materiasOk);
		estudianteMateriasInvalidas= new Estudiante("Pablo", 32,fecha, materiasInvalidas);

		estudianteNull=new Estudiante("",0,null,new ArrayList<>());


	}

	@Nested
	@DisplayName("Se valida tanto los parametros propios de la persona, como las materias")
	@Test
	public void estudianteOk() throws Exception {
		assertEquals(true,ValidadorEstudiante.validarEstudiante(estudianteOk));
		assertEquals(true, ValidadorEstudiante.validarNotas(estudianteOk));
	}

	@DisplayName("Se valida que es menor de edad")
	@Test
	public void estudianteMenorDeEdad() throws Exception {
		assertThrows(EstudianteMenorEdadException.class, ()->{
			ValidadorEstudiante.validarEstudiante(estudianteMenorEdad);
		});
	}
	@DisplayName("Se valida que el parametro nombre viene en null")

	@Test
	public void paramNombreNull() throws Exception {
		assertThrows(ParametrosNullException.class, ()->{
			ValidadorEstudiante.validarEstudiante(estudianteNombreNull);
		});
	}

	@DisplayName("Se valida que la fecha ingresada es null")
	@Test
	public void paramfechaNull() throws Exception {
		assertThrows(ParametrosNullException.class, ()->{
			ValidadorEstudiante.validarEstudiante(estudianteFechaNull);
		});
	}


	@DisplayName("Se valida que se ingresaron calificaciones invalidas, con el validador")
	@Test
	public void estudianteConMateriasConNotasInvalidas(){
		assertThrows(CalificacionInvalidaException.class, ()->{
			ValidadorEstudiante.validarNotas(estudianteMateriasInvalidas);
		});
	}

	@DisplayName("Se validan parametros vacios, nombre, edad, fecha y materias sin elementos")
	public void estudianteConParamsNull(){
		assertAll("paramsNull",
				()-> assertEquals(0, estudianteNull.getEdad()),
				()-> assertEquals(true, Objects.isNull(estudianteNull.getFecha())),
				()-> assertEquals(0, estudianteNull.getMaterias().size()),
				()-> assertThrows(CalificacionInvalidaException.class,()-> ValidadorEstudiante.validarNotas(estudianteNull))
		);
	}



}
