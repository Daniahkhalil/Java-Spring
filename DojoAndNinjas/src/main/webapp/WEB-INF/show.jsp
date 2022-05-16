<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos And Ninjas</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>


<table class="table table-striped">
  <thead>
 
    <tr>
      <th scope="col">#</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
      
   
    </tr>
  
  </thead>
  <tbody>
     <c:forEach var="ninja" items="${ninjas}">
    <tr>
   <td  scope="row"><c:out value="${ninja.id}"></c:out></td>
     <td  scope="row"><c:out value="${ninja.firstName}"></c:out></td>
     <td colspan="2"><c:out value="${ninja.lastName}"></c:out></td>
     <td colspan="2"><c:out value="${ninja.age}"></c:out></td>
     
    </tr>
  </c:forEach>

  </tbody>
</table>
</body>
</html>