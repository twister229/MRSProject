package com.mrs.entity;

import java.io.Serializable;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "orderdetail")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	private int id;
	private int orderID;
	private Integer equipmentID;
	private int serviceID;
	private Double equipmentCost;
	private double serviceCost;

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetail(int orderID, Integer equipmentID, int serviceID, Double equipmentCost, double serviceCost) {
		super();
		this.orderID = orderID;
		this.equipmentID = equipmentID;
		this.serviceID = serviceID;
		this.equipmentCost = equipmentCost;
		this.serviceCost = serviceCost;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "OrderID")
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	@Column(name = "EquipmentID")
	public Integer getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(Integer equipmentID) {
		this.equipmentID = equipmentID;
	}

	@Column(name = "ServiceID")
	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	@Column(name = "EquipmentCost")
	public Double getEquipmentCost() {
		return equipmentCost;
	}

	public void setEquipmentCost(Double equipmentCost) {
		this.equipmentCost = equipmentCost;
	}

	@Column(name = "ServiceCost")
	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}
}
