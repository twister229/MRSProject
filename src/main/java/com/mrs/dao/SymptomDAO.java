package com.mrs.dao;

import java.util.List;

import com.mrs.entity.Symptom;

public interface SymptomDAO {
	public List<Symptom> loadListSymptomName();
	public String getSymptomNameByID(int id);
	public Symptom getSymptomByID(int id);
}
