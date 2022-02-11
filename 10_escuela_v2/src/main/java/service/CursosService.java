package service;

import model.Curso;

public interface CursosService {
	boolean nuevoCurso(Curso curso);
	Curso cursoPorId(int idCurso);
}
