<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<span class="support tag open from-rainbow"></span><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><span class="support tag close from-rainbow"></span>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
        	<link rel="stylesheet" type="text/css" href="/css/style.css">
    </head>
<body>
  <h2> You visit this site <a href="/yourserver">http://localhost:9090/yourserver</a>  <c:out value="${countToShow+1}"/></h2>
<a href="/yourserver">Test Another visit</a>
</body>
</html>