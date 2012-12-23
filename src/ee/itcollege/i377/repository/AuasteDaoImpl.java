package ee.itcollege.i377.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import ee.itcollege.i377.model.Auaste;

@Repository
public class AuasteDaoImpl implements AuasteDao {

	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("piirivalvePersistenceUnit");

	@Override
	public void addAuaste(Auaste auaste) {
		
		//add audit information to entity
		auaste.setAvaja(SecurityContextHolder.getContext().getAuthentication().getName());
		auaste.setAvatud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.persist(auaste);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}

	@Override
	public void updateAuaste(Auaste auaste) {
		
		//add audit information to entity
		auaste.setMuutja(SecurityContextHolder.getContext().getAuthentication().getName());
		auaste.setMuudetud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.merge(auaste);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public void deleteAuasteById(Long id) {
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		Auaste auaste = entityManager.createNamedQuery("Auaste.findById", Auaste.class).setParameter("id", id).getSingleResult();
		
		//add audit information to entity
		auaste.setSulgeja(SecurityContextHolder.getContext().getAuthentication().getName());
		auaste.setSuletud(new Date());
				
		// Save the data
		//entityManager.merge(auaste);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public Auaste getAuasteById(Long id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<Auaste> q = em.createNamedQuery("Auaste.findById", Auaste.class).setParameter("id", id);
		    Auaste auaste = q.getSingleResult();
		    return auaste;
		}
		finally {
		    em.close();
		}
	}
	
	@Override
	public List<Auaste> getAllAuastes() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<Auaste> q = em.createNamedQuery("Auaste.findAll", Auaste.class);
		    List<Auaste> auaste = q.getResultList();
		    return auaste;
		}
		finally {
		    em.close();
		}
	}

}