package edu.fatec.sapa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import edu.fatec.sapa.model.User;

/**
 * Get user from database
 */
public class UserDAO {
	// database factory
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
	private EntityManager manager = factory.createEntityManager();
	
	public User getUser(String uname, String pass) {
		try {
			User user = (User) manager
					.createQuery("SELECT u FROM User u WHERE  u.uname = :name and u.pass = :pass ")
					.setParameter("name", uname)
					.setParameter("pass", pass).getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}
}
