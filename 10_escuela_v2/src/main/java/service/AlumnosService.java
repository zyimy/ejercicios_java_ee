package service;

import java.util.Date;
import java.util.List;

import model.Alumno;
import model.Curso;

public interface AlumnosService {
	boolean altaAlumno(Alumno alumno, int idCurso);
	List<Alumno> alumnosCurso(int idCurso);
	List<Alumno> alumnosFechaCurso(Date fecha);
	Curso cursoAlumno(String dni);
}
