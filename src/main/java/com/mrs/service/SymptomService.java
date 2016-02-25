package com.mrs.service;

import java.util.List;

import com.mrs.entity.Symptom;

public interface SymptomService {
	public List<Symptom> getListSymptomName();
	public String getSymptomNameByID(int id);
	public Symptom getSymptomByID(int id);
}
