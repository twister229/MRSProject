package com.mrs.service;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrs.dao.OrderDAO;
import com.mrs.dao.OrderDetailDAO;
import com.mrs.dao.OrderSymptomDAO;
import com.mrs.entity.Order;
import com.mrs.entity.OrderDetail;
import com.mrs.entity.OrderSymptom;
import com.mrs.obj.OrderStatusEnum;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderSymptomDAO orderSympDAO;
	@Autowired
	private OrderDetailDAO detailDAO;
	
	public List getOrdersByStatus(OrderStatusEnum status) {
		return orderDAO.getOrdersByStatus(status);
	}

	public Serializable createOrder(Order order) {
		return orderDAO.createOrder(order);
	}

	public Order getOrderByProduct(int proID) {
		return orderDAO.getOrderByProduct(proID);
	}

	public Serializable createOrderSymptom(OrderSymptom orderSymp) {
		return orderSympDAO.createOrderSymptom(orderSymp);
	}

	public List loadOrderSymptom(int orderID) {
		return orderSympDAO.loadOrderSymptom(orderID);
	}

	public int getProductIDByOrderID(int orderID) {
		return orderDAO.getProductIDByOrderID(orderID);
	}

	public Serializable createDetail(OrderDetail detail) {
		return detailDAO.createDetail(detail);
	}

	public Order updateStatus(OrderStatusEnum status, int orderID) {
		return orderDAO.updateStatus(status, orderID);
	}

	public List loadOrder() {
		return orderDAO.loadOrder();
	}
}
