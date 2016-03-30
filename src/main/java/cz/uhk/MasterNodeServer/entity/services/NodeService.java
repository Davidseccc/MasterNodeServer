package cz.uhk.MasterNodeServer.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.uhk.MasterNodeServer.entity.Node;
import cz.uhk.MasterNodeServer.entity.dao.NodeDAO;
@Service
@Transactional
public class NodeService{

	@Autowired
	private NodeDAO sensorDAO;
	
	public long countAllNodes() {
		return sensorDAO.countNodes();
	}

	public void deleteNode(Node n) {
		sensorDAO.remove(n);
	}

	public Node findNode(Integer id) {
		return sensorDAO.findNode(id);
	}

	public List<Node> findAllNodes() {
		return sensorDAO.findAllNodes();
	}

	public List<Node> findNodeEntries(int firstResult, int maxResults) {
		return sensorDAO.findNodeEntries(firstResult, maxResults);
	}

	public Node findNodeByName(String name) {
		return sensorDAO.findNodebyName(name);
	}

	public void saveSensor(Node n) {
		sensorDAO.persist(n);		
	}

	public Node updateSensor(Node n) {
		return sensorDAO.merge(n);
	}

}
