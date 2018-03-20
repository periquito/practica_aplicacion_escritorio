package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import paneles.PanelListadoCliente;
import paneles.PanelRegistroCliente;

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	//Paneles de la ventana
	private PanelRegistroCliente panelRegistroCliente = new PanelRegistroCliente();	
	private PanelListadoCliente panelListadoCliente = new PanelListadoCliente();
	
	//Barra de menu
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuAyuda = new JMenu("Ayuda");

	public VentanaPrincipal() {
		
		//Preparar la barra de menu:		
		JMenuItem clientesInsertar = new JMenuItem("Insertar Cliente");
		JMenuItem clientesListar = new JMenuItem("Listar Clientes");
		menuClientes.add(clientesInsertar);
		menuClientes.add(clientesListar);
		barraDeMenu.add(menuClientes);
		barraDeMenu.add(menuAyuda);
		this.setJMenuBar(barraDeMenu);
		
		//A las opciones de menu, quien las va a tender
		//cuando se las haga un click
		clientesInsertar.addActionListener(this);
		clientesListar.addActionListener(this);
		
		//Preparacion de la ventana principal
		this.setSize(800,600);
		this.setTitle("PROYECTO");
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//vamos a decir que cuando arranque esta ventana 
		//se muestra el panel de registro cliente
		this.setContentPane(panelRegistroCliente);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("atiendo a: " + e.getActionCommand());
		if(e.getActionCommand().equals("Insertar Cliente")){			
			setContentPane(panelRegistroCliente);		
		}else if(e.getActionCommand().equals("Listar Clientes")){		
			setContentPane(panelListadoCliente);
			panelListadoCliente.refrescarClientes();
		}
		SwingUtilities.updateComponentTreeUI(this);		
	}
}
