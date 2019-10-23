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
@Table(name="plan")
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Debe elegir el tipo de plan.")
	@Column(name="type",nullable=false,length=20)
	private String type;
	
	@Column(name="value",nullable=false)
	private float value;
	
	public Plan(@NotEmpty(message = "Debe elegir el tipo de plan.") String type, float value) {
		this.type = type;
		this.value = value;
	}

	public Plan() {
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
	
	public void setType(String type) {
		this.type = type;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}
}