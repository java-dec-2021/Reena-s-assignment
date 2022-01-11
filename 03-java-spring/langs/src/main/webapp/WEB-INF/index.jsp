<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>All Languages</h3>

 <c:forEach var="language" items="${languages}">
            <c:out value="${language.languageName}"></c:out>
            <c:out value="${language.creator}"></c:out>
            <c:out value="${language.version}"></c:out>
</c:forEach>

<h1>New Language</h1>
<form:form action="/languages" method="post" modelAttribute="newLang">
    <p>
        <form:label path="languageName">language Name</form:label>
        <form:input path="languageName"/>
         <form:errors path="languageName" class="text-danger"/>
    </p>
    <p>
        <form:label path="creator">creator</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="version">version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
  
    <input type="submit" value="Submit"/>
</form:form>    



</body>
</html>