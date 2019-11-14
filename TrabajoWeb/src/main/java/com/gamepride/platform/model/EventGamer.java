package com.gamepride.platform.model;


import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="event_gamers")

public class EventGamer{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="inscripted_at",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date inscriptedAt;

	@OneToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="role_id")
	private List<Role> roles;
	
	@PrePersist
	public void prePersist()
	{
		inscriptedAt=new Date();
	}
	
	public EventGamer() {
		roles=new ArrayList<>();
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}