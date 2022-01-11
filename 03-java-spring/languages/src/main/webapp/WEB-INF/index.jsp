<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to coding dojo, we offer below programs: 

 <c:forEach var="program" items="${programs}">
            <c:out value="${program}"></c:out>
</c:forEach>

</h3>

<form action="/welcome" method="POST">
<p> Name: <input type="text" name="firstName"> </p>
<p> Email: <input type="text" name="email"> </p>
<p>Program: 
	<select name="program">
	<option value="java">Java</option>
	<option value="MERN">MERN</option>
	<option value="Azure">Azure</option>
	</select>
</p>
<p><button>Submit</button></p>
</form>


</body>
</html>