package com.mrs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	private int invoiceID;
	private String customerUsername;
	private double totalCost;
	private int status;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "InvoiceID")
	public int getInvoiceID() {
		return invoiceID;
	}
	
	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}

	@Column(name = "CustomerUsername")
	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	@Column(name = "TotalCost")
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Column(name = "Status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
