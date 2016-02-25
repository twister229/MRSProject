package com.mrs.dao;

import java.io.Serializable;
import java.util.List;

import com.mrs.entity.Order;
import com.mrs.entity.Product;
import com.mrs.obj.OrderStatusEnum;

public interface OrderDAO {
	public List loadOrder();
	public List getOrdersByStatus(OrderStatusEnum status);
	public Serializable createOrder(Order order);
	public Order getOrderByProduct(int proID);
	public int getProductIDByOrderID(int orderID);
	
	public Order updateStatus(OrderStatusEnum status, int orderID);
}
