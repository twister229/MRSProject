package com.mrs.dao;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.OrderDetail;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	private HibernateRepository repository;

	public Serializable createDetail(OrderDetail detail) {
		return repository.create(detail);
	}
	
}
