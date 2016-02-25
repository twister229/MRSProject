package com.mrs.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.Symptom;

@Repository
public class SymptomDAOImpl implements SymptomDAO {

	@Autowired
	private HibernateRepository repository;
	
	public List<Symptom> loadListSymptomName() {
		List<Symptom> listSymp = repository.fetchAll(Symptom.class);
		return listSymp;
	}

	public String getSymptomNameByID(int id) {
		Symptom symp = repository.fetchById(id, Symptom.class);
		return symp.getSymptomName();
	}

	public Symptom getSymptomByID(int id) {
		return repository.fetchById(id, Symptom.class);
	}

}
