package ec.edu.uce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Inventario;
import ec.edu.uce.repository.IInventarioRepo;

@Service
public class InventarioServiceImpl implements IInventarioService {

	@Autowired
	private IInventarioRepo iInventarioRepo;

	@Override
	@Transactional
	@Async
	public void insertar(Inventario inventario) {

		inventario.setNombreHilo("Hilo:" + Thread.currentThread().getName());
		this.iInventarioRepo.insertar(inventario);
	}

}
