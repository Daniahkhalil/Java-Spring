<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body >
<main class="main">
<h1 class="center">Home Page</h1>
<a href="/product/new">New Product</a><br>
<a href="/category/new">New Category</a>
<hr>
<table class="table">
  <thead>
    <tr>
      
      <th scope="col">Products</th>
      <th scope="col">Categories</th>
    </tr>
  </thead>
  <tbody >
    <tr>
      <td>
	      <c:forEach var="products" items="${product}">
	      <a href="product/${products.id}">-<c:out value="${products.name}"/></a><br>
	      </c:forEach>
      </td>
      <td>
	      <c:forEach var="categories" items="${category}">
	      <a href="category/${categories.id}">-<c:out value="${categories.name}"/></a><br>
	      </c:forEach>
      </td>
    </tr>
  
  </tbody>
</table>
</main>
</body>
</html>