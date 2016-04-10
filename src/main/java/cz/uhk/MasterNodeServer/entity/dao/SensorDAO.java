package cz.uhk.MasterNodeServer.entity.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.MasterNodeServer.entity.Sensor;
import cz.uhk.MasterNodeServer.entity.Value;

@Service
public class SensorDAO{

	@PersistenceContext
	
	public long countSensors() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		long count = em.createQuery("SELECT COUNT(o) FROM Sensor o", Long.class).getSingleResult();

		em.close();
		return count;
	}

	public List<Sensor> findAllSensors() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();
/**		
		Calendar calendar = Calendar.getInstance();
		Date endDate = calendar.getTime();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)-10);
		Date startDate = calendar.getTime();
**/		
		TypedQuery<Sensor> q = em.createQuery("SELECT o FROM Sensor o", Sensor.class);
		//q.setParameter("startDate", startDate, TemporalType.TIMESTAMP);
		//q.setParameter("endDate", endDate, TemporalType.TIMESTAMP);

		List<Sensor> s = q.getResultList();
		em.close();
		return s;
	}

	public Sensor findSensor(Integer id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		if (id == null)
			return null;
		Sensor s = em.find(Sensor.class, id);
		em.close();
		return s;
	}

	public Sensor findSensorbyName(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager(); 
		
		if (name == null)
			throw new IllegalArgumentException("Sensor name argument is required");
		TypedQuery<Sensor> q = em.createQuery("SELECT o FROM Sensor AS o WHERE o.identifier = :name", Sensor.class);
		q.setParameter("name", name);
		em.close();
		return q.getSingleResult();
	}

	public List<Sensor> findSensorEntries(int firstResult, int maxResults) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		List<Sensor> s = em.createQuery("SELECT o FROM Sensor o", Sensor.class).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();
		em.close();
		return s;
	}

	@Transactional
	public void persist(Sensor s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(s);

		em.getTransaction().commit();
		em.close();
	}

	public void remove(Sensor s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();

		if (em.contains(s)) {
			em.remove(s);
		} else {
			Sensor attached = findSensor(s.getId());
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
	public Sensor merge(Sensor s) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Sensor merged = em.merge(s);
		em.flush();

		em.getTransaction().commit();
		em.close();
		return merged;
	}

}
