<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
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

<h1>New Ninja :</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
    <p>
        <form:label path="dojo">Dojo :</form:label>
        <form:errors path="dojo"/>
     	<form:select path="dojo" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
				  <c:forEach var="dojo" items="${dojos}">
				  	<form:option value="${dojo}"><c:out value="${dojo.name}"></c:out></form:option>
				  </c:forEach>
				</form:select>
    </p>
    <p>
    

	   <form:label path="firstName" for="floatingInput">First Name : </form:label>
		<form:input path="firstName" class="form-control"  id="floatingInput" />
		<form:errors path="firstName" class = "my-3" style="color: red;"/>
		
     
    </p>
    <p>
    	   <form:label path="lastName" for="floatingInput">Last Name : </form:label>
		<form:input path="lastName" class="form-control"  id="floatingInput" />
		<form:errors path="lastName" class = "my-3" style="color: red;"/>
      
    </p>
    <p>
       	   <form:label path="age" for="floatingInput">Age : </form:label>
		<form:input type="number" path="age" class="form-control"  id="floatingInput" />
		<form:errors path="age" class = "my-3" style="color: red;"/>

    </p>    
   <button type="submit" class="btn btn-danger">Create</button>
</form:form>   
</body>
</html>