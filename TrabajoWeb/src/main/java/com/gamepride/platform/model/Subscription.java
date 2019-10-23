package com.gamepride.platform.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="subscription")
public class Subscription implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Debe elegir el tipo de suscripción.")
	@Column(name="type",nullable=false,length=20)
	private String type;
	
	@Column(name="frequency",nullable=false,length=20)
	private String frequency;

	public Subscription(@NotEmpty(message = "Debe elegir el tipo de suscripción.") String type, String frequency) {
		this.type = type;
		this.frequency = frequency;
	}

	public Subscription() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String Type) {
		this.type = Type;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
}