<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<span class="support tag open from-rainbow"></span><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><span class="support tag close from-rainbow"></span>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>
    <h1>
    Customer Name : 
    <c:out value="${name}"/>
     <h1>
     <h3>
     Item Name : 
     <c:out value="${itemName }" />
     </h3>
     <h3>
     Price: $
     <c:out value="${price}"/>
     </h3>
     
      <h3>
     Description: 
     <c:out value="${description}"/>
     </h3>

     <h3>
     Vendor: 
     <c:out value="${vendor}"/>
     </h3>
     

</body>
</html>