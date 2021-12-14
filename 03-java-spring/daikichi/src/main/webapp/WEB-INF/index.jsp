<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
	
</head>
<body>

<%! String firstName="Reena"; %>
<h1>Are you feeling lucky? <%= firstName %></h1>
<%=12+12 %> 

<c:out value="${firstName}  ${stack} "/>


</body>
</html>