package patronDataAccessObjec;

import java.sql.SQLException;
import java.util.List;

import entidad.ProductoBean;

public interface ProductoDAO {

	public List<ProductoBean> listaXCategoria(String idCategoria) throws SQLException;
	public List<ProductoBean> listarTodos() throws SQLException;
	
	
}
  