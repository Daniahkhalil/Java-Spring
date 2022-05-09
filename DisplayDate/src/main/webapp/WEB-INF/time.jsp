<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<span class="support tag open from-rainbow"></span><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><span class="support tag close from-rainbow"></span>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
        	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
    </head>
<body>
<h1> <c:out value="${time }"/></h1>
</body>
</html>