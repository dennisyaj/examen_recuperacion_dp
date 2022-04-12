package ec.edu.uce.service;

import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Bodega;

@Service
public interface IBodegaService {

	void insertar(Bodega bodega);

	void actualizar(Bodega bodega);

	void borrar(Integer id);

	Bodega buscar(Integer id);

	Bodega buscarNumero(String numero);
}
