package com.demo.struts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.demo.struts.model.User;
import com.demo.struts.util.HibernateUtil;

public class UserDao {
	
	private SessionFactory factory;
	
	public UserDao() {
		factory = HibernateUtil.getSessionFactory();
	}
	
	public boolean addUser(User user) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	public List<User> getAllUsers() {
		Session session = factory.openSession();
		Query<User> query = session.createQuery("from User", User.class);
		List<User> userList = query.list();
		session.close();
		return userList;
	}

}
