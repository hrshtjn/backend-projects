package com.demo.struts.action;

import java.util.List;

import com.demo.struts.dao.UserDao;
import com.demo.struts.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	
	private UserDao dao = new UserDao();
	private User user;
	private List<User> users;
	
	public String add() {
		if(!user.getEmail().isEmpty()) {
			dao.addUser(user);
			return SUCCESS;
		}
		
		return INPUT;
		
	}
	
	public String list() {
		users = dao.getAllUsers();
		return SUCCESS;
	}
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
