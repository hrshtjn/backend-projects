<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<title>User List</title>
</head>
<body>
<h2>User List</h2>
<%-- <c:out value="${users}" /> --%>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Email</th>
			
		</tr>
		<logic:iterate name="users" id="user">
			<tr>
				<td><bean:write name="user" property="id"/></td>
				<td><bean:write name="user" property="name"/></td>
				<td><bean:write name="user" property="email"/></td>
			</tr>
		
		</logic:iterate>
	
	</table>
	
	<!-- <a href="index.jsp">Back</a> -->
	<!-- Back button -->
	<html:form action="/listUser.do">
		<html:hidden property="action" value="back"/>
		<input type="submit" value="Back"/>
	</html:form>

</body>
</html>