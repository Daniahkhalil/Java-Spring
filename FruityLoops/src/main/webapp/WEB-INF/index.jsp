<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<span class="support tag open from-rainbow"></span><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><span class="support tag close from-rainbow"></span>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Dojo Page</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
  <h1>Fruit Store</h1>
<div>
  
<table class="table">
  <thead>
    <tr>
      
      <th scope="col">Name</th>
      <th scope="col">Price</th>
  
    </tr>
  </thead>
    <c:forEach var="fruit" items="${fruits}">
  <tbody>
    <tr>
     
      <td> <c:out value="${fruit.getName()}"></c:out></td>

   <td> <c:out value="${fruit.getPrice()}"></c:out></td>

    
    </tr>
 

  </tbody>
      </c:forEach>
</table>
</div>
</body>
</html>