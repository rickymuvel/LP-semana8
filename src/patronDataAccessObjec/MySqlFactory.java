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

	
	
}
