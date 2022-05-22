<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
  	 <a href="/category/new">Add categories</a>
<table class="table border col-5 mb-5">
				  <thead>
				    <tr>
				     
				      <th scope="col">Categories</th>
				  
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="category" items="${categories}">
				    <tr>
				     <td> <c:out value="${category.name}"/></td>
				  
				     	     </tr>
				    </c:forEach>
			
				</table>
</body>
</html>