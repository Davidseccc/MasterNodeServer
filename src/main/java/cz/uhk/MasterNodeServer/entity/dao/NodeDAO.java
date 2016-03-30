package cz.uhk.MasterNodeServer.entity.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.MasterNodeServer.entity.Node;

@Service
public class NodeDAO{

	@PersistenceContext
	
	public long countNodes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		long count = em.createQuery("SELECT COUNT(o) FROM Sensor o", Long.class).getSingleResult();

		em.close();
		return count;
	}

	public List<Node> findAllNodes() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		List<Node> n = em.createQuery("SELECT o FROM Node o JOIN FETCH o.sensors", Node.class).getResultList();

		em.close();
		return n;
	}

	public Node findNode(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		if (id == null)
			return null;
		Node n = em.find(Node.class, id);
		em.close();
		return n;
	}

	public Node findNodebyName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager(); 
		
		if (name == null)
			throw new IllegalArgumentException("Sensor name argument is required");
		TypedQuery<Node> q = em.createQuery("SELECT o FROM Node AS o WHERE o.name = :name", Node.class);
		q.setParameter("name", name);
		em.close();
		return q.getSingleResult();
	}

	public List<Node> findNodeEntries(int firstResult, int maxResults) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		List<Node> n = em.createQuery("SELECT o FROM Node o", Node.class).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
		em.close();
		return n;
	}

	@Transactional
	public void persist(Node n) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(n);

		em.getTransaction().commit();
		em.close();
	}

	public void remove(Node n) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		if (em.contains(n)) {
			em.remove(n);
		} else {
			Node attached = findNode(n.getId());
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
	public Node merge(Node n) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Node merged = em.merge(n);
		em.flush();

		em.getTransaction().commit();
		em.close();
		return merged;
	}

}
