<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/books">Back to the shelf</a>
       <form:form action="/books/new" method="post" modelAttribute="newBook">
                  
                      
                      <form:label path="title" for="floatingInput">Title :</form:label>
                      <form:input type="text" path="title" name = "Title"  placeholder="Title"/>
                        <form:errors path="title" class = "my-3" style="color: red;"/>
                  
                      
                      <form:label path="author" for="floatingInput">Author :</form:label>
                      <form:input type="text" path="author" class="form-control" name = "Author" id="floatingInput" placeholder="Author"/>
                        <form:errors path="author" class = "my-3" style="color: red;"/>
                        
                        <form:label path="description" for="floatingInput">Description :</form:label>
                      <form:input type="text" path="description" class="form-control" name = "Description" id="floatingInput" placeholder="Description"/>
                        <form:errors path="description" class = "my-3" style="color: red;"/>
                        
                        
                    
                    <button type="submit" >Add</button>
                    </form:form>
</body>
</html>