<!--  
	Importación de la librería
 	con la directiva taglib
 	
 	misLibrerias es el Alias de la librería ubicada en taglib.tld
 	lp: es un prefijo (es cualquier nombre)
 		con el prefijo accedemos a las etiquetas que hemos creado
 -->

<%@ taglib uri="misLibrerias" prefix="lp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<lp:combo elementos="U,SC,...,AL" nombre="equipos"/><br>
<lp:combo elementos="Java,.Net,PHP,Nodejs,Javascript" nombre="lenguajesLP"/><br>

<lp:radio elementos="uno,dos,tres,cuatro" nombre="numeros"/>

</body>
</html>


