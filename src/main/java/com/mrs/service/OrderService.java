package com.mrs.service;

import java.io.Serializable;
import java.util.List;

import com.mrs.entity.Order;
import com.mrs.entity.OrderDetail;
import com.mrs.entity.OrderSymptom;
import com.mrs.obj.OrderStatusEnum;

public interface OrderService {
	public List loadOrder();
	public List getOrdersByStatus(OrderStatusEnum status);
	public Serializable createOrder(Order order);
	public Order getOrderByProduct(int proID);
	public Serializable createOrderSymptom(OrderSymptom orderSymp);
	public List loadOrderSymptom(int orderID);
	public int getProductIDByOrderID(int orderID);
	
	public Serializable createDetail(OrderDetail detail);
	public Order updateStatus(OrderStatusEnum status, int orderID);
}
