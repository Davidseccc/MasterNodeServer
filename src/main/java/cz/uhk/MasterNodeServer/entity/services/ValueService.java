package cz.uhk.MasterNodeServer.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.MasterNodeServer.entity.Value;
import cz.uhk.MasterNodeServer.entity.dao.ValueDAO;

@Service
@Transactional
public class ValueService {

	@Autowired
	private ValueDAO valueDAO;
	
	public long countAllValues() {

		return valueDAO.countValues();
	}

	
	public void deleteValue(Value v) {
		valueDAO.remove(v);
	}

	
	public Value findValue(Integer id) {
		return valueDAO.findValue(id);
	}

	
	public List<Value> findAllValues() {
		return valueDAO.findAllValues();
	}

	
	public List<Value> findValueEntries(int firstResult, int maxResults) {
		return valueDAO.findValueEntries(firstResult, maxResults);
	}

	
	public List<Value> findValueEntriesbySensor(String sensor, int firstResult, int maxResults) {
		return valueDAO.findValueEntriesbySensor(sensor, firstResult, maxResults);
	}
	public List<Float> findValuebySensor(String sensor, int firstResult, int maxResults) {
		return valueDAO.findValuebySensor(sensor, firstResult, maxResults);
	}

	public void saveValue(Value v) {
		valueDAO.persist(v);
	}

	
	public Value updateValue(Value v) {
		return valueDAO.merge(v);
	}

}
