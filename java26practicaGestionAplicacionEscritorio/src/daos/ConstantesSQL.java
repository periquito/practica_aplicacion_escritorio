package daos;

public class ConstantesSQL {
	final static String sqlInsercionCliente = 
			"INSERT INTO tabla_clientes "
			+ "(nombre, domicilio, poblacion,codigo_postal, telefono) "
			+ "VALUES (?,?,?,?,?)";

final static String sqlseleccionCliente = 
			"SELECT * FROM tabla_clientes";


}
