<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>

<title>Add user</title>
</head>
<body>
	<html:form action="/addUser.do" method="post">
		<html:hidden property="method" value="add"/>
	<table>
		<tr>
			<td>ID:</td>
			<td><html:text property="id"></html:text></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><html:text property="name"></html:text></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><html:text property="email"></html:text></td>
		</tr>
		<%-- <tr>
			<td colspan="3">
				<html:submit value="Add User"/>
			</td>
		</tr> --%>
	</table>
	
	<input type="submit" value="Save"/>
	</html:form>
	<br/>
	
	<!-- Back button -->
	<html:form action="/addUser.do">
		<html:hidden property="method" value="back"/>
		<input type="submit" value="Back"/>
	</html:form>

</body>
</html>