<%@page import="entidad.RolesBean"%>
<%@page import="entidad.ProductoBean"%>
<%@page import="java.util.List"%>
<%@ taglib uri="misLibrerias" prefix="lp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simulacro</title>
</head>
<body>

<h1>Productos por Categoría</h1>
<form action="consultaRol">
	Usuario <lp:cboDinamico sql="SQL_USUARIO" nombre="cboUsuario"/>
	<input type="submit" value="Filtrar" />
</form>
<table>
<%
	List<RolesBean> data = (List<RolesBean>) request.getAttribute("roles");
	if(data!=null){
		for(RolesBean b:data){
%>
<tr>
	<td><%= b.getIdrol() %></td>
	<td><%= b.getDescripcion() %></td>
</tr>
<%
		}
	}
%>
</table>
</body>
</html>