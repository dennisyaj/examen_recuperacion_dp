package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
