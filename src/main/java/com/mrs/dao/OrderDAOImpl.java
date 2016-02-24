package com.mrs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.Order;
import com.mrs.entity.Product;
import com.mrs.obj.OrderStatusEnum;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private HibernateRepository repository;
	
	public List getOrdersByStatus(OrderStatusEnum status) {
		String query = String.format("WHERE status = '%d'", status.getValue());
		return repository.fetchAllByQuery(query, Order.class);
	}

	public boolean createOrder(Order order) {
		try {
			repository.create(order);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
