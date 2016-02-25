package com.mrs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.dao.EquipmentDAO;
import com.mrs.entity.Equipment;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentDAO equipmentDAO;
	
	public List getAllEquipment() {
		return equipmentDAO.getAllEquipment();
	}

	public Equipment getEquipment(int equipID) {
		return equipmentDAO.getEquipment(equipID);
	}

}
