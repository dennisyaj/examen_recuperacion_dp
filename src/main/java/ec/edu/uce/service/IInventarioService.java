package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Inventario;
import ec.edu.uce.modelo.Producto;

public interface IInventarioService {
	
	void insertar(Inventario inventario);
	
	List<Inventario> buscarPorProducto(Producto id);
}
