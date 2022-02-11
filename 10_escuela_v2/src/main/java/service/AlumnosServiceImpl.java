package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import dao.CursosDao;
import model.Alumno;
import model.Curso;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	AlumnosDao daoAlumnos;
	CursosDao daoCursos;
	public AlumnosServiceImpl(@Autowired AlumnosDao daoAlumnos, @Autowired CursosDao daoCursos) {
		this.daoCursos=daoCursos;
		this.daoAlumnos=daoAlumnos;
	}

	@Override
	public boolean altaAlumno(Alumno alumno, int idCurso ) {
		Curso curso=daoCursos.findById(idCurso);
		if(daoAlumnos.findById(alumno.getDni())==null&&curso!=null) {
			alumno.setCurso(curso);
			daoAlumnos.save(alumno);
			return true;
		}
		return false;
	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		return daoAlumnos.findByCurso(idCurso);
	}

	@Override
	public List<Alumno> alumnosFechaCurso(Date fecha) {
		return daoAlumnos.findByFechaCurso(fecha);
	}

	@Override
	public Curso cursoAlumno(String dni) {
		return daoCursos.findByAlumno(dni);
	}

}
