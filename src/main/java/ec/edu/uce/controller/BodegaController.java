package ec.edu.uce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.Bodega;
@Controller
@RequestMapping("/empleados/")
public class BodegaController {

////////////1////////
	@GetMapping("insertarBodega")
	public String insertarBodega(Bodega bodega) {
		return "registrar";
	}

	@PostMapping("llenarDatos")
	public String llenarDatos(Bodega bodega, BindingResult result, Model modelo,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("mensaje", "Reservacion Creada");
		return "redirect:/clientes/registrarse";
	}
}
