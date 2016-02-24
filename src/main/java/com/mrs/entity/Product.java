package com.mrs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	private Integer productID;
	private String productName;
	private String customerUsername;
	private Integer modelID;
	private Integer type;
	private String description;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(String productName, String customerUsername, Integer modelID, Integer type,
			String description) {
		super();
		this.productName = productName;
		this.customerUsername = customerUsername;
		this.modelID = modelID;
		this.type = type;
		this.description = description;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProductID")
	public Integer getProductID() {
		return productID;
	}
	
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	
	@Column(name = "ProductName")
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "CustomerUsername")
	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	@Column(name = "ModelID")
	public Integer getModelID() {
		return modelID;
	}

	public void setModelID(Integer modelID) {
		this.modelID = modelID;
	}

	@Column(name = "Type")
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
