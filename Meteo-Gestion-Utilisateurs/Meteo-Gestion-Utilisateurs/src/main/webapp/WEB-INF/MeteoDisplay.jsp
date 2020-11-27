<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meteo</title>
</head>
<body>
	<h1>${sessionScope.nom }, Découvrir la météo</h1>
	<form action="<%= request.getContextPath()%>/meteo" method="post">
		<label>Ville: </label> <input type="text" name="ville" value="${ville}" required><br>
		

		<br> <input type="submit" value="valider">
	</form>
	<c:if test="${meteo != null}">
	<h3>la météo de la ville ${ville} est ${meteo}</h3>
	<h1>access Number =${sessionScope.accessNumber }</h1>
	</c:if>
</body>
</html>