<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Expense Name</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="expense" items="${expenses}">
    <tr>
      <th scope="row">1</th>
      <td><c:out value="expense.getName()"/></td>
      <td><c:out value="expense.getVendor()"/></td>
      <td><c:out value="expense.getAmount()"/></td>
      <td><a>Edit</a></td>
      <td>Delete</td>
    </tr>
        </c:forEach>


  </tbody>
</table>

<div>
<h1>Add Expense</h1>
				<form:form action="/expenses/new" method="post" modelAttribute="expense">
					<div class="form-floating my-3">
					  <form:input path="name" class="form-control" name = "expense" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="name" for="floatingInput">Expense Name</form:label>
						<form:errors path="name" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="vendor" type="text" class="form-control" name = "vendor" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="vendor" for="floatingInput">Vendor</form:label>
						<form:errors path="vendor" class = "my-3"  style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="amount" type="number" class="form-control" name = "amount" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="amount" for="floatingInput">Amount</form:label>
					<form:errors path="amount" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating mb-4">
					  <form:textarea path="description" class="form-control" placeholder="Leave a comment here" name = "amount" id="floatingTextarea2" style="height: 100px"></form:textarea>
					  <form:label path="description" for="floatingTextarea2">Description</form:label>
					<form:errors path="description" class = "my-3" style="color: red;"/>
					</div>
					<button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
				</form:form>

</div>
</body>
</html>