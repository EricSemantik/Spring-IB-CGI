package spring.formation.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import spring.formation.model.Fournisseur;
import spring.formation.model.Views;
import spring.formation.repo.IFournisseurRepository;

@RestController
@RequestMapping("/api/fournisseur")
public class FournisseurRestController {
	@Autowired
	private IFournisseurRepository fournisseurRepository;

	@GetMapping("")
	@JsonView(Views.ViewFournisseur.class)
	public List<Fournisseur> findAll() {
		return fournisseurRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur findById(@PathVariable Long id) {
		Optional<Fournisseur> optPropduit = fournisseurRepository.findById(id);
		
		if(optPropduit.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optPropduit.get();
	}
	
	@PostMapping("")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur create(@RequestBody Fournisseur fournisseur) {
		fournisseur =  fournisseurRepository.save(fournisseur);
		
		return fournisseur;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewFournisseur.class)
	public Fournisseur update(@RequestBody Fournisseur fournisseur, @PathVariable Long id) {
		if(id != fournisseur.getId() || !fournisseurRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		fournisseur =  fournisseurRepository.save(fournisseur);
		
		return fournisseur;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if(!fournisseurRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		fournisseurRepository.deleteById(id);
	}
}
