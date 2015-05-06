package patronDataAccessObjec;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.ConexionDB;
import entidad.ComboBean;

public class MySqlComboDAO implements ComboDAO{

	public ArrayList<ComboBean> lista(String sql) throws Exception {
		
		ArrayList<ComboBean> lista = new ArrayList<ComboBean>();
		ComboBean bean = null;
		System.out.println("SENTENCIA SQL : " + sql);	
		Connection conn = null;
		try {
			conn = new ConexionDB().getConexion();
			Statement pstm = conn.createStatement();
			ResultSet rst = pstm.executeQuery(sql);
			while (rst.next()) {
				bean = new ComboBean();
				bean.setValue(rst.getString(1));
				bean.setDescripcion(rst.getString(2));
				lista.add(bean);
			}
			rst.close();
			pstm.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return lista;
	}
	

}
