package edu.fatec.sapa.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpSession;

import edu.fatec.sapa.dao.UserDAO;
import edu.fatec.sapa.model.User;

/**
 * Code responsible to create user login
 */
@ManagedBean(name = "LoginMB")
@SessionScoped
public class UserController {
	public String username;
	public String userpass;
	public int userlevel;
	
	private UserDAO userDAO = new UserDAO(); //instantiate User database connection object
	private User user = new User(); //instantiate User entity
	
	public String login() {
		user = userDAO.getUser(user.getUname(), user.getUpass());
		if (user == null) {
			user = new User();
			FacesContext.getCurrentInstance().addMessage(
					null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario/senha incorretos.",
							"Login error!"));
			return null;
		}
		else {
			//login - create session
			HttpSession session = UserSession.getSession();
			session.setAttribute("uname", user);	
			return "/main";
		}
	}
	
	//logout
	public String logout() {
		HttpSession session = UserSession.getSession();
		session.invalidate();
		return "/index";
	}
	
	public void createUser() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("db_sapa");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		
		trx.begin();
		user = new User();
		
		user.setUname(username);
		user.setUpass(userpass);
		user.setUlevel(userlevel);
		
		try {			
			manager.persist(user);
			trx.commit();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "usuario criado"));
		} catch (PersistenceException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "usuario nao foi criado"));
		}
		
	}

	//getters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
		
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public int getUserlevel() {
		return userlevel;
	}

	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	
	
}