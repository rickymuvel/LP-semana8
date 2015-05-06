package patronDataAccessObjec;


public class MySqlFactory  extends Factory{

	@Override
	public ComboDAO getCombo() {
		return new MySqlComboDAO();
	}

	@Override
	public ProductoDAO getProducto() {
		return new MySqlProductoDAO();
	}

	@Override
	public UsuarioDAO getUsuario() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}
	
	public RolesDAO getRol() {
		// TODO Auto-generated method stub
		return new MySqlRolesDAO();
	}

	
	
}
