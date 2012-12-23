package ee.itcollege.i377.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import ee.itcollege.i377.model.VahtkonnaLiige;

@Repository
public class VahtkonnaLiigeDaoImpl implements VahtkonnaLiigeDao {

	
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("piirivalvePersistenceUnit");

	@Override
	public void addVahtkonnaLiige(VahtkonnaLiige vahtkonnaLiige) {
		
		//add audit information to entity
		vahtkonnaLiige.setAvaja(SecurityContextHolder.getContext().getAuthentication().getName());
		vahtkonnaLiige.setAvatud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.persist(vahtkonnaLiige);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}

	@Override
	public void updateVahtkonnaLiige(VahtkonnaLiige vahtkonnaLiige) {
		
		//add audit information to entity
		vahtkonnaLiige.setMuutja(SecurityContextHolder.getContext().getAuthentication().getName());
		vahtkonnaLiige.setMuudetud(new Date());
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		// Save the data
		entityManager.merge(vahtkonnaLiige);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public void deleteVahtkonnaLiigeById(Long id) {
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Create a transaction
		entityManager.getTransaction().begin();

		VahtkonnaLiige vahtkonnaLiige = entityManager.createNamedQuery("VahtkonnaLiige.findById", VahtkonnaLiige.class).setParameter("id", id).getSingleResult();
		
		//add audit information to entity
		vahtkonnaLiige.setSulgeja(SecurityContextHolder.getContext().getAuthentication().getName());
		vahtkonnaLiige.setSuletud(new Date());
				
		// Save the data
		//entityManager.merge(vahtkonnaLiige);

		// Commit the transaction
		entityManager.getTransaction().commit();

		// Close the connection
		entityManager.close();
	}
	
	@Override
	public VahtkonnaLiige getVahtkonnaLiigeById(Long id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<VahtkonnaLiige> q = em.createNamedQuery("VahtkonnaLiige.findById", VahtkonnaLiige.class).setParameter("id", id);
		    VahtkonnaLiige vahtkonnaLiige = q.getSingleResult();
		    return vahtkonnaLiige;
		}
		finally {
		    em.close();
		}
	}
	
	@Override
	public List<VahtkonnaLiige> getAllVahtkonnaLiiges() {
		EntityManager em = entityManagerFactory.createEntityManager();
		try {
		    TypedQuery<VahtkonnaLiige> q = em.createNamedQuery("VahtkonnaLiige.findAll", VahtkonnaLiige.class);
		    List<VahtkonnaLiige> vahtkonnaLiige = q.getResultList();
		    return vahtkonnaLiige;
		}
		finally {
		    em.close();
		}
	}

}