package spring.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring.formation.model.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long> {
	List<Produit> findByPrixAchatBetween(Double a, Double b);
	
	@Query("select p from Produit p where p.stock > 5")
	List<Produit> findAllProduitWithStock5();
}
