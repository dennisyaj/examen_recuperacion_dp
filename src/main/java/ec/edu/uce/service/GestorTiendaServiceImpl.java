package ec.edu.uce.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Bodega;
import ec.edu.uce.modelo.Inventario;
import ec.edu.uce.modelo.Producto;
import ec.edu.uce.repository.IInventarioRepo;

@Service
public class GestorTiendaServiceImpl implements IGestorTiendaService {
	@Autowired
	private IBodegaService iBodegaService;
	@Autowired
	private IProductoService iProductoService;

	@Autowired
	private IInventarioService iInventarioService;

	@Override
	@Transactional
	public void ingresarBodega(String nombre, String numero, String direccion, String telefono) {

		List<String> listaTelefonos = new ArrayList<>();
		String[] campo = telefono.split(",");

		for (int i = 0; i < campo.length; i++) {
			listaTelefonos.add(campo[i]);
		}

		Bodega bodega = new Bodega();
		bodega.setDireccion(direccion);
		bodega.setNumero(numero);
		bodega.setNombre(nombre);
		bodega.setTelefonos(listaTelefonos);

		this.iBodegaService.insertar(bodega);
	}

	@Override
	@Transactional
	public void ingresarProducto(String nombre, String codigoBarras, String categoria) {
		Producto producto = new Producto();
		producto.setCategoria(categoria);
		producto.setCodigoBarras(codigoBarras);
		producto.setNombre(nombre);
		producto.setStock(0);

		this.iProductoService.insertar(producto);

	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Producto> listaProducto() {

		return this.iProductoService.buscarTodos();
	}

	@Override
	@Transactional
	public boolean borrarProducto(Integer id) {

		if (this.iInventarioService.buscarPorProducto(this.iProductoService.buscar(id)).size() > 0) {
			return false;
		} else {
			this.iProductoService.borrar(id);
			return true;
		}

	}

	@Override
	@Transactional
	public void inngresarProductoInventario(String numeroBodega, String codigoBarras, Integer cantidad) {

		Producto producto = this.iProductoService.buscarCodigoBarras(codigoBarras);
		Bodega bodega = this.iBodegaService.buscarNumero(numeroBodega);

		for (int i = 1; i <= cantidad; i++) {

			Inventario inventario = new Inventario();
			inventario.setBodega(bodega);
			inventario.setCodigoBarrasIndividual(codigoBarras + " - " + i);
			inventario.setProducto(producto);
			this.iInventarioService.insertar(inventario);
		}

		producto.setStock(cantidad);
		this.iProductoService.actualizar(producto);
	}

}
