<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
</head>
<body>
	<h1>Liste des utilisateurs</h1>
	
	<c:forEach var="user" items="${listUsers}">
	<h4>${user.nom} &nbsp; ${user.prenom} </h4>
	</c:forEach>
	<a href="<%=request.getContextPath()%>/meteo/create-user">Nouveau</a>

</body>
</html>