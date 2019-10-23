package com.gamepride.platform.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subscription_plan")
public class SubscriptionPlan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private char id;
	
	@Column(name="name",nullable=false,length=50)
	private String subscriptedAt;
	
	public char getId() {
		return id;
	}
	public void setId(char id) {
		this.id = id;
	}
	public String getSubscriptedAt() {
		return subscriptedAt;
	}
	public void setSubscriptedAt(String subscriptedAt) {
		this.subscriptedAt = subscriptedAt;
	}
	
}
