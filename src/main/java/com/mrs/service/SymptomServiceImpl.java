package com.mrs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.dao.SymptomDAO;
import com.mrs.entity.Symptom;

@Service
@Transactional
public class SymptomServiceImpl implements SymptomService {

	@Autowired
	private SymptomDAO symptomDAO;
	
	public List<Symptom> getListSymptomName() {
		return symptomDAO.loadListSymptomName();
	}

	public String getSymptomNameByID(int id) {
		return symptomDAO.getSymptomNameByID(id);
	}

	public Symptom getSymptomByID(int id) {
		return symptomDAO.getSymptomByID(id);
	}

}
