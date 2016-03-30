package cz.uhk.MasterNodeServer.entity.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.MasterNodeServer.entity.Relay;

@Service
public class RelayDAO{

	@PersistenceContext
	
	public long countSensors() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		long count = em.createQuery("SELECT COUNT(o) FROM Relay o", Long.class).getSingleResult();

		em.close();
		return count;
	}

	public List<Relay> findAllSensors() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		List<Relay> r = em.createQuery("SELECT o FROM Relay o", Relay.class).getResultList();

		em.close();
		return r;
	}

	public Relay findSensor(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		if (id == null)
			return null;
		Relay r = em.find(Relay.class, id);
		em.close();
		return r;
	}

	public Relay findSensorbyName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager(); 
		
		if (name == null)
			throw new IllegalArgumentException("Relay name argument is required");
		TypedQuery<Relay> q = em.createQuery("SELECT o FROM Relay AS o WHERE o.identifier = :name", Relay.class);
		q.setParameter("name", name);
		em.close();
		return q.getSingleResult();
	}

	public List<Relay> findSensorEntries(int firstResult, int maxResults) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		List<Relay> s = em.createQuery("SELECT o FROM Relay o", Relay.class).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
		em.close();
		return s;
	}

	@Transactional
	public void persist(Relay s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(s);

		em.getTransaction().commit();
		em.close();
	}

	public void remove(Relay s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		if (em.contains(s)) {
			em.remove(s);
		} else {
			Relay attached = findSensor(s.getId());
			em.remove(attached);

		}

		em.getTransaction().commit();
		em.close();		
	}

	@Transactional
	public void flush() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		em.flush();

		em.getTransaction().commit();
		em.close();
	}

	@Transactional
	public void clear() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		em.clear();

		em.getTransaction().commit();
		em.close();
	}
	
	
	@Transactional
	public Relay merge(Relay s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Relay merged = em.merge(s);
		em.flush();

		em.getTransaction().commit();
		em.close();
		return merged;
	}

}
