package edu.fatec.sapa.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import edu.fatec.sapa.dao.UserDAO;
import edu.fatec.sapa.model.User;

/**
 * Code responsible to create user login
 */
@ManagedBean(name = "LoginMB")
@SessionScoped
public class UserController {
	
	private UserDAO userDAO = new UserDAO(); //instantiate User database connection object
	private User user = new User(); //instantiate User entity
	
	public String login() {
		user = userDAO.getUser(user.getUname(), user.getUpass());
		if (user == null) {
			user = new User();
			FacesContext.getCurrentInstance().addMessage(
					null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!",
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
		return "/login";
	}
	
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}