package spring.formation.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.formation.model.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long> {
	public List<Produit> findByPrixAchatBetween(Double a, Double b);
	
}
