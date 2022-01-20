<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<div class="container">

<h2>Project Info</h2>
 
 <h3> <c:out value="${project.projectName}"/></h3>

<h5><c:out value="${project.description}"/></h5>
 
 
 Created By:<c:out value="${project.User.firstName}"/>
 
<!-- Check if project belongs to user -->
	<p></p>
	<form action="/project/delete/${project.id}" method="post">
		<input type="hidden" name="_method" value="delete">
            <button class="btn btn-danger">Delete</button> 
	</form>
	<p></p>
	<form action="/projects/edit/${project.id}">
			   <button class="btn btn-info">Edit</button>	
	</form>
 	
 	<a href="/dashboard">All Users</a>
     <a href="/projects">All Projects</a>
 
 </div>
</body>
</html>