package com.gamepride.platform.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="subscriptions")
public class Subscription{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Debe elegir el tipo de suscripción.")
	@Column(name="type",nullable=false,length=20)
	private String type;
	
	@NotEmpty(message = "Debe ingresar una frecuencia.")
	@Column(name="frequency",nullable=false,length=20)
	private String frequency;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "subscription_plans", 
		joinColumns = @JoinColumn(name = "subscription_id"), 
		inverseJoinColumns=@JoinColumn(name = "plan_id"))
	private List<Plan> plans;

	@OneToMany(mappedBy = "subscriptionId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Person> people;
	
	public Subscription() {
		people=new ArrayList<>();
		plans=new ArrayList<>();
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

	public void setType(String type) {
		this.type = type;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}
}