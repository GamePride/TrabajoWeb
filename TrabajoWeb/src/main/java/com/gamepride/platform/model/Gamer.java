package com.gamepride.platform.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="gamers")
public class Gamer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Debe ingresar el email del usuario.")
	@Column(name="email",nullable=false,length=50)
	private String email;

	@NotEmpty(message = "Debe ingresar la contraseña del usuario.")
	@Column(name="password",nullable=false)
	private String password;

	@OneToOne
	@JoinColumn(name="id_person",nullable=false)
	private Person person;
		
	public Gamer() {
	}

	public Gamer(Integer id, @NotEmpty String email,
			@NotEmpty String password, Person person) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.person = person;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}