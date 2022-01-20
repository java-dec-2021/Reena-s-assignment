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

<h1>All Users</h1>
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
        
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/">New User</a>

</body>
</html>