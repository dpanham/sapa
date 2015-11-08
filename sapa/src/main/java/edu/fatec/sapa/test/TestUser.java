package edu.fatec.sapa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.fatec.sapa.model.*;
public class TestUser {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		User user = new User();
		
		user.setUname("usantos");
		user.setUpass("123");
		user.setUlevel(1);
		
		manager.persist(user);
		trx.commit();
	}
}