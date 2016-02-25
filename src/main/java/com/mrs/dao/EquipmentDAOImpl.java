package com.mrs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.Equipment;

@Repository
public class EquipmentDAOImpl implements EquipmentDAO {

	@Autowired
	private HibernateRepository repository;

	public List getAllEquipment() {
		return repository.fetchAll(Equipment.class);
	}

	public Equipment getEquipment(int equipID) {
		return repository.fetchById(equipID, Equipment.class);
	}
	
	
}
