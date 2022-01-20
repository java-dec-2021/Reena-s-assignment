<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    crossorigin="anonymous"/>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>All Users</h1>
 <a href="/">New User</a>
  <a href="/projects">All Projects</a>
    <a href="/projects/new">New Project</a>
<table class="table table-dark">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Action</th>
            <th>Login</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${Users}" var="User">
        <tr>
            <td><c:out value="${User.firstName}"/></td>
            <td><c:out value="${User.lastName}"/></td>
            <td><c:out value="${User.email}"/></td>
            <td>
               <form action="/delete/${User.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
				</form>
				</td>
				<td>
				
				 <form action="/login/${User.id}" method="post">
					    <input type="submit" value="Login">
				</form>
				</td>
		</tr>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>