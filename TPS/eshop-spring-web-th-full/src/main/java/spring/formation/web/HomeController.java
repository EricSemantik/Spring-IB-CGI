package spring.formation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

//	@RequestMapping(path = {"/", "/accueil"}, method = RequestMethod.GET)
	@GetMapping({"/", "/accueil"})
	public String accueil(Model model, @RequestParam(required = false) String username) {
		
		model.addAttribute("utilisateur",username);
		
		
		
		return "home";
	}
	
	
}
