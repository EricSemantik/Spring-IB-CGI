package spring.formation.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import spring.formation.model.Produit;
import spring.formation.model.Views;
import spring.formation.repo.IProduitRepository;

@RestController
public class ProduitRestController {
	@Autowired
	private IProduitRepository produitRepository;

	@GetMapping("/api/produit")
	@JsonView(Views.ViewProduit.class)
	public List<Produit> findAll() {
		return produitRepository.findAll();
	}
	
	@GetMapping("/api/produit/{id}")
	@JsonView(Views.ViewProduitDetail.class)
	public Produit findById(@PathVariable Long id) {
		Optional<Produit> optPropduit = produitRepository.findById(id);
		
		if(optPropduit.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optPropduit.get();
	}
}
