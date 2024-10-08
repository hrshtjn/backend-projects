<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>

<title>Add user</title>
</head>
<body>
	<h2>Add User</h2>
	<s:form action="addUser" method="post">
		<s:textfield label="ID" name="user.id"/>
		<s:textfield label="Name" name="user.name"/>
		<s:textfield label="Email" name="user.email"/>
		<s:submit value="Save"/>
	</s:form>
	<br/>
	<s:form action="goBack" method="post">		
		<s:submit value="Back"/>
	</s:form>

</body>
</html>