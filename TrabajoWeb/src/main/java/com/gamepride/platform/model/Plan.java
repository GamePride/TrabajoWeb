package com.gamepride.platform.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="plans")
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Debe elegir el tipo de plan.")
	@Column(name="type",nullable=false,length=20)
	private String type;
	
	@DecimalMin("0.00")
	@DecimalMax("30.00")
	@Column(name="cost",nullable=false,columnDefinition = "Decimal(8,2)")
	private float cost;
	
	public Plan() {
	}

	public Plan(int id, @NotEmpty String type,
			@DecimalMin("0.00") @DecimalMax("30.00") float cost) {
		this.id = id;
		this.type = type;
		this.cost = cost;
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
}