package cz.uhk.MasterNodeServer.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import java.util.List;
import static javax.persistence.FetchType.LAZY;


/**
 * The persistent class for the sensor database table.
 * 
 */
@Entity
@NamedQuery(name="Sensor.findAll", query="SELECT s FROM Sensor s")
@Table(name="sensor")
public class Sensor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String identifier;

	private String name;

	//bi-directional many-to-one association to Node
	@ManyToOne(fetch = LAZY)
	private Node node;

	//bi-directional many-to-one association to Value
	@JsonIgnore
	@OneToMany(mappedBy="sensor", fetch = LAZY)
	private List<Value> values;

	public Sensor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@JsonBackReference
	public Node getNode() {
		return this.node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	@JsonManagedReference
	public List<Value> getValues() {
		return this.values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

	public Value addValue(Value value) {
		getValues().add(value);
		value.setSensor(this);

		return value;
	}

	public Value removeValue(Value value) {
		getValues().remove(value);
		value.setSensor(null);

		return value;
	}

}