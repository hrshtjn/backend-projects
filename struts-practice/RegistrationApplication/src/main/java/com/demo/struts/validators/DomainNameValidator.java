package com.demo.struts.validators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class DomainNameValidator extends FieldValidatorSupport{
	
	private String domainName;

	@Override
	public void validate(Object object) throws ValidationException {
		// TODO Auto-generated method stub
		System.out.println("DomainNameValidator called");
		String fieldName = getFieldName();
		String email = (String)getFieldValue(fieldName,object);
		
		if(!email.endsWith(domainName)) 
		{
			addFieldError(fieldName, object);
		}
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

}
