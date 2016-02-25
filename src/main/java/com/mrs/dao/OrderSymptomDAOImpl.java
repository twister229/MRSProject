package com.mrs.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.OrderSymptom;

@Repository
public class OrderSymptomDAOImpl implements OrderSymptomDAO {

	@Autowired
	private HibernateRepository repository;

	public Serializable createOrderSymptom(OrderSymptom orderSymp) {
		return repository.create(orderSymp);
	}

	public List loadOrderSymptom(int orderID) {
		String query = String.format("WHERE orderID = '%d'", orderID);
		return repository.fetchAllByQuery(query, OrderSymptom.class);
	}
}
