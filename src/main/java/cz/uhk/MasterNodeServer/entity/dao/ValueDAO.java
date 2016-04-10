package cz.uhk.MasterNodeServer.entity.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.MasterNodeServer.entity.Value;

@Service
public class ValueDAO{

	@PersistenceContext

	public long countValues() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		long count = em.createQuery("SELECT COUNT(o) FROM Value o", Long.class).getSingleResult();

		em.close();
		return count;
	}

	public List<Value> findAllValues() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		List<Value> users = em.createQuery("SELECT o FROM Value o JOIN FETCH o.sensor s ORDER BY o.date DESC, s.id", Value.class).getResultList();

		em.close();
		return users;
	}

	public Value findValue(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		if (id == null)
			return null;
		Value v = em.find(Value.class, id);
		em.close();
		return v;
	}

	public List<Value> findValueEntries(int firstResult, int maxResults) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		List<Value> v = em.createQuery("SELECT o FROM Value o JOIN FETCH o.sensor s ORDER BY o.date DESC, s.id", Value.class).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
		em.close();
		return v;
	}

	@Transactional
	public void persist(Value v) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(v);

		em.getTransaction().commit();
		em.close();
	}

	@Transactional
	public void remove(Value v) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		if (em.contains(v)) {
			em.remove(v);
		} else {
			Value attached = findValue(v.getId());
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
	public Value merge(Value v) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Value merged = em.merge(v);
		em.flush();

		em.getTransaction().commit();
		em.close();
		return merged;
	}

	
	public List<Value> findValueEntriesbySensor(String sensor, int firstResult, int maxResults) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager(); 
		
		Calendar calendar = Calendar.getInstance();
		Date endDate = calendar.getTime();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)-24);
		Date startDate = calendar.getTime();

		
		if (sensor == null)
			throw new IllegalArgumentException("The Sensor argument is required");
		TypedQuery<Value> q = em.createQuery("SELECT o FROM Value o JOIN FETCH o.sensor s WHERE s.identifier = :sensor AND o.date BETWEEN :startDate AND :endDate  ORDER BY o.date ASC", Value.class)
				.setFirstResult(firstResult).setMaxResults(maxResults);
		q.setParameter("sensor", sensor);
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);

		List<Value> values = q.getResultList();
		em.close();
		return values;
	}

	public TypedQuery<Value> findValuesBySensorName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager(); 
		
		if (name == null)
			throw new IllegalArgumentException("The Email argument is required");
		TypedQuery<Value> q = em.createQuery("SELECT o FROM User AS o WHERE o.email = :email", Value.class);
		q.setParameter("email", name);
		em.close();
		return q;
	}

}
