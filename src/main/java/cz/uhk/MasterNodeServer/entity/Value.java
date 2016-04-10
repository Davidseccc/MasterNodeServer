package cz.uhk.MasterNodeServer.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import static javax.persistence.FetchType.LAZY;

/**
 * The persistent class for the value database table.
 * 
 */
@Entity
@NamedQuery(name="Value.findAll", query="SELECT v FROM Value v")
@Table(name="value")
public class Value implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Timestamp date;

	private float value;

	//bi-directional many-to-one association to Sensor
	@ManyToOne (fetch=FetchType.EAGER)
	@JoinColumn(name="sensor_id")
	@JsonManagedReference
	private Sensor sensor;

	public Value() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public float getValue() {
		return this.value;
	}

	public void setValue(float value) {
		this.value = value;
	}
	@JsonBackReference
	public Sensor getSensor() {
		return this.sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	@Override
	public String toString() {
		return "Value [id=" + id + ", date=" + date + ", value=" + value + "]";
	}

	
}