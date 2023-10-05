package spring.formation.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import spring.formation.model.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Long> {
	List<Commande> findAllGreaterThanPrixTotal(@Param("prix") double prix);
	
	@Query("select c from Commande c where c.date between ?1 and ?2")
	List<Commande> findAllBetweenDate(Date dtDebut, Date dtFin);
}
