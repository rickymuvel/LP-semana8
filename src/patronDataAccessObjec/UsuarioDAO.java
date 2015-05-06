package patronDataAccessObjec;

import java.sql.SQLException;
import java.util.List;

import entidad.UsuarioBean;

public interface UsuarioDAO {

	public List<UsuarioBean> listaXid(String idusuario) throws SQLException;
	public List<UsuarioBean> listarTodos() throws SQLException;
	
	
}
  