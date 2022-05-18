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
    
<h2>Register</h2>
<div>
                <form:form action="/register" method="post" modelAttribute="newUser">
                   
                      
                      <form:label path="userName" for="floatingInput">Name:</form:label>
                      <form:input path="userName"  name = "userName" placeholder="User Name"/>
                        <form:errors path="userName" class = "my-3" style="color: red;"/>
           
         
                      
                      <form:label path="email" for="floatingInput">Email:</form:label>
                      <form:input type="email" path="email" name = "email"  placeholder="name@example.com"/>
                        <form:errors path="email" class = "my-3" style="color: red;"/>
          
                   
                      
                      <form:label path="password" for="floatingInput">Password:</form:label>
                      <form:input type="password" path="password"  name = "password"  placeholder="Password"/>
                        <form:errors path="password" class = "my-3" style="color: red;"/>
                   
                  
                      
                      <form:label path="confirm" for="floatingInput">Confirm Password:</form:label>
                      <form:input type="password"  path="confirm"  name = "confirm"  placeholder="confirm password"/>
                        <form:errors path="confirm" class = "my-3" style="color: red;"/>
                    
                    <button type="submit" class="btn btn-outline-warning align-self-center">Register</button>
                    </form:form>
                    
                    </div>
    	
    		 
    		 <div>
    			<h2>Login</h2>
                <form:form action="/login" method="post" modelAttribute="newLogin">
                  
                      
                      <form:label path="email" for="floatingInput">Email:</form:label>
                      <form:input type="email" path="email" name = "email"  placeholder="name@example.com"/>
                        <form:errors path="email" class = "my-3" style="color: red;"/>
                  
                      
                      <form:label path="password" for="floatingInput">Password:</form:label>
                      <form:input type="password" path="password" class="form-control" name = "password" id="floatingInput" placeholder="Password"/>
                        <form:errors path="password" class = "my-3" style="color: red;"/>
                    
                    <button type="submit" >Log In</button>
                    </form:form>
			</div>

</body>
</html>