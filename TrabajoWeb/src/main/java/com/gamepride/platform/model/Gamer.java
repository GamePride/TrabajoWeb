package com.gamepride.platform.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;

@Entity
@Table(name="gamers")
public class Gamer{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Debe ingresar el nombre.")
	@Column(name="name",length=65)
	private String name;
	
	@NotEmpty(message = "Debe ingresar el nombre.")
	@Column(name="lastName",length=65)
	private String lastName;
	
	@Size(min = 9,max = 9,message="Número de teléfono inválido.")
	@Column(name="phone",length=9)
	private String phone;
	
	@Size(min = 10,max = 30,message="Número de cuentas inválido.")
	@Column(name="account_number",length=30)
	private String accountNumber;
	
	@NotEmpty(message = "Debe ingresar el Username del usuario.")
	@Column(name="username",nullable=false,length=50)
	private String username;

	@NotEmpty(message = "Debe ingresar la contraseña del usuario.")
	@Column(name="password",nullable=false)
	private String password;
		
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "event_gamers", 
		joinColumns = @JoinColumn(name = "gamer_id"), 
		inverseJoinColumns=@JoinColumn(name = "event_id"))
	private List<Event> events;
	
	@OneToOne(mappedBy = "gamerId",cascade = CascadeType.ALL)
	private LanCenter lancenter;
	
	@ManyToOne
	@JoinColumn(name="subscription_id")
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

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LanCenter getLancenters() {
		return lancenter;
	}

	public void setLancenters(LanCenter lancenter) {
		this.lancenter = lancenter;
	}

	public Subscription getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Subscription subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
}