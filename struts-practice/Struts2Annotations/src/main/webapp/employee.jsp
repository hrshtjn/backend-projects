<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<s:form action="registerEmployee">
    <s:textfield name="username" label="Username" />
    <s:password name="password" label="Password" />
    <s:submit value="Register" />
</s:form>