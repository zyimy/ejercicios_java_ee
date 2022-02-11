package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Alumno;
@Repository
public class AlumnosDaoImpl implements AlumnosDao {
	@PersistenceContext
	EntityManager emanager;
	
	@Transactional
	@Override
	public void save(Alumno alumno) {
		emanager.persist(alumno);

	}

	@Override
	public Alumno findById(String dni) {
		return emanager.find(Alumno.class, dni);
	}

	@Override
	public List<Alumno> findByCurso(int idCurso) {
		String jpql="select a from Alumno a where a.curso.idCurso=?1";
		var query=emanager.createQuery(jpql,Alumno.class);
		query.setParameter(1, idCurso);
		return query.getResultList();
	}

	@Override
	public List<Alumno> findByFechaCurso(Date fechaInicio) {
		String jpql="select a from Alumno a where a.curso.fechaInicio>=?1";
		var query=emanager.createQuery(jpql,Alumno.class);
		query.setParameter(1, fechaInicio);
		return query.getResultList();
	}

}
