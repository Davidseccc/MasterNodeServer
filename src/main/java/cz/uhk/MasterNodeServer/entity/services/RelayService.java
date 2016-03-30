package cz.uhk.MasterNodeServer.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.MasterNodeServer.entity.Relay;
import cz.uhk.MasterNodeServer.entity.dao.RelayDAO;

@Service
@Transactional
public class RelayService {

	@Autowired
	private RelayDAO relayDAO;
	
	public long countAllSensors() {
		return relayDAO.countSensors();
	}

	public void deleteSensor(Relay s) {
		relayDAO.remove(s);
	}

	public Relay findSensor(Integer id) {
		return relayDAO.findSensor(id);
	}

	public Relay findSensorbyName(String name) {
		return relayDAO.findSensorbyName(name);
	}

	public List<Relay> findAllSensors() {
		return relayDAO.findAllSensors();
	}

	public List<Relay> findSensorEntries(int firstResult, int maxResults) {
		return relayDAO.findSensorEntries(firstResult, maxResults);
	}

	public void saveSensor(Relay s) {
		relayDAO.persist(s);
		
	}

	public Relay updateSensor(Relay s) {
		return relayDAO.merge(s);
	}

}
