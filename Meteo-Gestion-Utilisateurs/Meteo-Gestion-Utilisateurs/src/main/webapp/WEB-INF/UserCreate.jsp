<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
</head>
<body>
	<h1>S'inscrire</h1>
	<form action="<%= request.getContextPath()%>/meteo/create-user" method="post">
		<label>Prenom : </label> <input type="text" name="prenom" required><br>
		<br> <label>Nom : </label> <input type="text" name="nom" required><br>
		<br> <label>Mot de passe :</label> <input type="text" name="mdp" required><br>
		<br> <input type="submit" name="add" value="creer">
	</form>
</body>
</html>