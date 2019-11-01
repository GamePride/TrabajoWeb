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
@Table(name="subscription_plans")
public class SubscriptionPlan implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Debe ingresar una fecha.")
	@Column(name="subscripted_at",nullable=false,length=50)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String subscriptedAt;
	
	@ManyToOne
	@JoinColumn(name="id_subscription",nullable=false)
	private Subscription subscription;
	
	@ManyToOne
	@JoinColumn(name="id_plan",nullable=false)
	private Plan plan;
	
	public SubscriptionPlan() {
	}

	public SubscriptionPlan(Integer id,
			@NotNull @Future String subscriptedAt,
			Subscription subscription, Plan plan) {
		this.subscriptedAt = subscriptedAt;
		this.subscription = subscription;
		this.plan = plan;
	}

	public String getSubscriptedAt() {
		return subscriptedAt;
	}

	public void setSubscriptedAt(String subscriptedAt) {
		this.subscriptedAt = subscriptedAt;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}
}
