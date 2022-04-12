package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.Bodega;
import ec.edu.uce.modelo.InventarioTO;
import ec.edu.uce.modelo.Producto;
import ec.edu.uce.service.IGestorTiendaService;
import ec.edu.uce.service.IProductoService;

@Controller
@RequestMapping("/bodegueros/")
public class BodegaController {

	@Autowired
	private IGestorTiendaService iGestorTiendaService;

	@Autowired
	private IProductoService iProductoService;

////////////1////////
	@GetMapping("insertarBodega")
	public String insertarBodega(Bodega bodega) {
		return "bodega";
	}

	@PostMapping("llenarDatos")
	public String llenarDatos(Bodega bodega, BindingResult result, Model modelo,
			RedirectAttributes redirectAttributes) {
		this.iGestorTiendaService.ingresarBodega(bodega.getNombre(), bodega.getNumero(), bodega.getDireccion(),
				bodega.getTelefono());
		redirectAttributes.addFlashAttribute("mensaje", "bodega Creada");
		return "redirect:/bodegueros/insertarBodega";
	}

////////////////////22
	@GetMapping("insertarProducto")
	public String insertarProducto(Producto producto) {
		return "producto";
	}

	@PostMapping("llenarDatosProducto")
	public String llenarDatosProducto(Producto producto, BindingResult result, Model modelo,
			RedirectAttributes redirectAttributes) {
		this.iGestorTiendaService.ingresarProducto(producto.getNombre(), producto.getCodigoBarras(),
				producto.getCategoria());
		return "redirect:/bodegueros/listaTodosProductos";
	}

	@GetMapping("listaTodosProductos")
	public String listaTodosProductos(Producto producto, Model modelo, RedirectAttributes redirectAttributes) {
		modelo.addAttribute("listaProducto", this.iGestorTiendaService.listaProducto());
		return "listaProductos";
	}

	@DeleteMapping("borrar/{id}")
	public String eliminarProd(@PathVariable("id") Integer id, Model modelo, RedirectAttributes redirectAttributes) {

		boolean valor = this.iGestorTiendaService.borrarProducto(id);
		if (valor) {
			redirectAttributes.addFlashAttribute("mensaje", "producto borrado");
		} else {
			redirectAttributes.addFlashAttribute("mensaje", "producto no borrado");
		}

		return "redirect:/bodegueros/listaTodosProductos";
	}

	///////////////////////////////// 1////////
	@GetMapping("ingresarInventario")
	public String ingresarInventario(InventarioTO inventarioTO) {
		return "inventario";
	}

	@PostMapping("llenarDatosInventario")
	public String llenarDatosInventario(InventarioTO inventarioTO, BindingResult result, Model modelo,
			RedirectAttributes redirectAttributes) {
		this.iGestorTiendaService.inngresarProductoInventario(inventarioTO.getNumeroBodega(),
				inventarioTO.getCodigoBarrasMaestro(), inventarioTO.getCantidad());
		redirectAttributes.addFlashAttribute("mensaje", "");
		return "redirect:/bodegueros/ingresarInventario";
	}
}
