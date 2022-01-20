<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>Create New Project</h1>
	<a href="/dashboard">All Users</a>
     <a href="/projects">All Projects</a>
	<form:form action="/projects/create" method="post" modelAttribute="newProject">
	    <div class="form-group">
	        <form:label path="projectName">Project Name:</form:label>
	        <form:errors class="text-danger" path="projectName"/>
	        <form:input class="form-control" path="projectName"/>
	    </div>
	    <div class="form-group">
	        <form:label path="description">Project Description:</form:label>
	        <form:errors class="text-danger" path="description"/>
	        <form:input class="form-control" path="description"/>
	    </div>
	     <div class="form-group">
	       <form:label path="User">User Name</form:label>
		        <form:errors path="User"/>
		        <form:select class="form-control" path="User">
		        <c:forEach items="${ allUsers }" var="User">
		        	<option value="${ User.id }">${ User.firstName }</option>
		        </c:forEach>
		        </form:select>
		  </div>
	    <input type="submit" class="btn btn-primary" value="Submit"/>
	</form:form>    
</div>


</body>
</html>