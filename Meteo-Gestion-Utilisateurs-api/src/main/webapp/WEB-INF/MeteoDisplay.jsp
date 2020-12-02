<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<c:if test="${cityFound == 1}">	
<script>
$(document).ready(function(){
  $("button").click(function(){
	var ville = $( "#ville" ).val();
    $.ajax({url: "http://localhost:8080/Meteo-Gestion-Utilisateurs/api/meteo?ville="+ville, success: function(result){
      $("#div1").html(ville+" "+result);
    }});
  });
});
</script>
</c:if>
<c:if test="${cityFound == 1}">	
<h1>la ville n'existe pas</h1>
</c:if>
<title>Meteo</title>
</head>
<body>
	<h1>${sessionScope.nom }, Découvrir la météo</h1>
	<label>Ville: </label> <input type="text" name="ville" id="ville" " required><br>
	<br> 
	<button> valider</button>
	<div id="div1"></div>
</body>
</html>