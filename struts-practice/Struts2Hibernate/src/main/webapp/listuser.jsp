<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head>

<title>User List</title>
</head>
<body>
<h2>User List</h2>
<s:iterator value="users">
	<p>ID: <s:property value="id"/></p>
	<p>Name: <s:property value="name"/></p>
	<p>Email: <s:property value="email"/></p>
</s:iterator>
<br/>
<s:a action="addUser">Add User</s:a>
<br/>
<s:form action="goBack" method="post">
		
		<s:submit value="Back"/>
	</s:form>

</body>
</html>