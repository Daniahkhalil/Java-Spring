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
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    </head>
<body>
   <label>Your Gold :</label>
        <input type="text" name='number'><br><br>
        <div class="d-flex flex-row bd-highlight mb-3">
        
      <div class="p-2 bd-highlight">
        
  <form action='/Gold' method='post'>
        <h2>Farm</h2>
        <p>(earns 10-20 gold)</p>
        <input type="submit" name='find'><br><br>
        
        </div>
        
    <div class="p-2 bd-highlight">
        
  <form action='/Gold' method='post'>
        <h2>Cave</h2>
        <p>(earns 10-20 gold)</p>
        <input type="submit" name='find'><br><br>
        
        </div>
        
      <div class="p-2 bd-highlight">
        
  <form action='/Gold' method='post'>
        <h2>House</h2>
        <p>(earns 10-20 gold)</p>
        <input type="submit" name='find'><br><br>
        
        </div>
        
              <div class="p-2 bd-highlight">
        
  <form action='/Gold' method='post'>
        <h2>Quest</h2>
        <p>(earns 10-20 gold)</p>
        <input type="submit" name='find'><br><br>
        
        </div>
   
    </div>
    
    <h3>Activities :</h3>
    <input type="text" name="activities" id="activities">



</body>