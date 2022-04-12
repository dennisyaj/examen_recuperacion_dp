package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Producto;

@Transactional
@Repository
public class ProductoRepoImpl implements IProductoRepo {


	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto producto) {
		this.entityManager.persist(producto);

	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);

	}

	@Override
	public void borrar(Integer id) {
		this.entityManager.remove(this.buscar(id));

	}

	@Override
	public Producto buscar(Integer id) {
		return this.entityManager.find(Producto.class, id);
	}
	

}
