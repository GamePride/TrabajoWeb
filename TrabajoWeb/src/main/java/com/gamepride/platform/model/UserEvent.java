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
@Table (name="user_event")
public class UserEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="inscriptionAt",nullable=false,length=50)
	private String inscriptionAt;

	@ManyToOne
	@JoinColumn(name="id_user",nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_event",nullable=false)
	private Event event;
	
	public UserEvent(int id, String inscriptionAt, User user, Event event) {
		super();
		this.id = id;
		this.inscriptionAt = inscriptionAt;
		this.user = user;
		this.event = event;
	}

	public UserEvent() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInscriptionAt() {
		return inscriptionAt;
	}

	public void setInscriptionAt(String inscriptionAt) {
		this.inscriptionAt = inscriptionAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}