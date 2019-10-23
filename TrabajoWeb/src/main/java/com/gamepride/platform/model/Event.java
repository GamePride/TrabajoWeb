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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="event")
public class Event implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Debe ingresar un nombre de Evento.")
	@Column(name="name",nullable=false,length=40)
	private String name;
	
	@NotEmpty(message = "Debe ingresar el nombre de un juego.")
	@Column(name="game",nullable=false,length=50)
	private String game;
	
	@NotNull(message = "Debe ingresar una fecha.")
	@Column(name="started_at",nullable=false)
	private Date startedAt;
	
	@Column(name="vacancy",nullable=false)
	private int vacancy;
	
	@Column(name="cost_inscription",nullable=false)
	private int costInscription;
	
	@Column(name="reward",nullable=false,length=40)
	private String reward;

	@ManyToOne
	@JoinColumn(name="id_lancenter",nullable=false)
	private LanCenter lancenter;
	
	public Event(@NotEmpty String name,
			@NotEmpty String game,
			@NotNull Date startedAt, int vacancy, int costInscription,
			String reward, LanCenter lancenter) {
		this.name = name;
		this.game = game;
		this.startedAt = startedAt;
		this.vacancy = vacancy;
		this.costInscription = costInscription;
		this.reward = reward;
		this.lancenter = lancenter;
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

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public int getCostInscription() {
		return costInscription;
	}

	public void setCostInscription(int costInscription) {
		this.costInscription = costInscription;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}
}