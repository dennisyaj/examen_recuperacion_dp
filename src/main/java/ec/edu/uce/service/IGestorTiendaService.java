package ec.edu.uce.service;

public interface IGestorTiendaService {
	
	void ingresarBodega(String nombre, String numero, String direccion, String telefono);

	void ingresarProdcuto(String nombre, String codigoBarras, String categoria);

}
