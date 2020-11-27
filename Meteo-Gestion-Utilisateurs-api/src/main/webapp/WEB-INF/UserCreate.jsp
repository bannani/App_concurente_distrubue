<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("button").click(function(){
	var nom = $( "#nom" ).val();
	var prenom = $( "#prenom" ).val();
	var mdp = $( "#mdp" ).val();
	$.post( "http://localhost:8080/Meteo-Gestion-Utilisateurs/api/users/addUser?prenom="+prenom+"&nom="+nom+"&mdp="+mdp, function( msg ) {
		console.log(msg)
		$("#div1").html( msg );
		});
  });
});
</script>
<title>Create User</title>
</head>
<body>
	<h1>S'inscrire</h1>
		<label>Prenom : </label> <input type="text" id="prenom" name="prenom" required><br>
		<br> <label>Nom : </label> <input type="text" id="nom" name="nom" required><br>
		<br> <label>Mot de passe :</label> <input type="text" id="mdp" name="mdp" required><br>
		<button>creer</button>
		<br>
		<div id="div1" color:green></div>
		<br>
		<a href ="<%= request.getContextPath()%>meteo/user-list">affichier users</a>
	
</body>
</html>