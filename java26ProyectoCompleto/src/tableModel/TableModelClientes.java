package tableModel;

import java.io.StreamCorruptedException;

import javax.swing.table.AbstractTableModel;

import modelo.Cliente;

public class TableModelClientes extends AbstractTableModel {
	
	private String[] columnas ={
			"nombre","domicilio","poblacion", "codigo postal", "telefono"};
	
	private String[][] datos = null;
	
	
	public TableModelClientes(Cliente[] clientes) {
		//datos va ser tantos arrays de string como clientes tenga que listar 
		//cada uno de esos array debera tener elementos como
		//queramos mostrar por cada columna
		datos = new String[clientes.length] [columnas.length];
		for (int i = 0; i < clientes.length; i++) {
			Cliente c = clientes[i];
			datos[i][0]=c.getNombre();
			datos[i][1]=c.getDomicilio();
			datos[i][2]=c.getPoblacion();
			datos[i][3]=c.getCodigoPostal();
			datos[i][4]=c.getTelefono();			
		}//end for		
	}//end TableModelClientes
	
			

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public Object getValueAt(int indiceFila, int IndiceColumna) {		
		return datos[indiceFila][IndiceColumna];
	}
	
	@Override public String getColumnName(int columnIndex) {
        return columnas[columnIndex];
    }

}//end class
