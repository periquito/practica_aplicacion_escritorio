package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import daos.PrendasDAOImpl;
import modelo.Cliente;
import modelo.Prenda;

public class PanelRegistroPrenda extends JPanel implements ActionListener {

	JTextField campoTipoMaterial = new JTextField(15);
	JTextField campoArticulo = new JTextField(15);
	JTextField campoColor = new JTextField(15);
	JTextField campoDetalles = new JTextField(15);
	JTextField campoUnidades = new JTextField(15);
	JTextField campoTalla = new JTextField(15);
	JTextField campoPrecio = new JTextField(15);

	public PanelRegistroPrenda() {

		// Asi asigno un gestor de diseño que me permite
		// colocar las cosas en forma dde filas y celdas
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		// Primer Fila:
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(new JLabel("INTRODUCE LOS DATOS LA PRENDA"), gbc);
		// vuelvo a decir que cada componente solo ocupe un elemento:
		gbc.gridwidth = 1;
		// Segunda Fila:
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("articulo: "), gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoArticulo, gbc);
		// tercera fila
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("tipo de material: "), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoTipoMaterial, gbc);
		// cuarta fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("color: "), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoColor, gbc);
		// quinta fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("detalles: "), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoDetalles, gbc);
		// sexta fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("unidades: "), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoUnidades, gbc);
		// septima fila
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("talla: "), gbc);
		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoTalla, gbc);
		// octavo fila
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("precio: "), gbc);
		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoPrecio, gbc);

		// Noveno fila
		JButton botonRegistroPrenda = new JButton("REGISTAR PRENDA");
		botonRegistroPrenda.addActionListener(this);
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroPrenda, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("ActionPerformed del PanelRegistroPrenda");
		String articulo = campoArticulo.getText();
		String tipoMaterial = campoTipoMaterial.getText();
		String color = campoColor.getText();
		String detalles = campoDetalles.getText();
		String unidades = campoUnidades.getText();
		String talla = campoTalla.getText();
		String precio = campoPrecio.getText();
		
		
		//Validaciones ahora habria que validar estos datos
		//...TODO
		//una vez validados todos los datos registramos en base de datos
		Prenda prendaAregistar = new Prenda(articulo, tipoMaterial, color, detalles, unidades, talla, precio);
		
		System.out.println("voy a registrar: " + prendaAregistar.toString());
		//Invoco a lo necesario de la capa de datos, para registrar el cliente
		//en base de datos
		PrendasDAOImpl prendasDAO = new PrendasDAOImpl();
		prendasDAO.registrarPrenda(prendaAregistar);

	}
}