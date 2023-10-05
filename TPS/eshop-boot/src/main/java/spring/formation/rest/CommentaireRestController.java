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

import spring.formation.model.Commentaire;
import spring.formation.model.Views;
import spring.formation.repo.ICommentaireRepository;

@RestController
@RequestMapping("/api/commentaire")
public class CommentaireRestController {

	@Autowired
	private ICommentaireRepository commentaireRepository;
	
	@GetMapping("")
	@JsonView(Views.ViewCommentaire.class)
	public List<Commentaire> findAll() {
		return commentaireRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCommentaire.class)
	public Commentaire findById(@PathVariable Long id) {
		Optional<Commentaire> optCommentaire = commentaireRepository.findById(id);
		
		if(optCommentaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return optCommentaire.get();
	}
	
	@PostMapping("")
	@JsonView(Views.ViewCommentaire.class)
	public Commentaire create(@RequestBody Commentaire commentaire) {
		commentaire =  commentaireRepository.save(commentaire);
		
		return commentaire;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewCommentaire.class)
	public Commentaire update(@RequestBody Commentaire commentaire, @PathVariable Long id) {
		if(id != commentaire.getId() || !commentaireRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		
		commentaire =  commentaireRepository.save(commentaire);
		
		return commentaire;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if(!commentaireRepository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		commentaireRepository.deleteById(id);
	}
	
}
