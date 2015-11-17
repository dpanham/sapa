package edu.fatec.sapa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Get situation types from database
 */
public class SituacaoDAO {
	// database factory
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
	private EntityManager manager = factory.createEntityManager();
	
	public List<Object[]> getSituacao() {
		TypedQuery<Object[]> query = manager.createQuery(
				"SELECT e FROM Situacao e", Object[].class);
		return query.getResultList();
	}	
}