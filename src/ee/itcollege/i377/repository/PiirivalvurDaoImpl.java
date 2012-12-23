package ee.itcollege.i377.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import ee.itcollege.i377.model.Piirivalvur;

@Repository
public class PiirivalvurDaoImpl implements PiirivalvurDao {

	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("piirivalvePersistenceUnit");

	@Override
	public void addPiirivalvur(Piirivalvur piirivalvur) {
		
		//add audit information to entity
		piirivalvur.setAvaja(SecurityContextHolder.getContext().getAuthentication().getName());
		piirivalvur.setAvatud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.persist(piirivalvur);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}

	@Override
	public void updatePiirivalvur(Piirivalvur piirivalvur) {
		
		//add audit information to entity
		piirivalvur.setMuutja(SecurityContextHolder.getContext().getAuthentication().getName());
		piirivalvur.setMuudetud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.merge(piirivalvur);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public void deletePiirivalvurById(Long id) {
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		Piirivalvur piirivalvur = entityManager.createNamedQuery("Piirivalvur.findById", Piirivalvur.class).setParameter("id", id).getSingleResult();
		
		//add audit information to entity
		piirivalvur.setSulgeja(SecurityContextHolder.getContext().getAuthentication().getName());
		piirivalvur.setSuletud(new Date());
				
		// Save the data
		//entityManager.merge(piirivalvur);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public Piirivalvur getPiirivalvurById(Long id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<Piirivalvur> q = em.createNamedQuery("Piirivalvur.findById", Piirivalvur.class).setParameter("id", id);
		    Piirivalvur piirivalvur = q.getSingleResult();
		    return piirivalvur;
		}
		finally {
		    em.close();
		}
	}
	
	@Override
	public List<Piirivalvur> getAllPiirivalvurs() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<Piirivalvur> q = em.createNamedQuery("Piirivalvur.findAll", Piirivalvur.class);
		    List<Piirivalvur> piirivalvur = q.getResultList();
		    return piirivalvur;
		}
		finally {
		    em.close();
		}
	}

}