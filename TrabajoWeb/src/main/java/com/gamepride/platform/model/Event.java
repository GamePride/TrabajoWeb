package com.gamepride.platform.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Debe ingresar un nombre de evento.")
	@Column(name="name",nullable=false,length=40)
	private String name;
	
	@NotEmpty(message = "Debe ingresar el nombre de un juego.")
	@Column(name="game",nullable=false,length=50)
	private String game;
	
	@NotNull(message = "Debe ingresar una fecha.")
	@Future(message = "El torneo no puede ser hoy, ingrese otra fecha.")
	@Column(name="started_at",nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
	private Date startedAt;
	
	@NotEmpty(message = "Debe ingresar el número de vacantes.")
	@Size(min=10,message="El mínimo de vacantes debe ser de 10 jugadores")
	@Column(name="vacancy",nullable=false)
	private Integer vacancy;
	
	@DecimalMin("0.00")
	@DecimalMax("50.00")
	@Column(name="cost_inscription",nullable=false,columnDefinition = "Decimal(3,2)")
	private Double costInscription;
	
	@Column(name="reward",nullable=false,length=40)
	private String reward;

	@Column(name = "published", nullable = false, length = 50)
	private Boolean published;
	
	@NotEmpty(message = "Debe ingresar las bases del torneo.")
	@Column(name="bases",nullable=false,length=255)
	private String bases;
	
	@ManyToOne
	@JoinColumn(name="id_lancenter",nullable=false)
	private LanCenter lancenter;
	
	@NotEmpty(message = "Debe ingresar una foto referencial del torneo.")
	@Column(name="photo",nullable=false,length=200)
	private String photo;
	
	public Event() {
	}

	public Event(Long id, @NotEmpty String name,
			@NotEmpty String game,
			@NotNull @Future Date startedAt,
			@NotEmpty @Size Integer vacancy,
			@DecimalMin("0.00") @DecimalMax("50.00") Double costInscription, String reward, Boolean published,
			@NotEmpty String photo,
			@NotEmpty String bases, LanCenter lancenter) {
		this.id = id;
		this.name = name;
		this.game = game;
		this.startedAt = startedAt;
		this.vacancy = vacancy;
		this.costInscription = costInscription;
		this.reward = reward;
		this.published = published;
		this.photo = photo;
		this.bases = bases;
		this.lancenter = lancenter;
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

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Integer getVacancy() {
		return vacancy;
	}

	public void setVacancy(Integer vacancy) {
		this.vacancy = vacancy;
	}

	public Double getCostInscription() {
		return costInscription;
	}

	public void setCostInscription(Double costInscription) {
		this.costInscription = costInscription;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public Boolean getPublished() {
		return published;
	}

	public void setPublished(Boolean published) {
		this.published = published;
	}

	public String getBases() {
		return bases;
	}

	public void setBases(String bases) {
		this.bases = bases;
	}

	public LanCenter getLancenter() {
		return lancenter;
	}

	public void setLancenter(LanCenter lancenter) {
		this.lancenter = lancenter;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}