package com.gamepride.platform.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
<<<<<<< HEAD

	
=======
	
	@PrePersist
	public void prePersist()
	{
		inscriptedAt=new Date();
	}
>>>>>>> fe0f9ba661ea21db11ec7eeecbbee3011ff53132

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
<<<<<<< HEAD


=======
>>>>>>> fe0f9ba661ea21db11ec7eeecbbee3011ff53132
}