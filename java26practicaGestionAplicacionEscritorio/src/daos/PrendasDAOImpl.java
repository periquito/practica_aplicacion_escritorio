package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			System.out.println("PERFECTO!!! Cliente insertado correctamente");
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
		// TODO Auto-generated method stub
		return null;
	}

}
