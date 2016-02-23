package com.mrs.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "symptom")
public class Symptom implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	private int symptomID;
	private String symptomName;
	private String description;
	private int skillID;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SymptomID")
	public int getSymptomID() {
		return symptomID;
	}

	@Column(name = "SymptomName")
	public String getSymptomName() {
		return symptomName;
	}

	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}

	@Column(name = "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "SkillID")
	public int getSkillID() {
		return skillID;
	}

	public void setSkillID(int skillID) {
		this.skillID = skillID;
	}
}
