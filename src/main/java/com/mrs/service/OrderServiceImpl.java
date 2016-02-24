package com.mrs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.dao.OrderDAO;
import com.mrs.entity.Order;
import com.mrs.obj.OrderStatusEnum;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	public List getOrdersByStatus(OrderStatusEnum status) {
		return orderDAO.getOrdersByStatus(status);
	}

	public boolean createOrder(Order order) {
		return orderDAO.createOrder(order);
	}
}
