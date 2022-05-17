<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>	Login Regstrition</title>
</head>
<body>
    
<h1>Regstiration :</h1>
<form:form action="/register" method="post" modelAttribute="newUser">
    <p>
        <form:label path="userName">User Name</form:label>
        <form:errors path="userName"/>
        <form:textarea path="userName"/>
        
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:errors path="email"/>
        <form:textarea path="email"/>
    </p>
    <p>
        <form:label path="password">Password</form:label>
        <form:errors path="password"/>
          <form:textarea path="password"/>
        
    </p>
    <p>
        <form:label path="confirm">Confirm</form:label>
        <form:errors path="confirm"/>     
         <form:textarea path="confirm"/>
    </p>    
    <input type="submit" value="Register"/>
</form:form>  

<h1>Login :</h1>
<form:form action="/login" method="post" modelAttribute="newLogin">
    <p>
        <form:label path="email">Email</form:label>
        <form:errors path="email"/>
        <form:textarea path="email"/>
        
    </p>
    

    <p>
        <form:label path="password">Password</form:label>
        <form:errors path="password"/>
          <form:textarea path="password"/>
        
    </p>
  
    <input type="submit" value="Login"/>
</form:form>     


</body>
</html>