package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Inventario;
import ec.edu.uce.modelo.Producto;

@Transactional
@Repository
public class InventarioRepoImpl implements IInventarioRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Inventario inventario) {
		this.entityManager.persist(inventario);

	}

	@Override
	public List<Inventario> buscarPorProducto(Producto id) {
		TypedQuery<Inventario> myQuery = this.entityManager
				.createQuery("SELECT a FROM Inventario a WHERE a.producto=:id", Inventario.class);
		myQuery.setParameter("id", id);
		return myQuery.getResultList();
	}

}
