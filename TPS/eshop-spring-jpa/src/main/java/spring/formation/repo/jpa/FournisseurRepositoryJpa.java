package spring.formation.repo.jpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spring.formation.model.Fournisseur;
import spring.formation.repo.IFournisseurRepository;

@Repository
@Transactional(readOnly = true)
public class FournisseurRepositoryJpa implements IFournisseurRepository {

	@PersistenceContext
	private EntityManager em;

	public FournisseurRepositoryJpa() {
	}

	public List<Fournisseur> findAll() {
		return em.createQuery("select f from Fourniseur f", Fournisseur.class).getResultList();
	}

	@Override
	public Optional<Fournisseur> findById(Long id) {
		return Optional.of(em.createQuery("select f from Fournisseur f left join fetch f.produits p where f.id = ?1",
				Fournisseur.class).setParameter(1, id).getSingleResult());
	}

	@Transactional(readOnly = false)
	public Fournisseur save(Fournisseur entity) {
		// INSERT
		if (em.contains(entity)) {
			em.persist(entity);
		}

		else { // UPDATE
			entity = em.merge(entity);
		}

		return entity;
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		em.createQuery("delete from Fournisseur e where e.id = ?1").setParameter(1, id).executeUpdate();
	}

}
