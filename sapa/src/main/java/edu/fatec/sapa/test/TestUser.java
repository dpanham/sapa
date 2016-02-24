package edu.fatec.sapa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.fatec.sapa.dao.UserDAO;
import edu.fatec.sapa.model.User;
public class TestUser {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		
		User user = new User();
		UserDAO userDAO = new UserDAO();
		user = userDAO.getUser("admin", "fatec");
		if (user == null) {
			trx.begin();
			user = new User();
			
			user.setUname("admin");
			user.setUpass("fatec");
			user.setUlevel(1);
			
			manager.persist(user);
			trx.commit();
		}	
	}
}