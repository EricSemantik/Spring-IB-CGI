package spring.formation.web;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import spring.formation.model.Commentaire;
import spring.formation.repo.ICommentaireRepository;
import spring.formation.web.validator.CommentaireValidator;

@Controller
public class CommentaireController {

	private ICommentaireRepository commentaireRepo;

	public CommentaireController(ICommentaireRepository commentaireRepo) {
		super();
		this.commentaireRepo = commentaireRepo;
	}

	@GetMapping("/commentaire") // ETAPE 1 : Réception de la Request
	public String list(Model model) {
		List<Commentaire> commentaires = commentaireRepo.findAll(); // ETAPE 2 : Récupération des données
		
		model.addAttribute("mesCommentaires", commentaires); // ETAPE 3 : On renseigne le Model

		return "commentaire/list"; // ETAPE 4 : Appel de la View
	}
	
	@GetMapping("/commentaire/add")
	public String add(Model model) {
		model.addAttribute("commentaire", new Commentaire());
		
		return "commentaire/form";
	}
	
	@GetMapping("/commentaire/edit")
	public String edit(@RequestParam Long id, Model model) {
		Optional<Commentaire> optCommentaire = commentaireRepo.findById(id);
		
		if(optCommentaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id inexistant");
		}
		
		model.addAttribute("commentaire", optCommentaire.get());
		
		return "commentaire/form";
	}
	
	@PostMapping("/commentaire/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date date, @RequestParam(defaultValue = "0") int note, @RequestParam String commentaire) {
		Commentaire comment = null;
		
		if(id != null) {
			comment = commentaireRepo.findById(id).get();
		} else {
			comment = new Commentaire();
		}
		
		comment.setDate(date);
		comment.setNote(note);
		comment.setCommentaire(commentaire);
		
		comment = commentaireRepo.save(comment);
		
		
		return "redirect:/commentaire";
	}
	
	@PostMapping("/commentaire/saveBis")
	public String saveBis(@ModelAttribute("commentaire") @Valid Commentaire commentaire, BindingResult result) {
		new CommentaireValidator().validate(commentaire, result);
		
		if(result.hasErrors()) {
			return "commentaire/form";
		}
		
		commentaire = commentaireRepo.save(commentaire);
		
		return "redirect:/commentaire";
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "forward:/commentaire";
	}
	
	@GetMapping("/commentaire/delete/{id}")
	public String delete(@PathVariable Long id) {
		commentaireRepo.deleteById(id);
		
		return "redirect:/commentaire";
	}

}
