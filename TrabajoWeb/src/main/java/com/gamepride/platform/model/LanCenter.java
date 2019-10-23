package com.gamepride.platform.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lancenter")
public class LanCenter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name",nullable=false,length=50)
	private String name;
	
	@Column(name="phone",nullable=false)
	private int phone;
	
	@Column(name="adress",nullable=false,length=60)
	private String adress;
	
	@Column(name="district",nullable=false,length=60)
	private String district;

	@ManyToOne
	@JoinColumn(name="id_person",nullable=false)
	private Person person;
	
	public LanCenter(int id, String name, int phone, String adress, String district, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.adress = adress;
		this.district = district;
		this.person = person;
	}

	public LanCenter() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}	
}