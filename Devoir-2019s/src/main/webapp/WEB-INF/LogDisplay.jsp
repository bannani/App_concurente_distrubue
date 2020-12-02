<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.enseirb.logs.Log" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<title>Logs List</title>
</head>
<body>
	<form action="" method="post">
		<label>Niveau: </label> <input type="text" name="niveau"
			value="${niveau}"><input type="submit" value="search"></form>
			<form action="" method="post">
			<br> <label>Source: </label> <input
			type="text" name="source" value="${source}">
		<input type="submit" value="search">
	</form>
	<h1>Liste des Logs</h1>
	<table>
	<tr>
       <th>Timestamp</th>
       <th>Niveau</th>
       <th>Source</th>
       <th>Message</th>
   </tr>
	<c:forEach var="log" items="${listLogs}">
	<tr>
	<c:if test="${log.vu}">
	<td>${log.timestamp}</td>
    <td>${log.niveau}</td>
    <td>${log.source}</td>
    <td> ${log.message}</td>
	</c:if>
	<c:if test="${! log.vu}">
	
       <td><h2 style="color:Tomato;">${log.timestamp}</h2></td>
       <td><h2 style="color:Tomato;">${log.niveau}</h2></td>
       <td><h2 style="color:Tomato;">${log.source}</h2></td>
       <td><h2 style="color:Tomato;"> ${log.message}</h2></td>
     
	</c:if>      
   </tr>
	</c:forEach>
	</table>
	<a href="<%=request.getContextPath()%>/logs/create-log">Nouveau</a>
	<c:if test="${bloqued == null}">
	<form action="" method="post">
		<input type="submit" value="flush" name="flush">
	</form>
	</c:if>
</body>
</html>