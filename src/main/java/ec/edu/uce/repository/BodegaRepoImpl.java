package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Bodega;

@Transactional
@Repository

public class BodegaRepoImpl implements IBodegaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Bodega bodega) {
		this.entityManager.persist(bodega);

	}

	@Override
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub

	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Bodega buscar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bodega buscarNumero(String numero) {
		TypedQuery<Bodega> myQuery = this.entityManager
				.createQuery("SELECT b FROM Bodega b WHERE b.numero=:numero", Bodega.class);
		myQuery.setParameter("numero", numero);

		return myQuery.getSingleResult();
	}

}
