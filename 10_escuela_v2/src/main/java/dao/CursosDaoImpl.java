package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Curso;
@Repository
public class CursosDaoImpl implements CursosDao {
	@PersistenceContext
	EntityManager emanager;
	@Transactional
	@Override
	public void save(Curso curso) {
		emanager.persist(curso);

	}

	@Override
	public Curso findById(int idCurso) {
		return emanager.find(Curso.class, idCurso);
	}

	@Override
	public Curso findByName(String name) {
		String jpql="select c from Curso c where c.denominacion=?1";
		var query=emanager.createQuery(jpql,Curso.class);
		query.setParameter(1, name);
		List<Curso> cursos=query.getResultList();
		return cursos.size()>0?cursos.get(0):null;
	}

	@Override
	public List<Curso> findAll() {
		String jpql="select c from Curso c";
		var query=emanager.createQuery(jpql,Curso.class);
		
		return query.getResultList();
	}

	@Override
	public List<Curso> findByDates(Date f1, Date f2) {
		String jpql="select c from Curso c where c.fechaInicio>=?1 and c.fechaInicio<=?2";
		var query=emanager.createQuery(jpql,Curso.class);
		query.setParameter(1, f1);
		query.setParameter(2, f2);
		return query.getResultList();
	}
	@Transactional
	@Override
	public void updateByDuration(int percent, int duration) {
		var jpql="update Curso c set c.precio=c.precio*((100-?1)/100) where c.duracion>?2";
		var query=emanager.createQuery(jpql);
		query.setParameter(1, percent);
		query.setParameter(2, duration);
		query.executeUpdate();

	}

	@Override
	public List<Curso> findByDurationMax(int duration) {
		var jpql="Select c from Curso c where c.duracion<?1";
		var query=emanager.createQuery(jpql,Curso.class);
		query.setParameter(1, duration);
		return query.getResultList();
	}

	@Override
	public Curso findByAlumno(String dni) {
		String jpql="select c from Curso c join c.alumnos a where a.dni=?1";
		var query=emanager.createQuery(jpql,Curso.class);
		query.setParameter(1, dni);
		List<Curso> cursos=query.getResultList();
		return cursos.size()>0?cursos.get(0):null;
	}

}
