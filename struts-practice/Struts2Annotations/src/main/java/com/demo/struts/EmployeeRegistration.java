package com.demo.struts;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ValidationAware;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;


@Action("/registerEmployee")
@Results({
	@Result(name="success",location="/success.jsp"),
	@Result(name="input",location="/employee.jsp")
})
public class EmployeeRegistration extends ActionSupport implements ValidationAware{
	
	private String username;
	private String password;
	
	@RequiredStringValidator( type= ValidatorType.SIMPLE,fieldName="username", message = "The name is required" )
	 public String getUsername() {
		return username;
	}

	 
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	


	public String execute() {
//		if (username == null || username.isEmpty()) {
//	        return "input"; // Redirect to input if username is not provided
//	    }
		System.out.println("username is:::" + username);
		return "success";
	}

}
