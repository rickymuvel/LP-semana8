package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagRadio extends TagSupport {
	private String elementos;
	private String nombre;
	
	@Override
	public int doStartTag() throws JspException {
		
		JspWriter out = pageContext.getOut();
		
		String[] separados = elementos.split(",");
		
		try {
			out.print("<input type='radio' name='"+ nombre +"'>");
			for (int i = 0; i < separados.length; i++) {
				out.print(separados[i]);
				out.print("<br>");
			}
			
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
