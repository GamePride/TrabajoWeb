package com.gamepride.platform.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="payments")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Debe ingresar una fecha.")
	@Column(name="paid_at",nullable=false,length=50)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  Date paidAt;
	
	@NotNull(message = "Debe elegir el tipo de pago.")
	@Column(name="type_pay",nullable=false)
	private String typePay;
	
    public Payment() {
	}
    
	public Payment(Integer id,
			@NotNull @Future Date paidAt,
			@NotNull @Future String typePay) {
		this.id = id;
		this.paidAt = paidAt;
		this.typePay = typePay;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getPaidAt() {
		return paidAt;
	}

	public void setPaidAt(Date paidAt) {
		this.paidAt = paidAt;
	}

	public String getTypePay() {
		return typePay;
	}
	public void setTypePay(String typePay) {
		this.typePay = typePay;
	}	
}