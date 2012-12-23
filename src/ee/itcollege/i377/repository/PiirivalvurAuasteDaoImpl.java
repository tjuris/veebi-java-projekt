package ee.itcollege.i377.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import ee.itcollege.i377.model.PiirivalvurAuaste;

@Repository
public class PiirivalvurAuasteDaoImpl implements PiirivalvurAuasteDao {

	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("piirivalvePersistenceUnit");

	@Override
	public void addPiirivalvurAuaste(PiirivalvurAuaste piirivalvurAuaste) {
		
		//add audit information to entity
		piirivalvurAuaste.setAvaja(SecurityContextHolder.getContext().getAuthentication().getName());
		piirivalvurAuaste.setAvatud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.persist(piirivalvurAuaste);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}

	@Override
	public void updatePiirivalvurAuaste(PiirivalvurAuaste piirivalvurAuaste) {
		
		//add audit information to entity
		piirivalvurAuaste.setMuutja(SecurityContextHolder.getContext().getAuthentication().getName());
		piirivalvurAuaste.setMuudetud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.merge(piirivalvurAuaste);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public void deletePiirivalvurAuasteById(Long id) {
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		PiirivalvurAuaste piirivalvurAuaste = entityManager.createNamedQuery("PiirivalvurAuaste.findById", PiirivalvurAuaste.class).setParameter("id", id).getSingleResult();
		
		//add audit information to entity
		piirivalvurAuaste.setSulgeja(SecurityContextHolder.getContext().getAuthentication().getName());
		piirivalvurAuaste.setSuletud(new Date());
				
		// Save the data
		//entityManager.merge(piirivalvurAuaste);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public PiirivalvurAuaste getPiirivalvurAuasteById(Long id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<PiirivalvurAuaste> q = em.createNamedQuery("PiirivalvurAuaste.findById", PiirivalvurAuaste.class).setParameter("id", id);
		    PiirivalvurAuaste piirivalvurAuaste = q.getSingleResult();
		    return piirivalvurAuaste;
		}
		finally {
		    em.close();
		}
	}
	
	@Override
	public List<PiirivalvurAuaste> getAllPiirivalvurAuastes() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<PiirivalvurAuaste> q = em.createNamedQuery("PiirivalvurAuaste.findAll", PiirivalvurAuaste.class);
		    List<PiirivalvurAuaste> piirivalvurAuaste = q.getResultList();
		    return piirivalvurAuaste;
		}
		finally {
		    em.close();
		}
	}

}