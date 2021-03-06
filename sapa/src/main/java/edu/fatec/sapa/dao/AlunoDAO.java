package edu.fatec.sapa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Get period from database
 */
public class AlunoDAO {
	// database factory
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
	private EntityManager manager = factory.createEntityManager();
	
	public List<Object[]> getAluno() {
		TypedQuery<Object[]> query = manager.createQuery(
				"SELECT e FROM Aluno e", Object[].class);
		return query.getResultList();
	}	
}