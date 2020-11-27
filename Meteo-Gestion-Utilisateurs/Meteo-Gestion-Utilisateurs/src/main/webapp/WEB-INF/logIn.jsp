<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log in</title>
</head>
<body>
	<h1>Log in</h1>
	<form action="<%= request.getContextPath()%>/meteo/login" method="post">
		<label>Nom : </label> <input type="text" name="nom" required><br>
		<br> <label>Mot de passe :</label> <input type="text" name="mdp" required><br>
		<c:if test="${not empty var1}">
         <h4>${msglog}</h4>
		</c:if>
		<br> <input type="submit" name="add" value="Log In">
		
	</form>
	<a href="<%=request.getContextPath()%>/meteo/create-user">S'inscrire</a>
</body>
</html>