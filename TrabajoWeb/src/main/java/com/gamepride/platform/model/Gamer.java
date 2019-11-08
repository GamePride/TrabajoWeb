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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="gamers")
public class Gamer{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Debe ingresar el email del usuario.")
	@Column(name="username",nullable=false,length=50)
	private String username;

	@NotEmpty(message = "Debe ingresar la contraseña del usuario.")
	@Column(name="password",nullable=false)
	private String password;

	@OneToOne(mappedBy = "personId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Person person;
		
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "event_gamers", 
		joinColumns = @JoinColumn(name = "gamer_id"), 
		inverseJoinColumns=@JoinColumn(name = "event_id"))
	private List<Event> events;

	@NotNull(message="Debe seleccionar una suscripción")
	@ManyToOne
	@JoinColumn(name="subscription_id",nullable=false)
	private Subscription subscriptionId;
	
	public Gamer() {
		events=new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Subscription getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Subscription subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
}