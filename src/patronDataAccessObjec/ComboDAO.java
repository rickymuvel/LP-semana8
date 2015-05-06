package patronDataAccessObjec;

import java.util.ArrayList;

import entidad.ComboBean;

public interface ComboDAO {

	public ArrayList<ComboBean> lista (String sql) throws Exception;
	
}
