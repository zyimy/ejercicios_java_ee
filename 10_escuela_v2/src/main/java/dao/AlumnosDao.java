package dao;

import java.util.Date;
import java.util.List;

import model.Alumno;

public interface AlumnosDao {
	void save(Alumno alumno);
	Alumno findById(String dni);
	List<Alumno> findByCurso(int idCurso);
	List<Alumno> findByFechaCurso(Date fechaInicio);
}
