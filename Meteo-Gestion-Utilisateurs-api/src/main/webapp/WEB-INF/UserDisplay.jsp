<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
			$.ajax({url: "http://localhost:8080/Meteo-Gestion-Utilisateurs/api/users/getList", success: function(result){
				var ul = $('<ul>').appendTo('div');
				var data_length = result.length;
				for (var i = 0; i < data_length; i++) {
					ul.append(
							$(document.createElement('li')).text(result[i]["nom"] + " " + result[i]["prenom"])
				    		);
				}
				
				 console.log(result)
				  console.log(ul)
			      
			}});
	  });
	
		</script>
<title>Users List</title>
</head>
<body>
	<h1>Liste des utilisateurs</h1>
	<div></div>
	<a href="<%=request.getContextPath()%>/meteo/create-user">Nouveau</a>
	

</body>
</html>
