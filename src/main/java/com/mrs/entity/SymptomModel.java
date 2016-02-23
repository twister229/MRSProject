package com.mrs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "symptom_model")
public class SymptomModel implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	private int id;
	private int modelID;
	private int symptomID;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	@Column(name = "ModelID")
	public int getModelID() {
		return modelID;
	}

	public void setModelID(int modelID) {
		this.modelID = modelID;
	}

	@Column(name = "SymptomID")
	public int getSymptomID() {
		return symptomID;
	}

	public void setSymptomID(int symptomID) {
		this.symptomID = symptomID;
	}
}
