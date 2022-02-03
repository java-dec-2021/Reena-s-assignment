<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Testing APIs</h1>
<c:forEach items="${results}" var="movie">
	<h1>
	   Movie:  ${movie.getString("Title")}
	</h1>
	<h2>Year:  ${movie.getString("Year")}</h2>
	<img src='${movie.getString("Poster")}'/>


</c:forEach>


</body>
</html>