package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.runtime.ListAdapter;
import patronDataAccessObjec.Factory;
import patronDataAccessObjec.ProductoDAO;
import patronDataAccessObjec.UsuarioDAO;
import entidad.ProductoBean;
import entidad.UsuarioBean;

public class ServletConsultaRol  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idusuario = request.getParameter("cboUsuario");
		Factory subFabrica = Factory.getTipo(Factory.TIPO_MYSQL);
		UsuarioDAO dao = subFabrica.getUsuario(); 
 //		ProductoDAO dao = subFabrica.getProducto();
		try {
			List<UsuarioBean> data = null;
			if(idusuario.equals("-1")){
				data = dao.listarTodos();
			}else{
				data = dao.listaXid(idusuario);
			}
			
			request.setAttribute("roles", data);
			request.getRequestDispatcher("/roles.jsp").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
