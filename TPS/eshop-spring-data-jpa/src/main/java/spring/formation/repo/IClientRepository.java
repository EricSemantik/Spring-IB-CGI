package spring.formation.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.formation.model.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
	Optional<Client> findFirstByNom(String nom);
	
	List<Client> findByNomStartingWith(String nom);
}
