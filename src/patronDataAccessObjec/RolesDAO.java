package patronDataAccessObjec;

import java.sql.SQLException;
import java.util.List;

import entidad.RolesBean;

public interface RolesDAO {

	public List<RolesBean> listaXid(String idusuario) throws SQLException;
	public List<RolesBean> listarTodos() throws SQLException;
	
	
}
  