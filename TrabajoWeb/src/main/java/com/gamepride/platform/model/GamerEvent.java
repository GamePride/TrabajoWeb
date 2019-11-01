package com.gamepride.platform.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="gamer_events")
public class GamerEvent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Debe ingresar una fecha.")
	@Future(message = "La fecha de inscripción no puede ser hoy, ingrese otra fecha.")
	@Column(name="inscriptedAt",nullable=false,length=50)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String inscriptedAt;

	@ManyToOne
	@JoinColumn(name="id_gamer",nullable=false)
	private Gamer gamer;
	
	@ManyToOne
	@JoinColumn(name="id_event",nullable=false)
	private Event event;
	
	public GamerEvent() {
	}

	public GamerEvent(String inscriptedAt, Gamer gamer, Event event) {
		this.inscriptedAt = inscriptedAt;
		this.gamer = gamer;
		this.event = event;
	}

	public String getInscriptedAt() {
		return inscriptedAt;
	}

	public void setInscriptedAt(String inscriptedAt) {
		this.inscriptedAt = inscriptedAt;
	}

	public Gamer getGamer() {
		return gamer;
	}

	public void setGamer(Gamer gamer) {
		this.gamer = gamer;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}