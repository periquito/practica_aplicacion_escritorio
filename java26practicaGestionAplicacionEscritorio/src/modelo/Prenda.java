package modelo;

public class Prenda {
	

	private String articulo;
	private String tipoMaterial;
	private String color;
	private String detalles;
	private String unidades;	
	private String talla;
	private String precio;
	
	public Prenda() {
		
	}

	public Prenda(String articulo, String tipoMaterial, String color,
			String detalles, String unidades,String talla, String precio ) {
		
		super();
		this.articulo = articulo;
		this.tipoMaterial = tipoMaterial;
		this.color = color;
		this.detalles = detalles;
		this.unidades = unidades;
		this.talla = talla;
		this.precio = precio;
		
	}



	public String getArticulo() {
		return articulo;
	}

	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}

	public String getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(String tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getUnidades() {
		return unidades;
	}

	public void setUnidades(String unidades) {
		this.unidades = unidades;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Prenda [articulo=" + articulo + ", tipoMaterial=" + tipoMaterial
						+ ", color=" + color + ", detalles=" + detalles
				+ ", unidades=" + unidades + ", talla=" + talla + ", precio=" + precio + "]";

	}	
}
