package patronDataAccessObjec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;
import entidad.RolesBean;

public class MySqlRolesDAO implements RolesDAO {
	
	@Override
	public List<RolesBean> listarTodos() throws SQLException {
		ArrayList<RolesBean> data = new ArrayList<RolesBean>();
		RolesBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new ConexionDB().getConexion();
			//String sql = "select * from usuario where idCategoria =?";
			String sql = "select * from roles";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new RolesBean();
				bean.setIdrol(rs.getInt("idrol"));
				bean.setDescripcion(rs.getString("descripcion"));
				data.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!= null)rs.close();
				if(pstm!= null)pstm.close();
				if(conn!= null)conn.close();
			} catch (SQLException e) {
			}
		}
		return data;
	}
	

	@Override
	public List<RolesBean> listaXid(String idrol) throws SQLException {
		ArrayList<RolesBean> data = new ArrayList<RolesBean>();
		RolesBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new ConexionDB().getConexion();
			//String sql = "select * from usuario where idCategoria =?";
			String sql = "select * from roles where idrol=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idrol);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new RolesBean();
				bean.setIdrol(rs.getInt("idrol"));
				bean.setDescripcion(rs.getString("descripcion"));
				data.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!= null)rs.close();
				if(pstm!= null)pstm.close();
				if(conn!= null)conn.close();
			} catch (SQLException e) {
			}
		}
		return data;
	}
}
