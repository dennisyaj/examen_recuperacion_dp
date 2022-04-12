package ec.edu.uce.modelo;

public class InventarioTO {

	private String numeroBodega;

	private String codigoBarrasMaestro;

	private Integer cantidad;

	
	public InventarioTO() {
	}

	public InventarioTO(String numeroBodega, String codigoBarrasMaestro, Integer cantidad) {
		this.numeroBodega = numeroBodega;
		this.codigoBarrasMaestro = codigoBarrasMaestro;
		this.cantidad = cantidad;
	}

	// GETS NAS SETS
	public String getNumeroBodega() {
		return numeroBodega;
	}

	public void setNumeroBodega(String numeroBodega) {
		this.numeroBodega = numeroBodega;
	}

	public String getCodigoBarrasMaestro() {
		return codigoBarrasMaestro;
	}

	public void setCodigoBarrasMaestro(String codigoBarrasMaestro) {
		this.codigoBarrasMaestro = codigoBarrasMaestro;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
