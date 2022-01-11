<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>All Students</h1>
<table>
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
			<th>Action</th>	           
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${students}" var="student">
        <tr>
            <td><c:out value="${student.firstName}"/></td>
            <td><c:out value="${student.lastName}"/></td>
            <td><c:out value="${student.email}"/></td>
          	<td>
		        <form action="/delete/${student.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
				</form>
			</td>
        
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/">New Student</a>
<a href="/dashboard">All Students</a>
<a href="/projects">All Projects</a>

</body>
</html>