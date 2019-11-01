package com.gamepride.platform.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (name = "persons")
public class Person implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Debe ingresar el nombre.")
	@Column(name="name",nullable=false,length=65)
	private String name;
	
	@Size(min = 9,max = 9,message="Número de teléfono inválido.")
	@Column(name="phone",nullable=false,length=9)
	private Integer phone;
	
	@Size(min = 10,max = 30,message="Número de cuentas inválido.")
	@Column(name="account_number",nullable=false,length=30)
	private Integer accountNumber;
	
	public Person() {
	}
	
	public Person(Integer id, @NotEmpty String name,
			@Size Integer phone,
			@Size Integer accountNumber) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.accountNumber = accountNumber;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
}