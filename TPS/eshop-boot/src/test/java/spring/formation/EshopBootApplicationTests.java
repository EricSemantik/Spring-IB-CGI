package spring.formation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import spring.formation.model.Utilisateur;
import spring.formation.repo.IUtilisateurRepository;

@SpringBootTest
class EshopBootApplicationTests {

	@Autowired
	private IUtilisateurRepository utilisateurRepository;
	
	@Test
	void contextLoads() {
		Utilisateur thibaut = new Utilisateur("thibaut", "123456", true);
		
		thibaut = utilisateurRepository.save(thibaut);
		
		Utilisateur sarah = new Utilisateur("sarah", "123456", false);
		
		sarah = utilisateurRepository.save(sarah);
		
		Utilisateur youssef = new Utilisateur("youssef", "123456", false);
		
		youssef = utilisateurRepository.save(youssef);
	}

}
