package daos;

public class ConstantesSQL {
	
	final static String sqlInsercionCliente = 
				"INSERT INTO tabla_clientes "
				+ "(nombre, domicilio, poblacion,codigo_postal, telefono) "
				+ "VALUES (?,?,?,?,?)";
	
	final static String sqlseleccionCliente = 
				"SELECT * FROM tabla_clientes";
	
	
	final static String sqlInsercionPrenda =
			"INSERT INTO tabla_prendas "
			+ "(articulo, tipo_material, color, detalles, unidades, talla, precio) "
			+ "VALUES (?,?,?,?,?,?,?)";
	
	final static String sqlseleccionPrenda = 
			"SELECT * FROM tabla_prendas";
	

}
