package ee.itcollege.i377.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import ee.itcollege.i377.model.Vahtkond;

@Repository
public class VahtkondDaoImpl implements VahtkondDao {

	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("piirivalvePersistenceUnit");

	@Override
	public void addVahtkond(Vahtkond vahtkond) {
		
		//add audit information to entity
		vahtkond.setAvaja(SecurityContextHolder.getContext().getAuthentication().getName());
		vahtkond.setAvatud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.persist(vahtkond);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}

	@Override
	public void updateVahtkond(Vahtkond vahtkond) {
		
		//add audit information to entity
		vahtkond.setMuutja(SecurityContextHolder.getContext().getAuthentication().getName());
		vahtkond.setMuudetud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.merge(vahtkond);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public void deleteVahtkondById(Long id) {
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		Vahtkond vahtkond = entityManager.createNamedQuery("Vahtkond.findById", Vahtkond.class).setParameter("id", id).getSingleResult();
		
		//add audit information to entity
		vahtkond.setSulgeja(SecurityContextHolder.getContext().getAuthentication().getName());
		vahtkond.setSuletud(new Date());
				
		// Save the data
		//entityManager.merge(vahtkond);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public Vahtkond getVahtkondById(Long id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<Vahtkond> q = em.createNamedQuery("Vahtkond.findById", Vahtkond.class).setParameter("id", id);
		    Vahtkond vahtkond = q.getSingleResult();
		    return vahtkond;
		}
		finally {
		    em.close();
		}
	}
	
	@Override
	public List<Vahtkond> getAllVahtkonds() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<Vahtkond> q = em.createNamedQuery("Vahtkond.findAll", Vahtkond.class);
		    List<Vahtkond> vahtkond = q.getResultList();
		    return vahtkond;
		}
		finally {
		    em.close();
		}
	}

}