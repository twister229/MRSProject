package com.mrs.dao;

import java.io.Serializable;
import java.util.List;

import com.mrs.entity.Order;
import com.mrs.obj.OrderStatusEnum;

public interface OrderDAO {
	public List getOrdersByStatus(OrderStatusEnum status);
	public Serializable createOrder(Order order);
	public Order getOrderByProduct(int proID);
}
