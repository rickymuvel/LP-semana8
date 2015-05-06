package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagCombo extends TagSupport {
	private String elementos;
	private String nombre;
	
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		String[] separados = elementos.split(",");
		
		try {
			out.print("<select name='"+ nombre +"'>");
			for (int i = 0; i < separados.length; i++) {
				out.print("<option>");
				out.print(separados[i]);
				out.print("</option>");
			}
			out.print("</select>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public String getElementos() {
		return elementos;
	}

	public void setElementos(String elementos) {
		this.elementos = elementos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
