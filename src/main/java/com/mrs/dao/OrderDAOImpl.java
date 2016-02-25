package com.mrs.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrs.entity.Order;
import com.mrs.obj.OrderStatusEnum;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private HibernateRepository repository;
	
	public List getOrdersByStatus(OrderStatusEnum status) {
		String query = String.format("WHERE status = '%d'", status.getValue());
		return repository.fetchAllByQuery(query, Order.class);
	}

	public Serializable createOrder(Order order) {
		return repository.create(order);
	}

	public Order getOrderByProduct(int proID) {
		String query = String.format("WHERE productID = '%d' ORDER BY orderID DESC", proID);
		List result = repository.fetchAllByQuery(query, Order.class);
		if (result != null) {
			return (Order) result.get(0);
		}
		return null;
	}
}
