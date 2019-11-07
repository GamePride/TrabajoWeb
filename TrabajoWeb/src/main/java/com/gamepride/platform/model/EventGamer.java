package com.gamepride.platform.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Event_Gamers")

public class EventGamer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Debe ingresar una fecha.")
	@Future(message = "El torneo no puede ser hoy, ingrese otra fecha.")
	@Column(name="inscripted_at",nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
	private Date inscriptedAt;

	public EventGamer() {
	}
	
	public EventGamer(Long id, @NotNull @Future Date inscriptedAt) {
		this.id = id;
		this.inscriptedAt = inscriptedAt;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInscriptedAt() {
		return inscriptedAt;
	}

	public void setInscriptedAt(Date inscriptedAt) {
		this.inscriptedAt = inscriptedAt;
	}
}
