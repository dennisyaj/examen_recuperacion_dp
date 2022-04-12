package ec.edu.uce.repository;

import ec.edu.uce.modelo.Bodega;

public interface IBodegaRepo {

	void insertar(Bodega bodega);

	void actualizar(Bodega bodega);

	void borrar(Integer id);

	Bodega buscar(Integer id);

	Bodega buscarNumero(String numero);
}
