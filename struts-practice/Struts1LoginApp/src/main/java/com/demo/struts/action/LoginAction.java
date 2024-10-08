package com.demo.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.demo.struts.form.LoginForm;

public class LoginAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginForm loginForm = (LoginForm) form;

		if (loginForm.getUserName() != null && loginForm.getPassword() != null
				&& loginForm.getUserName().equalsIgnoreCase("hrshtjn")
				&& loginForm.getPassword().equals("abc123")) {
			return mapping.findForward("success");
		} else
			return mapping.findForward("failure");
	}

}
