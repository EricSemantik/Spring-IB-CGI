package spring.formation.repo.jpa;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.formation.config.ApplicationConfig;
import spring.formation.model.Client;
import spring.formation.model.Commentaire;
import spring.formation.model.Fournisseur;
import spring.formation.model.Produit;
import spring.formation.repo.IClientRepository;
import spring.formation.repo.ICommentaireRepository;
import spring.formation.repo.IFournisseurRepository;
import spring.formation.repo.IProduitRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class PopulateTest {
	@Autowired
	private IClientRepository repoClient;
	@Autowired
	private ICommentaireRepository repoCommentaire;
	@Autowired
	private IFournisseurRepository repoFournisseur;
	@Autowired
	private IProduitRepository repoProduit;

	@Test
	public void populate() {
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setNom("F1");
		fournisseur.setResponsable("RESP");

		fournisseur = repoFournisseur.save(fournisseur);

		Produit produit = new Produit("NEW");
		produit.setPrixAchat(10d);
		produit.setPrixVente(100d);
		produit.setFournisseur(fournisseur);
		produit.setModele("MOD");
		produit.setReference("REF");

		produit = repoProduit.save(produit);
		
		Client client = new Client();
		client.setNom("SULTAN");
		client.setPrenom("Eric");
		client.setAdresse("eric@gmail.com");
		
		client = repoClient.save(client);
		
		Commentaire comment = new Commentaire(new Date(), 15, "Bon Produit", produit, client);
		
		comment = repoCommentaire.save(comment);
	}
}
