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
<title>Product Page</title>

    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<main class="main">
<h1 class="center"><c:out value="${product.name}"/></h1>
<a href="/">Home</a>
<hr>
<h1>Categories:</h1>
<ul>
<c:forEach var="cate" items="${category}">
<li><c:out value="${cate.name}"/></li>
</c:forEach>
</ul>
<hr>
<h1>Add Category</h1>
<form:form action="/product/${product.id}" method="post" modelAttribute="product">
  <div class="row mb-3">
    <div class="col-sm-10">
    
    <form:select path="categories"  class="form-control" id="inputEmail3">
    <c:forEach var="category" items="${cat}">
  		<form:option value="${category.id}">
  		<c:out value="${category.name}" />
  		</form:option>
  	
 </c:forEach>
 </form:select>
    </div>
  </div>
   <input type="submit" value="Add" class="btn btn-dark"/>
  </form:form>
</main>
</body>
</html>