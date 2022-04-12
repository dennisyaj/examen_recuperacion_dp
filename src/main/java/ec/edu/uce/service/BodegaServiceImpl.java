package ec.edu.uce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Bodega;
import ec.edu.uce.repository.IBodegaRepo;
@Service
public class BodegaServiceImpl implements IBodegaService {

	@Autowired
	private IBodegaRepo iBodegaRepo;

	@Override
	@Transactional
	public void insertar(Bodega bodega) {
		this.iBodegaRepo.insertar(bodega);
	}

	@Override
	@Transactional
	public void actualizar(Bodega bodega) {
		this.iBodegaRepo.actualizar(bodega);
	}

	@Override
	@Transactional
	public void borrar(Integer id) {
		this.iBodegaRepo.borrar(id);
	}

	@Override
	public Bodega buscar(Integer id) {
		return this.iBodegaRepo.buscar(id);
	}
	

}
