package dao;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface CursosDao {
	void save(Curso curso);
	Curso findById(int idCurso);
	Curso findByName(String name);
	List<Curso> findAll();
	List<Curso> findByDates(Date f1, Date f2);
	void updateByDuration(int percent, int duration);
	List<Curso> findByDurationMax(int duration);
	Curso findByAlumno(String dni);
}
