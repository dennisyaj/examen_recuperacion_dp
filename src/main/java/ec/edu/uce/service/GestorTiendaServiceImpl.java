package ec.edu.uce.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Bodega;
import ec.edu.uce.modelo.Producto;

@Service
public class GestorTiendaServiceImpl implements IGestorTiendaService {
	@Autowired
	private IBodegaService iBodegaService;
	@Autowired
	private IProductoService iProductoService;

	@Override
	@Transactional
	public void ingresarBodega(String nombre, String numero, String direccion, String telefono) {

		Bodega bodega = new Bodega();
		bodega.setDireccion(direccion);
		bodega.setNumero(numero);
		bodega.setNombre(nombre);
		List<String> listaTelefonos = new ArrayList<>();
		listaTelefonos.add(telefono);
		bodega.setTelefonos(listaTelefonos);

		this.iBodegaService.insertar(bodega);
	}

	@Override
	@Transactional
	public void ingresarProdcuto(String nombre, String codigoBarras, String categoria) {
		Producto producto = new Producto();
		producto.setCategoria(categoria);
		producto.setCodigoBarras(codigoBarras);
		producto.setNombre(nombre);
		producto.setStock(0);

		this.iProductoService.insertar(producto);
		
	}

}
