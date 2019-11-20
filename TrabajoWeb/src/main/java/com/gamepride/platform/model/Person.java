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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "people")
public class Person{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Debe ingresar el nombre.")
	@Column(name="name",nullable=false,length=65)
	private String name;
	
	@Size(min = 9,max = 9,message="Número de teléfono inválido.")
	@Column(name="phone",nullable=false,length=9)
	private String phone;
	
	@Size(min = 10,max = 30,message="Número de cuentas inválido.")
	@Column(name="account_number",nullable=false,length=30)
	private String accountNumber;
	/*
	@OneToMany(mappedBy = "personId",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<LanCenter> lancenters;
	*/
	@OneToOne
	@JoinColumn(name="gamer_id",nullable=false)
	private Gamer gamerId;
	
	@NotNull(message="Debe seleccionar una suscripción")
	@ManyToOne
	@JoinColumn(name="subscription_id",nullable=false)
	private Subscription subscriptionId;
	/*
	public Person() {
		lancenters=new ArrayList<>();
	}
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
/*
	public List<LanCenter> getLancenters() {
		return lancenters;
	}

	public void setLancenters(List<LanCenter> lancenters) {
		this.lancenters = lancenters;
	}
*/
	public Gamer getGamerId() {
		return gamerId;
	}

	public void setGamerId(Gamer gamerId) {
		this.gamerId = gamerId;
	}
	public Subscription getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Subscription subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
}