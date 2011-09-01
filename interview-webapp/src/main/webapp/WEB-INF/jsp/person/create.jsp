<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Create Person</title>
		<link rel="stylesheet" href="<c:url value='/css/style.css' />" type="text/css"></link>
	</head>
	<body>
		<form:form commandName="person">
			<h1>Create Person</h1>
			First Name: <form:input path="firstName"/>
			<form:errors  path="firstName"/>
			<br/><br/>
			Last Name: <form:input path="lastName"/>
			<br/><br/>
			<input value="Create" type="submit"/>
		</form:form>
	</body>
</html>
