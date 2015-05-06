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
<form action="consultaProducto">
	Categoria <lp:cboDinamico sql="SQL_CATEGORIA" nombre="cboCat"/>
	<input type="submit" value="Filtrar" />
</form>
<table>
<%
	List<ProductoBean> data = (List<ProductoBean>) request.getAttribute("productos");
	if(data!=null){
		for(ProductoBean b:data){
%>
<tr>
	<td><%= b.getCodigo() %></td>
	<td><%= b.getNombre() %></td>
	<td><%= b.getMarca() %></td>
</tr>
<%
		}
	}
%>
</table>
</body>
</html>




