package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tableModel.TableModelClientes;
import tableModel.TableModelPrendas;
import modelo.Cliente;
import modelo.Prenda;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import daos.PrendasDAO;
import daos.PrendasDAOImpl;

public class PanelListadoPrenda extends JPanel {
	
	private PrendasDAO daoPrendas = new PrendasDAOImpl();
	private Prenda[] prendas;
	
	public PanelListadoPrenda() {
		// TODO Auto-generated constructor stub
		
		this.add(new JLabel("Soy el panel de listado de prenda"));
	}//end PanelListadoCliente
	
	public void refrescarPrendas(){
		
		this.prendas = daoPrendas.obtenerPrendas();
		JTable tabla = new JTable(new TableModelPrendas(prendas));
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
