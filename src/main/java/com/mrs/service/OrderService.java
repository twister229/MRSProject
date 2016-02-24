package com.mrs.service;

import java.util.List;

import com.mrs.entity.Order;
import com.mrs.obj.OrderStatusEnum;

public interface OrderService {
	public List getOrdersByStatus(OrderStatusEnum status);
	public boolean createOrder(Order order);
}
