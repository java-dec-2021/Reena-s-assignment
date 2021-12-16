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
<h2>Welcome: <c:out value="${firstName}"/> </h2>
<h3>Email:<c:out value="${email}"/> </h3>
<h3>program:<c:out value="${program}"/> </h3>

<a href="/details">Details</a>

</body>
</html>