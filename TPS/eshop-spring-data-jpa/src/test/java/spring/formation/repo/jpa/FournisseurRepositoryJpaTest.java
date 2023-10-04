package spring.formation.repo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.formation.config.ApplicationConfig;
import spring.formation.model.Fournisseur;
import spring.formation.repo.IFournisseurRepository;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class FournisseurRepositoryJpaTest {

	@Autowired
	private IFournisseurRepository repoFournisseur;

	@Test
	public void testFindAll() {
		List<Fournisseur> fournisseurs = repoFournisseur.findAll();

		assertNotNull(fournisseurs);
		assertNotEquals(0, fournisseurs.size());
		assertNotEquals(Long.valueOf(0), fournisseurs.get(0).getId());
		assertNotNull(fournisseurs.get(0).getNom());
	}
	
	@Test
	public void testFindAllFournisseurByEmails() {
		Set<String> emails = new HashSet<String>();
		emails.add("toto@gmail.com");
		emails.add("titi@gmail.com");
		
		List<Fournisseur> fournisseurs = repoFournisseur.findAllFournisseurByEmails(emails);

		assertEquals(0, fournisseurs.size());
	}

//	@Test
	public void testFindById() {
		Long fournisseurId = 1L;
		Fournisseur fournisseur = repoFournisseur.findById(fournisseurId).get();

		assertNotNull(fournisseur);
		assertNotNull(fournisseur.getProduits());
		assertNotEquals(0, fournisseur.getProduits().size());
	}

//	@Test
	public void shouldAdd() {
		Fournisseur fournisseur = new Fournisseur();

		fournisseur.setNom("F1");
		fournisseur.setResponsable("RESP");

		fournisseur = repoFournisseur.save(fournisseur);

		assertNotEquals(Long.valueOf(0), fournisseur.getId());
	}

//	@Test
	public void shouldUpdate() {
		// ARRANGE
		Fournisseur fournisseur = new Fournisseur();

		fournisseur.setNom("F1");
		fournisseur.setResponsable("RESP");

		fournisseur = repoFournisseur.save(fournisseur);

		// ACT
		fournisseur = repoFournisseur.findById(fournisseur.getId()).get();

		fournisseur.setNom("F2");
		fournisseur.setResponsable("RESP2");
		fournisseur = repoFournisseur.save(fournisseur);

		// ASSERT
		fournisseur = repoFournisseur.findById(fournisseur.getId()).get();

		assertNotNull(fournisseur);
		assertEquals("F2", fournisseur.getId());
		assertEquals("RESP2", fournisseur.getNom());
	}

//	@Test
	public void testDeleteById() {
		Long fournisseurId = this.getLastId();
		repoFournisseur.deleteById(fournisseurId);

		Optional<Fournisseur> optFournisseur = repoFournisseur.findById(fournisseurId);

		assertNotNull(optFournisseur);
		assertFalse(optFournisseur.isPresent());
	}

	private Long getLastId() {
		List<Fournisseur> fournisseurs = repoFournisseur.findAll();
		return fournisseurs.get(fournisseurs.size() - 1).getId();
	}
}
