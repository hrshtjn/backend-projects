package com.demo.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.struts.form.UserForm;
import com.demo.struts.model.User;
import com.demo.struts.util.HibernateUtil;

public class AddUserAction extends DispatchAction{
	
	private static final Logger logger = LogManager.getLogger(AddUserAction.class);
	
	public ActionForward load(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Executing Add user -load method");
		
		return mapping.findForward("success");
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.info("Executing Add user -add method");
		
		UserForm userForm= (UserForm) form;
		User user = new User();
		user.setId(userForm.getId());
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		
		return mapping.findForward("add");
		
	}
	
	public ActionForward back(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("Executing Add user -back method");
		return mapping.findForward("back");
	}

}
