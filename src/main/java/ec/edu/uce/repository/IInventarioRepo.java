package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Inventario;
import ec.edu.uce.modelo.Producto;

public interface IInventarioRepo {
	
	void insertar(Inventario inventario);

	List<Inventario> buscarPorProducto(Producto id);
}
