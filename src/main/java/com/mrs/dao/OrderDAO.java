package com.mrs.dao;

import java.util.List;

import com.mrs.entity.Order;
import com.mrs.obj.OrderStatusEnum;

public interface OrderDAO {
	public List getOrdersByStatus(OrderStatusEnum status);
	public boolean createOrder(Order order);
}
