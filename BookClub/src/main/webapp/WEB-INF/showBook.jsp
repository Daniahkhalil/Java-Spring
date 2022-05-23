<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IShow Book</title>
</head>
<body>
<a href="/books">Back to the shelf</a>
<h1><c:out value="${book.title}"/></h1>
<p><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</p>
<h2>Here's <c:out value="${book.user.userName}"/>'s thoughts:</h2>
<p><c:out value="${book.description}"/></p>
</body>
</html>