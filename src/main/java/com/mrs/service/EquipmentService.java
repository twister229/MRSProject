package com.mrs.service;

import java.util.List;

import com.mrs.entity.Equipment;

public interface EquipmentService {
	public List getAllEquipment();
	public Equipment getEquipment(int equipID);
}
