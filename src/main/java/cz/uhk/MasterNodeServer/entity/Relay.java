package cz.uhk.MasterNodeServer.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;
import static javax.persistence.FetchType.LAZY;


/**
 * The persistent class for the relay database table.
 * 
 */
@Entity
@NamedQuery(name="Relay.findAll", query="SELECT r FROM Relay r")
@Table(name="relay")
public class Relay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String identifier;

	private String name;
	
	private Boolean state;

	//bi-directional many-to-one association to Node
	@ManyToOne(fetch = LAZY) 
	private Node node;

	public Relay() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
	@JsonBackReference
	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}


}