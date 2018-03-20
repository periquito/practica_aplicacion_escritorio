package daos;

public class ConstantesSQLR {
	final static String sqlInsercionPrenda = 
			"INSERT INTO tabla_prendas "
				+ "(articulo, tipo_material, color, detalles, unidades, talla, precio) "
				+ "VALUES (?,?,?,?,?,?,?)";

final static String sqlseleccionPrendas = 
			"SELECT * FROM tabla_prendas";

}
