package ec.edu.uce.service;

import java.util.List;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.Producto;

public interface IGestorTiendaService {

	void ingresarBodega(String nombre, String numero, String direccion, String telefono);

	void ingresarProdcuto(String nombre, String codigoBarras, String categoria);

	List<Producto> listaProducto();

	boolean borrarProducto(Integer id);

	void inngresarProductoInventario(String numeroBodega, String codigoBarras, Integer cantidad);

}
