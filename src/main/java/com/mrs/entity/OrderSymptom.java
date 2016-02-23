package com.mrs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_symptom")
public class OrderSymptom implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	private int id;
	private int orderID;
	private int symptomID;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	@Column(name = "OrderID")
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	@Column(name = "SymptomID")
	public int getSymptomID() {
		return symptomID;
	}

	public void setSymptomID(int symptomID) {
		this.symptomID = symptomID;
	}
}
