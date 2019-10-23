package com.gamepride.platform.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="datePay",nullable=false,length=50)
	private  int datePay;
	
	@Column(name="typePay",nullable=false)
	private char typePay;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDatePay() {
		return datePay;
	}
	public void setDatePay(int datePay) {
		this.datePay = datePay;
	}
	public char getTypePay() {
		return typePay;
	}
	public void setTypePay(char typePay) {
		this.typePay = typePay;
	}	
}