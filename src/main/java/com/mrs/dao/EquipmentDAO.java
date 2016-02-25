package com.mrs.dao;

import java.util.List;

import com.mrs.entity.Equipment;

public interface EquipmentDAO {
	public List getAllEquipment();
	public Equipment getEquipment(int equipID);
}
