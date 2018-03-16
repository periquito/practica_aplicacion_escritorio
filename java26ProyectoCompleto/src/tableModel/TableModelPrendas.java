package tableModel;

import java.io.StreamCorruptedException;

import javax.swing.table.AbstractTableModel;

import modelo.Cliente;
import modelo.Prenda;

public class TableModelPrendas extends AbstractTableModel {
	
	private String[] columnas ={
			"articulo","tipo_material","color", "detalles", "unidades", "talla", "precio"};
	
	private String[][] datos = null;
	
	
	public TableModelPrendas(Prenda[] prendas) {
		//datos va ser tantos arrays de string como clientes tenga que listar 
		//cada uno de esos array debera tener elementos como
		//queramos mostrar por cada columna
		
		datos = new String[prendas.length] [columnas.length];
		
		for (int i = 0; i < prendas.length; i++) {
			Prenda c = prendas[i];
			datos[i][0]=c.getArticulo();
			datos[i][1]=c.getTipoMaterial();
			datos[i][2]=c.getColor();
			datos[i][3]=c.getDetalles();
			datos[i][4]=c.getUnidades();	
			datos[i][5]=c.getTalla();
			datos[i][6]=c.getPrecio();
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
