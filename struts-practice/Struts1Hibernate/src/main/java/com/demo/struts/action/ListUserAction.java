package com.demo.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.hibernate.query.Query;


import com.demo.struts.model.User;
import com.demo.struts.util.HibernateUtil;

public class ListUserAction extends Action{
	
	private static final Logger logger = LogManager.getLogger(ListUserAction.class);
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Executing List user -execute method");
		
		String action = request.getParameter("action");
		
		if("back".equals(action)) {
			return mapping.findForward("back");
		}
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<User> query = session.createQuery("from User", User.class);
		List<User> users = query.list();
		
		session.close();
		request.setAttribute("users", users);
		
		return mapping.findForward("success");
		
	}

}
