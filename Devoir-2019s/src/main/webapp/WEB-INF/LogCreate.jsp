<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Log</title>
</head>
<body>
	<h1>Nouvelle Log</h1>
	<form action="<%= request.getContextPath()%>/logs/create-log" method="post">
		<label>Niveau : </label> <input type="text" name="niveau" required><br>
		<br> <label>Source : </label> <input type="text" name="source" required><br>
		<br> <label>Message : </label> <input type="text" name="message" required><br>
		<br> <input type="submit" name="add" value="creer">
	</form>
</body>
</html>