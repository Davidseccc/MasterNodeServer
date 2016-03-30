package cz.uhk.MasterNodeServer.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the node database table.
 * 
 */
@Entity
@NamedQuery(name="Node.findAll", query="SELECT n FROM Node n")
@Table(name="node")
public class Node implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String ip;

	private String name;

	//bi-directional many-to-one association to Sensor
	@JsonIgnore
	@OneToMany(mappedBy="node" , fetch=FetchType.LAZY)
	private List<Sensor> sensors;
	
	@JsonIgnore
	@OneToMany(mappedBy="node" , fetch=FetchType.LAZY)
	private List<Relay> relay;



	public Node() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@JsonManagedReference
	public List<Sensor> getSensors() {
		return this.sensors;
	}
	
	public void setSensors(List<Sensor> sensors) {
		this.sensors = sensors;
	}
	@JsonManagedReference
	public List<Relay> getRelay() {
		return relay;
	}

	public void setRelay(List<Relay> relay) {
		this.relay = relay;
	}
	public Sensor addSensor(Sensor sensor) {
		getSensors().add(sensor);
		sensor.setNode(this);

		return sensor;
	}

	public Sensor removeSensor(Sensor sensor) {
		getSensors().remove(sensor);
		sensor.setNode(null);

		return sensor;
	}

}