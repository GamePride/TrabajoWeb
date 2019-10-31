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
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="user_events")
public class UserEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Debe ingresar una fecha.")
	@Future(message = "La fecha de inscripción no puede ser hoy, ingrese otra fecha.")
	@Column(name="inscriptedAt",nullable=false,length=50)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String inscriptedAt;

	@ManyToOne
	@JoinColumn(name="id_user",nullable=false)
	private Gamer user;
	
	@ManyToOne
	@JoinColumn(name="id_event",nullable=false)
	private Event event;
	
	public UserEvent() {
	}

	public UserEvent(String inscriptedAt, Gamer user, Event event) {
		this.inscriptedAt = inscriptedAt;
		this.user = user;
		this.event = event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInscriptedAt() {
		return inscriptedAt;
	}

	public void setInscriptedAt(String inscriptedAt) {
		this.inscriptedAt = inscriptedAt;
	}

	public Gamer getUser() {
		return user;
	}

	public void setUser(Gamer user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}