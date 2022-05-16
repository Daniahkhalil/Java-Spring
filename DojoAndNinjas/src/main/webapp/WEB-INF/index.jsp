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
<h2>New Dojo</h2>

<form:form action="/dojos/new" method="post" modelAttribute="dojo">
  
    <p>

					  <form:label path="name" for="floatingInput">Dojo Name : </form:label>
					    <form:input path="name" class="form-control"  id="floatingInput" />
						<form:errors path="name" class = "my-3" style="color: red;"/>
    </p>
     
    <button type="submit" class="btn btn-danger">Create</button>
</form:form>    
</body>
</html>