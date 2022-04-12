package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Inventario;

public interface IInventarioRepo {
	
	void insertar(Inventario inventario);

	List<Inventario> buscarPorProducto(String id);
}
