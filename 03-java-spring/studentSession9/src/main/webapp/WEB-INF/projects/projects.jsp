<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    crossorigin="anonymous"
  />
    <title>Insert title here</title>
  </head>
  <body>
    <h1>All Projects</h1>
    <p><c:out value="${loogedIn}" /></p>
    <a href="/">Home</a>
    <a href="/projects/new">Create New Project</a>
    <a href="/dashboard">All Students</a>

    <table class="table table-dark">
      <thead>
        <tr>
          <th>Project name</th>
          <th>Created By</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${allProjects}" var="project">
          <tr>
            <td>
              <a href="/projectDetails/${project.id}">
                <c:out value="${project.projectName}"
              /></a>
            </td>
            <td>
              <c:out value="${project.student.firstName}" />,
              <c:out value="${project.student.lastName}" />
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
