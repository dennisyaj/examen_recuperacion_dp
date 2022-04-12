package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Producto;

public interface IProductoService {
	void insertar(Producto producto);

	void actualizar(Producto producto);

	void borrar(Integer id);

	Producto buscar(Integer id);

	List<Producto> buscarTodos();

	Producto buscarCodigoBarras(String numero);
}
