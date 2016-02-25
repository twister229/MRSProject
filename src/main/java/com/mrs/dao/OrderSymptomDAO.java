package com.mrs.dao;

import java.io.Serializable;
import java.util.List;

import com.mrs.entity.OrderSymptom;

public interface OrderSymptomDAO {
	public Serializable createOrderSymptom(OrderSymptom orderSymp);
	public List loadOrderSymptom(int orderID);
}
