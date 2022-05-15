<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Language</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

				<a href="/languages">Go Back</a>
		
		<div class = "row justify-content-center">
			<div class = "col-5 align-self-center">
			<h1>Edit Language</h1>
				<form:form action="/languages/${language.id}/edit" method="post" modelAttribute="language">
				<input type="hidden" name="_method" value="put">
					<div >
					  <form:input path="name"  name = "name" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="name" for="floatingInput">Language Name</form:label>
						<form:errors path="name" style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="creator" type="text" name = "vendor" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="creator" for="floatingInput">Creator</form:label>
						<form:errors path="creator" />
					</div>
					<div class="form-floating mb-3">
					  <form:input path="version" type="text"  name = "version" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="version" for="floatingInput">Version</form:label>
					<form:errors path="version"/>
					</div>
					<button type="submit">Update</button>
				</form:form>
			</div>
		</div>
	</body>
</html>