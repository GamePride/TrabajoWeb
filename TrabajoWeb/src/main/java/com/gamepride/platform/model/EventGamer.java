package com.gamepride.platform.model;

import java.sql.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="event_gamers")

public class EventGamer{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Debe ingresar una fecha.")
	@Future(message = "El torneo no puede ser hoy, ingrese otra fecha.")
	@Column(name="inscripted_at",nullable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
	private Date inscriptedAt;

	

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