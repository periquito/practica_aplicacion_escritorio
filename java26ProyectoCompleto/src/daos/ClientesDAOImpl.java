package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.Main;
import modelo.Cliente;

public class ClientesDAOImpl implements ClientesDAO {

	private Connection miConexion = null;

	public ClientesDAOImpl() {
		// preparao driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/practica_escritorio", "root",
					"jeveris");

		} catch (ClassNotFoundException e) {
			System.out
					.println("ERROR!! no encuentro el driver-libreria de MySql");
		} catch (SQLException e) {
			System.out.println("ERROR!! de conexion o ERROR!! la SQL esta mal");
		}
	}

	@Override
	public void registrarCliente(Cliente c) {

		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionCliente);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPoblacion());
			ps.setString(4, c.getCodigoPostal());
			ps.setString(5, c.getTelefono());

			ps.execute();
			ps.close();
			System.out.println("PERFECTO!!! Cliente insertado correctamente");
		} catch (SQLException e) {
			System.out.println("ERROR!!! fallo en la SQL");
		}
	}

	@Override
	public void borrarCliente(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Cliente[] obtenerClientes() {

		Cliente[] clientes = null;
		try {
			PreparedStatement ps = miConexion
					.prepareStatement(ConstantesSQL.sqlseleccionCliente);

			// Para SQL tipo select debo usar el metodo executeQuery
			ResultSet resultado = ps.executeQuery();

			List<Cliente> listClientes = new ArrayList<Cliente>();
			while (resultado.next()) {
				// next pasa al siguiente resultado de la base de datos que
				// aun no hemos procesado, si no hay ningun resultado mas
				// devuelve false
				Cliente c = new Cliente();
				c.setNombre(resultado.getString("nombre"));
				c.setDomicilio(resultado.getString("domicilio"));
				c.setCodigoPostal(resultado.getString("codigo_postal"));
				c.setPoblacion(resultado.getString("poblacion"));
				c.setTelefono(resultado.getString("telefono"));

				listClientes.add(c);
			}
			// transformar de list a array
			clientes = listClientes.toArray(new Cliente[listClientes.size()]);
		} catch (SQLException e) {
			System.out.println("ERROR!!! en la SQL de la seleccion clientes");
		}
		return clientes;
	}//end obtener cliente


	
}//end class
