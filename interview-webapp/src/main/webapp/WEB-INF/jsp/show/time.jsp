<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
	<head>
		<title>Show Time</title>
		<script type="text/javascript">
			function retrieveTime(){
				var request = new XMLHttpRequest();
		        request.open("POST", "<c:url value='/show/time.do' />", true);
		        request.onreadystatechange = function () { 
			        	document.getElementById("time").innerHTML = request.responseText;
			        };
		        request.send(null);
			}
		</script>
	</head>
	<body>
		<input id="retrieveTime" type="button" onclick="retrieveTime();" value="Show Time"/>
		<br/>
		<div id="time"></div>
	</body>
</html>