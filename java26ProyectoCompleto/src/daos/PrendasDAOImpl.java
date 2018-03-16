package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Prenda;

public class PrendasDAOImpl implements PrendasDAO {
	
	private Connection miConexion = null;
	
	public PrendasDAOImpl(){
		
		//preparao driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection(
										"jdbc:mysql://localhost:3306/practica_escritorio", "root", "jeveris");
			
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR!! no encuentro el driver-libreria de MySql");
		} catch (SQLException e) {
			System.out.println("ERROR!! de conexion o ERROR!! la SQL esta mal");
		}	
	}
	@Override
	public void registrarPrenda(Prenda c) {
		
		String sqlInsercionPrenda = "INSERT INTO tabla_prendas "
				+ "(articulo, tipo_material, color, detalles, unidades, talla, precio) "
				+ "VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(sqlInsercionPrenda);
			ps.setString(1,c.getArticulo());
			ps.setString(2,c.getTipoMaterial());
			ps.setString(3,c.getColor());
			ps.setString(4,c.getDetalles());
			ps.setString(5,c.getUnidades());
			ps.setString(6,c.getTalla());
			ps.setString(7,c.getPrecio());
			
			ps.execute();
			ps.close();
			System.out.println("PERFECTO!!! Prenda insertado correctamente");
		} catch (SQLException e) {
			System.out.println("ERROR!!! fallo en la SQL");
			
			System.out.println(e.getMessage());
		}		
	}
	@Override
	public void borrarPrenda(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Prenda[] obtenerPrendas() {
		Prenda[] prendas = null;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlseleccionPrenda);

			// Para SQL tipo select debo usar el metodo executeQuery
			ResultSet resultado = ps.executeQuery();

			List<Prenda> listPrendas = new ArrayList<Prenda>();
			while (resultado.next()) {
				// next pasa al siguiente resultado de la base de datos que
				// aun no hemos procesado, si no hay ningun resultado mas
				// devuelve false
				Prenda c = new Prenda();
				c.setArticulo(resultado.getString("articulo"));
				c.setTipoMaterial(resultado.getString("tipo_material"));
				c.setColor(resultado.getString("color"));
				c.setDetalles(resultado.getString("detalles"));
				c.setUnidades(resultado.getString("unidades"));
				c.setTalla(resultado.getString("talla"));
				c.setPrecio(resultado.getString("precio"));

				listPrendas.add(c);
			}
			// transformar de list a array
			prendas = listPrendas.toArray(new Prenda[listPrendas.size()]);
		} catch (SQLException e) {
			System.out.println("ERROR!!! en la SQL de la seleccion clientes");
		}
		return prendas;
	}//end obtener cliente

}
