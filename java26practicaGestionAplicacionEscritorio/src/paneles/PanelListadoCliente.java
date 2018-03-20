package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tableModel.TableModelClientes;
import modelo.Cliente;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;

public class PanelListadoCliente extends JPanel {
	
	private ClientesDAO daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;
	
	public PanelListadoCliente() {
		// TODO Auto-generated constructor stub
		
		this.add(new JLabel("Soy el panel de listado de cliente"));
	}//end PanelListadoCliente
	
	public void refrescarClientes(){
		
		this.clientes = daoClientes.obtenerClientes();
		JTable tabla = new JTable(new TableModelClientes(clientes));
		//quito todo lo que tuviera antes del panel
		
	
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
        tabla.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tabla);
        this.removeAll();

        //Add the scroll pane to this panel.
        this.add(scrollPane);

		
	}//end refrescarClientes

}//end class
