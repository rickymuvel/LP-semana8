package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patronDataAccessObjec.Factory;
import patronDataAccessObjec.ProductoDAO;
import entidad.ProductoBean;


public class ServletConsultaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String categoria = request.getParameter("cboCategoria");
		
		
	}

}
