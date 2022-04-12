package ec.edu.uce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Producto;
import ec.edu.uce.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo iProductoRepo;

	@Override
	@Transactional
	public void insertar(Producto producto) {
		this.iProductoRepo.insertar(producto);
	}

	@Override
	@Transactional
	public void actualizar(Producto producto) {
		this.iProductoRepo.actualizar(producto);
	}

	@Override
	@Transactional
	public void borrar(Integer id) {
		this.iProductoRepo.borrar(id);
	}

	@Override
	public Producto buscar(Integer id) {
		return this.iProductoRepo.buscar(id);
	}
}
