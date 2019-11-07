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
@Table(name="subscriptions")
public class Subscription implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Debe elegir el tipo de suscripción.")
	@Column(name="type",nullable=false,length=20)
	private String type;
	
	@NotEmpty(message = "Debe ingresar una frecuencia.")
	@Column(name="frequency",nullable=false,length=20)
	private String frequency;

	public Subscription() {
	}
	
	public Subscription(Long id, @NotEmpty String type, @NotEmpty String frequency) {
		this.id = id;
		this.type = type;
		this.frequency = frequency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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