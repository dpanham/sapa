package edu.fatec.sapa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.fatec.sapa.model.*;
public class test {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sapa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		User user = new User();
		
		user.setUname("usantos");
		user.setPass("123");
		
		manager.persist(user);
		trx.commit();
	}
}