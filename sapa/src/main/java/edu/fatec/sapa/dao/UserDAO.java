package edu.fatec.sapa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import edu.fatec.sapa.controller.HibernateUtil;
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
					.createQuery("SELECT u FROM User u WHERE  u.uname = :name and u.upass = :pass ")
					.setParameter("name", uname)
					.setParameter("pass", pass).getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void createUser(User user) {
		//Session session = HibernateUtil.getSesssionFactory().openSession();
		Configuration conf = new Configuration().configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		 SessionFactory sf = conf.buildSessionFactory(sr);
		 Session session = sf.openSession();
		 session.beginTransaction();
		try{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} finally {
			session.clear();
		}
	}
		
}
