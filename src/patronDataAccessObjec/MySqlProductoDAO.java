package patronDataAccessObjec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConexionDB;
import entidad.ProductoBean;

public class MySqlProductoDAO implements ProductoDAO {

	@Override
	public List<ProductoBean> listaXCategoria(String idCategoria)	throws SQLException {
		
		ArrayList<ProductoBean> data = new ArrayList<ProductoBean>();
		ProductoBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql = "select * from producto where idCategoria =?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idCategoria);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new ProductoBean();
				bean.setCodigo(rs.getInt("idproducto"));
				bean.setNombre(rs.getString("nombre"));
				bean.setMarca(rs.getString("marca"));
				bean.setPrecio(rs.getDouble("precio"));
				bean.setStock(rs.getInt("stock"));
				bean.setIdCategoria(rs.getInt("idcategoria"));
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
	public List<ProductoBean> listarTodos() throws SQLException {
		ArrayList<ProductoBean> data = new ArrayList<ProductoBean>();
		ProductoBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs  = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql = "select * from producto";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				bean = new ProductoBean();
				bean.setCodigo(rs.getInt("idproducto"));
				bean.setNombre(rs.getString("nombre"));
				bean.setMarca(rs.getString("marca"));
				bean.setPrecio(rs.getDouble("precio"));
				bean.setStock(rs.getInt("stock"));
				bean.setIdCategoria(rs.getInt("idcategoria"));
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
