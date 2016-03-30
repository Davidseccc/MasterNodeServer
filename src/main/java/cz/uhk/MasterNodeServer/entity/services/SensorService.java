package cz.uhk.MasterNodeServer.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.MasterNodeServer.entity.Sensor;
import cz.uhk.MasterNodeServer.entity.dao.SensorDAO;
@Service
@Transactional
public class SensorService {

	@Autowired
	private SensorDAO sensorDAO;
	
	public long countAllSensors() {
		return sensorDAO.countSensors();
	}

	public void deleteSensor(Sensor s) {
		sensorDAO.remove(s);
	}

	public Sensor findSensor(Integer id) {
		return sensorDAO.findSensor(id);
	}

	public Sensor findSensorbyName(String name) {
		return sensorDAO.findSensorbyName(name);
	}

	public List<Sensor> findAllSensors() {
		return sensorDAO.findAllSensors();
	}

	public List<Sensor> findSensorEntries(int firstResult, int maxResults) {
		return findSensorEntries(firstResult, maxResults);
	}

	public void saveSensor(Sensor s) {
		sensorDAO.persist(s);
		
	}

	public Sensor updateSensor(Sensor s) {
		return sensorDAO.merge(s);
	}

}
