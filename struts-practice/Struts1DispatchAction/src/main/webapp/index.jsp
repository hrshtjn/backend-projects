<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<html:html>
<HEAD>
<TITLE>Dispatch Action Example</TITLE>
<BODY>

	<H3>Dispatch Action Example</H3>
	<p>
		<html:link page="/user.do?parameter=add">Call Add Section</html:link>
	</p>
	<p>
		<html:link page="/user.do?parameter=edit">Call Edit Section</html:link>
	</p>
	<p>
		<html:link page="/user.do?parameter=search">Call Search Section</html:link>
	</p>
	<p>
		<html:link page="/user.do?parameter=save">Call Save Section</html:link>
	</p>
</html:html>