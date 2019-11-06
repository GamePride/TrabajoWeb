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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="lancenters")
public class LanCenter implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Debe ingresar el nombre del LanCenter.")
	@Column(name="name",nullable=false,length=50)
	private String name;
	
	@NotEmpty(message = "Debe ingresar el número del LanCenter.")
	@Size(min = 7,max = 7,message="Número de teléfono inválido.")
	@Column(name="phone",nullable=false)
	private String phone;
	
	@NotEmpty(message = "Debe ingresar la dirección del LanCenter.")
	@Column(name="adress",nullable=false,length=60)
	private String adress;
	
	@NotEmpty(message = "Debe ingresar el distrito del LanCenter.")
	@Column(name="district",nullable=false,length=60)
	private String district;

	@ManyToOne
	@JoinColumn(name="id_person",nullable=false)
	private Person manager;

	public LanCenter() {
	}

	public LanCenter(Long id, @NotEmpty String name,
			@Size String phone,
			@NotEmpty String adress,
			@NotEmpty String district, Person manager) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.adress = adress;
		this.district = district;
		this.manager = manager;
	}

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

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}
}