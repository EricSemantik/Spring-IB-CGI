package spring.formation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@GetMapping("")
	public String showProduit(@RequestParam Long id, Model model) {
		model.addAttribute("id", id * 2);

		return "produits";
	}

	@GetMapping("/{idProduit}")
	public String showProduitPath(@PathVariable("idProduit") Long id, Model model) {
		model.addAttribute("id", id * 2);

		return "produits";
	}
}
