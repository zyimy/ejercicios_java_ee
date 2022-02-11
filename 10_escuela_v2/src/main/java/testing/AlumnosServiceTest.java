package testing;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import configuration.ModeloConfig;
import service.AlumnosService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ModeloConfig.class }) 
public class AlumnosServiceTest {
	@Autowired
	AlumnosService service;
	
	@Test
	void testAlumnosCurso() {
		assertEquals(3, service.alumnosCurso(2).size());
	}
	
	@Test
	void testCursoAlumno() {
		assertEquals("java"	,service.cursoAlumno("1111A").getDenominacion());
	}
}
