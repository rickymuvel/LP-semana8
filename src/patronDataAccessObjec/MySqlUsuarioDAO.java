package patronDataAccessObjec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;
import entidad.ProductoBean;
import entidad.UsuarioBean;

public class MySqlUsuarioDAO implements UsuarioDAO {

	
	@Override
		public List<UsuarioBean> listarTodos() throws SQLException {
		ArrayList<UsuarioBean> data = new ArrayList<UsuarioBean>();
		UsuarioBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql = "select * from usuario";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new UsuarioBean();
				bean.setIdusuario(rs.getInt("idusuario"));
				bean.setNombre(rs.getString("nombre"));
				bean.setLogin(rs.getString("login"));
				bean.setCorreo(rs.getString("correo"));
				bean.setClave(rs.getString("clave"));
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
	public List<UsuarioBean> listaXid(String idusuario) throws SQLException {
		ArrayList<UsuarioBean> data = new ArrayList<UsuarioBean>();
		UsuarioBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new ConexionDB().getConexion();
			//String sql = "select * from usuario where idCategoria =?";
			String sql = "select * from usuario where idusuario=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idusuario);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new UsuarioBean();
				bean.setIdusuario(rs.getInt("idusuario"));
				bean.setNombre(rs.getString("nombre"));
				bean.setLogin(rs.getString("login"));
				bean.setCorreo(rs.getString("correo"));
				bean.setClave(rs.getString("clave"));
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
