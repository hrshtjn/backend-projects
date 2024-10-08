<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<body>
	<h1>Welcome to user management</h1>
	<h2><bean:message key="greeting"/></h2>
	<a href="listUser.do">List all</a>
	<br/>
	<a href="addUser.do?method=load">Add user</a>
	<br/>
	<a href="changeLocale.do?lang=en">English</a>
	<br/>
	<a href="changeLocale.do?lang=fr">French</a>
</body>
</html>