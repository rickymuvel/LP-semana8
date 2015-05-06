package tags;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import patronDataAccessObjec.ComboDAO;
import patronDataAccessObjec.Factory;
import entidad.ComboBean;

@SuppressWarnings("serial")
public class TagComboDinamico extends TagSupport{
	
	private String nombre, sql;
	
	public int doStartTag() throws JspException {
		//Permite leer archivos properties
		ResourceBundle rb = ResourceBundle.getBundle("tags");
		
		JspWriter out = pageContext.getOut();

		Factory bd = Factory.getTipo(Factory.TIPO_MYSQL);
		ComboDAO  dao = bd.getCombo();
		
		try {
			out.print("<select name='" + nombre + "'>");
			out.print("<option value='-1'>[Todos]</option>");
			
			List<ComboBean>  lista = dao.lista(rb.getString(sql));
				for (ComboBean obj : lista) {
					out.print("<option value='" +obj.getValue()+ "'>");
					out.print(obj.getDescripcion());
					out.print("</option>");
				}
			out.print("</select>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getSql() {
		return sql;
	}




	public void setSql(String sql) {
		this.sql = sql;
	}



}
