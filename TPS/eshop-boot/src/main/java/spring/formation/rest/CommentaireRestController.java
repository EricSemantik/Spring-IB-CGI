package spring.formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import spring.formation.model.Commentaire;
import spring.formation.model.Views;
import spring.formation.repo.ICommentaireRepository;

@RestController
public class CommentaireRestController {

	@Autowired
	private ICommentaireRepository commentaireRepository;
	
	@GetMapping("/api/commentaire")
	@JsonView(Views.ViewCommentaire.class)
	public List<Commentaire> findAll() {
		return commentaireRepository.findAll();
	}
	
}
