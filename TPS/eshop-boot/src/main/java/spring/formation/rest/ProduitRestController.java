package spring.formation.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import spring.formation.model.Produit;
import spring.formation.model.Views;
import spring.formation.repo.IProduitRepository;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {
	@Autowired
	private IProduitRepository produitRepository;

	@GetMapping("")
	@JsonView(Views.ViewProduit.class)
	public List<Produit> findAll() {
		return produitRepository.findAllWithFournisseur();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewProduit.class)
	public Produit findById(@PathVariable Long id) {
		Optional<Produit> optPropduit = produitRepository.findById(id);
		
		if(optPropduit.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optPropduit.get();
	}
	
	@GetMapping("/{id}/detail")
	@JsonView(Views.ViewProduitDetail.class)
	public Produit detailById(@PathVariable Long id) {
		Optional<Produit> optPropduit = produitRepository.findById(id);
		
		if(optPropduit.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optPropduit.get();
	}
	
	@PostMapping("")
	@JsonView(Views.ViewProduit.class)
	@PreAuthorize("hasRole('ADMIN')")

	public Produit create(@RequestBody Produit produit) {
		produit =  produitRepository.save(produit);
		
		return produit;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewProduit.class)
	public Produit update(@RequestBody Produit produit, @PathVariable Long id) {
		if(id != produit.getId() || !produitRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		produit =  produitRepository.save(produit);
		
		return produit;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if(!produitRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		produitRepository.deleteById(id);
	}
}
