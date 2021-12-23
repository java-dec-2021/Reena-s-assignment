<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page isErrorPage="true" %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to coding dojo</h3>


<!-- <form action="/welcome" method="POST">
<p> First Name: <input type="text" name="firstName"> </p>
<p> Last Name: <input type="text" name="lastName"> </p>
<p> Email: <input type="text" name="email"> </p>
<p><button>Submit</button></p>
</form> -->

<h1>New Book</h1>
<form:form action="/create" method="post" modelAttribute="newStudent">
    <p>
        <form:label path="firstName">firstName</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:textarea path="lastName"/>
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:errors path="email"/>
        <form:input path="email"/>
    </p>
  
    <input type="submit" value="Submit"/>
</form:form>  


</body>
</html>