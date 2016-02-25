package com.mrs.dao;

import java.io.Serializable;

import com.mrs.entity.OrderDetail;

public interface OrderDetailDAO {
	public Serializable createDetail(OrderDetail detail);
}
