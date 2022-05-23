<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   
      
                <h1>Welcome, <c:out value="${currentUser.userName}"></c:out>!</h1>
                
                <a href="/logout">Logout</a>
                <a href="/books/new">+Add to my shelf</a>
    <table class="table table-dark table-hover">
  <thead>
    <tr>
    
      <th class="table-secondary">ID</th>
      <th class="table-secondary">Title</th>
      <th class="table-secondary">Author</th>
      <th class="table-secondary">Posted By</th>
    </tr>
  </thead>
  <tbody>
  
      
      <c:forEach var="book" items="${books}">
       <tr class="table-secondary">
        <td class="table-secondary">.<c:out value="${book.id}"/></td>
       <td class="table-secondary">.<a href="/show/${book.id}"> <c:out value="${book.title}"/></a></td>
        <td class="table-secondary">.<c:out value="${book.author}"/></td>
      <td class="table-secondary">.<c:out value="${book.user.userName}"/></td>
       </tr>
      </c:forEach>
   
  
  </tbody>
</table>

        
          


</body>
</html>